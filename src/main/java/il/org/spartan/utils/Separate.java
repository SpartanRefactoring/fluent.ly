// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package il.org.spartan.utils;

import static il.org.spartan.strings.StringUtils.*;
import static il.org.spartan.utils.Box.*;
import static il.org.spartan.utils.___.*;

import java.util.*;

import org.jetbrains.annotations.*;

import il.org.spartan.*;
import il.org.spartan.streotypes.*;
import il.org.spartan.utils.Separate;
import il.org.spartan.utils.Separator;

/** A utility class providing library functions that take an array or a
 * collection, and return a {@link String} composed by the elements of this
 * collection, separated by a given {@link String} or <code><b>char</b></code>.
 * @author Yossi Gil, the Technion.
 * @since 07/08/2008 */
@Utility public enum Separate {
  ;
  private static final char COMMA = ',';
  private static final char SPACE = ' ';
  private static final char DOT = '.';
  public static final String NL = "\n";

  /** Separate elements of a given array of <code><b>boolean</b></code>s by a
   * given <code><b>char</b></code>
   * @param bs an array of elements to be separated
   * @param between what should be used for separating these elements.
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>bs</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final boolean[] bs, final char between) {
    return by(box(bs), between + "");
  }

  /** Separate elements of a given array of <code><b>boolean</b></code>s by a
   * given {{link @String}}
   * @param bs an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>bs</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final boolean[] bs, final String between) {
    return by(box(bs), between);
  }

  /** Separate elements of a given array of <code><b>byte</b></code>s by a given
   * <code><b>char</b></code>
   * @param bs an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>bs</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final byte[] bs, final char between) {
    return by(box(bs), between + "");
  }

  /** Separate elements of a given array of <code><b>byte</b></code>s by a given
   * {{link @String}}
   * @param bs an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>bs</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final byte[] bs, final String between) {
    return by(box(bs), between);
  }

  /** Separate elements of a given array of <code><b>char</b></code>s by a given
   * <code><b>char</b></code>
   * @param cs an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>cs</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final char[] cs, final char between) {
    return by(box(cs), between + "");
  }

  /** Separate elements of a given array of <code><b>char</b></code>s by a given
   * {{link @String}}
   * @param cs an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>cs</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final char[] cs, final String between) {
    return by(box(cs), between);
  }

  /** Separate elements of a given array of <code><b>double</b></code>s by a
   * given <code><b>char</b></code>
   * @param ds an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ds</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final double[] ds, final char between) {
    return by(box(ds), between + "");
  }

  /** Separate elements of a given array of <code><b>double</b></code>s by a
   * given {{link @String}}
   * @param ds an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ds</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final double[] ds, final String between) {
    return by(box(ds), between);
  }

  /** Separate elements of a given {{@link Iterable}} collection of objects by a
   * given {@link String}, where the textual representation of each object is
   * obtained by a user supplied function.
   * @param ts an {@link Iterable} collection of elements to be separated
   * @param <T> type of elements in the {@link Iterable} collection parameter
   * @param f a function object, providing a function that translates an object
   *        of type <code>T</code> into a {@link String}
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the result of applying
   *         function <code>f</code> to the elements in <code>ts</code> ,
   *         separated by <code>between</code> */
  @NotNull public static <T> String by(@NotNull final F<T> f, @NotNull final Iterable<? extends T> ts, final String between) {
    @NotNull final Separator s = new Separator(between);
    @NotNull final StringBuffer $ = new StringBuffer();
    for (final T ¢ : ts)
      $.append(s).append(f.__(¢));
    return $ + "";
  }

  /** Separate elements of a given {{@link Iterable}} collection of objects by a
   * given <code><b>char</b></code>, where the textual representation of each
   * object is obtained by a user supplied function.
   * @param ts an {@link Iterable} collection of elements to be separated
   * @param <T> type of elements in the {@link Iterable} collection parameter
   * @param f a function object, providing a function that translates an object
   *        of type <code>T</code> into a {@link String}
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the result of applying
   *         function <code>f</code> to the elements in <code>ts</code> ,
   *         separated by <code>between</code> */
  @NotNull public static <T> String by(@NotNull final F<T> f, @NotNull final Iterable<T> ts, final char between) {
    return by(f, ts, between + "");
  }

