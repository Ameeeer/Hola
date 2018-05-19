package ru.kpfu.itis.entertainmentadviser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entertainmentadviser.dao.TagDao;
import ru.kpfu.itis.entertainmentadviser.model.User;
import ru.kpfu.itis.entertainmentadviser.model.UserTag;

import java.util.List;

@Service
public class UserTagServiceImpl implements UserTagService {
    @Autowired
    TagDao tagDao;

    @Override
    public List<UserTag> getAllTags() {
        return tagDao.findAll();
    }

    @Override
    public List<UserTag> getAllUserTags(User user) {
        List<UserTag> userTags = tagDao.findAll();
        for(UserTag userTag : userTags) {
            userTag.setChosen(tagDao.isChoosenByUser(user, userTag));
        }
        return userTags;
    }

    @Override
    public UserTag getUserTagById(Long tagId, User user) {
        UserTag userTag = tagDao.findById(tagId);
        userTag.setChosen(tagDao.isChoosenByUser(user, userTag));
        return userTag;
    }

    @Override
    public void addTagToUser(User user, UserTag userTag) {
        tagDao.addTagToUser(user, userTag);
    }

    @Override
    public void deleteTagForUser(User user, UserTag userTag) {
        tagDao.deleteTagForUser(user, userTag);
    }
}
