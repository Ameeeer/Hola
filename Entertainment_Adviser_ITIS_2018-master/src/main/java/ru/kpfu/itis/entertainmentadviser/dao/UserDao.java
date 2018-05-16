package ru.kpfu.itis.entertainmentadviser.dao;

import ru.kpfu.itis.entertainmentadviser.model.User;

public interface UserDao {
    User findById(Long id);
    User findByUsername(String username);
}
