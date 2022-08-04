package com.menthor.MenthorProject.service;

import com.menthor.MenthorProject.dto.UserDto;
import com.menthor.MenthorProject.model.EventEntity;
import com.menthor.MenthorProject.model.MatchEntity;
import com.menthor.MenthorProject.repository.EventRepository;
import com.menthor.MenthorProject.repository.MatchRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final MatchRepository matchRepository;
    private final UserDto.Response response;

    public EventService(EventRepository eventRepository, MatchRepository matchRepository) {
        this.eventRepository = eventRepository;
        this.matchRepository = matchRepository;
        this.response = new UserDto.Response();
    }

    public UserDto.Response Create(EventEntity event){
        Optional<MatchEntity> isEmpty = matchRepository.findById(event.getMatchId());
        if (!isEmpty.isEmpty()){
            eventRepository.save(event);
            response.setMessage("Görüşme Kaydedildi.");
            return response;
        }else {
            response.setMessage("Görüşme Kaydedilirken Bir Sorun Oluştu !");
            return response;
        }
    }

    public boolean Delete(Long id){
        try {
            eventRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
