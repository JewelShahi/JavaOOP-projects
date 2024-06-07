public class Main {

  public static void main(String[] args) {

    // Shopping System Object
    ShoppingSystem shoppingSystem = new ShoppingSystem();

    // Adding Products To The System
    Product[] products = {
      new Product("P-001", "Apple", 0.75, 50),
      new Product("P-002", "Orange", 0.60, 40),
      new Product("P-003", "Bread", 2.50, 30),
      new Product("P-004", "Milk", 1.20, 20),
      new Product("P-005", "Chocolate", 3.99, 15),
      new Product("P-006", "Toothpaste", 4.50, 25),
      new Product("P-007", "Soap", 2.20, 35),
      new Product("P-008", "Eggs", 1.50, 10),
      new Product("P-009", "Shampoo", 5.99, 20),
      new Product("P-010", "Potato Chips", 1.99, 25),
      new Product("P-011", "Shampoo", 5.99, 50),
      new Product("P-012", "Notebook", 2.49, 100),
      new Product("P-013", "Pen", 0.99, 200),
      new Product("P-014", "Toothpaste", 3.49, 75),
      new Product("P-015", "Laundry Detergent", 8.99, 40),
      new Product("P-016", "Dish Soap", 2.99, 60),
      new Product("P-017", "Light Bulb", 1.49, 150),
      new Product("P-018", "Hand Sanitizer", 4.99, 120),
      new Product("P-019", "Batteries (AA)", 6.99, 80),
      new Product("P-020", "Glue Stick", 1.29, 90)
    };

    // Making Customers
    Customer customer1 = new Customer("C-001", "Alice", "alice@example.com");
    Customer customer2 = new Customer("C-002", "Bob", "bob@example.com");

    // Adding Customers To The System
    shoppingSystem.registerCustomer(customer1);
    shoppingSystem.registerCustomer(customer2);

    // Adding Products To The System
    for (Product product : products)
      shoppingSystem.addProduct(product);

    try {
      // Customer 1 adds products to cart
      customer1.addToCart(products[2], 2);
      customer1.addToCart(products[0], 5);

      // Customer 2 adds a product to cart
      customer2.addToCart(products[1], 1);
      customer2.addToCart(products[3], 5);
      // customer2.addToCart(products[3], 200); // OutOfStocks Exception
      // customer2.addToCart(new Product("143", "Test", 2.50, 30), 4); //
      // ProductNotFoundException

      // Creating Orders
      Order order1 = new Order("O-001", customer1, customer1.getCart(), customer1.calculateTotalCartPrice());

      Order order2 = new Order("O-002", customer2, customer2.getCart(), customer2.calculateTotalCartPrice());

      // Add An Order To The System
      shoppingSystem.addOrder(order1);
      shoppingSystem.addOrder(order2);

      // shoppingSystem.addOrder(new Order("O-001", customer2, customer2.getCart(),
      // customer2.calculateTotalCartPrice())); // OrderAlreadyExistsException

      // Print The Total Price
      System.out.println("Total price of customer2: " + order2.getTotalPrice());

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    // Printing All The Orders And Its Info
    System.out.println("\nAll orders --->\n");
    for (Order order : shoppingSystem.getOrders().values()) {
      System.out.println(order.toString());
    }

    // All Registred Customers
    System.out.println("\nAll customers --->\n");
    System.out.println(shoppingSystem.getCustomers());

    // // All Added Products
    // System.out.println("\nAll products --->\n");
    // System.out.println(shoppingSystem.getProducts());
  }
}
