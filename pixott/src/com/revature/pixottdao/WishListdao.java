package com.revature.pixottdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pixott.model.MovieSearch;

public class WishListdao {
	
	//public List<MovieSearch> view1(int name){
		public static void addwishllist(int id,int user) {
			String sql = "insert into wishlist (movieid,customerid) values (?,?);";
			try(
					Connection connection = Util.getConnection();
					PreparedStatement stmt = connection.prepareStatement(sql);
					){
				           stmt.setInt(1, id);
				           stmt.setInt(2, user);
		                 stmt.executeUpdate();
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		}
			
		public List<MovieSearch> view(int name ){
			String sql=" select * from wishlist inner join movie on movieid = movie.id inner join customer on customerid =(?) where customer.id=(?)";
			List<MovieSearch> show=new ArrayList<>();
			try(
					Connection connection = Util.getConnection();
					PreparedStatement stmt = connection.prepareStatement(sql);
					){
				           stmt.setInt(1, name);
				           stmt.setInt(2, name);
				           ResultSet rs= stmt.executeQuery();
				   		while(rs.next()) {
				   			MovieSearch sh=new MovieSearch();
				   			sh.setId(rs.getInt("movieid"));
				   			sh.setName(rs.getString("name"));
				   			show.add(sh);
				   		}
				   }catch (SQLException e) {
				   	Util.displayMessage(e);
				   }
				   	return show;
				   }
	}
