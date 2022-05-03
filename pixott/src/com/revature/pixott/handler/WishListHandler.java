package com.revature.pixott.handler;

import java.util.List;

import com.revature.pixott.app.App;
import com.revature.pixott.model.MovieSearch;
import com.revature.pixottdao.Customerdao;
import com.revature.pixottdao.WishListdao;

public class WishListHandler {
	public static void display() {
		int unique=Customerdao.id;
		System.out.println("you watched movie list");
		System.out.println("*************************");
		WishListdao list=new WishListdao();
		List<MovieSearch> movie=list.view(unique);
		movie.forEach(System.out::println);
		System.out.println("select the movie id to play");
		int option=App.scanner.nextInt();
		System.out.println("Thanks for watchig......");
		UserMenu.display();
	}

}
