package com.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Match_ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private LostDog lostDog;
    @ManyToOne
    private FoundDog foundDog;

    private double similarity; //相似度，100以内
    private int status;//0:Python刚插入，

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LostDog getLostDog() {
        return lostDog;
    }

    public void setLostDog(LostDog lostDog) {
        this.lostDog = lostDog;
    }

    public FoundDog getFoundDog() {
        return foundDog;
    }

    public void setFoundDog(FoundDog foundDog) {
        this.foundDog = foundDog;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
