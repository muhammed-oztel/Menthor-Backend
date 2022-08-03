package com.menthor.MenthorProject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Match")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "mentor_id")
    private Long mentor_id;

    @Column(name = "mentee_id")
    private Long mentee_id;

    @Column(name = "date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(Long mentor_id) {
        this.mentor_id = mentor_id;
    }

    public Long getMentee_id() {
        return mentee_id;
    }

    public void setMentee_id(Long mentee_id) {
        this.mentee_id = mentee_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
