package mars_rover;

public enum Direction {
  N {
    @Override
    public Direction rotateLeft() {
      return Direction.create("W");
    }
  }, E {
    @Override
    public Direction rotateLeft() {
      return Direction.create("N");
    }
  }, S {
    @Override
    public Direction rotateLeft() {
      return Direction.create("E");
    }
  }, W {
    @Override
    public Direction rotateLeft() {
      return Direction.create("S");
    }
  };

  public static Direction create(String direction) {
    // TODO Use if as the video
    return Direction.valueOf(direction);
  }

  public abstract Direction rotateLeft();
}
