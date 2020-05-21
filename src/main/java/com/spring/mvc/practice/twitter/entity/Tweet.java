package com.spring.mvc.practice.twitter.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tweet")
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String description;

    @CreationTimestamp
    @Column(name = "created_date")
    private java.util.Date datetime;

    public Tweet() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Tweet(String description, Date datetime) {
        this.description = description;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
