import java.util.*;

class Main {

  // category promotion
  public static List<Category> getApplicableCategories = List.of(
      Category.FISH, Category.DIARY, Category.MEAT

  );

  // adding products
  public static List<Product> getApplicableProduct = List.of(
      new Product("1", Category.MEAT, "Beef", 17.79, ""),
      new Product("2", Category.MEAT, "Lamb", 19.89, ""),
      new Product("3", Category.MEAT, "Chicken", 6.59, ""),
      new Product("4", Category.FISH, "Salmon", 30.0, ""),
      new Product("5", Category.FISH, "Prawns", 19.29, ""),
      new Product("6", Category.VEGITABLE, "Broccoli", 4.19, ""),
      new Product("7", Category.VEGITABLE, "Cucumber", 2.69, ""),
      new Product("8", Category.VEGITABLE, "Lettuce", 0.99, ""),
      new Product("9", Category.SNACKS, "ChioChips", 3.89, ""),
      new Product("10", Category.SNACKS, "Takis", 4.39, ""),
      new Product("11", Category.SNACKS, "Biscuit", 2.49, ""),
      new Product("12", Category.DIARY, "Cheese", 15.76, ""),
      new Product("13", Category.DIARY, "Milk", 2.29, ""),
      new Product("14", Category.FISH, "Prawns", 19.29, ""));

  public static int getPercentDiscount(int percent) {
    return percent;
  }

  // discount and printing all category products

  public static void productPromotion(List<Category> c, List<Product> b, int discount) {
    for (Category d : c) {
      b.stream()
          .filter(a -> d.equals(a.getCategory()))
          .forEach(x -> {
            x.setPrice(Math.round((x.getPrice() - x.getPrice() * getPercentDiscount(discount) / 100) * 100.0) / 100.0);
            System.out.println(x.toString());
          });
    }
  }

  public static void main(String[] args) {
    productPromotion(getApplicableCategories, getApplicableProduct, 10);
  }
}
