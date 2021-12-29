package lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public float getWeight() {
        if (fruits.size() != 0) {
            return fruits.size() * fruits.get(0).getWeight();
        }
        else {
            return 0;
        }
    }

    public void addFruit(T fruit){
        this.fruits.add(fruit);
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<T> box){
        for (int i = this.fruits.size() - 1; i > -1 ; i--){
            box.addFruit(this.fruits.get(i));
            this.fruits.remove(i);
        }
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }
}