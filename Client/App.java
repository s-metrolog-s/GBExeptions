package org.example.ExceptionsFinalTask.Client;

import org.example.ExceptionsFinalTask.Core.Controller.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class App {
    public static Logger logger = Logger.getLogger(Math.class.getName());

    public void startWork() {
        try {
            LogManager.getLogManager().readConfiguration(
                    new FileInputStream("./src/main/java/org/example/ExceptionsFinalTask/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        Handler fileHandler = null;
        try {
            fileHandler = new FileHandler("./src/main/java/org/example/ExceptionsFinalTask/Client/Logs/log.txt", true);
        } catch (IOException e) {
            System.out.println("Файл не найден");;
        }

        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        logger.info("Запуск приложения");

        System.out.println("************************************************");
        System.out.println("Добро пожаловать в программу База данных пользователей");
        Controller controller = new Controller();
        controller.startWork();
    }
}
