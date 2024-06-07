import java.lang.reflect.*;
public class Main {
  public static void main(String[] args) throws Exception {
    for(Field f : UpperClass.class.getDeclaredFields()){
      if(f.isAnnotationPresent(Upper.class)){
        Object obj = f.get(new UpperClass("joethebest", "ko_kaza"));
        if(obj instanceof String stringSaver){
          for(int i=0; i<f.getAnnotation(Upper.class).time(); i++){
            System.out.println(stringSaver.toUpperCase());
          }
        }
      }
    }
  }
}
