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

    private Date deleted;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getMentor() {
        return mentor;
    }

    public void setMentor(Long mentor) {
        this.mentor = mentor;
    }

    public Long getMentee() {
        return mentee;
    }

    public void setMentee(Long mentee) {
        this.mentee = mentee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}