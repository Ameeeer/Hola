package ru.kpfu.itis.entertainmentadviser.service;

import ru.kpfu.itis.entertainmentadviser.model.User;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
}
