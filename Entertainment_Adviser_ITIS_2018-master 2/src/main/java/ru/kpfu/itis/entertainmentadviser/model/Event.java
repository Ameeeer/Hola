package ru.kpfu.itis.entertainmentadviser.model;

import java.util.List;
import java.util.ArrayList;

public class Event{
    private Long id;
    private String name;
    private String description;
    private Long date;
    private String address;
    private String image_url;
    private String tag;
    private String status;
    private List<EventTag> eventTags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDate() {
        return this.date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return this.image_url;
    }

    public void setImage(String image) {
        this.image_url = image;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EventTag> getEventTags() {
        return this.eventTags;
    }

    public void setEventTags(List<EventTag> eventTags) {
        this.eventTags = eventTags;
    }
}
