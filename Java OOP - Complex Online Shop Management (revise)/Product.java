/**
 * Product
 */
public class Product {

	// Properties
	private String productID;
	private String name;
	private double price;
	private int stockCount;

	// Constructor
	public Product(String productID, String name, double price, int stockCount) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.stockCount = stockCount;
	}

	// Getters and Setters
	public String getProductID() {
		return this.productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockCount() {
		return this.stockCount;
	}

	public void setstockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	// Methods

	// Puchase
	public void purchase(int quantity) throws OutOfStockException {
		if (this.stockCount < quantity) {
			throw new OutOfStockException("Product is out of stock.");
		}
		this.stockCount -= quantity;
	}

	// Restock
	public void restock(int quantity) {
		this.stockCount += quantity;
	}

	@Override
	public String toString() {
		return "Product {\n" +
				"\tProductID ='" + this.productID + "\n" +
				"\tName ='" + this.name + "', \n" +
				"\tPrice =" + this.price + ",\n" +
				"\tStock Count =" + this.stockCount + "\n" +
				"}\n";
	}
}
