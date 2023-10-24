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
            if (getDirection().equals("N")) {
              setDirection("W");
            } else if (getDirection().equals("S")) {
              setDirection("E");
            } else if (getDirection().equals("W")) {
              setDirection("S");
            } else {
              setDirection("N");
            }
          } else if (command.equals("r")) {

            // Rotate Rover
            if (getDirection().equals("N")) {
              setDirection("E");
            } else if (getDirection().equals("S")) {
              setDirection("W");
            } else if (getDirection().equals("W")) {
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

            if (getDirection().equals("N")) {
              y += displacement;
            } else if (getDirection().equals("S")) {
              y -= displacement;
            } else if (getDirection().equals("W")) {
              x -= displacement;
            } else {
              x += displacement;
            }
          }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (y != rover.y) return false;
        if (x != rover.x) return false;
        return getDirection()
          != null ? getDirection().equals(rover.getDirection()) : rover.getDirection() == null;

    }

    @Override
    public int hashCode() {
        int result = getDirection() != null ? getDirection().hashCode() : 0;
        result = 31 * result + y;
        result = 31 * result + x;
        return result;
    }

    @Override
    public String toString() {
        return "Rover{" +
            "direction='" + getDirection() + '\'' +
            ", y=" + y +
            ", x=" + x +
            '}';
    }

  private void setDirection(String direction) {
    this.direction = direction;
    this.directionType = Direction.create(direction);
  }

  public String getDirection() {
    return direction;
  }
}
