
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Task1 {

    // Метод для преобразования галлонов в литры таск 1
    public static double convertGallonsToLiters(int gallons) {
        final double LITERS_PER_GALLON = 3.78541;  // коэффициент перевода
        return gallons * LITERS_PER_GALLON;
    }

    // Метод для расчета сожженных калорий во время тренировки таск 2
    public static int fitCalc(int durationInMinutes, int intensityLevel) {
        int caloriesBurnedPerMinute = switch (intensityLevel) {
            case 1 ->
                5;
            case 2 ->
                8;
            case 3 ->
                10;
            default -> {
                System.out.println("Недопустимый уровень интенсивности");
                yield 0;
            }
        };
        return durationInMinutes * caloriesBurnedPerMinute;
    }

    // Метод для расчета количества товаров на складе таск 3
    public static int containers(int boxes, int bags, int barrels) {
        int totalItems = (boxes * 20) + (bags * 50) + (barrels * 100);
        return totalItems;
    }

    // таск 4
    public static String triangleType(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "не является треугольником";
        } else if (x == y && y == z) {
            return "равносторонний";
        } else if (x == y || x == z || y == z) {
            return "равнобедренный";
        } else {
            return "разносторонний";
        }

    }

    // таск 5
    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b;
    }

    //таск 6
    public static int howManyItems(double lengthOfFabric, double width, double height) {
        // Общая площадь ткани в квадратных метрах
        double totalFabricArea = lengthOfFabric * 2;

        // Площадь одной детали в квадратных метрах
        double itemArea = width * height;

        // Количество пододеяльников, которые можно сшить
        return (int) (totalFabricArea / itemArea);
    }

    // таск 7
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // таск 8
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // таск 9
    public static int ticketSaler(int numTickets, int ticketPrice) {
        final double COMMISSION_RATE = 0.15; // Фиксированная комиссия 15%
        double totalRevenue = numTickets * ticketPrice * (1 + COMMISSION_RATE);
        return (int) totalRevenue;
    }

    // таск 10
    public static int tables(int students, int tables) {
        int missingTables = (students + 1) / 2 - tables; // Количество недостающих столов
        return Math.max(missingTables, 0); // Возвращаем 0, если недостающих столов нет
    }

    public static void main(String[] args) {
        // Установка кодировки UTF-8 для консоли
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("UTF-8 encoding is not supported!");
        }

        // Примеры с галоннами таск 1
        System.out.println("convert(9) ➞ " + convertGallonsToLiters(9));
        System.out.println("convert(10) ➞ " + convertGallonsToLiters(10));
        System.out.println("convert(21) ➞ " + convertGallonsToLiters(21));

        // фитнес программа таск 2
        System.out.println("fitCalc(21, 1) ➞ " + fitCalc(21, 1));
        System.out.println("fitCalc(36, 2) ➞ " + fitCalc(36, 2));
        System.out.println("fitCalc(63, 3) ➞ " + fitCalc(63, 3));
        // таск 3
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(4, 3, 2));
        System.out.println(containers(1, 20, 4));

        // таск 4
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        // таск 5
        System.out.println(ternaryEvaluation(8, 4));  // Вывод: 8
        System.out.println(ternaryEvaluation(1, 11));  // Вывод: 11
        System.out.println(ternaryEvaluation(5, 9));  // Вывод: 9
        // таск 6
        System.out.println(howManyItems(22, 1.4, 2));   // Вывод: 15
        System.out.println(howManyItems(45, 1.8, 1.9)); // Вывод: 26
        System.out.println(howManyItems(100, 2, 2));    // Вывод: 50
        // таск 7
        System.out.println(factorial(3)); // Вывод: 6
        System.out.println(factorial(5)); // Вывод: 120
        System.out.println(factorial(7)); // Вывод: 5040
        // таск 8
        System.out.println(gcd(48, 18)); // Вывод: 6
        System.out.println(gcd(52, 8));  // Вывод: 4
        System.out.println(gcd(259, 28)); // Вывод: 7
        // таск 9
        System.out.println(ticketSaler(70, 1500)); // Вывод: 120749
        System.out.println(ticketSaler(24, 950));  // Вывод: 26219
        System.out.println(ticketSaler(53, 1250)); // Вывод: 76187
        // таск 10
        System.out.println(tables(5, 2)); // Вывод: 1
        System.out.println(tables(31, 20)); // Вывод: 0
        System.out.println(tables(123, 58)); // Вывод: 4
    }

}
