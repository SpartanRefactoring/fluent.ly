/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package il.org.spartan;

import static il.org.spartan.Utils.*;
import static il.org.spartan.azzert.*;

import org.eclipse.jdt.annotation.Nullable;
import org.jetbrains.annotations.*;
import org.junit.*;

/** A class for lazy, memoizing evaluation of objects of arbitrary type. The
 * evaluation must never return <code><b>null</b></code>.
 * @param <T> some arbitrary type
 * @author Yossi Gil
 * @since 2014-06-20 */
public abstract class NonNullCache<T> {
  /** The cached value, null when the cache was not populated */
  private @Nullable T value;

  /** Compute the cached value, either by looking up the memoized valued, or by
   * actual computation
   * @return cached value */
  @NotNull public T value() {
    return value != null ? value : (value = ____());
  }

  /** This function is to be implemented by clients, giving a method for
   * computing the cached value. This class protects this function, guaranteeing
   * that it would only be called once.
   * @return value to be cached */
  @NotNull protected abstract T ____();

  //
  public static class TEST extends NonNullCache<String> {
    private static final int SOME_OFFSET = 17;
    private int evaluations;

    @Test public void firstReturnsFirstOffset() {
      azzert.that(value(), is(SOME_OFFSET + "x0"));
    }

    @Test public void restReturnsFirstOffset() {
      value();
      azzert.that(value(), is(SOME_OFFSET + "x0"));
      for (int ¢ = 0; ¢ < 10; ++¢)
        azzert.that(value(), is(SOME_OFFSET + "x0"));
    }

    @Override @NotNull protected String ____() {
      return SOME_OFFSET + "x" + sqr(evaluations++);
    }
  }
}
