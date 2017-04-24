package il.org.spartan.utils;

import static il.org.spartan.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.*;
import il.org.spartan.utils.Primes;

/** @author Yossi Gil
 * @since Mar 1, 2012 */
public class Primes {
  private static boolean isPrime(final int c) {
    for (int d = 2; d * d <= c; ++d)
      if (c % d == 0)
        return false;
    return true;
  }

  private int current = 1;

  public int next() {
    for (;;)
      if (isPrime(++current))
        return current;
  }

  @SuppressWarnings("static-method") //
  public static class TEST {
    @Test public void firstIsTwo() {
      azzert.that(new Primes().next(), is(2));
    }

    @Test public void secondIsThree() {
      @NotNull final Primes p = new Primes();
      p.next();
      azzert.that(p.next(), is(3));
    }

    @Test public void thirdIsFive() {
      @NotNull final Primes p = new Primes();
      p.next();
      p.next();
      azzert.that(p.next(), is(5));
    }
  }
}
