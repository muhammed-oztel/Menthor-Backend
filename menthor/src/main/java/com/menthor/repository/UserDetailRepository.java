package com.menthor.repository;

import com.menthor.model.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long> {
<<<<<<< HEAD
    public List<UserDetailEntity> findByUserId(Long id);
=======
    public List<UserDetailEntity> findByUserId(Long userId);
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
}
