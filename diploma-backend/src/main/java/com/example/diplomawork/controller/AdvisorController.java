package com.example.diplomawork.controller;

import com.example.api.AdvisorApi;
import com.example.diplomawork.service.AdvisorService;
import com.example.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdvisorController implements AdvisorApi {

    private final AdvisorService advisorService;

    @Override
    public ResponseEntity<TopicSelectRequestFullInfoDto> getTeamTopicRequestFullInfo(Long topicId, Long requestId) {
        return ResponseEntity.ok(advisorService.getRequestFullInfo(topicId, requestId));
    }

    @Override
    public ResponseEntity<Void> acceptTopicRequests(Long topicId, Long requestId) {
        advisorService.acceptTopicRequests(topicId, requestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> createTopic(TopicCreateUpdateRequest request) {
        advisorService.createUpdateTopic(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteTopic(Long topicId) {
        advisorService.deleteTopic(topicId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TopicShortInfoDto>> getConfirmedTopics() {
        return ResponseEntity.ok(advisorService.getConfirmedTopics());
    }

    @Override
    public ResponseEntity<TopicInfoByBlocksDto> getTopic(Long topicId) {
        return ResponseEntity.ok(advisorService.getTopic(topicId));
    }

    @Override
    public ResponseEntity<List<TopicSelectRequestDto>> getTopicRequests(Long topicId) {
        return ResponseEntity.ok(advisorService.getTopicRequests(topicId));
    }

    @Override
    public ResponseEntity<List<TopicShortInfoDto>> getUnconfirmedTopics() {
        return ResponseEntity.ok(advisorService.getUnconfirmedTopics());
    }

    @Override
    public ResponseEntity<Void> updateTopic(TopicCreateUpdateRequest request) {
        advisorService.createUpdateTopic(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
