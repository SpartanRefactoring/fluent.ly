package fluent.ly;

import org.junit.jupiter.api.*;

@SuppressWarnings("static-method") class truTest {
  @Test void testBoolean() {
    assert tru.ignoring(true);
  }

  @Test void testInt() {
    assert tru.ignoring(0);
  }

  @Test void testNull() {
    assert tru.ignoring(null);
  }

  @Test void testObject() {
    assert tru.ignoring(new Object());
  }

  @Test void testDouble() {
    assert tru.ignoring(3.2);
  }

  @Test void testFloat() {
    assert tru.ignoring(3.2f);
  }

  @Test void testChar() {
    assert tru.ignoring('c');
  }

  @Test void testByte() {
    assert tru.ignoring((byte) 12);
  }
}
