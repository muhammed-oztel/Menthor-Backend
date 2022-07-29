package com.lynas.paginationandsorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where name like %?1%")
    List<Student> findByName(String name);
}