package ru.kpfu.itis.entertainmentadviser.dao;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.entertainmentadviser.model.User;
import ru.kpfu.itis.entertainmentadviser.model.UserTag;

import java.util.List;
@Component
public class TagDaoimpl implements TagDao {
    @Override
    public List<UserTag> getUserTags(User user) {
        return null;
    }
}
