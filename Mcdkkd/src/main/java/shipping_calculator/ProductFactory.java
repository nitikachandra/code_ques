package shipping_calculator;

/**
 * Created by shiva.b on 21/11/18.
 */
public class ProductFactory {
  public Product getProduct(String name, boolean inflammable, boolean fragile, int length,
                            int height, int breadth, int cordX, int cordY, String center) {
    return new Product(name, inflammable, fragile, length, height, breadth, cordX, cordY, center);
  }
}
