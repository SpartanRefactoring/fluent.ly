// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package il.org.spartan.utils;

import org.jetbrains.annotations.*;

import il.org.spartan.streotypes.*;
import il.org.spartan.utils.Unbox;

/** A utility class, with a collection of function to box primitive types in
 * their reference type equivalent representation. Similarly, this class offers
 * functions to box arrays of primitive types into their reference type
 * equivalent.
 * @author Yossi Gil, the Technion.
 * @since 21/06/2008
 * @see Unbox */
@Utility public enum Box {
  // A namespace: no values to this <code><b>enum</b></code>
  ;
  /** Box a <code><b>boolean</b></code> into a {@link Boolean} object.
   * @param ¢ some <code><b>boolean</b></code> value
   * @return a non-<code><b>null</b></code> {@link Boolean} with the value of
   *         <code>c</code> */
  public static Boolean box(final boolean ¢) {
    return Boolean.valueOf(¢);
  }

  /** Box an array of <code><b>boolean</b></code>s into an array of
   * {@link Boolean}s.
   * @param bs an array of <code><b>boolean</b></code>s
   * @return an array of {@link Boolean} of the same length as that of the
   *         parameter, and such that it in its <tt>i</tt><em>th</em> position
   *         is the boxed value of the <tt>i</tt><em>th</em> of the parameter */
  @NotNull public static Boolean[] box(@NotNull final boolean bs[]) {
    @NotNull final Boolean[] $ = new Boolean[bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  /** Box a <code><b>byte</b></code> into a {@link Byte} object.
   * @param ¢ some <code><b>long</b></code> value
   * @return a non-<code><b>null</b></code> {@link Long} with the value of
   *         <code>l</code> */
  public static Byte box(final byte ¢) {
    return Byte.valueOf(¢);
  }

  /** Box an array of <code><b>byte</b></code>s into an array of {@link Byte}s.
   * @param bs an array of <code><b>byte</b></code>s
   * @return an array of {@link Byte} of the same length as that of the
   *         parameter, and such that it in its <tt>i</tt><em>th</em> position
   *         is the boxed value of the <tt>i</tt><em>th</em> of the parameter */
  @NotNull public static Byte[] box(@NotNull final byte bs[]) {
    @NotNull final Byte[] $ = new Byte[bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  /** Box a <code><b>char</b></code> into a {@link Character} object.
   * @param ¢ some <code><b>char</b></code> value
   * @return a non-<code><b>null</b></code> {@link Character} with the value of
   *         <code>c</code> */
  public static Character box(final char ¢) {
    return Character.valueOf(¢);
  }

  /** Box an array of <code><b>byte</b></code>s into an array of
   * {@link Character}s.
   * @param cs an array of <code><b>long</b></code>s
   * @return an array of {@link Character} of the same length as that of the
   *         parameter, and such that it in its <tt>i</tt><em>th</em> position
   *         is the boxed value of the <tt>i</tt><em>th</em> of the parameter */
  @NotNull public static Character[] box(@NotNull final char cs[]) {
    @NotNull final Character[] $ = new Character[cs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(cs[¢]);
    return $;
  }

  /** Box a <code><b>double</b></code> into a {@link Double} object.
   * @param ¢ some <code><b>double</b></code> value
   * @return a non-<code><b>null</b></code> {@link Double} with the value of
   *         <code>d</code> */
  public static Double box(final double ¢) {
    return Double.valueOf(¢);
  }

  /** Box an array of <code><b>double</b></code>s into an array of
   * {@link Double} s.
   * @param ds an array of <code><b>double</b></code>s
   * @return an array of {@link Double} of the same length as that of the
   *         parameter, and such that it in its <tt>i</tt><em>th</em> position
   *         is the boxed value of the <tt>i</tt><em>th</em> of the parameter */
  @NotNull public static Double[] box(@NotNull final double ds[]) {
    @NotNull final Double[] $ = new Double[ds.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ds[¢]);
    return $;
  }

  /** Box a <code><b>float</b></code> into a {@link Float} object.
   * @param ¢ some <code><b>float</b></code> value
   * @return a non-<code><b>null</b></code> {@link Float} with the value of
   *         <code>f</code> */
  public static Float box(final float ¢) {
    return Float.valueOf(¢);
  }

  /** Box an array of <code><b>float</b></code>s into an array of {@link Float}
   * s.
   * @param fs an array of <code><b>float</b></code>s
   * @return an array of {@link Float} of the same length as that of the
   *         parameter, and such that it in its <tt>i</tt><em>th</em> position
   *         is the boxed value of the <tt>i</tt><em>th</em> of the parameter */
  @NotNull public static Float[] box(@NotNull final float fs[]) {
    @NotNull final Float[] $ = new Float[fs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(fs[¢]);
    return $;
  }

  /** Box an <code><b>int</b></code> into an {@link Integer} object.
   * @param ¢ some <code><b>int</b></code> value
   * @return a non-<code><b>null</b></code> {@link Integer} with the value of
   *         <code>n</code> */
  public static Integer box(final int ¢) {
    return Integer.valueOf(¢);
  }

  /** Box an array of <code><b>int</b></code>s into an array of {@link Integer}
   * s.
   * @param is an array of <code><b>int</b></code>s
   * @return an array of {@link Integer} of the same length as that of the
   *         parameter, and such that it in its <tt>i</tt><em>th</em> position
   *         is the boxed value of the <tt>i</tt><em>th</em> of the parameter */
  @NotNull public static Integer[] box(@NotNull final int is[]) {
    @NotNull final Integer[] $ = new Integer[is.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(is[¢]);
    return $;
  }

  /** Box a <code><b>long</b></code> into a {@link Long} object.
   * @param ¢ some <code><b>long</b></code> value
   * @return a non-<code><b>null</b></code> {@link Long} with the value of
   *         <code>l</code> */
  public static Long box(final long ¢) {
    return Long.valueOf(¢);
  }

  /** Box an array of <code><b>long</b></code>s into an array of {@link Long}s.
   * @param ls an array of <code><b>long</b></code>s
   * @return an array of {@link Long} of the same length as that of the
   *         parameter, and such that it in its <tt>i</tt><em>th</em> position
   *         is the boxed value of the <tt>i</tt><em>th</em> of the parameter */
  @NotNull public static Long[] box(@NotNull final long ls[]) {
    @NotNull final Long[] $ = new Long[ls.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ls[¢]);
    return $;
  }

  /** Box a <code><b>short</b></code> into a {@link Short} object.
   * @param ¢ some <code><b>short</b></code> value
   * @return a non-<code><b>null</b></code> {@link Short} with the value of
   *         <code>s</code> */
  public static Short box(final short ¢) {
    return Short.valueOf(¢);
  }

  /** Box an array of <code><b>short</b></code>s into an array of {@link Short}
   * s.
   * @param ss an array of <code><b>short</b></code>s
   * @return an array of {@link Short} of the same length as that of the
   *         parameter, and such that it in its <tt>i</tt><em>th</em> position
   *         is the boxed value of the <tt>i</tt><em>th</em> of the parameter */
  @NotNull public static Short[] box(@NotNull final short ss[]) {
    @NotNull final Short[] $ = new Short[ss.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ss[¢]);
    return $;
  }

  public static Double it(final double ¢) {
    return box(¢);
  }

  /** Box an <code><b>int</b></code> into an {@link Integer} object.
   * @param ¢ some <code><b>int</b></code> value
   * @return a non-<code><b>null</b></code> {@link Integer} with the value of
   *         <code>n</code>
   * @see #box(int) */
  public static Integer it(final int ¢) {
    return box(¢);
  }

  /** Box an array of <code><b>int</b></code>s into an array of {@link Integer}
   * s.
   * @param ¢ an array of <code><b>int</b></code>s
   * @return an array of {@link Integer} of the same length as that of the
   *         parameter, and such that it in its <tt>i</tt><em>th</em> position
   *         is the boxed value of the <tt>i</tt><em>th</em> of the parameter */
  @NotNull public static Integer[] it(@NotNull final int ¢[]) {
    return box(¢);
  }

  /** Box a <code><b>long</b></code> into a {@link Long} object.
   * @param ¢ some <code><b>long</b></code> value
   * @return a non-<code><b>null</b></code> {@link Long} with the value of
   *         <code>l</code> */
  public static Long it(final long ¢) {
    return box(¢);
  }
}
