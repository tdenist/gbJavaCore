public class Main {

    public static void main(String[] args) {

        AppData data = new AppData();

        data.load("data.csv");

        System.out.println(data);

        System.out.println();
        data.save(data, "data_out.csv");
    }
}
