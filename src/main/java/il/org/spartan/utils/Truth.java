package il.org.spartan.utils;

import java.util.function.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

public enum Truth {
  T("true"), //
  F("false"), //
  X("Assertion exception"), //
  N("Null pointer exception"), //
  R("Runtime exception"), //
  Ħ("Throwable of some other kind");
  public static Truth truthOf(final BooleanSupplier $) {
    try {
      return $.getAsBoolean() ? T : F;
    } catch (final NullPointerException e) {
      forget.it(e);
      return N;
    } catch (final AssertionError e) {
      forget.it(e);
      return X;
    } catch (final RuntimeException e) {
      forget.it(e);
      return R;
    } catch (final Throwable e) {
      forget.it(e);
      return Ħ;
    }
  }

  Truth not() {
    return this == T ? F : //
        this == F ? T : //
            this;
  }

  Truth or(final Truth other) {
    return this == T ? this : other;
  }

  Truth and(final Truth other) {
    return this == F ? this : other;
  }

  public static String letterOf(final BooleanSupplier ¢) {
    return truthOf(¢) + "";
  }

  public final @NotNull String description;

  Truth(final @NotNull String description) {
    this.description = description;
  }

  @Override public String toString() {
    return description;
  }
}
