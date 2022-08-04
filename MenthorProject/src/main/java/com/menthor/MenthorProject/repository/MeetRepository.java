package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.MeetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetRepository extends JpaRepository<MeetEntity, Long> {
}
