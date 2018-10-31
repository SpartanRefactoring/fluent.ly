/** Part of the "Spartan Blog"; mutate the rest, but leave this line as is */
package fluent.ly;

import java.util.*;
import java.util.stream.*;

import org.jetbrains.annotations.*;

/** @author Yossi Gil <tt>yogi@cs.technion.ac.il</tt>
 * @since 2017-04-23 */
public interface is {
  interface not {
    /** the candidate is not in ts */
    @SafeVarargs static <T> boolean in(final T candidate, final T... ts) {
      return !is.in(candidate, ts);
    }
  }

  static <T> boolean empty(final Collection<T> ¢) {
    return ¢ == null || ¢.isEmpty();
  }

  static <T> boolean empty(final Iterable<T> ¢) {
    return ¢ == null || !¢.iterator().hasNext();
  }

  static boolean empty(final @Nullable String ¢) {
    return ¢ == null || ¢.isEmpty();
  }

  static <T> boolean empty(final T[] ¢) {
    return ¢ == null || ¢.length == 0;
  }

  /** Determine if an item can be found in a list of values
   * @param           < T > JD
   * @param candidate what to search for
   * @param ts        where to search
   * @return true if the item is found in the list */
  @SafeVarargs static <T> boolean in(final T candidate, final T... ts) {
    return Stream.of(ts).anyMatch(λ -> is.equal(λ, candidate));
  }

  public static <T> boolean equal(@Nullable T t1, @Nullable T t2) {
    if (t1 == null)
      return t2 == null;
    if (t1 == t2)
      return true;
    return t1.equals(t2);
  }

  /** Determine if an item is not included in a list of values
   * @param           <T> JD
   * @param candidate what to search for
   * @param ts        where to search
   * @return true if the the item is not found in the list */
  @SafeVarargs static <T> boolean out(final T candidate, final T... ts) {
    return !in(candidate, ts);
  }
}
