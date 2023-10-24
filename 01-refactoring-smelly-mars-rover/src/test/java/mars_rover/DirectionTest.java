package mars_rover;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DirectionTest {

  @Test
  void shouldCreateDirection() {
    assertEquals(Direction.N, Direction.create("N"));
    assertEquals(Direction.E, Direction.create("E"));
    assertEquals(Direction.S, Direction.create("S"));
    assertEquals(Direction.W, Direction.create("W"));
  }
}