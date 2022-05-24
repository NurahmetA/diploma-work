package com.example.diplomawork;

import com.example.diplomawork.model.*;
import com.example.diplomawork.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class DiplomaWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiplomaWorkApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    @Transactional
    CommandLineRunner run(RoleRepository roleRepository, TopicRepository topicRepository, UserRepository userRepository, GroupRepository groupRepository, InitialRepository initialRepository, TeamRepository teamRepository, TeamTopicRepository teamTopicRepository, UserTeamRepository userTeamRepository, StageRepository stageRepository) {
        return args -> {
            roleRepository.save(new Role(null, "ROLE_ADMIN"));
            roleRepository.save(new Role(null, "ROLE_USER"));
            roleRepository.save(new Role(null, "ROLE_COMMISSION"));
            userRepository.save(new User(null, "Test", "Test", "Test", "test@gmail.com", "test", new BCryptPasswordEncoder().encode("12131213"), roleRepository.findByName("ROLE_USER")));
            userRepository.save(new User(null, "Test1", "Test1", "Test1", "test1@gmail.com", "test1", new BCryptPasswordEncoder().encode("12131213"), roleRepository.findByName("ROLE_USER")));
            userRepository.save(new User(null, "Admin", "Admin", "Admin", "Admin@gmail.com", "admin", new BCryptPasswordEncoder().encode("admin"), roleRepository.findByName("ROLE_ADMIN")));
            userRepository.save(new User(null, "Assel", "Smayil", "Maralbaevna", "assel.smayil@gmail.com", "asmayil", new BCryptPasswordEncoder().encode("12131213"), roleRepository.findByName("ROLE_COMMISSION")));
            userRepository.save(new User(null, "Askar", "Khaimuldin", "", "askar@gmail.com", "askar", new BCryptPasswordEncoder().encode("12131213"), roleRepository.findByName("ROLE_COMMISSION")));
            initialRepository.save(Initial.builder().id(null).initial("SE").build());
            initialRepository.save(Initial.builder().id(null).initial("CS").build());
            initialRepository.save(Initial.builder().id(null).initial("MT").build());
            groupRepository.save(new Group(null, "1903", initialRepository.findByInitial("SE")));
            topicRepository.save(Topic.builder()
                    .name("DIPLOMA PROJECT #1")
                    .creator(userRepository.findByUsername("asmayil").get())
                    .initial(initialRepository.findById(1L).get())
                    .selected(true)
                    .build());
            teamRepository.save(Team.builder()
                    .name("REMMA")
                    .confirmed(true)
                    .creator(userRepository.findByUsername("test").get())
                    .advisor(userRepository.findByUsername("asmayil").get())
                    .choices(3)
                    .build());
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("test").get(), teamRepository.findById(1L).get(), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("test1").get(), teamRepository.findById(1L).get(), true));
            teamTopicRepository.save(TeamTopic.builder()
                    .topic(topicRepository.findById(1L).get())
                    .team(teamRepository.findById(1L).get())
                    .approved(true)
                    .build());
            stageRepository.save(Stage.builder().name("PRE-DEFENCE#1").build());
            stageRepository.save(Stage.builder().name("PRE-DEFENCE#2").build());
            stageRepository.save(Stage.builder().name("DEFENCE").build());
            Topic topic = topicRepository.findById(1L).get();
            Team team = teamRepository.findById(1L).get();
            team.setTopic(topic);
            teamRepository.save(team);
        };
    }
}
