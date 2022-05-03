package com.revature.pixottdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pixott.model.Movie;

public class Historydao {
	public List<Movie> history(int id,int unique){
		String sql="insert into history (historyid,userid) values(?,?)";
		List<Movie> list=new ArrayList<>();
		try(
				Connection connection=Util.getConnection();
				PreparedStatement stmt=connection.prepareStatement(sql);
				){
			stmt.setInt(1,id);
			stmt.setInt(2,unique);
			stmt.executeUpdate();
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		return list;
		
	}

}