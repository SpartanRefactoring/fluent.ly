package fluent.ly;

import org.jetbrains.annotations.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-13 */
public interface de {
  interface To<@NotNull T> {
    @NotNull T to(@NotNull T t);
  }

  static <T> To<@NotNull T> fault(final T value) {
    return λ -> value == null ? λ : value;
  }
}
