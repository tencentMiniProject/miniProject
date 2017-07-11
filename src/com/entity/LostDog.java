package com.entity;

import javax.persistence.*;
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

}
