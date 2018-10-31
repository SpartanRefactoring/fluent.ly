package il.org.spartan.utils;

import java.io.*;
import java.nio.charset.*;
import java.util.stream.*;

import org.jetbrains.annotations.*;

/** Fluent API
 * @author Yossi Gil
 * @since 2016 */
public interface fault {
  static @NotNull String done() {
    return done(stackCapture());
  }

  static @NotNull String done(final Throwable ¢) {
    return "\n   Stack trace: [[[.................\n\n" + //
        trace(¢) + //
        "\n   END stack trace: .................]]]" + //
        "\n-----this is all I know.";
  }

  static Throwable stackCapture() {
    return new AssertionError();
  }

  static @NotNull String trace() {
    return trace(stackCapture());
  }

  static @NotNull String trace(final Throwable ¢) {
    final ByteArrayOutputStream $ = new ByteArrayOutputStream();
    ¢.printStackTrace(new PrintStream($));
    return new String($.toByteArray(), StandardCharsets.UTF_8);
  }

  static @NotNull String dump() {
    return dump("");
  }

  static @NotNull String dump(final @NotNull String specfically) {
    return "\n FAULT: this should not have happened!" + specfically + "\n-----To help you fix the code, here is some info";
  }

  static boolean unreachable() {
    return false;
  }

  static @NotNull String specifically(final @NotNull String explanation, final Object... os) {
    return dump("\n " + explanation) + Stream.of(os).map(λ -> dump(λ.getClass().getSimpleName(), λ)).reduce((x, y) -> x + y).get() + done();
  }

  static @NotNull String dump(final @NotNull String name, final Object value) {
    return "\n " + name + "=[" + value + "]";
  }

  static boolean bool(@SuppressWarnings("unused") final Object __) {
    return false;
  }
}
