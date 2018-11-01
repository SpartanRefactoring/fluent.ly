package fluent.ly;

import org.junit.jupiter.api.*;

@SuppressWarnings("static-method") class falzeTest {
  @Test void testBoolean() {
    assert !falze.ignoring(true);
  }

  @Test void testInt() {
    assert !falze.ignoring(0);
  }

  @Test void testNull() {
    assert !falze.ignoring(null);
  }

  @Test void testObject() {
    assert !falze.ignoring(new Object());
  }

  @Test void testDouble() {
    assert !falze.ignoring(3.2);
  }

  @Test void testFloat() {
    assert !falze.ignoring(3.2f);
  }

  @Test void testChar() {
    assert !falze.ignoring('c');
  }

  @Test void testByte() {
    assert !falze.ignoring((byte) 12);
  }


}
