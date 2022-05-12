package com.example.diplomawork.repository;

import com.example.diplomawork.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findDocumentsByDefenceId(Long defenceId);
}