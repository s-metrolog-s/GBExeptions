package org.example.ExceptionsFinalTask.Core.Model;

import org.example.ExceptionsFinalTask.Core.Controller.Settings;
import org.example.ExceptionsFinalTask.Exceptions.ExampleException;

import java.util.Arrays;
import java.util.List;

public class Parser {
    /**
     * Принимает на вход строку и создает список отдельных элементов
     * по шаблону в классе Settings
     * @param inputString Входная строка для парсинга строки
     * @return возвращает список отдельных элементов для создания метода userCreator
     */
    public static List<String> parseInputString(String inputString) throws ExampleException {
        List<String> resultList;
        //Замена в случае загрузки из одного файла
        if (inputString.contains(">") || inputString.contains("<")) {
            inputString = inputString.replace(">", "");
            inputString = inputString.replace("<", "");
        }
        resultList = Arrays.asList(inputString.split(" "));
        if (resultList.size() > Settings.FIELD_QUANTITY) {
            throw new ExampleException("Введено больше параметров");
        } else if (resultList.size() < Settings.FIELD_QUANTITY) {
            throw new ExampleException("Введено меньше параметров");
        }
        return resultList;
    }
}
