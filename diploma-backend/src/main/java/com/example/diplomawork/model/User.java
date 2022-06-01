package com.example.diplomawork.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private String middleName;

    @Column(unique = true)
    private String email;

    @NonNull
    @Column(unique = true)
    private String username;

    @NonNull
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne(mappedBy = "student")
    private UserGrade grade;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<UserTeam> userTeams;

    @OneToMany(mappedBy = "questioner", fetch = FetchType.LAZY)
    List<Question> userQuestions;

    @OneToMany(mappedBy = "responder", fetch = FetchType.LAZY)
    List<Question> questionsResponders;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    List<UserCommissionGrade> commissionsGrades;

    @OneToMany(mappedBy = "commission", fetch = FetchType.LAZY)
    List<UserCommissionGrade> commissionGrades;

}

