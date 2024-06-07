class Testing {

  String str;

  public Testing(String s) {
    this.str = s;
  }

  public String getStr() {
    return this.str;
  }

  public void setStr(String s) {
    this.str = s;
  }

  @Test
  public void printing() {
    System.out.println("Hello!");
  }

  @Override
  public String toString() {
    return "Testing [str=" + this.str + "]";
  }
}
