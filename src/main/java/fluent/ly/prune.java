/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package fluent.ly;

import static il.org.spartan.Utils.*;
import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** A <b>Utility class</b> providing functions to remove
 * <code><b>null</b></code> elements from arrays and iterable collections. For
 * example, to process the non-<code><b>null</b></code> elements of an array:
 *
 * <pre>
 * void f(String ss[]) {
 *     for (String s: Prune.nulls(ss))
 *     		// ... s is not null.
 * }
 * </pre>
 *
 * @author Yossi Gil
 * @since 27/08/2008 */
public enum prune {
  ;
  private static @NotNull String[] asArrray(final @NotNull List<String> $) {
    return cantBeNull($.toArray(new String @NotNull [0]));
  }

  /** Prune <code><b>null</b></code> elements from a given collection.
   * @param    <T> JD
   * @param    <C> JD
   * @param ts JD */
  public static @NotNull <T, C extends Collection<T>> C nulls(final @NotNull C $) {
    for (final @NotNull Iterator<T> ¢ = $.iterator(); ¢.hasNext();)
      if (¢.next() == null)
        ¢.remove();
    return $;
  }

  /** Prune <code><b>null</b></code> elements from a given collection.
   * @param    <T> type of elements in the collection.
   * @param ts a collection of values.
   * @return a new collection, containing only those non- <code><b>null</b></code>
   *         elements of the parameter, and in the same order. No
   *         <code><b>null</b></code> elements are present on this returned
   *         collection. */
  public static @NotNull <T> List<T> nulls(final @NotNull Iterable<T> ts) {
    final @NotNull ArrayList<T> $ = new ArrayList<>();
    for (final @Nullable T ¢ : ts)
      if (¢ != null)
        $.add(¢);
    return $;
  }

  /** Prune <code><b>null</b></code> elements from a given array.
   * @param    <T> type of elements in the array.
   * @param ts an array of values.
   * @return a new array, containing precisely those non- <code><b>null</b></code>
   *         elements of the parameter, and in the same order. No
   *         <code><b>null</b></code> elements are present on this returned
   *         collection. */
  public static @NotNull <T> T[] nulls(final T[] ts) {
    final @NotNull List<@NotNull T> $ = new ArrayList<>();
    if (ts != null)
      for (final @Nullable T ¢ : ts)
        if (¢ != null)
          $.add(¢);
    return cantBeNull($.toArray(shrink(ts)));
  }

  /** Shrink an array size to zero.
   * @param   <T> type of elements in the input array.
   * @param ¢ an array of values.
   * @return an array of size 0 of elements of type <code>T</code>. */
  private static <T> T[] shrink(final T @NotNull [] ¢) {
    return Arrays.copyOf(¢, 0);
  }

  public static <T> @NotNull String @NotNull [] whites(final @NotNull T... ts) {
    final @NotNull List<String> $ = new ArrayList<>();
    for (final @Nullable T ¢ : ts)
      if (¢ != null)
        accumulate.to($).add((¢ + "").trim());
    return asArrray($);
  }

  /** A JUnit test class for the enclosing class.
   * @author Yossi Gil, the Technion.
   * @since 27/08/2008 */
  @SuppressWarnings({ "static-method", "synthetic-access" }) //
  public static class TEST1 {
    final @NotNull String @Nullable [] alternatingArray = new String @Nullable [] { null, "A", null, null, "B", null, null, null, "C", null };
    final @NotNull String[] nonNullArray = { "1", "2", "4" };
    private final @NotNull lazy<List<String>> sparseCollection = new lazy<List<String>>() {
      @Override public @NotNull List<String> get() {
        return as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null, null, null, null);
      }
    };

    @Test public void nullsNotNullArrayLength() {
      assertEquals(nonNullArray.length, nulls(nonNullArray).length);
    }

    @Test public void nullsNullArrayItems() {
      assertEquals("1", nulls(nonNullArray)[0]);
      assertEquals("2", nulls(nonNullArray)[1]);
      assertEquals("4", nulls(nonNullArray)[2]);
    }

