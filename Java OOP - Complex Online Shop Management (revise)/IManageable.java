public interface IManageable{
  public void addProduct(Product product);
  public void removeProduct(String productId) throws ProductNotFoundException;
}
