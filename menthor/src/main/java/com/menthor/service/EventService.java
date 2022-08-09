package com.menthor.service;

import com.menthor.dto.UserDto;
import com.menthor.model.EventEntity;
import com.menthor.model.MatchEntity;
import com.menthor.model.UserEntity;
import com.menthor.repository.EventRepository;
import com.menthor.repository.MatchRepository;
import com.menthor.repository.UserRepository;
import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final MatchRepository matchRepository;
    private final UserRepository userRepository;
    private final UserDto.Response response;

    public EventService(EventRepository eventRepository, MatchRepository matchRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
        this.response = new UserDto.Response();
    }

    public UserDto.Response Create(Long userId, EventEntity event){
        try{
            UserEntity user = userRepository.getReferenceById(userId);
            Long matchId = null;
            if (user.getRole().toLowerCase().equals("mentor")){
                matchId = matchRepository.findByMentorAndAndDeleted(userId, null).get(0).getId();
            }else if (user.getRole().toLowerCase().equals("mentee")){
                matchId = matchRepository.findByMenteeAndAndDeleted(userId, null).get(0).getId();
            }
            Optional<MatchEntity> isEmpty = matchRepository.findById(matchId);
            if (!isEmpty.isEmpty()){
                event.setMatchId(matchId);
                eventRepository.save(event);
                response.setMessage("Görüşme Kaydedildi.");
                return response;
            }else {
                response.setMessage("Görüşme Kaydedilirken Bir Sorun Oluştu !");
                return response;
            }
        }catch(Exception e){
            return null;
        }
    }

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

    public List<EventEntity> GetList(Long userId){
        try {
            UserEntity user = userRepository.getReferenceById(userId);
            Long matchId = null;
            if (user.getRole().toLowerCase().equals("mentor")){
                matchId = matchRepository.findByMentorAndAndDeleted(userId, null).get(0).getId();
            }else if (user.getRole().toLowerCase().equals("mentee")){
                matchId = matchRepository.findByMenteeAndAndDeleted(userId, null).get(0).getId();
            }
            List<EventEntity> events = eventRepository.findByMatchIdAndDeleted(matchId, null);
            if (events.isEmpty())
                return null;
            else
                return events;
        }catch (Exception ex){
            return null;
        }
    }

    public UserDto.Response Delete(Long id){
        EventEntity event = eventRepository.getReferenceById(id);
        event.setDeleted(new Date());
        eventRepository.save(event);
        response.setMessage("Görüşme Silindi.");
        return response;
    }
}