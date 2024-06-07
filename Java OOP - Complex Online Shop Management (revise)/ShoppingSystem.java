// Imports
import java.util.HashMap;

public class ShoppingSystem implements IManageable {

	// Fields
	protected static HashMap<String, Product> products;
	private HashMap<String, Customer> customers;
	private HashMap<String, Order> orders;

	// Constructor
	public ShoppingSystem() {
		ShoppingSystem.products = new HashMap<String, Product>();
		this.customers = new HashMap<String, Customer>();
		this.orders = new HashMap<String, Order>();
	}

	// Implement IManageable methods
	// Add Product
	public void addProduct(Product product) {
		ShoppingSystem.products.put(product.getProductID(), product);
	}

	// Remove Product
	public void removeProduct(String productID) throws ProductNotFoundException {
		if (!ShoppingSystem.products.containsKey(productID)) {
			throw new ProductNotFoundException("Product not found with ID: " + productID);
		}
		ShoppingSystem.products.remove(productID);
	}

	// Add Customer
	public void registerCustomer(Customer customer) {
		this.customers.put(customer.getCustomerID(), customer);
	}

	// Remove Customer
	public void unregisterCustomer(String customerID) throws CustomerNotFoundException {
		if (!customers.containsKey(customerID)) {
			throw new CustomerNotFoundException("Customer not found with ID: " + customerID);
		}
		this.customers.remove(customerID);
	}

	// Add Order
	public void addOrder(Order order) throws OrderAlreadyExistsException {
		if(this.orders.containsKey(order.getOrderId())){
			throw new OrderAlreadyExistsException("Order with ID: " + order.getOrderId() + " already exists.");
		}
		this.orders.put(order.getOrderId(), order);
	}

	// Getter orders List
	public HashMap<String, Order> getOrders() {
		return this.orders;
	}

	public HashMap<String, Product> getProducts() {
		return ShoppingSystem.products;
	}

	public HashMap<String, Customer> getCustomers() {
		return this.customers;
	}

	// Test
	// @Override
	// public String toString(){
	// 	return 
	// 		"ShoppingSystem {\n" +
	// 			"\tProducts = " + ShoppingSystem.products + "\n" +
	// 			"\tCustomers = " + this.customers + "\n" +
	// 			"\tOrders = " + this.orders + "\n" +
	// 		"}";
	// }
}
