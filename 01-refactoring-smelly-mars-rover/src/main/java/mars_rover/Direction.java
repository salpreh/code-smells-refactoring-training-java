package mars_rover;

public enum Direction {
  N, E, S, W;

  public static Direction create(String direction) {
    return Direction.valueOf(direction);
  }
}
