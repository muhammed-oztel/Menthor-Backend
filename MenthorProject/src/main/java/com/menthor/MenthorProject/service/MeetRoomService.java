package com.menthor.MenthorProject.service;

import com.menthor.MenthorProject.model.MatchEntity;
import com.menthor.MenthorProject.model.MeetRoomKeyEntity;
import com.menthor.MenthorProject.repository.MatchRepository;
import com.menthor.MenthorProject.repository.MeetRoomRepository;
import org.springframework.stereotype.Service;

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
            MatchEntity matchEntity = matchRepository.findByMentor_id(mentor_id);
            MeetRoomKeyEntity meetRoomKeyEntity = meetRoomRepository.findByMatch_Id(matchEntity.getId());

            if (meetRoomKeyEntity != null) {
                return UpdateCode(meetRoomKeyEntity, Key);
            } else {
                try {
                    meetRoomKeyEntity = new MeetRoomKeyEntity();
                    meetRoomKeyEntity.setMatch_Id(matchEntity.getId());
                    meetRoomKeyEntity.setRoom_code(Key);
                    meetRoomRepository.save(meetRoomKeyEntity);
                    return "MeetRoom id gonderildi.";
                } catch (Exception e) {
                    return "MeetRoom id gonderilemedi!";
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
            return "MeetRoom id gonderildi.";
        }catch (Exception e){
            return "MeetRoom id gonderilemedi!";
        }
    }

    public String GetCode(Long mentee_id){
        try {
            MatchEntity matchEntity = matchRepository.findByMentee_id(mentee_id);
            MeetRoomKeyEntity meetRoomKeyEntity = meetRoomRepository.findByMatch_Id(matchEntity.getId());
            return meetRoomKeyEntity.getRoom_code();
        } catch (Exception e){
            return null;
        }
    }
}
