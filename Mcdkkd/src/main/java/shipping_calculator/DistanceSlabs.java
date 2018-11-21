package shipping_calculator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by shiva.b on 21/11/18.
 */
@Data
@AllArgsConstructor
public class DistanceSlabs {
  private String name;
  private double threshold;
  private double rate;
}
