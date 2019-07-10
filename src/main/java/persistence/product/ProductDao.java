package persistence.product;

import java.util.ArrayList;

import models.Product;

public interface ProductDao {

  public boolean saveProduct(Product product, String feed_id) throws ClassNotFoundException;

  public boolean updateProduct(Product product) throws ClassNotFoundException;

  public ArrayList<String> getAllStringHashes(String feedId);

  public boolean deleteProdcut(String feedId);

}