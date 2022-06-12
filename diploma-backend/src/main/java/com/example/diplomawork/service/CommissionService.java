package com.example.diplomawork.service;

import com.example.diplomawork.mapper.DefenceMapper;
import com.example.diplomawork.mapper.QuestionMapper;
import com.example.diplomawork.mapper.TeamMapper;
import com.example.diplomawork.mapper.UserMapper;
import com.example.diplomawork.model.*;
import com.example.diplomawork.repository.*;
import com.example.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommissionService {

    private final UserTeamRepository userTeamRepository;

    private final DefenceRepository defenceRepository;

    private final QuestionRepository questionRepository;

    private final UserRepository userRepository;

    private final DefenceCommissionRepository defenceCommissionRepository;

    private final UserCommissionGradeRepository userCommissionGradeRepository;

    private final AuthService authService;

    private final TeamMapper teamMapper;

    private final UserMapper userMapper;

    private final DefenceMapper defenceMapper;

    private final QuestionMapper questionMapper;

    public DefenceInfoByBlocksDto getCommissionDefence(Long defenceId) {
        Defence defence = defenceRepository.findById(defenceId).orElseThrow(() -> new EntityNotFoundException("Defence with id: " + defenceId + " not found"));
        Team team = defence.getTeam();
        List<UserTeam> userTeams = userTeamRepository.findAllByTeamIdAndAcceptedTrue(team.getId());
        TeamInfoWithMembersDto teamInfo = TeamInfoWithMembersDto.builder()
                .team(teamMapper.entity2dto(team).advisor(team.getAdvisor() != null ? team.getAdvisor().getFirstName() + " " + team.getAdvisor().getLastName() : null))
                .members(userTeams.stream().map(userTeam -> userMapper.entity2dto(userTeam.getUser())).collect(Collectors.toList()))
                .build();
        List<QuestionDto> questions = new ArrayList<>();
        questionRepository.findAllByDefenceIdAndQuestionerId(defenceId, authService.getCurrentUser().getId()).forEach(question -> {
            QuestionDto questionDto = questionMapper.entity2dto(question);
            questionDto.setResponderName(question.getResponder().getLastName() + " " + question.getResponder().getFirstName().charAt(0) + ".");
            questions.add(questionDto);
        });
        return DefenceInfoByBlocksDto.builder()
                .defence(defenceMapper.entity2dto(defence))
                .team(teamInfo)
                .questions(questions)
                .build();
    }

    public void createQuestion(Long defenceId, CommissionQuestionCreateRequest request) {
        List<Long> studentIds = request.getStudentIds();
        studentIds.stream().map(studentId -> Question.builder()
                .questioner(authService.getCurrentUser())
                .description(request.getDescription())
                .defence(defenceRepository.findById(defenceId).orElseThrow(() -> new EntityNotFoundException("Defence with id: " + defenceId + " not found")))
                .responder(userRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("User with id: " + studentId + " not found")))
                .build()).forEach(questionRepository::save);
    }

    public void updateQuestion(Long questionId, CommissionQuestionUpdateRequest request) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new EntityNotFoundException("Question with id: " + questionId + " not found"));
        question.setDescription(request.getDescription());
        questionRepository.save(question);
    }

    public void setGrade(Long defenceId, Long studentId, GradeDto grade) {
        User student = userRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("User with id: " + studentId + " not found"));
        User commission = authService.getCurrentUser();
        Defence defence = defenceRepository.findById(defenceId).orElseThrow(() -> new EntityNotFoundException("Defence with id: " + defenceId + " not found"));
        UserCommissionGrade userCommissionGrade = userCommissionGradeRepository.findByCommissionIdAndStudentId(commission.getId(), student.getId()).orElse(null);
        if (userCommissionGrade == null) {
            userCommissionGrade = UserCommissionGrade.builder()
                    .id(null)
                    .commission(commission)
                    .defence(defence)
                    .student(student)
                    .build();
        }
        userCommissionGrade.setGrade(grade.getGrade());
        userCommissionGradeRepository.save(userCommissionGrade);
    }

    public List<DefenceShortInfoDto> getCommissionDefences() {
        User currentUser = authService.getCurrentUser();
        List<DefenceCommission> defenceCommissions = defenceCommissionRepository.findDefenceCommissionsByCommissionId(currentUser.getId());
        List<Defence> defences = defenceCommissions.stream().map(DefenceCommission::getDefence).collect(Collectors.toList());
        List<DefenceShortInfoDto> list = defences.stream().map(defence -> DefenceShortInfoDto.builder()
                .id(defence.getId())
                .defenceDate(defence.getDefenceDate())
                .team(defence.getTeam().getName())
                .topic(defence.getTeam().getTopic().getName())
                .stage(defence.getStage().getName())
                .build()).collect(Collectors.toList());
        return list;
    }

    public List<UserDto> getDefenceCommissions(Long defenceId) {
        List<DefenceCommission> defenceCommissions = defenceCommissionRepository.findDefenceCommissionsByDefenceId(defenceId);
        return defenceCommissions.stream().filter(defence -> !defence.getCommission().getUsername().equals("rakhimzhanov") && !defence.getCommission().getUsername().equals("ayabekova")).map(defence -> userMapper.entity2dto(defence.getCommission())).collect(Collectors.toList());
    }

    public List<StudentWithGradeDto> getStudentsWithCommissionGrades(Long defenceId) {
        User commission = authService.getCurrentUser();
        Defence defence = defenceRepository.findById(defenceId).orElseThrow(() -> new EntityNotFoundException("Defence with id: " + defenceId + " not found"));
        Team team = defence.getTeam();
        List<UserTeam> userTeams = userTeamRepository.findAllByTeamIdAndAcceptedTrue(team.getId());
        List<StudentWithGradeDto> students = new ArrayList<>();
        userTeams.forEach(userTeam -> {
            UserCommissionGrade grade = userCommissionGradeRepository.findByCommissionIdAndStudentIdAndDefenceId(commission.getId(), userTeam.getUser().getId(), defenceId);
            students.add(StudentWithGradeDto.builder().id(userTeam.getUser().getId()).fullName(userTeam.getUser().getFirstName() + " " + userTeam.getUser().getLastName()).grade(grade != null ? grade.getGrade() : null).build());
        });
        return students;
    }

    public void deleteDefenceQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
