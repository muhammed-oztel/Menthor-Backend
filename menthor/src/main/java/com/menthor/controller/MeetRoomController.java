package com.menthor.controller;

import com.menthor.service.MeetRoomService;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/meetroom")
public class MeetRoomController {
    private final MeetRoomService meetRoomService;


    public MeetRoomController(MeetRoomService meetRoomService) {
        this.meetRoomService = meetRoomService;
    }

    @PostMapping("/Mentor_side/{mentorId}")
    public String Mentor_side(@PathVariable Long mentorId, @RequestBody String key){
        String[] keyy = key.split("=");
        return meetRoomService.CreateCode(keyy[0], mentorId);
    }

    @GetMapping("/Mentee_side/{menteeId}")
    public String Mentee_side(@PathVariable Long menteeId){
        return meetRoomService.GetCode(menteeId);
    }
}