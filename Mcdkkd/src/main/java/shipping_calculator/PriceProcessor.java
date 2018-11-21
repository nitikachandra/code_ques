package shipping_calculator;

/**
 * Created by shiva.b on 21/11/18.
 */
public interface PriceProcessor<T> {
  boolean shouldExecute(T product, User user);

  double getCost(T product, User user);
}
