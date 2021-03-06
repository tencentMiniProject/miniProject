package com.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class LostDog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 70)
    private String userName;
    @OneToMany(mappedBy = "lostDog")
    private Set<Match_> matches;
    private String picPath;
    private String content;
    private String race;
    private int age;
    private String location;
    private String nickName;
    private String sex;
    private String time;
    private int MatchedDogId;
    @Type(type="text")
    @Column
    private String vec;
    private int dog_class;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
