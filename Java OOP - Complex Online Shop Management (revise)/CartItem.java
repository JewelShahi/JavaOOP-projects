public class CartItem {

	// Properties
	private Product product;
	private int quantity;
	private double totalPrice;

	// Constructor
	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = product.getPrice() * quantity;
	}

	// Getters and Setters
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalPrice(double totalPrice){
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice(){
		return this.totalPrice;
	}
}
