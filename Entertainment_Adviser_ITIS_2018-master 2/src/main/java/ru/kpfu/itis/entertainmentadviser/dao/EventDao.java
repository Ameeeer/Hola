package ru.kpfu.itis.entertainmentadviser.dao;

import ru.kpfu.itis.entertainmentadviser.model.Event;
import ru.kpfu.itis.entertainmentadviser.model.User;

import java.util.List;

public interface EventDao {
    List<Event> findall();
    Event save(Event event);
    List<Event> AllInfoAboutEventbyid(Long id);
    Event iGo(Event event, User user);
}
