package fluent.ly;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-10 */
@SuppressWarnings("unused") 
public enum tru  {
  ;
static boolean forgetting(final Object _1, final Object... _2) {
    return true;
  }
  
  static boolean forgetting(final Runnable ¢) {
    ¢.run();
    return true;
  }

  static boolean ignoring(final boolean __) {
    return true;
  }

  static boolean ignoring(final double __) {
    return true;
  }

  static boolean ignoring(final long __) {
    return true;
  }

  public static boolean ignoring(Object __) {
    return true;
  }


}
