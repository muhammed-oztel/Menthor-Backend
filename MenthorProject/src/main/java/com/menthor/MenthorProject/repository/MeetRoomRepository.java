package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.MeetRoomKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetRoomRepository extends JpaRepository<MeetRoomKeyEntity, Long> {

    public MeetRoomKeyEntity findByMatch_Id(Long match_id);

}
