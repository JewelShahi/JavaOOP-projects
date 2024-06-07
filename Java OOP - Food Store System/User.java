import java.util.function.*;
class User{

  // fields
  private String name;
  private String password;

  // constructor
  User(final String name, final String password){
    this.name = name;
    this.password = password;
  }

  // user name
  public String getName() {
  	return name;
  }
  public void setName(final String name) {
  	this.name = name;
  }

  // user password
  public String getPassword() {
  	return password;
  }
  public void setPassword(final String password) {
  	this.password = password;
  }
  
}
