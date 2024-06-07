enum Category{
  DIARY,
  MEAT,
  FISH,
  SNACKS,
  GADGETS,
  VEGITABLE,
  FRUIT;
}

class Product{

  // fields
  private String id;
  private String name;
  private String description;
  private Category category;
  private double price;

  // constructor
  Product(final String id, Category c, final String name, final double price, final String description){
    this.id = id;
    this.category = c;
    this.name = name;
    this.price = (price<=0.00)?0.00:price;
    this.description = description;
  }
  
  // product id
  public String getId() {
  	return id;
  }
  public void setId(final String id) {
  	this.id = id;
  }

  // product name
  public String getName() {
  	return name;
  }
  public void setName(final String name) {
  	this.name = name;
  }

  // product description
  public String getDescription() {
  	return description;
  }
  public void setDescription(final String description) {
  	this.description = description;
  }

  // product category
  public Category getCategory() {
  	return category;
  }
  public void setCategory(final Category category) {
  	this.category = category;
  }

  // product price
  public double getPrice() {
  	return price;
  }
  public void setPrice(final double price) {
  	this.price = price;
  }

  // product getting values
  @Override
  public String toString(){
    return "Product id: "+getId()+"\nProduct name: "+getName()+"\nProduct description: "+getDescription()+"\nProduct category: "+getCategory()+"\nProduct price: "+getPrice()+"\n";
  }
}
