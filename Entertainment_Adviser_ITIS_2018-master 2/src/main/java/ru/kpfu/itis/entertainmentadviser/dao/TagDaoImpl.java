package ru.kpfu.itis.entertainmentadviser.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entertainmentadviser.model.User;
import ru.kpfu.itis.entertainmentadviser.model.UserTag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TagDaoImpl implements TagDao{
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    RowMapper<UserTag> userTagRowMapper;

    @Override
    public List<UserTag> findAll() {
        String sqlQuery = "SELECT * FROM tag";
        List<UserTag> userTagList = namedParameterJdbcTemplate.query(sqlQuery, userTagRowMapper);
        return userTagList;
    }
    @Override
    public Boolean isChoosenByUser(User user, UserTag userTag) {
        String sqlQuery = "SELECT EXISTS(SELECT * FROM user_tag ut WHERE ut.user_id = :userId AND ut.tags_id = :tagId)";
        Map namedParameters = new HashMap();
        namedParameters.put("userId", user.getId());
        namedParameters.put("tagId", userTag.getId());
        Boolean isChoosen = namedParameterJdbcTemplate.queryForObject(sqlQuery, namedParameters, Boolean.class);
        return isChoosen;
    }

    @Override
    public UserTag findById(Long id) {
        String sqlQuery = "SELECT * FROM tag where id = :userTagId";
        Map namedParameters = new HashMap();
        namedParameters.put("userTagId", id);
        return namedParameterJdbcTemplate.queryForObject(sqlQuery, namedParameters, userTagRowMapper);
    }

    @Override
    public void addTagToUser(User user, UserTag userTag) {
        String sqlQuery = "INSERT INTO user_tag (user_id, tags_id) VALUES (:userId, :tagId)";
        Map namedParameters = new HashMap();
        namedParameters.put("userId", user.getId());
        namedParameters.put("tagId", userTag.getId());
        namedParameterJdbcTemplate.update(sqlQuery, namedParameters);
    }

    @Override
    public void deleteTagForUser(User user, UserTag userTag) {
        String sqlQuery = "DELETE FROM user_tag WHERE user_id = :userId AND tags_id = :tagId";
        Map namedParameters = new HashMap();
        namedParameters.put("userId", user.getId());
        namedParameters.put("tagId", userTag.getId());
        namedParameterJdbcTemplate.update(sqlQuery, namedParameters);
    }
}
