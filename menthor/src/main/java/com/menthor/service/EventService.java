package com.menthor.service;

import com.menthor.dto.UserDto;
import com.menthor.model.EventEntity;
import com.menthor.model.MatchEntity;
import com.menthor.repository.EventRepository;
import com.menthor.repository.MatchRepository;
import org.springframework.stereotype.Service;

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

    public UserDto.Response Update(Long id, EventEntity event){
        EventEntity updatedEvent = eventRepository.getReferenceById(id);
        updatedEvent.setTitle(event.getTitle());
        updatedEvent.setDescription(event.getDescription());
        updatedEvent.setStartDate(event.getStartDate());
        updatedEvent.setFinishDate(event.getFinishDate());
        eventRepository.save(updatedEvent);
        response.setMessage("Görüşme Güncellendi.");
        return response;
    }

    public Optional<EventEntity> ListById(Long id){
        return eventRepository.findById(id);
    }

    public UserDto.Response Delete(Long id){
        eventRepository.deleteById(id);
        response.setMessage("Görüşme Silindi.");
        return response;
    }
}