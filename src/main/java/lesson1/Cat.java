package lesson1;

import java.util.Objects;

public class Cat extends Animal implements CanSwim {

    private boolean isWild;
    private double swimmingSpeed;

    public Cat(String name, String color, int age, boolean isWild, double swimmingSpeed) {
        super(name, color, age);
        this.isWild = isWild;
        this.swimmingSpeed = swimmingSpeed;
    }

    public void voice() {
        System.out.println("Кот мяукает!");
    }

    public double swim(Pool pool) {
        System.out.println("Я кот, я плыву!");
        System.out.println("Затратил " + pool.getLength() / swimmingSpeed);
        return pool.getLength() / swimmingSpeed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return isWild == cat.isWild && Double.compare(cat.swimmingSpeed, swimmingSpeed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWild, swimmingSpeed);
    }

    public double getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean wild) {
        isWild = wild;
    }
}
