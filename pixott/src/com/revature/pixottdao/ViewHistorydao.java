package com.revature.pixottdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pixott.model.Movie;

public class ViewHistorydao {
	public List<Movie> show(int id){
		String sql=String.format("select*from history inner join movie on historyid=movie.id inner join customer on userid=%d where customer.id=%d;",id,id);
		java.util.List<Movie> sh=new ArrayList<>();
		try(
				Connection connection=Util.getConnection();
				PreparedStatement stmt=connection.prepareStatement(sql);
				){
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Movie sho=new Movie();
				sho.setId(rs.getInt("historyid"));
				sho.setName(rs.getString("name"));
				sh.add(sho);
			}
			
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		return sh;
	}

}