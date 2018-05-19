package ru.kpfu.itis.entertainmentadviser.service;

import ru.kpfu.itis.entertainmentadviser.model.User;
import ru.kpfu.itis.entertainmentadviser.model.UserTag;

import java.util.List;

public interface UserTagService {
    List<UserTag> getAllTags();
    List<UserTag> getAllUserTags(User user);
    UserTag getUserTagById(Long tagId, User user);
    void addTagToUser(User user, UserTag userTag);
    void deleteTagForUser(User user, UserTag userTag);
}
