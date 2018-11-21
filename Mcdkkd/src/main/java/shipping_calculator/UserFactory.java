package shipping_calculator;

/**
 * Created by shiva.b on 21/11/18.
 */
public class UserFactory {

  public User getUser(String name, int cordX, int cordY) {
    return new User(name, cordX, cordY);
  }
}
