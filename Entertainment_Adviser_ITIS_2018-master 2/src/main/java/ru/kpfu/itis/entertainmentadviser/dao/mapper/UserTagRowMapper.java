package ru.kpfu.itis.entertainmentadviser.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.entertainmentadviser.model.UserTag;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserTagRowMapper implements RowMapper<UserTag> {
    @Override
    public UserTag mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserTag userTag = new UserTag();
        userTag.setId(rs.getLong("id"));
        userTag.setTagName(rs.getString("tag_name"));
        return userTag;
    }
}
