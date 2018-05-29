package ru.job4j.wait;

import net.jcip.annotations.ThreadSafe;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;


/**
 * class ParallelSearch.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
@ThreadSafe
public class ParallelSearch {

    private final String root;
    private final String text;
    private final List<String> exts;
    private final BlockingQueue<String> files = new ArrayBlockingQueue<>(256);
    private final BlockingQueue<String> paths = new ArrayBlockingQueue<>(256);
    private volatile boolean flag = false;

    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public BlockingQueue<String> search() {
        new Thread(this::searchFiles).start();
        Thread read = new Thread(this::read);
        read.start();
        try {
            read.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.paths;
    }


    private void searchFiles() {
        Path start = Paths.get(this.root);
        try {
            Files.walkFileTree(start, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.flag = true;
        }
    }


    private void read() {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < cores; i++) {
            executor.submit(this::parse);
        }

        while (true) {
            if (this.flag && this.files.isEmpty()) {
                executor.shutdownNow();
                break;
            }
        }
    }

    private void parse() {
        while (true) {
            File file;
            try {
                file = new File(this.files.take());
            } catch (InterruptedException e) {
                break;
            }
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file)))) {
                String result;
                while ((result = reader.readLine()) != null) {
                    if (result.contains(this.text)) {
                        this.paths.offer(file.toString());
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String extension(String fileName) {
        String ext = "";
        int beginIndex = fileName.lastIndexOf('.');
        if (beginIndex > 0) {
            ext = fileName.substring(beginIndex + 1);
        }
        return ext;
    }

    @ThreadSafe
    private class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            FileVisitResult result = CONTINUE;
            if (dir.toString().contains(".")) {
                result = SKIP_SUBTREE;
            }
            return result;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (exts.contains(extension(file.toString()))) {
                files.offer(file.toString());
            }
            return CONTINUE;
        }
    }
}

