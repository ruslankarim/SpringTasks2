package ru.javamentor.karimov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.karimov.dao.UserDAO;
import ru.javamentor.karimov.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserDAO userDAO;

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    };

    @Transactional
    @Override
    public void insertUser(User user){
        userDAO.insertUser(user);
    };

    @Transactional
    @Override
    public void updateUser(User user){
        userDAO.updateUser(user);
    };

    @Transactional
    @Override
    public User getUserByID(Long id){
        return userDAO.getUserByID(id);
    };

    @Transactional
    @Override
    public void deleteUser(Long id){
        userDAO.deleteUser(id);
    };
}
