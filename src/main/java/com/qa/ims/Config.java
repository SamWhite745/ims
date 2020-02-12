package com.qa.ims;

public class Config {
	private static String username;
	private static String password;
	
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Config.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Config.password = password;
	}
}
