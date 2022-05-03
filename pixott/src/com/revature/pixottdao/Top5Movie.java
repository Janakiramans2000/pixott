package com.revature.pixottdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pixott.model.Top5;

public class Top5Movie {
	public  List<Top5> Top() {
	String sql="select *from top5movie join movie on movieid=movie.id ";
	ArrayList<Top5> result =new ArrayList<>();
	try (
			Connection conn =Util.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);	
			) {
	           ResultSet rs=stmt.executeQuery(sql);
	           while(rs.next()){
				Top5 review = new Top5();
				review.setName(rs.getString("name"));
				review.setId(rs.getInt("movieid"));
				result.add(review);
	           }
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			
			}
			return result;
}

	
}