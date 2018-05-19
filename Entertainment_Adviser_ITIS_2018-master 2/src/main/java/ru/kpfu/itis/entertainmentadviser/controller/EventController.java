package ru.kpfu.itis.entertainmentadviser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.entertainmentadviser.dao.EventDao;
import ru.kpfu.itis.entertainmentadviser.model.Event;
import ru.kpfu.itis.entertainmentadviser.model.User;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    EventDao eventDao;

    @GetMapping("/events")
    String getAllevents(Model model) {
        List<Event> EventList = eventDao.findall();
        model.addAttribute("getAllevents", EventList);
        return "events";
    }

    @GetMapping("/events/{id}")
    String getAllinfoaboutEvent(Model model, @PathVariable Long id) {
        List<Event> eventsList = eventDao.AllInfoAboutEventbyid(id);
        model.addAttribute("getEventById", eventsList);
        return "eventsByid";
    }

    @PostMapping("/events/iGo")
    String iGo(Model model, @RequestParam(name = "event_id") Long id, @RequestParam(name = "user_id") Long id) {
        Event event = eventDao.iGo();
    }
}

