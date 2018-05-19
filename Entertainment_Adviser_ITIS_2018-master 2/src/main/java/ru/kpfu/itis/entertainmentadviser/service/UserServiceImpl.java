package ru.kpfu.itis.entertainmentadviser.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.entertainmentadviser.dao.UserDao;
import ru.kpfu.itis.entertainmentadviser.model.User;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
