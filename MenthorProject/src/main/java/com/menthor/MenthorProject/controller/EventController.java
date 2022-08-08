package com.menthor.MenthorProject.controller;

import com.menthor.MenthorProject.dto.UserDto;
import com.menthor.MenthorProject.model.EventEntity;
import com.menthor.MenthorProject.service.EventService;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
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

<<<<<<< HEAD
    @DeleteMapping("/delete/{id}")
    public boolean Delete(@PathVariable Long id) { return eventService.Delete(id); }
=======
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
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
}
