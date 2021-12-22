package lesson2;

public class MyArrayDataException extends RuntimeException {

    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String getMessage() {
        return "В элементе массива [" + this.i + "][" + this.j + "]"
                + "значение не возможно преобразовать к типу Integer";
    }
}
