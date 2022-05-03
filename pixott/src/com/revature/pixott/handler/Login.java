package com.revature.pixott.handler;

import com.revature.pixott.app.App;
import com.revature.pixott.model.Customer;
import com.revature.pixottdao.Customerdao;

public class Login {
	public static void display() {
		System.out.print("login");
		System.out.println("===");
		System.out.print("mobilenumber;");
		String mobilenumber=App.scanner.next();
		System.out.print("password;");
		
		String pass=App.scanner.next();
		Customerdao customer=new Customerdao();
		Customer Customer = customer.getCustomer(mobilenumber);
		if (Customer.getPassward().equals(pass)) {
			System.out.println("Login Successful");
			System.out.println(Customer.getName());
			UserMenu.display();
		} else {
			System.out.println("Invalid mobile number or password.");
		
		}
		}

	}