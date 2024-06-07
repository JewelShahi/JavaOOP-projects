import java.util.*;

class Animal implements Sound {

  protected void eat() {
    System.out.println("Eat");
  }

  @Override
  public void makeSound() {
    System.out.println("Moooooooo!");
  }

}

class Moo extends Animal {

  // ---------------- Fields ----------------
  private String a;
  private final short age = 50;
  private int b;
  public final char c = 'c';
  protected final double cost = 2.6;

  // ---------------- Constructors ----------------
  public Moo(String a, int b) {
    this.a = a;
    this.b = b;
  }

  public Moo(Moo m) {
    this.a = m.getA();
    this.b = m.getB();
  }

  // ---------------- Methods ----------------
  // setters
  public void setA(String a) {
    this.a = a;
  }

  public void setB(int b) {
    this.b = b;
  }

  // getters
  public String getA() {
    return a;
  }

  public int getB() {
    return b;
  }

  // a public method
  public void PrintingData(final int a, long b, short c, double d, char ch, String str, List<Integer> l) {

  }

  // a private method
  private void H() {
    System.out.println("H");
  }

  // a protected method
  protected int K() {
    return 0;
  }

  // a inherited overriden method
  @Override
  protected void eat() {
    System.out.println("Mmmm yummy!");
  }
}