  /** Separate elements of a given generic array by a given
   * <code><b>char</b></code>, where the textual representation of each object
   * is obtained by a user supplied function.
   * @param ts an array of elements to be separated
   * @param <T> type of elements in <code>ts</code>
   * @param f a function object, providing a function that translates an object
   *        of type <code>T</code> into a {@link String}
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the result of applying
   *         function <code>f</code> to the elements in <code>ts</code> ,
   *         separated by <code>between</code> */
  @NotNull public static <T> String by(@NotNull final F<T> f, @NotNull final T[] ts, final char between) {
    return by(f, ts, between + "");
  }

  /** Separate elements of a given generic array by a given {{link @String}},
   * where the textual representation of each object is obtained by a user
   * supplied function.
   * @param ts an array of elements to be separated
   * @param <T> type of elements in <code>ts</code>
   * @param f a function object, providing a function that translates an object
   *        of type <code>T</code> into a {@link String}
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the result of applying
   *         function <code>f</code> to the elements in <code>ts</code> ,
   *         separated by <code>between</code> */
  @NotNull public static <T> String by(@NotNull final F<T> f, @NotNull final T[] ts, final String between) {
    @NotNull final Separator s = new Separator(between);
    @NotNull final StringBuffer $ = new StringBuffer();
    for (final T ¢ : ts)
      $.append(s).append(f.__(¢));
    return $ + "";
  }

  /** Separate elements of a given array of <code><b>float</b></code>s by a
   * given <code><b>char</b></code>
   * @param fs an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>fs</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final float[] fs, final char between) {
    return by(box(fs), between + "");
  }

  /** Separate elements of a given array of <code><b>float</b></code>s by a
   * given {{link @String}}
   * @param fs an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>fs</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final float[] fs, final String between) {
    return by(box(fs), between);
  }

  /** Separate elements of a given array of <code><b>int</b></code>s by a given
   * <code><b>char</b></code>
   * @param is an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>is</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final int[] is, final char between) {
    return by(box(is), between + "");
  }

  /** Separate elements of a given array of <code><b>int</b></code>s by a given
   * {{link @String}}
   * @param is an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>is</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final int[] is, final String between) {
    return by(box(is), between);
  }

  /** Separate elements of a given {@link Iterable} collection by a given
   * <code><b>char</b></code>
   * @param ts an {@link Iterable} collection of elements to be separated
   * @param <T> type of elements in the {@link Iterable} collection parameter
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ts</code> separated by
   *         <code>between</code> */
  @NotNull public static <T> String by(@NotNull final Iterable<T> ts, final char between) {
    return by(ts, between + "");
  }

  /** Separate elements of a given {@link Iterable} collection by a given
   * {{link @String}}
   * @param ts an {@link Iterable} collection of elements to be separated
   * @param <T> type of elements in the {@link Iterable} collection parameter
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ts</code> separated by
   *         <code>between</code> */
  @NotNull public static <T> String by(@NotNull final Iterable<T> ts, final String between) {
    @NotNull final Separator s = new Separator(between);
    @NotNull final StringBuffer $ = new StringBuffer();
    for (final T ¢ : ts)
      $.append(s).append(¢);
    return $ + "";
  }

  /** Separate elements of a given array of <code><b>long</b></code>s by a given
   * <code><b>char</b></code>
   * @param ls an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ls</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final long[] ls, final char between) {
    return by(box(ls), between + "");
  }

  /** Separate elements of a given array of <code><b>long</b></code>s by a given
   * {{link @String}}
   * @param ls an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ls</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final long[] ls, final String between) {
    return by(box(ls), between);
  }

  /** A simple minded separation of members of a {@link Map} data type.
   * @param <Key> type of elements serving as keys of the map.
   * @param <Value> type of elements serving as values of the map.
   * @param m a non-<code><b>null</b></code> {@link Map} objects whose entries
   *        are to be separated.
   * @param between a non-<code><b>null</b></code> specifying what should be
   *        used for separating these entries.
   * @param arrow a non-<code><b>null</b></code> specifying what separates a key
   *        from a value
   * @return a concatenation of all map entries, separated by
   *         <code>separator</code>, and where the key of each entry is
   *         separated from the value by <code>arrow</code>. */
  @NotNull public static <Key, Value> String by(@NotNull final Map<Key, Value> m, final String between, final String arrow) {
    nonnull(m);
    nonnull(between);
    nonnull(arrow);
    @NotNull final Separator s = new Separator(between);
    @NotNull final StringBuffer $ = new StringBuffer();
    for (final Key ¢ : m.keySet())
      $.append(s).append(¢).append(arrow).append(m.get(¢));
    return $ + "";
  }

