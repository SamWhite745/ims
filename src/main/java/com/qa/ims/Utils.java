package com.qa.ims;

import java.util.Scanner;

public class Utils {

	private static Scanner scanner = new Scanner(System.in);

	public static String getStringInput() {
		return scanner.next();
	}

	public static int getIntInput() {
		return scanner.nextInt();
	}
}
