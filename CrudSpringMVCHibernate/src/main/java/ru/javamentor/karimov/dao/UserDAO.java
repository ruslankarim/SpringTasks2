package ru.javamentor.karimov.dao;

import ru.javamentor.karimov.model.User;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void insertUser(User user);
    void updateUser(User user);
    User getUserByID(Long id);
    void deleteUser(Long id);
}
