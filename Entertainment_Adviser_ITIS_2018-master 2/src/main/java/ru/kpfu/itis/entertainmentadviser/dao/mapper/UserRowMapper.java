package ru.kpfu.itis.entertainmentadviser.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.entertainmentadviser.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFirstname(rs.getString("firstname"));
        user.setSecondname(rs.getString("secondname"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
