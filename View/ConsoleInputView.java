package org.example.ExceptionsFinalTask.View;

import org.example.ExceptionsFinalTask.Core.Controller.Settings;
import org.example.ExceptionsFinalTask.Core.Controller.Status;
import org.example.ExceptionsFinalTask.Exceptions.ExampleException;
import org.example.ExceptionsFinalTask.Core.Model.UserCreator;

import java.util.Scanner;

import static org.example.ExceptionsFinalTask.Client.App.logger;
import static org.example.ExceptionsFinalTask.Core.Controller.Controller.base;

public class ConsoleInputView {
    public void start() {
        Status status = Status.CONSOLE_INPUT_MODE;
        while (status.equals(Status.CONSOLE_INPUT_MODE)) {
            System.out.println("************************************************");
            System.out.println("Введите данные по шаблону: \n" + Settings.EXAMPLE_OF_STRING);
            Scanner scanner = new Scanner(System.in);
            String inputRow = scanner.nextLine();

            try {
                base.addNewUser(UserCreator.userCreator(inputRow));
                System.out.println("Данные о пользователе успешно сохранены");
                logger.info("Внесены данные: " + inputRow);
            } catch (ExampleException e) {
                System.out.println("Данные не сохранены: " + e.getMessage());
                logger.info("Не успешная попытка сохранения данных " + inputRow);
            }

            System.out.println("Внести следующего пользователя? (y/n)");
            String answer = scanner.next();
            if (!(answer.equals("y") || answer.equals("Y"))) {
                status = Status.WORK;
            }
        }
    }
}
