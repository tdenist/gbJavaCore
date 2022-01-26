import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя города (на русском) или 0 для выхода: ");
            String city = scanner.nextLine();

            if (city.equals("0")) break;

            System.out.println("Введите 1 для получения погоды на сегодня.\n" +
                    "Введите 5 для прогноза на 5 дней.\n" +
                    "Введите 2 для получения данных из базы данных.\n" +
                    "Для выхода введите 0.\n" +
                    "Ввод: ");

            String command = scanner.nextLine();

            //TODO* Сделать метод валидации пользовательского ввода
            while (!(command.equals("1") || command.equals("5") || command.equals("2")|| command.equals("0"))){
                System.out.println("Введено некорректное значение!\n" +
                        "Введите 1 для получения погоды на сегодня.\n" +
                        "Введите 5 для прогноза на 5 дней.\n" +
                        "Введите 2 для получения данных из базы данных.\n" +
                        "Для выхода введите 0.\n" +
                        "Ввод: ");

                command = scanner.nextLine();
            }

            if (command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}