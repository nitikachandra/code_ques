package shipping_calculator;

/**
 * Created by shiva.b on 21/11/18.
 */
public class FragilePrice implements PriceProcessor<Product> {
  @Override
  public boolean shouldExecute(Product product, User user) {
    return product.isFragile();
  }

  @Override
  public double getCost(Product product, User user) {
    return CommonConstants.FRAGILE_COST;
  }
}
