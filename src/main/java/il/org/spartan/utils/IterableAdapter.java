// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package il.org.spartan.utils;

import static il.org.spartan.utils.___.*;

import java.util.*;

import org.jetbrains.annotations.*;

import il.org.spartan.streotypes.*;
import il.org.spartan.utils.IterableAdapter;

/** An {@link Iterable} interface to an {@link Enumeration} using the
 * <b>Adapter</b> design pattern.
 * @author Yossi Gil, the Technion.
 * @since 31/07/2008
 * @param <T> type of elements in the iterated collection */
@Canopy @Instantiable public final class IterableAdapter<T> implements Iterable<T> {
  /** A factory method, generating an {@link Iterable} from a given
   * {@link Enumeration}
   * @param <T> type of elements in the iterated collection
   * @param ¢ an enumeration to convert into an {@link Iterable}
   * @return a new {@link Iterable} created from the parameter */
  @NotNull public static <T> Iterable<T> make(final Enumeration<T> ¢) {
    return new IterableAdapter<>(¢);
  }

  final Enumeration<T> implementation;

  /** Create an {@link Iterable} from a given enumeration
   * @param implmenetation an enumeration adapted by the newly created
   *        {@link Iterable} */
  public IterableAdapter(final Enumeration<T> implmenetation) {
    this.implementation = implmenetation;
  }

  @Override @NotNull public Iterator<T> iterator() {
    return new Iterator<T>() {
      @Override public boolean hasNext() {
        return implementation.hasMoreElements();
      }

      @Override public T next() {
        return implementation.nextElement();
      }

      @Override public void remove() {
        require(false, "cannot remove elements from an adapted enumeration");
      }
    };
  }
}
