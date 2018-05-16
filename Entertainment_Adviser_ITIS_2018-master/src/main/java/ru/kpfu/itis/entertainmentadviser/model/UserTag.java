package ru.kpfu.itis.entertainmentadviser.model;

public class UserTag {
    Long id;
    String tagName;
    Boolean isChosen;

    public UserTag(Long id, String tagName, Boolean isChosen) {
        this.id = id;
        this.tagName = tagName;
        this.isChosen = isChosen;
    }

    public UserTag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Boolean getChosen() {
        return isChosen;
    }

    public void setChosen(Boolean chosen) {
        isChosen = chosen;
    }
}
