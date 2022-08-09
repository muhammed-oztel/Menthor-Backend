package com.menthor.model;

import javax.persistence.*;

@Entity
@Table(name = "MeetRoomKey")
public class MeetRoomKeyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column
    private Long match;
    @Column(name = "room_code")
    private String room_code;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRoom_code() {
        return room_code;
    }

    public void setRoom_code(String room_code) {
        this.room_code = room_code;
    }

    public Long getMatch_Id() {
        return match;
    }

    public void setMatch_Id(Long match_Id) {
        this.match = match_Id;
    }
}