package mentor.search.repository;

import mentor.search.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SearchRepository extends JpaRepository<Mentor, Long> {

    @Query("SELECT p FROM Mentor p WHERE " + "p.name LIKE CONCAT('%',:query, '%)"+ "p.description LIKE CONCAT('%', :query, '%')")
    List<Mentor> searchMentor(String query);

    @Query(value = "SELECT * FROM mentors p WHERE " + "p.name LIKE CONCAT('%',:query, '%)"+ "p.description LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List<Mentor> searchMentorSQL(String query);
}
