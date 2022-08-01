package com.lynas.paginationandsorting.Repository;
import com.lynas.paginationandsorting.Entity.MentorSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MentorSearchRepository extends JpaRepository<MentorSearch, Long> {
    @Query("select s from MentorSearch s where name like %?1%")
    List<MentorSearch> findByName(String name);
}
