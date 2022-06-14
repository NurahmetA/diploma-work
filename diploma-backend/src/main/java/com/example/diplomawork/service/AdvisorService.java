package com.example.diplomawork.service;

import com.example.diplomawork.mapper.TeamMapper;
import com.example.diplomawork.mapper.TopicMapper;
import com.example.diplomawork.mapper.UserMapper;
import com.example.diplomawork.model.*;
import com.example.diplomawork.repository.*;
import com.example.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AdvisorService {

    private final TeamRepository teamRepository;

    private final TopicRepository topicRepository;

    private final TeamTopicRepository teamTopicRepository;

    private final UserTeamRepository userTeamRepository;

    private final AuthService authService;

    private final TeamMapper teamMapper;

    private final UserMapper userMapper;

    private final TopicMapper topicMapper;

    public void acceptTopicRequests(Long topicId, Long requestId) {
        User user = authService.getCurrentUser();
        TeamTopic teamTopic = teamTopicRepository.findById(requestId).orElseThrow(() -> new EntityNotFoundException("Team topic not found!"));
        teamTopic.setApproved(true);
        Topic topic = teamTopic.getTopic();
        topic.setSelected(true);
        Team team = teamTopic.getTeam();
        topic.setTeam(team);
        team.setAdvisor(user);
        team.setTopic(topic);
        team.setConfirmed(true);
        teamTopicRepository.save(teamTopic);
        topicRepository.save(topic);
        teamRepository.save(team);
        teamTopicRepository.deleteAllByTopicIdAndApprovedFalse(topicId);
    }

    public void updateTopic(TopicCreateUpdateRequest request) {
        Topic topic = topicRepository.findById(request.getId()).orElseThrow(() -> new EntityNotFoundException("Topic not found"));
        topic.setName(request.getName());
        topicRepository.save(topic);
    }

    public void createTopic(TopicCreateUpdateRequest request) {
        topicRepository.save(Topic.builder()
                .name(request.getName())
                .selected(false)
                .creator(authService.getCurrentUser())
                .build());
    }

    public void deleteTopic(Long topicId) {
        topicRepository.deleteById(topicId);
    }

    public List<TopicShortInfoDto> getConfirmedTopics() {
        User currentUser = authService.getCurrentUser();
        List<Topic> confirmedTopics = topicRepository.findAllByCreatorIdAndSelectedTrue(currentUser.getId());
        return confirmedTopics.stream().map(topic -> TopicShortInfoDto.builder()
                .id(topic.getId())
                .advisor(currentUser.getLastName() + " " + currentUser.getFirstName())
                .topicName(topic.getName())
                .build()).collect(Collectors.toList());
    }

    public TopicInfoByBlocksDto getTopic(Long topicId) {
        TopicInfoByBlocksDto.TopicInfoByBlocksDtoBuilder builder = TopicInfoByBlocksDto.builder();
        Topic topic = topicRepository.findById(topicId).orElseThrow(() -> new EntityNotFoundException("Topic with id: " + topicId + " not found"));
        if (topic.getSelected()) {
            if (topic.getTeam() != null) {
                List<UserTeam> users = userTeamRepository.findAllByTeamIdAndAcceptedTrue(topic.getTeam().getId());
                List<UserDto> members = users.stream().map(user -> userMapper.entity2dto(user.getUser())).collect(Collectors.toList());
                TeamInfoWithMembersDto dto = TeamInfoWithMembersDto.builder()
                        .team(topic.getTeam() != null ? teamMapper.entity2dto(topic.getTeam()) : null)
                        .members(members)
                        .build();
                builder.team(dto);
            }
        }
        return builder.topic(topicMapper.entity2dto(topic))
                .creator(userMapper.entity2dto(authService.getCurrentUser()))
                .build();
    }

    public List<TopicSelectRequestDto> getTopicRequests(Long topicId) {
        List<TeamTopic> teamTopics = teamTopicRepository.findAllByTopicIdAndApprovedFalse(topicId);
        return teamTopics.stream().map(teamTopic -> TopicSelectRequestDto.builder()
                .id(teamTopic.getId())
                .team(teamTopic.getTeam().getName())
                .build()).collect(Collectors.toList());
    }

    public List<TopicShortInfoDto> getUnconfirmedTopics() {
        User currentUser = authService.getCurrentUser();
        List<Topic> confirmedTopics = topicRepository.findAllByCreatorIdAndSelectedFalse(currentUser.getId());
        return confirmedTopics.stream().map(topic -> TopicShortInfoDto.builder()
                .id(topic.getId())
                .advisor(currentUser.getLastName() + " " + currentUser.getFirstName())
                .topicName(topic.getName())
                .build()).collect(Collectors.toList());
    }

    public TopicSelectRequestFullInfoDto getRequestFullInfo(Long topicId, Long requestId) {
        TeamTopic teamTopic = teamTopicRepository.findById(requestId).orElseThrow(() -> new EntityNotFoundException("Request with id: " + requestId + " not found"));
        List<UserTeam> users = userTeamRepository.findAllByTeamIdAndAcceptedTrue(teamTopic.getTeam().getId());
        List<UserDto> members = users.stream().map(user -> userMapper.entity2dto(user.getUser())).collect(Collectors.toList());
        return TopicSelectRequestFullInfoDto.builder()
                .id(teamTopic.getId())
                .team(teamTopic.getTeam().getName())
                .topic(teamTopic.getTopic().getName())
                .members(members)
                .build();
    }
}
