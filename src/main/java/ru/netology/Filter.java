package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        logger.log("Начинаем фильтровать значения;");
        for (Integer x:
             source) {
            if (x <= threshold) {
                logger.log("Значение '" + x + "' проходит;");
                result.add(x);
            } else {
                logger.log("Значение '" + x + "' не проходит;");
            }
        }
        logger.log("Прошло фильтр " + result.size() + " из " + source.size() + ";");
        return result;
    }
}
