package com.example.diplomawork.controller;

import com.example.api.StudentApi;
import com.example.diplomawork.service.StudentService;
import com.example.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController implements StudentApi {

    private final StudentService studentService;


    @Override
    public ResponseEntity<StudentStatusDto> studentStatus() {
        return ResponseEntity.ok(studentService.getStudentStatus());
    }

    @Override
    public ResponseEntity<Void> updateTeam(TeamCreateUpdateRequest request) {
        studentService.createUpdateTeam(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> removeTeamMember(Long memberId) {
        studentService.removeTeamMember(memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> createRequestToTopic(Long topicId) {
        studentService.createRequestToTopic(topicId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TeamShortInfoDto>> getAvailableTeams() {
        return ResponseEntity.ok(studentService.getAvailableTeams());
    }

    @Override
    public ResponseEntity<List<TopicShortInfoDto>> getAvailableTopics() {
        return ResponseEntity.ok(studentService.getAvailableTopics());
    }
    @Override
    public ResponseEntity<Void> acceptTeamJoinRequest(Long requestId) {
        studentService.acceptTeamJoinRequest(requestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> createRequestToTeam(Long teamId) {
        studentService.createRequestToTeam(teamId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> createTeam(TeamCreateUpdateRequest request) {
        studentService.createUpdateTeam(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TeamInfoWithMembersDto> getTeam() {
        return ResponseEntity.ok(studentService.getTeam());
    }

    @Override
    public ResponseEntity<List<UserTeamRequestDto>> getTeamRequests() {
        return ResponseEntity.ok(studentService.getTeamJoinRequests());
    }

    @Override
    public ResponseEntity<List<TeamJoinRequestInfoByBlocksDto>> getUserRequests() {
        return ResponseEntity.ok(studentService.getUserRequests());
    }
}
