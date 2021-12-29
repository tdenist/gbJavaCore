package lesson3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //создание наборов яблок и апельсинов для добавления в коробку
        ArrayList<Apple> appleArrayList1 = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            appleArrayList1.add(new Apple());
        }

        ArrayList<Apple> appleArrayList2 = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            appleArrayList2.add(new Apple());
        }

        ArrayList<Orange> orangeArrayList = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            orangeArrayList.add(new Orange());
        }

        //создание коробок с яблоками и апельсинами
        Box<Apple> boxWithApple1 = new Box<> (appleArrayList1);
        Box<Orange> boxWithOrange1 = new Box<> (orangeArrayList);
        Box<Apple> boxWithApple2 = new Box<> (appleArrayList2);

        //вывод веса коробок
        System.out.println(boxWithApple1.getWeight());
        System.out.println(boxWithOrange1.getWeight());
        System.out.println(boxWithApple2.getWeight());

        /*
        сравнение веса коробок
        проверяем, что можно сравнивать коробки с апельсинами с коробками с явблоками
         */
        System.out.println();
        System.out.println(boxWithOrange1.compare(boxWithApple1));
        System.out.println(boxWithApple1.compare(boxWithApple2));

        //добавление нового фрукта в коробку
        boxWithApple1.addFruit(new Apple());
        //boxWithApple1.addFruit(new Orange()); тут ошибка - в коробку с яблоками нельзя добавить апельсин
        System.out.println();
        //проверяем, что масса коробки после добавления фрукта изменилась и изменился результат сравнения
        System.out.println(boxWithApple1.getWeight());
        System.out.println(boxWithOrange1.compare(boxWithApple1));
        System.out.println(boxWithApple1.compare(boxWithApple2));

        /*
        проверяем работу метода transfer класса Box
        выводим ArrayList фруктов в коробке до и после выполнения метода transfer
         */
        System.out.println();
        System.out.println(boxWithApple1.getFruits());
        System.out.println(boxWithApple2.getFruits());
        boxWithApple1.transfer(boxWithApple2);
        System.out.println(boxWithApple1.getFruits());
        System.out.println(boxWithApple2.getFruits());
        //boxWithApple2.transfer(boxWithOrange1); тут ошибка, т.к. в методе transfer класса Box входной параметр типизировал
    }
}