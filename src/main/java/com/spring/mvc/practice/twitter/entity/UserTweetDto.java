package com.spring.mvc.practice.twitter.entity;

import java.util.Date;

public class UserTweetDto {

    private String username;
    private String description;
    private Date datetime;

    public UserTweetDto() {

    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDatetime() {
        return datetime;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public UserTweetDto(String username, String description, Date datetime) {
        this.username = username;
        this.description = description;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "UserTweetDto{" +
                "username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
