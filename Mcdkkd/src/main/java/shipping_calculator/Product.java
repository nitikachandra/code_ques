package shipping_calculator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by shiva.b on 21/11/18.
 */
@Data
@AllArgsConstructor
public class Product {

  private String name;
  private boolean inflammable = false;
  private boolean fragile = false;
  private int length;
  private int height;
  private int breadth;
  private int cordX;
  private int cordY;
  private String center;

}
