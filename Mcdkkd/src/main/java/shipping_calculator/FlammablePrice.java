package shipping_calculator;

/**
 * Created by shiva.b on 21/11/18.
 */
public class FlammablePrice implements PriceProcessor<Product> {
  @Override
  public boolean shouldExecute(Product product, User user) {
    return product.isInflammable();
  }

  @Override
  public double getCost(Product product, User user) {
    return CommonConstants.FLAMMABLE_COST;
  }
}
