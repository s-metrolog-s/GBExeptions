package org.example.ExceptionsFinalTask.View;

import org.example.ExceptionsFinalTask.Core.Controller.Status;
import org.example.ExceptionsFinalTask.Core.Model.UserCreator;
import org.example.ExceptionsFinalTask.Exceptions.ExampleException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.example.ExceptionsFinalTask.Client.App.logger;
import static org.example.ExceptionsFinalTask.Core.Controller.Controller.base;

public class FileInputView {
    public void start() {
        Status status = Status.FILE_INPUT_MODE;
        while (status.equals(Status.FILE_INPUT_MODE)) {
            System.out.println("************************************************");
            System.out.println("Загрузка данных из файла...");
            try {
                FileReader fileReader = new FileReader("./src/main/java/org/example/ExceptionsFinalTask/Client/DataBase/db.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    base.addNewUser(UserCreator.userCreator((line)));
                }
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Файл с данными отсутствует");
            } catch (ExampleException e) {
                System.out.println("Данные не загружены: " + e.getMessage());
                logger.info("Не успешная попытка загрузки данных");
            }
            System.out.println("Данные успешно загружены");
            logger.info("Внесены данные из файла");

            status = Status.WORK;
        }
    }
}
