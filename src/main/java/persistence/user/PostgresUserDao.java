package persistence.user;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

import models.Account;
import models.Product;
import persistence.PostgresBaseDao;

public class PostgresUserDao extends PostgresBaseDao implements UserDao {

  @Override
	public String findRoleForUser(String name, String pass) {
		
		System.out.println("name: " + name + " pass: " + pass);
		
		try {
			
			Connection con = super.getConnection();
			
			PreparedStatement prepStatement = con.prepareStatement("select role from useraccount where username = ? and password = ?");
			prepStatement.setString(1, name);
			prepStatement.setString(2, pass);
			ResultSet result = prepStatement.executeQuery();
			
			if(result.next()) {
				System.out.print("result:");
				System.out.print(result.toString());
				
				return result.getString("role");	
			} else {
				return null;
			}
			
		} catch(Exception e) {
			System.out.print(e);
			return null;
		}
	}

  // public boolean saveUser(Account user) throws ClassNotFoundException {
  //   try (Connection con = super.getConnection()) {

  //     PreparedStatement pstmt = con.prepareStatement(
  //       "insert into account(user_id, title, description, user_link, publication_date, account_id) values(?,?,?,?,?,?)"
  //     );
  //     // pstmt.setString(1, user.getId());
  //     // pstmt.setString(2, user.getTitle());
  //     // pstmt.setString(3, user.getDescription());
  //     // pstmt.setString(4, user.getUserLink());
  //     // pstmt.setString(5, user.getPublicationDate());
  //     // pstmt.setInt(6, 1);
  //     // pstmt.executeUpdate();

	// 		return true;
	// 	} catch (SQLException e) {
  //     e.printStackTrace();

	// 		return false;
	// 	}
  // }


  // public ArrayList<User> getAllUsersByUser(String userId) throws ClassNotFoundException {
  //   ArrayList<User> tempUsers = new ArrayList<User>();
  //   try (Connection con = super.getConnection()) {

  //     PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE account_id = ?");
  //     ps.setString(1, userId);
  //     ResultSet result = ps.executeQuery();
    
  //     while(result.next()) {
  //       tempUsers.add(new User(
  //         result.getString("user_id"),
  //         result.getString("title"),
  //         result.getString("description"),
  //         result.getString("user_link")
  //       ));
  //     }
      
  //     return tempUsers;
  //   } catch (SQLException e) {
  //     e.printStackTrace();

	// 		return null;
  //   }
    
  // }

}