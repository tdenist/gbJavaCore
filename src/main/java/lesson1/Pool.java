package lesson1;

public class Pool {

    private double length;
    private double maxTimeSwimming = 15;

    public Pool(int length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getMaxTimeSwimming() {
        return maxTimeSwimming;
    }

    public void setMaxTimeSwimming(double maxTimeSwimming) {
        this.maxTimeSwimming = maxTimeSwimming;
    }

    public double getTimeToOvercomePool(Animal swimmer) {
        CanSwim animal = (CanSwim) swimmer;
        return animal.swim(this);
    }
}
