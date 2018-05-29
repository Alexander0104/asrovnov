package ru.job4j.wait;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ParallelSearchTest {

    @Test
    public void search() {
        String root = "D:\\GitHub";
        String text = "[groups]";
        List<String> exts = new ArrayList<>(Arrays.asList("conf"));
        ParallelSearch parallelSearch = new ParallelSearch(root, text, exts);
        BlockingQueue<String> result = parallelSearch.search();
        for (String string : result) {
            System.out.println(string);
        }
    }
}