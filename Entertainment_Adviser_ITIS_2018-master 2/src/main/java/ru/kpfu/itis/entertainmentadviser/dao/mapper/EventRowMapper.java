package ru.kpfu.itis.entertainmentadviser.dao.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.entertainmentadviser.dao.EventDao;
import ru.kpfu.itis.entertainmentadviser.model.Event;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EventRowMapper implements RowMapper<Event> {
    @Autowired
    EventDao eventDao;
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setId(rs.getLong("id"));
        event.setName(rs.getString("name"));
        event.setDescription(rs.getString("description"));
        event.setAddress(rs.getString("address"));
        event.setImage(rs.getString("image_url"));
        event.setStatus(rs.getString("status"));
        return event;
    }
}
