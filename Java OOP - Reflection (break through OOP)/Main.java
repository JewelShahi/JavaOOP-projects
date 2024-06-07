import java.lang.reflect.*;

class Main {

  public static void main(String[] args) throws Exception {

    System.out.println("---------- Other things ----------");
    // Field f = m.getClass().getDeclaredField("b");//we declared the field b, get
    // the instance of it
    // f.setAccessible(true);
    // f.set(m, 30);
    System.out.println("----------------------------------------------------------------------");
    
    Moo m = new Moo("OK", 10);
    System.out.println("---------- Constructors ----------");
    Constructor<?>[] constructor = m.getClass().getConstructors();// just use Moo.class.getConstructors()
    for (Constructor<?> cl : constructor) {
      System.out.println("Constructor name: " + cl.getName() + "\tParameter count: " + cl.getParameterCount());
      Parameter[] param = cl.getParameters();
      for (Parameter p : param) {
        System.out.println("Parameter name: " + p.getName() + "\tParameter type: " + p.getType());
      }
      System.out.println();
    }
    System.out.println("----------------------------------------------------------------------");

    Class<Moo> c = Moo.class;
    
    Method[] methods = c.getMethods();// if c.getDeclaredMethods() -- will show all methods thats declared by us not default methods e.g. --toString(), wait(), hashCode()...; declared methods will show all public, private and protected methods , not like methods() all public
    System.out.println("---------- Methods ----------");
    for (Method me : methods) {
      System.out.println("Name: " + me.getName() + "\tModifier: " + Modifier.toString(me.getModifiers())
          + "\tReturn type: " + me.getReturnType().getName() + "\tParameter count: "
          + me.getParameterCount());
      if (me.getParameterCount() == 0) {
        System.out.println("No parameter\n");
      } else {
        Parameter[] param = me.getParameters();
        for (Parameter p : param) {
          System.out.println("Parameter name: " + p.getName() + "\tParameter type: " + p.getType());
        }
        System.out.println();
      }
    }
    System.out.println("----------------------------------------------------------------------");

    System.out.println("---------- Fields ----------");
    Field[] fields = c.getDeclaredFields(); // we can use c.getFields() but private and protected won't show up
    for (Field f : fields) {
      System.out.println("Modifier: " + Modifier.toString(f.getModifiers()) + "\tField name: " + f.getName() + "\tReturn type: "+f.getType().getName());
    }
    System.out.println("----------------------------------------------------------------------");
  }
}