  /** Separate elements of a given array of <code><b>short</b></code>s by a
   * given <code><b>char</b></code>
   * @param ss an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ss</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final short[] ss, final char between) {
    return by(box(ss), between + "");
  }

  /** Separate elements of a given array of <code><b>short</b></code>s by a
   * given {{link @String}}
   * @param ss an array of elements to be separated
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ss</code> separated by
   *         <code>between</code> */
  @NotNull public static String by(@NotNull final short[] ss, final String between) {
    return by(box(ss), between);
  }

  /** Separate elements of a given array by a given <code><b>char</b></code>
   * @param ts an array of elements to be separated
   * @param <T> type of elements in the array parameter
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ts</code> separated by
   *         <code>between</code> */
  @NotNull public static <T> String by(@NotNull final T[] ts, final char between) {
    return by(ts, between + "");
  }

  /** Separate elements of a given array by a given {{link @String}}
   * @param ts an array of elements to be separated
   * @param <T> type of elements in the array parameter
   * @param between what should be used for separating these elements
   * @return a {{link @String}} obtained by concatenating the textual
   *         representation of the elements in <code>ts</code> separated by
   *         <code>between</code> */
  @NotNull public static <T> String by(@NotNull final T[] ts, final String between) {
    return by(λ -> λ + "", ts, between);
  }

  /** Separate elements of a given {{@link Iterable}} collection of objects by
   * commas where the textual representation of each object is obtained by a
   * user supplied function.
   * @param ts an {@link Iterable} collection of elements to be separated
   * @param <T> type of elements in the {@link Iterable} collection parameter
   * @param f a function object, providing a function that translates an object
   *        of type <code>T</code> into a {@link String}
   * @return a {{link @String}} obtained by concatenating the result of applying
   *         function <code>f</code> to the elements in <code>ts</code> ,
   *         separated by <code>between</code> */
  @NotNull public static <T> String byCommas(@NotNull final F<T> f, @NotNull final Iterable<? extends T> ts) {
    return by(f, ts, ",");
  }

  /** Separate a variables length list of arguments by a comma character.
   * @param ¢ the objects to be separated.
   * @return a concatenation of the comma separated {@link Object#toString()}
   *         representations of the elements of <code>os</code>. */
  @NotNull public static String byCommas(@NotNull final Object... ¢) {
    return by(¢, COMMA);
  }

  /** Separate a variables length list of arguments by a dot character.
   * @param ¢ the objects to be separated.
   * @return a concatenation of the space separated {@link Object#toString()}
   *         representations of the elements of <code>os</code>. */
  @NotNull public static String byDots(final Object... ¢) {
    return by(prune.whites(¢), DOT);
  }

  /** Separate a variables length list of arguments by a dot character.
   * @param ¢ the objects to be separated.
   * @return a concatenation of the space separated {@link Object#toString()}
   *         representations of the elements of <code>os</code>. */
  @NotNull public static String byNewLines(final Object... ¢) {
    return by(prune.whites(¢), "\n");
  }

  /** Separate a variables length list of arguments by a space character.
   * @param ¢ the objects to be separated.
   * @return a concatenation of the space separated {@link Object#toString()}
   *         representations of the elements of <code>os</code>. */
  @NotNull public static String bySpaces(final Object... ¢) {
    return by(prune.whites(¢), SPACE);
  }

  /** A simple program demonstrating the use of this class. This program prints
   * a comma separated list of its arguments, where special characters in each
   * argument are escaped prior to printing.
   * @param args list of the command line arguments. */
  public static void main(@NotNull final String[] args) {
    System.out.println("Arguments are: " + Separate.by(λ -> "\"" + esc(λ) + "\"", args, ", "));
  }

  @NotNull public static String nl(@NotNull final Iterable<String> ¢) {
    return by(¢, NL);
  }

  @NotNull public static String nl(@NotNull final String... ¢) {
    return by(¢, NL);
  }

  /** An interface supplying a function object pointer, where the function
   * return value is {@link String}. To create such a pointer, create a subclass
   * that implements this interface (typically as an anonymous class), giving an
   * implementation to function {@link #__(Object)}, and then pass an instance
   * of this subclass class.
   * @author Yossi Gil, the Technion.
   * @since 07/08/2008
   * @param <T> type of values that the function takes */
  public interface F<T> {
    /** Anonymous function for translating an object into text
     * @param t an object of type <code>T</code>
     * @return a textual */
    @NotNull String __(T t);
  }
}
