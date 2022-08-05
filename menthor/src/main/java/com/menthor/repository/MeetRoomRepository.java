package com.menthor.repository;

import com.menthor.model.MeetRoomKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetRoomRepository extends JpaRepository<MeetRoomKeyEntity, Long> {

    public List<MeetRoomKeyEntity> findByMatch(Long match);

}