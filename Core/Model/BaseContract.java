package org.example.ExceptionsFinalTask.Core.Model;

import java.io.IOException;
import java.util.List;

public interface BaseContract {
    public void addNewUser(User user);
    public void saveAllBase() throws IOException;
    public void openDatabase();
    public void showAllUser();
}
