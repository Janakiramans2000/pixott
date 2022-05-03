
package com.revature.pixott.handler;

import java.util.List;

import com.revature.pixott.model.Top5;
import com.revature.pixottdao.Top5Movie;

public class UserTop5 {
	public static void display() {
		Top5Movie user=new Top5Movie();
		List<Top5> show=user.Top();
		System.out.println(String.format("%s %-40s", "id","name"));
		show.forEach(System.out::println);
		UserMenu.display();
		
	}

}