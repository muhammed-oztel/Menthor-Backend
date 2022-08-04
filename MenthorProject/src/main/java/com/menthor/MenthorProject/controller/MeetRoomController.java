package com.menthor.MenthorProject.controller;

import com.menthor.MenthorProject.service.MeetRoomService;
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
        return meetRoomService.CreateCode(key, mentorId);
    }

    @GetMapping("/Mentee_side")
    public String Mentee_side(@RequestBody Long input){
        return meetRoomService.GetCode(input);
    }
}
