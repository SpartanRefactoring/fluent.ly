package il.org.spartan.utils;

import java.util.stream.*;

import il.org.spartan.utils.Duplo;
import il.org.spartan.utils.Nested;

/** nested element in a hierarchical structure
 * @author Dor Ma'ayan <tt>dor.d.ma@gmail.com</tt>
 * @author Ori Roth
 * @author Oren Afek
 * @since 2017-03-27 */
public interface Nested<T> extends Duplo<T> {
  interface Root<T> extends Nested<T>, Duplo.Atomic<T> {
    //
  }

  @Override default NeighborsMerger<T> neighborsMerger() {
    return (self, others) -> {
      Stream<T> $ = Stream.empty();
      for (final Duplo<T> ¢ : others)
        $ = Stream.concat(¢.neighborsStream(), selfStream());
      return $;
    };
  }

  interface Compound<T> extends Nested<T>, Duplo.Compound<T> {
    Nested<T> parent();

    @Override default Iterable<Duplo<T>> neighbors() {
      return a.singleton.list(parent());
    }
  }
}
