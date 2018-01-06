package ru.job4j;

/** The first program.
 * Class Calculate create Hello World.
 * @author Alexander Rovnov.
 * @version 0.0.1
 */
public class Calculate {
	/** Entry point to class & application.
	 * param args array of string arguments.
	 */
	public static void main(String[] args) {
		System.out.println("Hello World"); 
	}
	
	/**
	 * Method echo.
	 * @param name Your name.
	 * @return Echo plus your name.
	 */
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}