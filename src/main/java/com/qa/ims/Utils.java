package com.qa.ims;

import java.util.Scanner;

public class Utils {
	private static Scanner scanner = new Scanner(System.in);

	private Utils() {
		throw new IllegalStateException("Utility class");
	}

	public static String getStringInput() {
		return scanner.next();
	}
}
