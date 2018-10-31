package il.org.spartan.utils;

import org.jetbrains.annotations.*;

/** Reducer that concatenate strings
 * @author Yossi Gil
 * @since 2017-03-19 */
public class ReduceStringConcatenate extends Reduce<String> {
  @Override public String reduce(final @NotNull String s1, final @NotNull String s2) {
    return s1 + s2;
  }

  @Override public String reduce() {
    return "";
  }
}
