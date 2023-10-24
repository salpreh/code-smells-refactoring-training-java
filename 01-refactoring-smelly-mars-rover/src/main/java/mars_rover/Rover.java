package mars_rover;

public class Rover {

    private String direction;
    private Direction directionType;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.setDirection(direction);
        this.y = y;
        this.x = x;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

          if (command.equals("l")) {

            // Rotate Rover
            if (isFacingNorth()) {
              setDirection("W");
            } else if (isFacingSouth()) {
              setDirection("E");
            } else if (isFacingWest()) {
              setDirection("S");
            } else {
              setDirection("N");
            }
          } else if (command.equals("r")) {

            // Rotate Rover
            if (isFacingNorth()) {
              setDirection("E");
            } else if (isFacingSouth()) {
              setDirection("W");
            } else if (isFacingWest()) {
              setDirection("N");
            } else {
              setDirection("S");
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
    return Direction.W.equals(this.directionType);
  }

  private boolean isFacingSouth() {
    return Direction.S.equals(this.directionType);
  }

  private boolean isFacingNorth() {
    return Direction.N.equals(this.directionType);
  }

  private void setDirection(String direction) {
    this.direction = direction;
    this.directionType = Direction.create(direction);
  }

  public String getDirection() {
    return direction;
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
    return directionType == rover.directionType;
  }

  @Override
  public int hashCode() {
    int result = directionType != null ? directionType.hashCode() : 0;
    result = 31 * result + y;
    result = 31 * result + x;
    return result;
  }

  @Override
  public String toString() {
    return "Rover{" +
      "directionType=" + directionType +
      ", y=" + y +
      ", x=" + x +
      '}';
  }
}
