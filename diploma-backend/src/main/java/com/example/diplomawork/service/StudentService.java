package com.example.diplomawork.service;

import com.example.diplomawork.mapper.GroupMapper;
import com.example.diplomawork.mapper.JoinRequestMapper;
import com.example.diplomawork.mapper.TeamMapper;
import com.example.diplomawork.mapper.UserMapper;
import com.example.diplomawork.model.*;
import com.example.diplomawork.repository.*;
import com.example.models.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.MethodNotAllowedException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final AuthService authService;

    private final TeamRepository teamRepository;

    private final TopicRepository topicRepository;

    private final UserRepository userRepository;

    private final UserTeamRepository userTeamRepository;

    private final TeamTopicRepository teamTopicRepository;

    private final TeamMapper teamMapper;

    private final UserMapper userMapper;

    private final GroupMapper groupMapper;

    private final JoinRequestMapper joinRequestMapper;

    public void createUpdateTeam(TeamCreateUpdateRequest request) {
        User currentUser = authService.getCurrentUser();
        Team team = Team.builder()
                .id(request.getTeamId() != null ? request.getTeamId() : null)
                .name(request.getName())
                .creator(currentUser)
                .advisor(request.getAdvisorId() != null ? userRepository.findById(request.getAdvisorId()).orElseThrow(() -> new EntityNotFoundException("Not found")) : null)
                .confirmed(false)
                .topic(request.getTopicId() != null ? topicRepository.findById(request.getTopicId()).orElseThrow(() -> new EntityNotFoundException("Not found")) : null)
                .build();
        teamRepository.saveAndFlush(team);
        userTeamRepository.save(UserTeam.builder()
                .team(team)
                .user(currentUser)
                .accepted(true)
                .build());
    }

    public List<UserTeamRequestDto> getTeamJoinRequests() {
        User currentUser = authService.getCurrentUser();
        Team team = teamRepository.findByCreatorId(currentUser.getId()).orElseThrow(() -> new EntityNotFoundException("Team with creator id: " + currentUser.getId() + " not found"));
        return userTeamRepository.findAllByTeamIdAndAcceptedFalse(team.getId())
                .stream().map(userTeam -> UserTeamRequestDto.builder()
                        .id(userTeam.getId())
                        .user(userMapper.entity2dto(userTeam.getUser()))
                        .build()).collect(Collectors.toList());
    }

    @SneakyThrows
    public void acceptTeamJoinRequest(Long requestId) {
        User currentUser = authService.getCurrentUser();
        Team team = teamRepository.findByCreatorId(currentUser.getId()).orElseThrow(() -> new EntityNotFoundException("Team with creator id: " + currentUser.getId() + " not found"));
        UserTeam userTeam = userTeamRepository.findById(requestId).orElseThrow(() -> new EntityNotFoundException("Request with id: " + requestId + " not found"));
        if (userTeam.getTeam().getId() != team.getId()) {
            throw new IllegalAccessException("Action is not allowed!");
        }
        userTeam.setAccepted(true);
        userTeamRepository.save(userTeam);
    }

    public TeamInfoWithMembersDto getTeam() {
        User currentUser = authService.getCurrentUser();
        UserTeam userTeamSet = userTeamRepository.findByUserIdAndAcceptedTrue(currentUser.getId()).orElseThrow(() -> new EntityNotFoundException("Team with member id: " + currentUser.getId() + " not found"));
        Team team = userTeamSet.getTeam();
        List<UserTeam> userTeams = userTeamRepository.findAllByTeamIdAndAcceptedTrue(team.getId());
        return TeamInfoWithMembersDto.builder()
                .team(teamMapper.entity2dto(team))
                .members(userTeams.stream().map(userTeam -> userMapper.entity2dto(userTeam.getUser())).collect(Collectors.toList()))
                .build();
    }

    public void createRequestToTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new EntityNotFoundException("Team with id: " + teamId + " not found"));
        userTeamRepository.save(UserTeam.builder()
                .user(authService.getCurrentUser())
                .team(team)
                .accepted(false)
                .build());
    }

    public List<TeamJoinRequestInfoByBlocksDto> getUserRequests() {
        User currentUser = authService.getCurrentUser();
        List<UserTeam> userTeams = userTeamRepository.findAllByUserId(currentUser.getId());
        return userTeams.stream().map(userTeam -> TeamJoinRequestInfoByBlocksDto.builder()
                .request(joinRequestMapper.entity2dto(userTeam))
                .team(teamMapper.entity2dto(userTeam.getTeam()))
                .build()).collect(Collectors.toList());
    }

    public List<TeamShortInfoDto> getAvailableTeams() {
        return teamRepository.findAllByConfirmedFalse().stream().map(teamMapper::entity2dto).collect(Collectors.toList());
    }

    @SneakyThrows
    public void createRequestToTopic(Long topicId) {
        User currentUser = authService.getCurrentUser();
        Team team = teamRepository.findByCreatorId(authService.getCurrentUser().getId()).orElseThrow(() -> new EntityNotFoundException("Team with creator id: " + currentUser.getId() + " not found"));
        if (team == null) {
            throw new IllegalAccessException("Action is not allowed!");
        }
        TeamTopic request = TeamTopic.builder()
                .team(team)
                .topic(topicRepository.findById(topicId).orElseThrow(() -> new EntityNotFoundException("Topic not found!")))
                .build();
        teamTopicRepository.save(request);
    }


    public List<TopicShortInfoDto> getAvailableTopics() {
        List<Topic> topics = topicRepository.findAllBySelectedFalse();
        return topics.stream().map(topic -> TopicShortInfoDto.builder().id(topic.getId()).topicName(topic.getName())
                .advisor(topic.getCreator().getLastName() + " " + topic.getCreator().getFirstName())
                .build()).collect(Collectors.toList());
    }
}
