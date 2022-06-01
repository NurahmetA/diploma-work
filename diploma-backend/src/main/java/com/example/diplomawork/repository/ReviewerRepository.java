package com.example.diplomawork.repository;

import com.example.diplomawork.model.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {

    Reviewer findByFullName(String fullName);

}
