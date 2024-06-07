
// Imports
import java.util.*;

public class Customer extends ShoppingSystem implements IPurchasable {

  // Properties
  private String customerID;
  private String name;
  private String email;
  private HashMap<String, CartItem> cart;

  // Constructor
  public Customer(String customerID, String name, String email) {
    this.customerID = customerID;
    this.name = name;
    this.email = email;
    this.cart = new HashMap<String, CartItem>();
  }

  // Getters and Setters
  public String getCustomerID() {
    return customerID;
  }

  public void setCustomerID(String customerID) {
    this.customerID = customerID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public HashMap<String, CartItem> getCart() {
    return cart;
  }

  public void setCart(HashMap<String, CartItem> cart) {
    this.cart = cart;
  }

  // Implementing Interfaces Methods

  // Add Product To Cart
  public void addToCart(Product product, int quantity) throws ProductNotFoundException, OutOfStockException {
    if (!ShoppingSystem.products.containsKey(product.getProductID())) {
      throw new ProductNotFoundException("Product not found.");
    } else {
      if (this.cart.containsKey(product.getProductID())) {

        product.purchase(quantity);

        CartItem existingItem = cart.get(product.getProductID());
        existingItem.setQuantity(existingItem.getQuantity() + quantity);
        existingItem.setTotalPrice(existingItem.getTotalPrice() + product.getPrice() * quantity);
      } else {

        product.purchase(quantity);

        this.cart.put(product.getProductID(), new CartItem(product, quantity));
      }
    }
  }

  // Calculate Carts Total Price
  public double calculateTotalCartPrice() {
    double totalPrice = 0.0;
    for (CartItem item : cart.values()) {
      totalPrice += item.getTotalPrice();
    }
    return totalPrice;
  }

  // Remove Product From Cart
  public void removeFromCart(String productID) throws ProductNotFoundException {
    if (ShoppingSystem.products.containsKey(productID) == false) {
      throw new ProductNotFoundException("This product doesnt exist!");
    }

    if (!cart.containsKey(productID)) {
      throw new ProductNotFoundException("Product not found in cart.");
    }
    cart.remove(productID);
  }

  // Checkout
  public void checkout(ShoppingSystem system) {
    cart.clear();
  }

  // Prints everything
  @Override
  public String toString() {
    return "Customer {\n" +
        "\tCustomerID = '" + this.customerID + "',\n" +
        "\tName = '" + this.name + "',\n" +
        "\tEmail = '" + this.email + "',\n" +
        "\tCart = [\n" + this.cart + "\n\t]\n" +
        "}\n";
  }
}
