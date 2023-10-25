package mars_rover;

public class Rover {

  private Direction direction;
  private int y;
  private int x;

  public Rover(int x, int y, String direction) {
    this.direction = Direction.create(direction);
    this.y = y;
    this.x = x;
  }

  public void receive(String commandsSequence) {
    for (int i = 0; i < commandsSequence.length(); ++i) {
      String command = commandsSequence.substring(i, i + 1);

      if (command.equals("l")) {

        // Rotate Rover
        if (isFacingNorth()) {
          this.direction = Direction.create("W");
        } else if (isFacingSouth()) {
          this.direction = Direction.create("E");
        } else if (isFacingWest()) {
          this.direction = Direction.create("S");
        } else {
          this.direction = Direction.create("N");
        }
      } else if (command.equals("r")) {

        // Rotate Rover
        if (isFacingNorth()) {
          this.direction = Direction.create("E");
        } else if (isFacingSouth()) {
          this.direction = Direction.create("W");
        } else if (isFacingWest()) {
          this.direction = Direction.create("N");
        } else {
          this.direction = Direction.create("S");
        }
      } else {

        // Displace Rover
        int displacement1 = -1;

        if (command.equals("f")) {
          displacement1 = 1;
        }
        int displacement = displacement1;

        if (isFacingNorth()) {
          y += displacement;
        } else if (isFacingSouth()) {
          y -= displacement;
        } else if (isFacingWest()) {
          x -= displacement;
        } else {
          x += displacement;
        }
      }
    }
  }

  private boolean isFacingWest() {
    return Direction.W.equals(this.direction);
  }

  private boolean isFacingSouth() {
    return Direction.S.equals(this.direction);
  }

  private boolean isFacingNorth() {
    return Direction.N.equals(this.direction);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Rover rover = (Rover) o;

    if (y != rover.y) {
      return false;
    }
    if (x != rover.x) {
      return false;
    }
    return direction == rover.direction;
  }

  @Override
  public int hashCode() {
    int result = direction != null ? direction.hashCode() : 0;
    result = 31 * result + y;
    result = 31 * result + x;
    return result;
  }

  @Override
  public String toString() {
    return "Rover{" +
      "directionType=" + direction +
      ", y=" + y +
      ", x=" + x +
      '}';
  }
}
