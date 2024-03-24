package org.example.ExceptionsFinalTask.Core.Model;

import org.example.ExceptionsFinalTask.Exceptions.ExampleException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseOfUsers implements BaseContract {
    List<User> userBase = new ArrayList<>();

    @Override
    public void addNewUser(User user) throws ExampleException {
        if (!userBase.contains(user)) {
            userBase.add(user);
        } else {
            throw new ExampleException("такой пользователь уже существует");
        }
    }

    @Override
    public void saveAllBase() {
        try {
            for (int i = 0; i < userBase.size(); i++) {
                FileWriter fileWriter = new FileWriter(
                        "./src/main/java/org/example/ExceptionsFinalTask/Client/DataBase/" +
                                userBase.get(i).getSurname() + ".txt", true);
                fileWriter.write(userBase.get(i).toString() + "\n");
                fileWriter.close();
            }
            System.out.println("Данные о пользователях успешно сохранены");

        } catch (IOException e) {
            System.out.println("Файл не доступен, база данных не сохранена");
            e.printStackTrace();
        }
    }

    @Override
    public void openDatabase() {

    }

    @Override
    public void showAllUser() {
        for (User item : userBase) {
            System.out.println(item.toString());
        }
    }
}
