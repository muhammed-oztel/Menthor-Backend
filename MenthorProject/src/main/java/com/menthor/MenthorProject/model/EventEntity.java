package com.menthor.MenthorProject.model;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc

@Entity
@Table(name = "Event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "matchId")
    private Long matchId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

<<<<<<< HEAD
    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "finishDate")
    private Date finishDate;
=======
    @Column(name = "start")
    private String start;

    @Column(name = "finish")
    private String end;
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

<<<<<<< HEAD
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
=======
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
    }
}
