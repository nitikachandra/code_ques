package shipping_calculator;

import java.util.ArrayList;
import java.util.List;

import static shipping_calculator.CommonConstants.INFINITE_DISTANCE;

/**
 * Created by shiva.b on 21/11/18.
 */
public class LogisticPrice implements PriceProcessor<Product> {

  private List<DistanceSlabs> slabs;

  public LogisticPrice() {
    slabs = new ArrayList<DistanceSlabs>();
    slabs.add(new DistanceSlabs("1st slab", 5, 0));
    slabs.add(new DistanceSlabs("2nd slab", 5, 6));
    slabs.add(new DistanceSlabs("3rd slab", INFINITE_DISTANCE, 12));
  }

  public boolean shouldExecute(Product product, User user) {
    return true;
  }

  public double getCost(Product product, User user) {
    double distance = getDistance(product, user);
    double cost = 0.0;
    for (DistanceSlabs slab : slabs) {
      cost += slabCost(distance, slab);
      if (slab.getThreshold() == INFINITE_DISTANCE) {
        distance = 0;
      }
      else {
        distance = Math.max(distance - slab.getThreshold(), 0);
      }
    }
    return cost;
  }

  private double slabCost(double distance, DistanceSlabs slab) {
    if (slab.getThreshold() == INFINITE_DISTANCE) {
      return distance * slab.getRate();
    }
    else {
      double applicableDistance = Math.min(slab.getThreshold(), distance);
      return applicableDistance * slab.getRate();
    }
  }

  private double getDistance(Product product, User user) {
    return Utils.getDistance(
      product.getCordX(), product.getCordY(),
      user.getCordX(), user.getCordY()
    );
  }
}
