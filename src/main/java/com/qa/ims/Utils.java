package com.qa.ims;

import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("resource")

public class Utils {

	private static Scanner scanner = new Scanner(System.in);

	public static String getStringInput() {
		return scanner.nextLine();
	}

	public static int getIntInput() {
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Not a valid integer");
			}
		}
	}
}
