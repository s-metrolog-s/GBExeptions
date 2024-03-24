package org.example.ExceptionsFinalTask.Core.Model;

import org.example.ExceptionsFinalTask.Core.Controller.Settings;
import org.example.ExceptionsFinalTask.Exceptions.ExampleException;

import java.util.List;


public class UserCreator {
    /**
     * Метод для создания экземпляра класса User и проверка на соответствие полей шаблону
     * @param inputString Входная строка после метода Parser
     * @return
     */
    public static User userCreator(String inputString) throws ExampleException {
        User newUser = new User();
        List<String> inputData = Parser.parseInputString(inputString);

        //ФИО по заданию не требует проверки
        newUser.setSurname(inputData.get(0));
        newUser.setName(inputData.get(1));
        newUser.setPatronymic(inputData.get(2));

        //Проверка строки на формат dd.mm.yyyy
        String checkDate = inputData.get(3);
        if (checkDate.length() == Settings.DATE_OF_BIRTH_LENGTH &&
                Integer.parseInt(checkDate.substring(0, 2)) <= 31 &&
                Integer.parseInt(checkDate.substring(3, 5)) <= 12 &&
                Integer.parseInt(checkDate.substring(6, 10)) <= Settings.CURRENT_YEAR
        ) {
            newUser.setDateOfBirth(checkDate);
        } else {
            throw new ExampleException("дата указана не верно");
        }

        //целое беззнаковое число без форматирования
        String checkPhone = inputData.get(4);
        if (checkPhone.length() != Settings.PHONE_LENGTH) {
            throw new ExampleException("проверьте длину номера телефона");
        }
        try {
            newUser.setPhoneNumber(Long.parseLong(checkPhone));
        } catch (NumberFormatException e) {
            throw new ExampleException("телефон указан не верно");
        }

        //символ латиницей f или m
        String checkGender = inputData.get(5);
        if (checkGender.equals("m") || checkGender.equals("f")) {
            newUser.setGender(checkGender);
        } else {
            throw new ExampleException("пол может содержать только символы f или m");
        }
        return newUser;
    }
}
