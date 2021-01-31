package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        logger.log("Запускаем программу;");
        logger.log("Запрашиваем данные у пользователя;");
        int size = getValue("Введите размер списка: ", scanner);
        int maxValue = getValue("Введите максимальное значение: ", scanner);
        logger.log("Создадим и заполним список чисел;");
        List<Integer> source = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            source.add(random.nextInt(maxValue));
        }
        logger.log("Запросим значение для фильтра;");
        int threshold = getValue("Введите порог для фильтра: ", scanner);
        Filter filter = new Filter(threshold);
        List<Integer> result = filter.filterOut(source);
        logger.log("Выводим результат на экран;");
        for (Integer x:
             result) {
            System.out.println(x);
        }
        logger.log("Завершаем работу программы.");
    }

    private static int getValue(String msg, Scanner scanner) {
        Logger logger = Logger.getInstance();
        System.out.print(msg);
        String valueAsString = scanner.nextLine();
        logger.log("Пользователь ввёл значение: '" + valueAsString + "';");
        int value;
        if (inputCorrect(valueAsString)) {
            value = Integer.parseInt(valueAsString);
        } else {
            value = getValue(msg, scanner);
        }
        return value;
    }

    private static boolean inputCorrect(String input) {
        Logger logger = Logger.getInstance();
        try {
           int value = Integer.parseInt(input);
           logger.log("Введённое значение верно;");
           return true;
        } catch (Exception e) {
            logger.log("Введённое значение неверно;");
            return false;
        }

    }
}
