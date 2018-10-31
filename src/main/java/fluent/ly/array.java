package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;

public interface array {
  /** Sorts an array
   * @param ¢ what to sort
   * @return given array with elements in sorted order */
  static int @NotNull [] sort(final int @NotNull [] ¢) {
    Arrays.sort(¢);
    return ¢;
  }

  /** Swap the contents of two cells in a given array
   * @param    <T> type of array elements
   * @param ts the given array
   * @param i  index of one cell
   * @param j  index of another cell */
  static <T> void swap(final T[] ts, final int i, final int j) {
    final T t = ts[i];
    ts[i] = ts[j];
    ts[j] = t;
  }

  /** Deletes a specified element from an array, by reallocating an array whose
   * size is smaller by one and shifting the other elements down.
   * @param    <T> JD
   * @param ts an arbitrary array
   * @param i  position of element to be deleted
   * @return newly created array */
  static <T> T[] delete(final T[] ts, final int i) {
    @SuppressWarnings("null") final T @NotNull [] $ = Arrays.copyOf(ts, ts.length - 1);
    System.arraycopy(ts, i + 1, $, i, $.length - i);
    return $;
  }

  /** Appends an element to an array, by reallocating an array whose size is
   * greater by one and placing the element at the last position.
   * @param    <T> JD
   * @param ts an arbitrary array
   * @param t  an element
   * @return newly created array */
  static <T> T @NotNull [] append(final @NotNull T[] ts, final T t) {
    @SuppressWarnings("null") final T @NotNull [] $ = Arrays.copyOf(ts, 1 + ts.length);
    $[ts.length] = t;
    return $;
  }
}
