package com.menthor.service;

import com.menthor.model.MatchEntity;
import com.menthor.model.MeetRoomKeyEntity;
import com.menthor.repository.MatchRepository;
import com.menthor.repository.MeetRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetRoomService {
    private final MeetRoomRepository meetRoomRepository;
    private final MatchRepository matchRepository;

    public MeetRoomService(MeetRoomRepository meetRoomRepository, MatchRepository matchRepository) {
        this.meetRoomRepository = meetRoomRepository;
        this.matchRepository = matchRepository;
    }

    public String CreateCode(String Key, Long mentor_id) {
        try {
            List<MatchEntity> matchEntities = ListMatchForMentor(mentor_id);
            MatchEntity matchEntity = matchEntities.get(0);
            List<MeetRoomKeyEntity> meetRoomKeyEntities = meetRoomRepository.findByMatch(matchEntity.getId());

            if (meetRoomKeyEntities.size() >= 1) {
                MeetRoomKeyEntity meetRoomKeyEntity = meetRoomKeyEntities.get(0);
                return UpdateCode(meetRoomKeyEntity, Key);
            } else {
                try {
                    MeetRoomKeyEntity meetRoomKeyEntity = new MeetRoomKeyEntity();
                    meetRoomKeyEntity.setMatch_Id(matchEntity.getId());
                    meetRoomKeyEntity.setRoom_code(Key);
                    meetRoomRepository.save(meetRoomKeyEntity);
                    return "MeetRoom id kaydedildi.";
                } catch (Exception e) {
                    return "MeetRoom id kaydedilemedi!";
                }
            }
        } catch (Exception e) {
            return "Sorgulama sirasinda hata olustu!";
        }
    }



    public String UpdateCode(MeetRoomKeyEntity meetRoomKeyEntity, String Key){
        try {
            meetRoomKeyEntity.setRoom_code(Key);
            meetRoomRepository.save(meetRoomKeyEntity);
            return "MeetRoom id guncellendi.";
        }catch (Exception e){
            return "MeetRoom id guncellenemedi!";
        }
    }

    public String GetCode(Long mentee_id){
        try {
            List<MatchEntity> matchEntities = ListMatchForMentee(mentee_id);
            MatchEntity matchEntity = matchEntities.get(0);
            List<MeetRoomKeyEntity> meetRoomKeyEntities = ListMeetRoom(matchEntity.getId());
            MeetRoomKeyEntity meetRoomKeyEntity = meetRoomKeyEntities.get(0);
            return meetRoomKeyEntity.getRoom_code();
        } catch (Exception e){
            return null;
        }
    }

    public List<MatchEntity> ListMatchForMentor(Long User_id){
        return matchRepository.findByMentor(User_id);
    }

    public List<MatchEntity> ListMatchForMentee(Long User_id){
        return matchRepository.findByMentee(User_id);
    }
    public List<MeetRoomKeyEntity> ListMeetRoom(Long Match_id){
        return meetRoomRepository.findByMatch(Match_id);
    }
}