package com.menthor.MenthorProject.service;

import com.menthor.MenthorProject.dto.UserDto;
import com.menthor.MenthorProject.model.EventEntity;
import com.menthor.MenthorProject.model.MatchEntity;
import com.menthor.MenthorProject.repository.EventRepository;
import com.menthor.MenthorProject.repository.MatchRepository;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import javax.transaction.Transactional;
=======
import java.util.List;
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
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

<<<<<<< HEAD
    public boolean Delete(Long id){
        try {
            eventRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
=======
    public UserDto.Response Update(Long id, EventEntity event){
        EventEntity updatedEvent = eventRepository.getReferenceById(id);
        updatedEvent.setTitle(event.getTitle());
        updatedEvent.setDescription(event.getDescription());
        updatedEvent.setStart(event.getStart());
        updatedEvent.setEnd(event.getEnd());
        eventRepository.save(updatedEvent);
        response.setMessage("Görüşme Güncellendi.");
        return response;
    }

    public List<EventEntity> GetList(Long matchId){
        return eventRepository.findByMatchId(matchId);
    }

    public UserDto.Response Delete(Long id){
        eventRepository.deleteById(id);
        response.setMessage("Görüşme Silindi.");
        return response;
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
    }
}
