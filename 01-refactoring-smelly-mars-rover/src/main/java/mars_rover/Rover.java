package mars_rover;

import java.util.Objects;

public class Rover {

  private Direction direction;
  private Coordinates coordinates;

  public Rover(int x, int y, String direction) {
    this.direction = Direction.create(direction);
    this.coordinates = new Coordinates(x, y);
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
          this.coordinates = coordinates.moveAlongYAxis(displacement);
        } else if (isFacingSouth()) {
          this.coordinates = coordinates.moveAlongYAxis(-displacement);
        } else if (isFacingWest()) {
          this.coordinates = coordinates.moveAlongXAxis(displacement);
        } else {
          this.coordinates = coordinates.moveAlongXAxis(-displacement);
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

    if (direction != rover.direction) {
      return false;
    }
    return Objects.equals(coordinates, rover.coordinates);
  }

  @Override
  public int hashCode() {
    int result = direction != null ? direction.hashCode() : 0;
    result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Rover{" +
      "direction=" + direction +
      ", coordinates=" + coordinates +
      '}';
  }
}
