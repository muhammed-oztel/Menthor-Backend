package com.menthor.controller;

import com.menthor.dto.UserDto;
import com.menthor.model.EventEntity;
import com.menthor.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public UserDto.Response Create(@RequestBody EventEntity event){
        return eventService.Create(event);
    }

    @PutMapping("/update/{id}")
    public UserDto.Response Update(@PathVariable Long id, @RequestBody EventEntity event){
        return eventService.Update(id, event);
    }

    @GetMapping("/list/{matchId}")
    public List<EventEntity> GetList(@PathVariable Long matchId){
        return eventService.GetList(matchId);
    }

    @DeleteMapping("/delete/{id}")
    public UserDto.Response Delete(@PathVariable Long id) {
        return eventService.Delete(id);
    }
}