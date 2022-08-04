package com.menthor.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Meet")
public class MeetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private UserEntity userEntity1;

    @ManyToOne
    @JoinColumn(name = "mentee_id")
    private UserEntity userEntity2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserEntity getUserEntity1() {
        return userEntity1;
    }

    public void setUserEntity1(UserEntity userEntity1) {
        this.userEntity1 = userEntity1;
    }

    public UserEntity getUserEntity2() {
        return userEntity2;
    }

    public void setUserEntity2(UserEntity userEntity2) {
        this.userEntity2 = userEntity2;
    }
}
