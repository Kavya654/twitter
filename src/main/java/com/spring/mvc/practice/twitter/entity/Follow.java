package com.spring.mvc.practice.twitter.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "follow")
public class Follow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "who")
    private int who;

    @Column(name = "whom")
    private int whom;

    @Column(name = "status")
    private String status;

    public Follow() {
    }

    public Follow(int who, int whom, String status) {
        this.who = who;
        this.whom = whom;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getWho() {
        return who;
    }
    public void setWho(int who) {
        this.who = who;
    }
    public int getWhom() {
        return whom;
    }
    public void setWhom(int whom) {
        this.whom = whom;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", who=" + who +
                ", whom=" + whom +
                ", status='" + status + '\'' +
                '}';
    }
}
