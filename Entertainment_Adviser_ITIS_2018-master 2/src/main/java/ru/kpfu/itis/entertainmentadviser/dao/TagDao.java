package ru.kpfu.itis.entertainmentadviser.dao;

import ru.kpfu.itis.entertainmentadviser.model.User;
import ru.kpfu.itis.entertainmentadviser.model.UserTag;

import java.util.List;

public interface TagDao {
    List<UserTag> findAll();
    Boolean isChoosenByUser(User user, UserTag userTag);
    UserTag findById(Long id);
    void addTagToUser(User user, UserTag userTag);
    void deleteTagForUser(User user, UserTag userTag);
}
