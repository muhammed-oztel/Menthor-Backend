package com.menthor.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Match")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "mentor")
    private Long mentor;

    @Column(name = "mentee")
    private Long mentee;

    @Column(name = "date")
    private Date date;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getMentor_id() {
        return mentor;
    }

    public void setMentor_id(Long mentor_id) {
        this.mentor = mentor_id;
    }

    public Long getMentee_id() {
        return mentee;
    }

    public void setMentee_id(Long mentee_id) {
        this.mentee = mentee_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}