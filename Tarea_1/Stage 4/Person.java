public class Person {
    public Person(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void leftMove() {
        x = x - 0.5;
    }

    public void upMove() {
        y = y + 0.5;
    }

    public void downMove() {
        y = y - 0.5;
    }

    public void rightMove() {
        x = x + 0.5;
    }

    public double getPositionX() {
        return this.x;
    }

    public double getPositionY() {
        return this.y;
    }

    private double x;
    private double y;

}