    @Test public void nullsPruneArrayAltenatingItems() {
      assertEquals("A", nulls(alternatingArray)[0]);
      assertEquals("B", nulls(alternatingArray)[1]);
      assertEquals("C", nulls(alternatingArray)[2]);
    }

    @Test public void nullsPruneArrayAltenatingLength() {
      assertEquals(3, nulls(alternatingArray).length);
    }

    @Test public void nullsPruneSparseCollectionContents() {
      final @NotNull String[] a = nulls(sparseCollection.get()).toArray(new String[3]);
      assertEquals("A", a[0]);
      assertEquals("B", a[1]);
      assertEquals("C", a[2]);
      assertEquals(3, a.length);
    }

    @Test public void nullsPruneSparseCollectionLength() {
      assertEquals(3, nulls(sparseCollection.get()).size());
    }

    @Test public void nullsPrunNotNull() {
      assert nulls(sparseCollection.get()) != null;
    }

    @Test public void shrinkArray() {
      assertEquals(0, shrink(new Object[10]).length);
    }

    @Test public void shrinkEmptyArray() {
      assertEquals(0, shrink(new Object[0]).length);
    }

    @Test public void whitesEmptyArray() {
      assertEquals(0, prune.whites().length);
    }

    @Test public void whitesEmptyList() {
      assertEquals(0, prune.whites().length);
    }
  }

  /** A JUnit test class for the enclosing class.
   * @author Yossi Gil, the Technion.
   * @since 27/08/2008 */
  @SuppressWarnings({ "static-method", "synthetic-access" }) public static class TEST2 {
    final @NotNull String @NotNull [] alternatingArray = new String[] { null, "A", null, null, "B", null, null, null, "C", null };
    final @NotNull String @NotNull [] nonNullArray = { "1", "2", "4" };
    final @NotNull Supplier<List<String>> x = new Supplier<List<String>>() {
      @Override public List<String> get() {
        List<String> $ = an.empty.list();
        $.add(null);
        $.add(null);
        $.add(null);
        $.add(null);
        $.add(null);
        $.add("A");
        $.add(null);
        $.add(null);
        $.add(null);
        $.add("B");
        $.add(null);
        $.add("C");
        $.add(null);
        $.add(null);
        $.add(null);
        $.add(null);
        return $;
      }
    };
    private @NotNull List<String> sparseCollection = new Supplier<List<String>>() {
      @Override public @NotNull List<String> get() {
        @NotNull List<String> $ = an.empty.list();
        $.add(null);
        $.add(null);
        $.add(null);
        $.add(null);
        $.add(null);
        $.add("A");
        $.add(null);
        $.add(null);
        $.add(null);
        $.add("B");
        $.add(null);
        $.add("C");
        $.add(null);
        $.add(null);
        $.add(null);
        $.add(null);
        return $;
      }
    }.get();

    @Test public void testNotNullArrayItems() {
      azzert.that(nulls(nonNullArray)[0], is("1"));
      azzert.that(nulls(nonNullArray)[1], is("2"));
      azzert.that(nulls(nonNullArray)[2], is("4"));
    }

    @Test public void testNotNullArrayLength() {
      azzert.that(nulls(nonNullArray).length, is(nonNullArray.length));
    }

    @Test public void testPruneArrayAltenatingItems() {
      azzert.that(nulls(alternatingArray)[0], is("A"));
      azzert.that(nulls(alternatingArray)[1], is("B"));
      azzert.that(nulls(alternatingArray)[2], is("C"));
    }

    @Test public void testPruneArrayAltenatingLength() {
      azzert.that(nulls(alternatingArray).length, is(3));
    }

    @Test public void testPruneSparseCollectionContents() {
      final @NotNull String[] a = nulls(sparseCollection).toArray(new String[3]);
      azzert.that(a[0], is("A"));
      azzert.that(a[1], is("B"));
      azzert.that(a[2], is("C"));
      azzert.that(a.length, is(3));
    }

    @Test public void testPruneSparseCollectionLength() {
      azzert.that(nulls(sparseCollection).size(), is(3));
    }

    @Test public void testPrunNotNull() {
      assert nulls(sparseCollection) != null;
    }

    @Test public void testShrink() {
      azzert.that(shrink(new Object[10]).length, is(0));
    }
  }
}
