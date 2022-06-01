package com.example.diplomawork.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "initials")
@Builder
public class Initial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String initial;

    @OneToMany(mappedBy = "initial", fetch = FetchType.LAZY)
    private List<Group> groups;
}
