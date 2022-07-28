package com.example.springtutorial.repository;
import com.example.springtutorial.models.file_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface file_repository extends JpaRepository<file_model, String> {
}
