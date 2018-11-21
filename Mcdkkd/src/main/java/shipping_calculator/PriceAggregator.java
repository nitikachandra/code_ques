package shipping_calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiva.b on 21/11/18.
 */
public class PriceAggregator {

  private List<PriceProcessor<Product>> productLevelProcessors;
  private List<PriceProcessor<List<Product>>> listLevelProcessor;

  public PriceAggregator() {
    productLevelProcessors = new ArrayList<>();
    listLevelProcessor = new ArrayList<>();

    productLevelProcessors.add(new LogisticPrice());
    productLevelProcessors.add(new FragilePrice());
    productLevelProcessors.add(new FlammablePrice());

    listLevelProcessor.add(new ShippingPrice());
  }

  public double getCost(List<Product> products, User user) {
    double cost = 0.0;

    for (PriceProcessor<Product> processor : productLevelProcessors) {
      for (Product product : products) {
        cost += processor.getCost(product, user);
      }
    }

    for (PriceProcessor<List<Product>> processor : listLevelProcessor) {
      cost += processor.getCost(products, user);
    }
    return cost;
  }
}
