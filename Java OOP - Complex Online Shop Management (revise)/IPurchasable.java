
public interface IPurchasable {
  public void addToCart(Product product, int quantity) throws Exception;
  public void removeFromCart(String productId) throws ProductNotFoundException;
}
