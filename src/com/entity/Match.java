package com.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private LostDog lostDog;
    @ManyToOne
    private FoundDog foundDog;

    private double similarity; //相似度，100以内
    private int status;//0:Python刚插入，
}
