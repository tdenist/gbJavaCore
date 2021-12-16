package lesson1;


public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Барсик", "белый", 1, true, 10);
        Cat cat2 = new Cat("Мурзик", "белый", 3, false, 5);
        Turtle turtle = new Turtle("Тортилла", "коричневый", 3, 1);
        Wolf wolf = new Wolf("Вася", "серый", 3, 15);

        Team dreamTeam = new Team ("Коты", new Animal[]{cat1, cat2, turtle, wolf});

        Pool pool1 = new Pool(100);
        Pool pool2 = new Pool(10);

        Course course = new Course(new Pool[]{pool1, pool2});

        course.doIt(dreamTeam);
        System.out.println();
        System.out.println(dreamTeam.showResults());
    }
}
