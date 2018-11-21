package shipping_calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shiva.b on 21/11/18.
 */
public class ShippingPrice implements PriceProcessor<List<Product>> {

  public boolean shouldExecute(List<Product> product, User user) {
    return true;
  }

  public double getCost(List<Product> product, User user) {
    Map<String, List<Product>> productMap = groupByCenter(product);
    double cost = 0.0;

    for (String center : productMap.keySet()) {
      List<Product> products = productMap.get(center);
      cost += getCenterCost(products);
    }
    return 0;
  }

  //add algo for price calculation
  private double getCenterCost(List<Product> products) {
    double bucketTillNow = 0.0;

    return bucketTillNow;
  }

  private Map<String, List<Product>> groupByCenter(List<Product> products) {
    Map<String, List<Product>> productMap = new HashMap<>();
    products.forEach(product -> {
      if (productMap.containsKey(product.getCenter())) {
        productMap.get(product.getCenter()).add(product);
      }
      else {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productMap.put(product.getCenter(), productList);
      }
    });
    return productMap;
  }
}
