
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    // Метод, который возвращает строку, состоящую из символов из первой строки,
    // которых нет во второй строке
    public static String duplicateChars(String str1, String str2) {
        return str1.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .filter(c -> !str2.contains(c))
                .collect(Collectors.joining());
    }

    // Метод, который подсчитывает количество нечетных чисел, кратных 3, в массиве
    public static long dividedByThree(int[] arr) {
        return Arrays.stream(arr)
                .filter(num -> num % 2 != 0 && num % 3 == 0)
                .count();
    }
    // Метод, который возвращает инициалы ФИО в библиографическом формате

    public static String getInitials(String fullName) {
        String[] parts = fullName.split(" ");
        return parts[1].charAt(0) + "." + parts[2].charAt(0) + "." + capitalize(parts[0]);
    }

    // Вспомогательный метод, который капитализирует первую букву слова
    private static String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
    // Метод, который нормализует массив вещественных чисел в диапазон [0, 1]

    public static double[] normalizator(double[] arr) {
        double min = Arrays.stream(arr).min().orElse(0);
        double max = Arrays.stream(arr).max().orElse(0);
        return Arrays.stream(arr)
                .map(num -> (max == min) ? 0 : (num - min) / (max - min))
                .toArray();
    }
    // Метод, который возвращает список уникальных целых чисел из массива вещественных чисел

    public static List<Integer> compressedNums(double[] arr) {
        return Arrays.stream(arr)
                .filter(num -> num != 0)
                .mapToInt(num -> (int) num)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    // Метод, который преобразует строку из CamelCase в SnakeCase
    public static String camelToSnake(String camel) {
        return camel.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }
    // Метод, который возвращает второй по величине уникальный элемент массива

    public static Integer secondBiggest(int[] arr) {
        return Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
    // Метод, который выполняет локальный реверс части строки между двумя маркерными символами

    public static String localReverse(String s, char marker) {
        int first = s.indexOf(marker);
        int last = s.lastIndexOf(marker);
        if (first == -1 || first == last) {
            return s;
        }
        String reversedPart = new StringBuilder(s.substring(first + 1, last)).reverse().toString();
        return s.substring(0, first + 1) + reversedPart + s.substring(last);
    }
    // Метод, который возвращает количество одинаковых элементов в трех числах

    public static int equal(int a, int b, int c) {
        Set<Integer> uniqueNumbers = new HashSet<>(Arrays.asList(a, b, c));
        return 4 - uniqueNumbers.size();
    }

    // Метод, который проверяет, являются ли две строки анаграммами
    public static boolean isAnagram(String str1, String str2) {
        // Очищаем строки от всех символов, кроме букв и цифр, и переводим в нижний регистр
        String cleanedStr1 = str1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String cleanedStr2 = str2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // Проверяем, что длины очищенных строк равны
        // и что символы в них одинаковые (в любом порядке)
        return cleanedStr1.length() == cleanedStr2.length()
                && Arrays.equals(sortedChars(cleanedStr1), sortedChars(cleanedStr2));
    }

    // Вспомогательный метод, который возвращает массив символов строки в отсортированном виде
    private static char[] sortedChars(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return arr;

    }

    public static void main(String[] args) {
        // Установка кодировки UTF-8 для консоли
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("UTF-8 encoding is not supported!");
        }

        //Вывод
        System.out.println(duplicateChars("Barack", "Obama"));
        System.out.println(dividedByThree(new int[]{3, 12, 7, 81, 52}));
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));
        System.out.println(Arrays.toString(normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5})));
        System.out.println(Arrays.toString(normalizator(new double[]{10.0, 10.0, 10.0, 10.0})));
        System.out.println(compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5}));
        System.out.println(camelToSnake("helloWorld"));
        System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4}));
        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));
        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5, 5, 5));
        System.out.println(equal(4, 9, 6));
        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
    }
}
