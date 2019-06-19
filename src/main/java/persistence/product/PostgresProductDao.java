package persistence.product;

import java.sql.*;

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

}