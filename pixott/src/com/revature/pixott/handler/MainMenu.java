package com.revature.pixott.handler;


import com.revature.pixott.app.App;

public class MainMenu {
	public static void display() {
		System.out.println("pixott Menu");
		System.out.println("=============");
		System.out.println("1. signup;");
		System.out.println("2. login;");
		System.out.println("3,exit");
		System.out.println("Enter option: ");
		int option = App.scanner.nextInt();
		if (option == 1) {
			Signup.display();
		}else if(option==2) {
			
			Login.display();
			
		}else if(option==3) {
			System.out.println("thankyou for using pixxott");
		}
	}

}