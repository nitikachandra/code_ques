package shipping_calculator;

/**
 * Created by shiva.b on 21/11/18.
 */
public class Utils {
  public static double getDistance(int x1, int y1, int x2, int y2) {
    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
  }
}
