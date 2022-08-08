package com.menthor.calendar;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menteeId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mentorId;

    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime finish;

    public Event(Long id, String title, String description, LocalDateTime start, LocalDateTime finish) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.start = start;
        this.finish = finish;
    }

    public Event(Long id, Long menteeId, Long mentorId, String title, String description, LocalDateTime start, LocalDateTime finish) {
        this.id = id;
        this.menteeId = menteeId;
        this.mentorId = mentorId;
        this.title = title;
        this.description = description;
        this.start = start;
        this.finish = finish;
    }

    public Event() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Long getMenteeId() {
        return menteeId;
    }

    public void setMenteeId(Long menteeId) {
        this.menteeId = menteeId;
    }

    public Long getMentorId() {
        return mentorId;
    }

    public void setMentorId(Long mentorId) {
        this.mentorId = mentorId;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", description=" + description + ", start=" + start
                + ", finish=" + finish + "menteeId"+ menteeId+ "mentorId" + mentorId+ "]";
    }
}