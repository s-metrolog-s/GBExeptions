package org.example.ExceptionsFinalTask.Core.Controller;

import org.example.ExceptionsFinalTask.Core.Model.BaseOfUsers;
import org.example.ExceptionsFinalTask.View.ConsoleInputView;
import org.example.ExceptionsFinalTask.View.FileInputView;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.ExceptionsFinalTask.Client.App.logger;

public class Controller {
    public static BaseOfUsers base = new BaseOfUsers();
    public void startWork(){
        logger.info("Запуск главного окна программы");
        Status status = Status.WORK;
        FileInputView fileInputView = new FileInputView();
        ConsoleInputView consoleInputView = new ConsoleInputView();
        while (!status.equals(Status.EXIT)) {
            System.out.println("************************************************");
            System.out.println("Введите число для выбора режима программы:\n" +
                    "1 - Ввод данных из командной строки\n" +
                    "2 - Ввод из файла с данными\n" +
                    "3 - Вывод всех пользоваталей Базы данных\n" +
                    "4 - Сохранение всех пользователей в файл\n" +
                    "4-9 - Выход и программы");
            Scanner scanner = new Scanner(System.in);
            int mode = 9;

            try {
                mode = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите верное значение меню");
            }

            switch (mode) {
                case 1 -> {
                    logger.info("Выбран режим ввода данных из командной строки");
                    consoleInputView.start();
                }
                case 2 -> {
                    logger.info("Выбран режим ввода данных из файла");
                    fileInputView.start();
                }
                case 3 -> {
                    base.showAllUser();
                    logger.info("Открыта база данных");
                }
                case 4 -> {
                    base.saveAllBase();
                    logger.info("База данных сохранена>");
                }
                default -> status = Status.EXIT;
            }
        }
        System.out.println("Работа программы завершена,\n спасибо за пользование нашей программой!");
    }
}
