package ru.kpfu.itis.entertainmentadviser.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entertainmentadviser.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    RowMapper<User> userRowMapper;

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        String sqlQuery = "SELECT * FROM users WHERE username = :username";
        Map namedParameters = new HashMap();
        namedParameters.put("username", username);
        User user = namedParameterJdbcTemplate.queryForObject(sqlQuery, namedParameters, userRowMapper);
        return user;
    }

    @Override
    public List<User> showProfile(Long id) {
        String sqlQuery = "SELECT * FROM users WHERE id = :id";
        User ProfileOfUser = findById(id);
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);
        List <User> endlessProfile = namedParameterJdbcTemplate.query(sqlQuery,namedParameters,userRowMapper);
        return endlessProfile;
    }

    @Override
    public List<User> update(String username,String firstname,String secondname,Long id) {
        String sqlQuery = "UPDATE users " +
                "SET username = :username, firstname = :firstname, secondname = :secondname " +
                "WHERE id = :id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);
        namedParameters.put("firstname",firstname);
        namedParameters.put("username",username);
        namedParameters.put("secondname",secondname);
        namedParameterJdbcTemplate.update(sqlQuery,namedParameters);
        return null;
    }
}
