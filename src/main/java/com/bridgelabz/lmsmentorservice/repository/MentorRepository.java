package com.bridgelabz.lmsmentorservice.repository;

import com.bridgelabz.lmsmentorservice.model.MentorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MentorRepository extends JpaRepository<MentorModel, Long> {
    @Query(value = "select * from Mentor WHERE id = 1", nativeQuery = true)
   List<MentorModel> findByAllId(long id);

// int getCount();
}