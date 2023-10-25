package mars_rover;

public enum Direction {
  N {
    @Override
    public Direction rotateLeft() {
      return Direction.create("W");
    }

    @Override
    public Direction rotateRight() {
      return Direction.create("E");
    }

    @Override
    public Coordinates move(Coordinates coordinates, int displacement) {
      return coordinates.moveAlongYAxis(displacement);
    }
  }, E {
    @Override
    public Direction rotateLeft() {
      return Direction.create("N");
    }

    @Override
    public Direction rotateRight() {
      return Direction.create("S");
    }

    @Override
    public Coordinates move(Coordinates coordinates, int displacement) {
      return coordinates.moveAlongXAxis(-displacement);
    }
  }, S {
    @Override
    public Direction rotateLeft() {
      return Direction.create("E");
    }

    @Override
    public Direction rotateRight() {
      return Direction.create("W");
    }

    @Override
    public Coordinates move(Coordinates coordinates, int displacement) {
      return coordinates.moveAlongYAxis(-displacement);
    }
  }, W {
    @Override
    public Direction rotateLeft() {
      return Direction.create("S");
    }

    @Override
    public Direction rotateRight() {
      return Direction.create("N");
    }

    @Override
    public Coordinates move(Coordinates coordinates, int displacement) {
      return coordinates.moveAlongXAxis(displacement);
    }
  };

  public static Direction create(String direction) {
    // TODO Use if as the video
    return Direction.valueOf(direction);
  }

  public abstract Direction rotateLeft();
  public abstract Direction rotateRight();
  public abstract Coordinates move(Coordinates coordinates, int displacement);
}
