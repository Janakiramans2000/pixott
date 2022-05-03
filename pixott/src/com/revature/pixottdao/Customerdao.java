package com.revature.pixottdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pixott.handler.Login;
import com.revature.pixott.handler.UserMenu;
import com.revature.pixott.model.Customer;

public class Customerdao {
	public static int id;
		public void signup(Customer Customer) {
		String sql ="insert into customer (Name, MobileNumber, Password) values (?, ?, ?)";
		try (
		Connection conn =Util.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);	
		) {
			System.out.println("connected successfully.");
			stmt.setString(1, Customer.getName());
			stmt.setString(2, Customer.getMobilenumber());
			stmt.setString(3, Customer.getPassward());
			stmt.execute();
			System.out.print("detail added succfully");

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			

	}
}
		public Customer getCustomer(String mobile) {
			
			String sql="select *from customer where mobilenumber=?";
			try(
					Connection conn=Util.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);
					
					)
			{
				stmt.setString(1, mobile);
				ResultSet rs=stmt.executeQuery();
				if(rs.next()) {
					Customer  customer=new Customer();
					customer.setId(rs.getInt("id"));
					customer.setName(rs.getString("name"));
					customer.setName(rs.getString("mobilenumber"));
					customer.setPassward(rs.getString("password"));
					System.out.println("welcome back"+customer.getName());
					//int id=Login.id;
					id=customer.getId();
					UserMenu.display();
					
				}else {
					System.out.println("invalid login details");
					Login.display();
				}
				
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				
			}
			return null;
		}

			public static  int getuserid(String name,String password) {
				int userid=0;
				String sql="select id from customer where name=(?) and password=(?)";
				try(
						Connection connection=Util.getConnection();
						PreparedStatement stmt=connection.prepareStatement(sql);
						){
					stmt.setString(1,name);
					stmt.setString(2, password);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						userid = rs.getInt("id");
					}

				} catch (SQLException e) {
					Util.displayMessage(e);
				}
				return userid;
							
						
				
				
			}
		}