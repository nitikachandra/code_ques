package shipping_calculator;

import java.util.List;

/**
 * Created by shiva.b on 21/11/18.
 */
public class ShippingHandler {

  private PriceAggregator priceAggregator;

  public ShippingHandler() {
    priceAggregator = new PriceAggregator();
  }

  public double getPrice(List<Product> products, User user) {
    return priceAggregator.getCost(products, user);
  }
}
