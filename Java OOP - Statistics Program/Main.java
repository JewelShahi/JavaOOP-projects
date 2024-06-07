import java.util.*;
class Main {
  public static void main(String[] args) {
    double[] arr = {0, 0, 0, 1.0, 2.0, 2.0, 2.0, 3};
    System.out.println(Stat.count(arr));
    System.out.println(Stat.sum(arr));
    System.out.println(Stat.min(arr));
    System.out.println(Stat.max(arr));
    System.out.println(Stat.mean(arr));
    System.out.println(Stat.median(arr));
    System.out.println(Stat.mode(arr));
    System.out.println(Stat.var(arr));
    System.out.println(Stat.std(arr));
    
  }
}
