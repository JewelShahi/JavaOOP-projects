class Promotion {

  // fields
  private String name;
  private String description;

  // constructor
  Promotion(final String name, final String description){
    this.name = name;
    this.description = description;
  }
  
  // promotion name
  public String getName() {
  	return name;
  }
  public void setName(final String name) {
  	this.name = name;
  }

  // promotion description
  public String getDescription() {
  	return description;
  }
  public void setDescription(final String description) {
  	this.description = description;
  }

  // moze da se zameni s functional interface Predicate<T>
  void isApplicable(Product product){
    if(description.contains(product.getName()))
      apply(product);
  }

  // moze da se zameni s functional Interface Function<T, D> ili s Consumer<T>
  void apply(Product product){
    product.setPrice(product.getPrice() - (10/100)*product.getPrice());
 }
  
}
