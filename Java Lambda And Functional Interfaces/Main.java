import java.util.function.*;
import java.util.*;
import java.util.stream.*;
import java.nio.file.*;

class Main {
  public static void main(String[] args) throws Exception {
    Function<String, String> reverseIt = a->{
      String result = "";
      for(int i = a.length()-1; i >= 0; i--)
        result += a.charAt(i);
      return result;
    };
    System.out.println(reverseIt.apply("yag e veigroeG navI"));

    ArrayList<Integer> a = new ArrayList<>();
    for(int i=0;  i<25; i++)
      a.add(new Random().nextInt(100));

    a.forEach(x->System.out.print(x+" "));
    System.out.println();

    boolean d = a.stream().sorted().filter(x->x<=60).mapToInt(Integer::intValue).average().isPresent();

    // import java.util.strem.*;
    Stream.of(1, 4, 5, 8, 9, 6, 10, 2).parallel().skip(2).filter(x->x>0).forEachOrdered(x->System.out.print(x+" "));//skip removes first 2 elm

    // import java.util.strem.*;
    Stream.of("Hello", "Bob", " Cat", "Helen").sorted().findFirst().ifPresentOrElse(x->System.out.println(x), ()->System.out.println("fuck off"));// ifPresent(Consumer<>)

    // import java.util.strem.*;
    Stream.of(1, 4, 5, 8, 9, 6, 10, 2).sorted().skip(2).filter(x->x>0).mapToInt(Integer::intValue).reduce(Integer::max).ifPresent(x->System.out.println(x));// mapToInt(Integer::intValue).max().getAsInt() or mapToInt(i->i).max().getAsInt()

    System.out.println("\nParallel stream");
    // import java.util.strem.*;
    Stream.of(1, 4, 5, 8, 9, 6, 10, 2).parallel().map(x -> x*x).sorted().forEachOrdered(x->System.out.println(x));//sort doesn't work and it's ok to remove it, prints it ordered with forEachOrdered(Consumer<>) and .sorted before forEachOrdered sorts it, else with just forEach is random

    System.out.println("\nStream");
    // import java.util.strem.*;
    Stream.of(1, 4, 5, 8, 9, 6, 10, 2).sorted().map(x -> x*x).forEach(x->System.out.println(x));
    //System.out.println();

    System.out.println("\n\nPrinting lines from a file with Stream");


    // import java.util.strem.*; and import java.nio.file.*;
    Stream<String> str = Files.lines(Paths.get("folder/file.txt"));
    int n = (int) str.sorted().filter(x->x.length()>=5).count();
    str.close();
    System.out.println(n);

    // import java.util.strem.*; and import java.nio.file.*;
    Stream<String> str1 = Files.lines(Paths.get("folder/file.txt"));
    str1.filter(x->x.length()>=5).sorted().forEach(x->System.out.println(x));
    str1.close();

    System.out.println("\n\nGetting info from data.txt where the data has leght of max 3 characters --->");
    // import java.util.strem.*; and import java.nio.file.*;
    Stream<String> getData = Files.lines(Paths.get("folder/data.txt"));
    getData
      .map(x->x.split(","))
      .filter(x->x.length==3)
      .filter(x->Double.parseDouble(x[1])>=15.0)
      .forEach(x->System.out.println(x[0]+" "+x[1]+" "+x[2]));
    getData.close();

    // import java.util.strem.*;
    IntSummaryStatistics stats = IntStream.of(1, 4, 5, 8, 9, 6, 10, 2).summaryStatistics();
    System.out.println(stats);

    System.out.println("\n\nEnds with \"et\" ?");
    // import java.util.strem.*; and import java.nio.file.*;
     Stream<String> endsWithET = Files.lines(Paths.get("folder/file.txt"));
    endsWithET.parallel().filter(x->x.endsWith("et"))/*.sorted()*/.forEach(x->System.out.println(x));
    endsWithET.close();
  }
}
/*

Java stream
https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

Java IntStream
https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html

Java OptionalInt
https://docs.oracle.com/javase/8/docs/api/java/util/OptionalInt.html

*/
