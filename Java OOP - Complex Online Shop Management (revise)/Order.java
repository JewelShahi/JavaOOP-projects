import java.util.*;
import java.util.stream.*;


public class Order {

  // Properties
  private String orderId;
  private Customer customer;
  private HashMap<String, CartItem> products;
  private double totalPrice;

  // Constructor
  public Order(String orderId, Customer customer, HashMap<String, CartItem> products, double totalPrice) throws CustomerNotFoundException{
    this.orderId = orderId;
    this.customer = customer;
    this.products = products;
    this.totalPrice = totalPrice;
  }

  // Getters and Setters
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public HashMap<String, CartItem> getProducts() {
    return products;
  }

  public void setProducts(HashMap<String, CartItem> products) {
    this.products = products;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  // Prints Evrything
  @Override
  public String toString(){
    return 
      "Order {\n" +
        "\tOrder ID = '" + this.orderId + "\n" +
        "\tCustomer = '" + this.customer.getCustomerID() + "', \n" +
        "\tProducts = {\n" +
        "\t\t" + products.entrySet().stream()
            .map(entry -> "'" + entry.getKey() + "': " + entry.getValue().getProduct().getName()+" x "+entry.getValue().getQuantity()+" ("+entry.getValue().getProduct().getPrice()+") ")
            .collect(Collectors.joining(",\n\t\t")) + 
        "\n\t},\n" +
        "\tTotal Price = " + this.totalPrice + "\n" +
      "}\n";
  }
  
}
