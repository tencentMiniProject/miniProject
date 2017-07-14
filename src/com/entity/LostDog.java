package com.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class LostDog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = true, length = 70)
    private String userName;
    @OneToMany(mappedBy = "lostDog")
    private Set<Match_> matches;
    private String picPath;
    private String content;
    private String race;
    private int age;
    private String location;
    private int MatchedDogId;

    public int getMatchedDogId() {
        return MatchedDogId;
    }

    public void setMatchedDogId(int matchedDogId) {
        MatchedDogId = matchedDogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Match_> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match_> matches) {
        this.matches = matches;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
