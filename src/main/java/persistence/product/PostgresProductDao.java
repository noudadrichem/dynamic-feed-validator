package persistence.product;

import java.sql.*;
import java.util.ArrayList;

import models.Product;
import persistence.PostgresBaseDao;

public class PostgresProductDao extends PostgresBaseDao {

  public boolean saveProduct(Product product, String feed_id) throws ClassNotFoundException {
    try (Connection con = super.getConnection()) {

      PreparedStatement pstmt = con.prepareStatement(
        "insert into product(hashed, feed_id, product_id_from_feed) values(?, ?, ?)"
      );
      pstmt.setString(1, product.getProductHashCode()); 
      pstmt.setString(2, feed_id);
      pstmt.setString(3, product.getId());
      pstmt.executeUpdate();

      return true;
    } catch (SQLException e) {
      e.printStackTrace();

      return false;
    }
  }

  public boolean updateProduct(Product product) throws ClassNotFoundException {
    try (Connection con = super.getConnection()) {

      PreparedStatement pstmt = con.prepareStatement(
        "update product set hashed = ?, product_id = ? where hashed = ? and product_id = ?"
      );

      pstmt.setString(1, product.getProductHashCode());
      pstmt.setString(2, product.getId());
      pstmt.setString(3, product.getProductHashCode());
      pstmt.setString(4, product.getId());

      pstmt.executeUpdate();

      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  
  public ArrayList<String> getAllStringHashes(String feedId) {
		ArrayList<String> tempList = new ArrayList<String>();
		
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT hashed FROM product WHERE feed_id = ?");
			ps.setString(1, feedId);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				tempList.add(
          result.getString("hashed")
        );
			}
			
		} catch(Exception e) {
      e.printStackTrace();
    }

    return tempList;
  }

  public boolean deleteProdcut(String feedId) {
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("delete from product where feed_id = ?");
			ps.setString(1, feedId);      
      ps.execute();

      return true;
		} catch(Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}