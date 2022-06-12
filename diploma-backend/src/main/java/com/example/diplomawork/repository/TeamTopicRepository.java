package com.example.diplomawork.repository;

import com.example.diplomawork.model.TeamTopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamTopicRepository extends JpaRepository<TeamTopic, Long> {
    List<TeamTopic> findAllByTopicIdAndApprovedFalse(Long topicId);

    void deleteAllByTopicIdAndApprovedFalse(Long topicId);
}
