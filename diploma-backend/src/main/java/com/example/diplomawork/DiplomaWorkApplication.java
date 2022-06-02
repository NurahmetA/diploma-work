package com.example.diplomawork;

import com.example.diplomawork.model.*;
import com.example.diplomawork.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        corsConfiguration.setAllowedOrigins(Arrays.asList("https://diploma-aitu-frontend.herokuapp.com/"));
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

//    @Bean
//    @Transactional
//    CommandLineRunner run(ReviewerRepository reviewerRepository, RoleRepository roleRepository, TopicRepository topicRepository, UserRepository userRepository, GroupRepository groupRepository, InitialRepository initialRepository, TeamRepository teamRepository, TeamTopicRepository teamTopicRepository, UserTeamRepository userTeamRepository, StageRepository stageRepository) {
//        return args -> {
//
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Байшемиров Жарасбек Дуйсембекович").careerGrade("PhD").workPlace("Кафедра математики и математического моделирования КазНПУ им.Абая").profession("ассоциированный профессор").build());
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Хомпыш Ардабек").careerGrade("PHD").workPlace("КН МОН РК").profession("Научный сотрудник Институт информационных и вычислительных технологий").build());
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Умаров Фахриддин Алишерович").careerGrade("PhD Candidate").workPlace("IITU, Information Systems Department").profession("Senior-lecturer").build());
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Укибасов Баубек Муратулы").careerGrade("Masters of Computer Science").workPlace("IITU").profession("Senior-lecturer").build());
//
//            roleRepository.save(new Role(null, "ROLE_ADMIN"));
//            roleRepository.save(new Role(null, "ROLE_STUDENT"));
//            roleRepository.save(new Role(null, "ROLE_COMMISSION"));
//            roleRepository.save(new Role(null, "ROLE_SECRETARY"));
//            roleRepository.save(new Role(null, "ROLE_ADVISOR"));
//
//            // --------------------//
//            initialRepository.save(Initial.builder().initial("IT").build());
//            initialRepository.save(Initial.builder().initial("SE").build());
//            initialRepository.save(Initial.builder().initial("MT").build());
//
//            groupRepository.save(new Group(null, "IT-1902", initialRepository.findByInitial("IT")));
//            groupRepository.save(new Group(null, "IT-1901", initialRepository.findByInitial("IT")));
//            groupRepository.save(new Group(null, "SE-1908", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "SE-1907", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "SE-1902", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "SE-1904", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "SE-1905", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "MT-1901", initialRepository.findByInitial("MT")));
//            groupRepository.save(new Group(null, "MT-1902", initialRepository.findByInitial("MT")));
//
//
//
//            stageRepository.save(Stage.builder().name("DEFENCE").build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("admin")
//                    .lastName("admin")
//                    .middleName(null)
//                    .username("admin")
//                    .role(roleRepository.findByName("ROLE_ADMIN"))
//                    .password(new BCryptPasswordEncoder().encode("admin"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Д.")
//                    .lastName("Едилхан")
//                    .middleName(null)
//                    .username("edilkhan")
//                    .role(roleRepository.findByName("ROLE_COMMISSION"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("А.")
//                    .lastName("Адамова")
//                    .middleName(null)
//                    .username("adamova")
//                    .role(roleRepository.findByName("ROLE_COMMISSION"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("С.")
//                    .lastName("Аубакиров")
//                    .middleName(null)
//                    .username("aubakirov")
//                    .role(roleRepository.findByName("ROLE_COMMISSION"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Д.")
//                    .lastName("Аябекова")
//                    .middleName(null)
//                    .username("ayabekova")
//                    .role(roleRepository.findByName("ROLE_COMMISSION"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("А.")
//                    .lastName("Смайыл")
//                    .middleName(null)
//                    .username("smaiyl")
//                    .role(roleRepository.findByName("ROLE_COMMISSION"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Б.")
//                    .lastName("Кумалаков")
//                    .middleName(null)
//                    .username("kumalakov")
//                    .role(roleRepository.findByName("ROLE_COMMISSION"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Н.")
//                    .lastName("Рахимжанов")
//                    .middleName(null)
//                    .username("rakhimzhanov")
//                    .role(roleRepository.findByName("ROLE_COMMISSION"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Secretar")
//                    .lastName("Secretar")
//                    .middleName("Secretar")
//                    .username("sec")
//                    .role(roleRepository.findByName("ROLE_SECRETARY"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Т.")
////                    .lastName("Мукатаев")
////                    .username("tleu13")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Implementation of Single Sign-On microservice for AUTH")
////                    .creator(userRepository.findByUsername("tleu13").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Даир")
////                    .lastName("Алаев")
////                    .middleName("Дамирович")
////                    .username("alayevd")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1905"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Исмаил")
////                    .lastName("Ибрагим")
////                    .middleName("Ибрагимұлы")
////                    .username("ibragimi")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1907"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Әбдуали")
////                    .lastName("Ілияс")
////                    .middleName("Бірлікұлы")
////                    .username("iliasa")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1907"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Алаев + Ибрагим + Ілияс")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("alayevd").get())
////                    .advisor(userRepository.findByUsername("tleu13").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("alayevd").get(), teamRepository.findTeamByName("Алаев + Ибрагим + Ілияс"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("ibragimi").get(),  teamRepository.findTeamByName("Алаев + Ибрагим + Ілияс"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("iliasa").get(),  teamRepository.findTeamByName("Алаев + Ибрагим + Ілияс"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Implementation of Single Sign-On microservice for AUTH"))
////                    .team(teamRepository.findTeamByName("Алаев + Ибрагим + Ілияс"))
////                    .approved(true)
////                    .build());
////
////            Team team1 = teamRepository.findTeamByName("Алаев + Ибрагим + Ілияс");
////            team1.setReviewer(reviewerRepository.findByFullName("Умаров Фахриддин Алишерович"));
////            team1.setTopic(topicRepository.findByName("Implementation of Single Sign-On microservice for AUTH"));
////            teamRepository.save(team1);
////
////            // --------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("А.")
////                    .lastName("Адамова")
////                    .username("adamovaa")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Development of a mobile application to analyze data from open sources")
////                    .creator(userRepository.findByUsername("adamovaa").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Аслан")
////                    .lastName("Алшанов")
////                    .middleName("Бауыржанулы")
////                    .username("alshanova")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("IT", "1902"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Диас")
////                    .lastName("Жаканов")
////                    .middleName("Максатұлы")
////                    .username("zhakanovd")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("IT", "1902"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Алшанов + Жаканов")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("alshanova").get())
////                    .advisor(userRepository.findByUsername("adamovaa").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("alshanova").get(), teamRepository.findTeamByName("Алшанов + Жаканов"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zhakanovd").get(),  teamRepository.findTeamByName("Алшанов + Жаканов"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Development of a mobile application to analyze data from open sources"))
////                    .team(teamRepository.findTeamByName("Алшанов + Жаканов"))
////                    .approved(true)
////                    .build());
////
////            Team team2 = teamRepository.findTeamByName("Алшанов + Жаканов");
////            team2.setReviewer(reviewerRepository.findById(2L).get());
////            team2.setTopic(topicRepository.findByName("Development of a mobile application to analyze data from open sources"));
////            teamRepository.save(team2);
////
////            // --------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("С.")
////                    .lastName("Аубакиров")
////                    .username("aubakirovs")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Distributed load testing for http traffic simulation in production")
////                    .creator(userRepository.findByUsername("aubakirovs").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Үміт")
////                    .lastName("Құмарова")
////                    .middleName("Қайратқызы")
////                    .username("kumarovau")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("IT", "1903"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Құмарова")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("kumarovau").get())
////                    .advisor(userRepository.findByUsername("aubakirovs").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kumarovau").get(), teamRepository.findTeamByName("Құмарова"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Distributed load testing for http traffic simulation in production"))
////                    .team(teamRepository.findTeamByName("Құмарова"))
////                    .approved(true)
////                    .build());
////
////            Team team3 = teamRepository.findTeamByName("Құмарова");
////            team3.setReviewer(reviewerRepository.findById(3L).get());
////            team3.setTopic(topicRepository.findByName("Distributed load testing for http traffic simulation in production"));
////            teamRepository.save(team3);
//
////            // --------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("А.")
////                    .lastName("Турсынкулова")
////                    .username("tursynkulovaa")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Web-application for automating business processes of computer service centers")
////                    .creator(userRepository.findByUsername("tursynkulovaa").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Дәрия")
////                    .lastName("Бигабулова")
////                    .middleName("Нұрланқызы")
////                    .username("bigabulovad")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1907"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Эльдар")
////                    .lastName("Сайрамбай")
////                    .middleName("Бауржанұлы")
////                    .username("sairambaye")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1907"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Бигабулова + Сайрамбай")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("bigabulovad").get())
////                    .advisor(userRepository.findByUsername("tursynkulovaa").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("bigabulovad").get(), teamRepository.findTeamByName("Бигабулова + Сайрамбай"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sairambaye").get(),  teamRepository.findTeamByName("Бигабулова + Сайрамбай"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Web-application for automating business processes of computer service centers"))
////                    .team(teamRepository.findTeamByName("Бигабулова + Сайрамбай"))
////                    .approved(true)
////                    .build());
////
////            Team team4 = teamRepository.findTeamByName("Бигабулова + Сайрамбай");
////            team4.setReviewer(reviewerRepository.findById(4L).get());
////            team4.setTopic(topicRepository.findByName("Web-application for automating business processes of computer service centers"));
////            teamRepository.save(team4);
////
////            // --------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Н.")
////                    .lastName("Асанова")
////                    .username("assanovan")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Development of a volunteer platform")
////                    .creator(userRepository.findByUsername("assanovan").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Алимжан")
////                    .lastName("Имангазин")
////                    .middleName("Ерболович")
////                    .username("imangazina")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1903"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Мағауия")
////                    .lastName("Мәжит")
////                    .middleName("Ғабитұлы")
////                    .username("mazhitm")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1903"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Рахат")
////                    .lastName("Төлеу")
////                    .middleName("Ризабекұлы")
////                    .username("toleur")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1903"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Имангазин + Мәжит + Төлеу")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("imangazina").get())
////                    .advisor(userRepository.findByUsername("assanovan").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("imangazina").get(), teamRepository.findTeamByName("Имангазин + Мәжит + Төлеу"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("mazhitm").get(),  teamRepository.findTeamByName("Имангазин + Мәжит + Төлеу"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("toleur").get(),  teamRepository.findTeamByName("Имангазин + Мәжит + Төлеу"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Development of a volunteer platform"))
////                    .team(teamRepository.findTeamByName("Имангазин + Мәжит + Төлеу"))
////                    .approved(true)
////                    .build());
////
////            Team team5 = teamRepository.findTeamByName("Имангазин + Мәжит + Төлеу");
////            team5.setReviewer(reviewerRepository.findById(1L).get());
////            team5.setTopic(topicRepository.findByName("Development of a volunteer platform"));
////            teamRepository.save(team5);
////
////            // --------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Н.")
////                    .lastName("Хаймульдин")
////                    .username("khaimuldinn")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Development of mobile application 'Service for subscription and delivery of ZOO-goods'")
////                    .creator(userRepository.findByUsername("khaimuldinn").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Жансая")
////                    .lastName("Жайланова")
////                    .middleName("Айдынкызы")
////                    .username("zhailanovaz")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1901"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Томирис")
////                    .lastName("Саят")
////                    .middleName("")
////                    .username("sayatt")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1901"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Тамина")
////                    .lastName("Темірхан")
////                    .middleName("Ержанқызы")
////                    .username("temirkhant")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1901"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Жайланова + Саят + Темірхан")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("temirkhant").get())
////                    .advisor(userRepository.findByUsername("khaimuldinn").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zhailanovaz").get(), teamRepository.findTeamByName("Жайланова + Саят + Темірхан"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sayatt").get(),  teamRepository.findTeamByName("Жайланова + Саят + Темірхан"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("temirkhant").get(),  teamRepository.findTeamByName("Жайланова + Саят + Темірхан"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Development of mobile application 'Service for subscription and delivery of ZOO-goods'"))
////                    .team(teamRepository.findTeamByName("Жайланова + Саят + Темірхан"))
////                    .approved(true)
////                    .build());
////
////            Team team6 = teamRepository.findTeamByName("Жайланова + Саят + Темірхан");
////            team6.setReviewer(reviewerRepository.findById(5L).get());
////            team6.setTopic(topicRepository.findByName("Development of mobile application 'Service for subscription and delivery of ZOO-goods'"));
////            teamRepository.save(team6);
//
//            // --------------------//
//
//            //defence day 2 -> 02.06.2022
//
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Д.")
////                    .lastName("Лебедев")
////                    .username("lebedevd")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Development of a module for the Competitive Contract Commission for domestic and foreign teaching staff for Astana IT University")
////                    .creator(userRepository.findByUsername("lebedevd").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Ерасыл")
////                    .lastName("Болат")
////                    .middleName("Жұмағазыұлы")
////                    .username("bolate")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1902"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Анияр")
////                    .lastName("Калиев")
////                    .middleName("Ануарбекович")
////                    .username("kaliyeva")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Айбын")
////                    .lastName("Сағындық")
////                    .middleName("Бекенұлы")
////                    .username("sagyndyka")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Ален")
////                    .lastName("Туякбаев")
////                    .middleName("Сакенович")
////                    .username("tuyakbayeva")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1902"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Болат + Калиев + Сағындық + Туякбаев")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("tuyakbayeva").get())
////                    .advisor(userRepository.findByUsername("lebedevd").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("bolate").get(), teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kaliyeva").get(),  teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sagyndyka").get(),  teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("tuyakbayeva").get(),  teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Development of a module for the Competitive Contract Commission for domestic and foreign teaching staff for Astana IT University"))
////                    .team(teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"))
////                    .approved(true)
////                    .build());
////
////            Team team7 = teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев");
////            team7.setTopic(topicRepository.findByName("Development of a module for the Competitive Contract Commission for domestic and foreign teaching staff for Astana IT University"));
////            teamRepository.save(team7);
////
////            // --------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("A.")
////                    .lastName("Хаймульдин")
////                    .username("khaimuldina")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Development of data analyzer system to find available job positions from open source")
////                    .creator(userRepository.findByUsername("khaimuldina").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Азатқали")
////                    .lastName("Нұрұмғалиев")
////                    .middleName("Берикқалиұлы")
////                    .username("nurumgaliyeva")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1905"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Нұрым")
////                    .lastName("Сиырбаев")
////                    .middleName("Айзатұлы")
////                    .username("siyrbayevn")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1905"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Мадияр")
////                    .lastName("Усабеков")
////                    .middleName("Нурланович")
////                    .username("ussabekovm")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1905"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Нұрұмғалиев + Сиырбаев + Усабеков")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("ussabekovm").get())
////                    .advisor(userRepository.findByUsername("khaimuldina").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("nurumgaliyeva").get(), teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("siyrbayevn").get(),  teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("ussabekovm").get(),  teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Development of data analyzer system to find available job positions from open source"))
////                    .team(teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков"))
////                    .approved(true)
////                    .build());
////
////            Team team8 = teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков");
////            team8.setTopic(topicRepository.findByName("Development of data analyzer system to find available job positions from open source"));
////            teamRepository.save(team8);
////
////            // --------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Ж.")
////                    .lastName("Сарсенова")
////                    .username("sarsenovaz")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Development of system for translating manga and comics with automatic identification and replacement of text")
////                    .creator(userRepository.findByUsername("sarsenovaz").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Динмухаммед")
////                    .lastName("Еримбетов")
////                    .middleName("Ермекулы")
////                    .username("erimbetovd")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Мағжан")
////                    .lastName("Жақуда")
////                    .middleName("Ардақұлы")
////                    .username("zhakudam")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Рахат")
////                    .lastName("Шаяхметов")
////                    .middleName("Серикулы")
////                    .username("shayahmetovr")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1906"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Еримбетов + Жақуда + Шаяхметов")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("shayahmetovr").get())
////                    .advisor(userRepository.findByUsername("sarsenovaz").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("erimbetovd").get(), teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zhakudam").get(),  teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("shayahmetovr").get(),  teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Development of system for translating manga and comics with automatic identification and replacement of text"))
////                    .team(teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов"))
////                    .approved(true)
////                    .build());
////
////            Team team9 = teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов");
////            team9.setTopic(topicRepository.findByName("Development of system for translating manga and comics with automatic identification and replacement of text"));
////            teamRepository.save(team9);
////
////            //------------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("С.")
////                    .lastName("Аубакиров")
////                    .username("aubakirovs")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Development of MDM system for restaurants")
////                    .creator(userRepository.findByUsername("aubakirovs").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Адильхан")
////                    .lastName("Кенжетаев")
////                    .middleName("Сырымбетович")
////                    .username("kenzhetayeva")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1906"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Ақылбек")
////                    .lastName("Қонысқайров")
////                    .middleName("Ерланұлы")
////                    .username("konyskaiyrova")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1905"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Асфандияр")
////                    .lastName("Марат")
////                    .middleName("Русланулы")
////                    .username("marata")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Кенжетаев + Қонысқайров + Марат")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("marata").get())
////                    .advisor(userRepository.findByUsername("aubakirovs").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kenzhetayeva").get(), teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("konyskaiyrova").get(),  teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("marata").get(),  teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Development of MDM system for restaurants"))
////                    .team(teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат"))
////                    .approved(true)
////                    .build());
////
////            Team team10 = teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат");
////            team10.setTopic(topicRepository.findByName("Development of MDM system for restaurants"));
////            teamRepository.save(team10);
////
////            // --------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("T.")
////                    .lastName("Мукатаев")
////                    .username("tleu13")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Implementation of blokchain in Go")
////                    .creator(userRepository.findByUsername("tleu13").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Мирас")
////                    .lastName("Алимов")
////                    .middleName("Сакенович")
////                    .username("alimovm")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1901"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Амиран")
////                    .lastName("Құрман")
////                    .middleName("Мәлікұлы")
////                    .username("kurmana")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1901"))
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Бекнұр")
////                    .lastName("Раисов")
////                    .middleName("Кенжебекұлы")
////                    .username("raissovb")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1901"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Алимов + Құрман + Раисов")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("raissovb").get())
////                    .advisor(userRepository.findByUsername("tleu13").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("alimovm").get(), teamRepository.findTeamByName("Алимов + Құрман + Раисов"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kurmana").get(),  teamRepository.findTeamByName("Алимов + Құрман + Раисов"), true));
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("raissovb").get(),  teamRepository.findTeamByName("Алимов + Құрман + Раисов"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Implementation of blokchain in Go"))
////                    .team(teamRepository.findTeamByName("Алимов + Құрман + Раисов"))
////                    .approved(true)
////                    .build());
////
////            Team team11 = teamRepository.findTeamByName("Алимов + Құрман + Раисов");
////            team11.setTopic(topicRepository.findByName("Implementation of blokchain in Go"));
////            teamRepository.save(team11);
////
////            // --------------------//
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Д.")
////                    .lastName("Лебедев")
////                    .username("levedevd")
////                    .role(roleRepository.findByName("ROLE_ADVISOR"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .build());
////
////            topicRepository.save(Topic.builder()
////                    .name("Development of the “Digital University” information system using microservice architecture")
////                    .creator(userRepository.findByUsername("levedevd").get())
////                    .selected(true)
////                    .build());
////
////            userRepository.save(User.builder()
////                    .id(null)
////                    .firstName("Алихан")
////                    .lastName("Жомартов")
////                    .middleName("Мадиұлы")
////                    .username("zhomartova")
////                    .role(roleRepository.findByName("ROLE_STUDENT"))
////                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
////                    .group(groupRepository.findByInitialInitialAndName("SE", "1903"))
////                    .build());
////
////            teamRepository.save(Team.builder()
////                    .name("Жомартов")
////                    .confirmed(true)
////                    .creator(userRepository.findByUsername("zhomartova").get())
////                    .advisor(userRepository.findByUsername("levedevd").get())
////                    .build());
////
////            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zhomartova").get(), teamRepository.findTeamByName("Жомартов"), true));
////
////            teamTopicRepository.save(TeamTopic.builder()
////                    .topic(topicRepository.findByName("Development of the “Digital University” information system using microservice architecture"))
////                    .team(teamRepository.findTeamByName("Жомартов"))
////                    .approved(true)
////                    .build());
////
////            Team team12 = teamRepository.findTeamByName("Жомартов");
////            team12.setTopic(topicRepository.findByName("Development of the “Digital University” information system using microservice architecture"));
////            teamRepository.save(team12);
//
//            // --------------------//
//
//
//
//            //defence day 3 -> 03.06.2022
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Г.")
//                    .lastName("Егембердиева")
//                    .username("yegemberdiyeva")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of an application for visual image recognition")
//                    .creator(userRepository.findByUsername("yegemberdiyeva").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Алихан")
//                    .lastName("Мажикен")
//                    .middleName("Куатұлы")
//                    .username("mazhikena")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Рушан")
//                    .lastName("Салаватов")
//                    .middleName("Багдатович")
//                    .username("salavatovt")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Самат")
//                    .lastName("Токиш")
//                    .middleName("Муратұлы")
//                    .username("tokishs")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Мажикен + Салаватов + Токиш")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("tokishs").get())
//                    .advisor(userRepository.findByUsername("yegemberdiyeva").get())
//                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("mazhikena").get(), teamRepository.findTeamByName("Мажикен + Салаватов + Токиш"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("salavatovt").get(),  teamRepository.findTeamByName("Мажикен + Салаватов + Токиш"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("tokishs").get(),  teamRepository.findTeamByName("Мажикен + Салаватов + Токиш"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of an application for visual image recognition"))
//                    .team(teamRepository.findTeamByName("Мажикен + Салаватов + Токиш"))
//                    .approved(true)
//                    .build());
//
//            Team team7 = teamRepository.findTeamByName("Мажикен + Салаватов + Токиш");
//            team7.setTopic(topicRepository.findByName("Development of an application for visual image recognition"));
//            teamRepository.save(team7);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Э.")
//                    .lastName("Жантилеуов")
//                    .username("zhantileuove")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Developing web Application for forecasting Rent and house price for large cities of Kazakhstan with stacking and ensemble algorithms of ML")
//                    .creator(userRepository.findByUsername("zhantileuove").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Малика")
//                    .lastName("Абдрахманова")
//                    .middleName("Малика")
//                    .username("andrakhmanovam")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Әлиxан")
//                    .lastName("Жахсылық")
//                    .middleName("Ғабитұлы")
//                    .username("zhaksylyka")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ілиас")
//                    .lastName("Төлегенов")
//                    .middleName("Алтайұлы")
//                    .username("tolegenovi")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1901"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Абдрахманова + Жахсылық + Төлегенов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("tolegenovi").get())
//                    .advisor(userRepository.findByUsername("zhantileuove").get())
//                    .reviewer(reviewerRepository.findByFullName("Хомпыш Ардабек"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("andrakhmanovam").get(), teamRepository.findTeamByName("Абдрахманова + Жахсылық + Төлегенов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zhaksylyka").get(),  teamRepository.findTeamByName("Абдрахманова + Жахсылық + Төлегенов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("tolegenovi").get(),  teamRepository.findTeamByName("Абдрахманова + Жахсылық + Төлегенов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Developing web Application for forecasting Rent and house price for large cities of Kazakhstan with stacking and ensemble algorithms of ML"))
//                    .team(teamRepository.findTeamByName("Абдрахманова + Жахсылық + Төлегенов"))
//                    .approved(true)
//                    .build());
//
//            Team team8 = teamRepository.findTeamByName("Абдрахманова + Жахсылық + Төлегенов");
//            team8.setTopic(topicRepository.findByName("Developing web Application for forecasting Rent and house price for large cities of Kazakhstan with stacking and ensemble algorithms of ML"));
//            teamRepository.save(team8);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Н.")
//                    .lastName("Асанова")
//                    .username("assanovan")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a model for selecting elective courses in the university system")
//                    .creator(userRepository.findByUsername("assanovan").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Жәнел")
//                    .lastName("Қайырбекова")
//                    .middleName("Ермекқызы")
//                    .username("kairbekovazh")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ұлжан")
//                    .lastName("Рахметолланова")
//                    .middleName("Нұрхатқызы")
//                    .username("rahmetollanovau")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("MT", "MT-1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Адлет")
//                    .lastName("Социал")
//                    .middleName("Мұратбекұлы")
//                    .username("sociala")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Қайырбекова + Рахметолланова + Социал")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("sociala").get())
//                    .advisor(userRepository.findByUsername("assanovan").get())
//                    .reviewer(reviewerRepository.findByFullName("Умаров Фахриддин Алишерович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kairbekovazh").get(), teamRepository.findTeamByName("Қайырбекова + Рахметолланова + Социал"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("rahmetollanovau").get(),  teamRepository.findTeamByName("Қайырбекова + Рахметолланова + Социал"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sociala").get(),  teamRepository.findTeamByName("Қайырбекова + Рахметолланова + Социал"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a model for selecting elective courses in the university system"))
//                    .team(teamRepository.findTeamByName("Қайырбекова + Рахметолланова + Социал"))
//                    .approved(true)
//                    .build());
//
//            Team team9 = teamRepository.findTeamByName("Қайырбекова + Рахметолланова + Социал");
//            team9.setTopic(topicRepository.findByName("Development of a model for selecting elective courses in the university system"));
//            teamRepository.save(team9);
//
//            //------------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("К.")
//                    .lastName("Мухитова")
//                    .username("mukhitovak")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a mobile restaurant aggregator application with the possibility of booking seats")
//                    .creator(userRepository.findByUsername("mukhitovak").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Абылайхан")
//                    .lastName("Жетес")
//                    .middleName("")
//                    .username("zhetesa")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1908"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Азамат")
//                    .lastName("Саидұлы")
//                    .middleName("")
//                    .username("saidulya")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Арман")
//                    .lastName("Иманбаев")
//                    .middleName("")
//                    .username("imanbayeva")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("MT", "MT-1902"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Жетес + Саидұлы + Иманбаев")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("imanbayeva").get())
//                    .advisor(userRepository.findByUsername("mukhitovak").get())
//                    .reviewer(reviewerRepository.findByFullName("Укибасов Баубек Муратулы"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zhetesa").get(), teamRepository.findTeamByName("Жетес + Саидұлы + Иманбаев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("saidulya").get(),  teamRepository.findTeamByName("Жетес + Саидұлы + Иманбаев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("imanbayeva").get(),  teamRepository.findTeamByName("Жетес + Саидұлы + Иманбаев"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a mobile restaurant aggregator application with the possibility of booking seats"))
//                    .team(teamRepository.findTeamByName("Жетес + Саидұлы + Иманбаев"))
//                    .approved(true)
//                    .build());
//
//            Team team10 = teamRepository.findTeamByName("Жетес + Саидұлы + Иманбаев");
//            team10.setTopic(topicRepository.findByName("Development of a mobile restaurant aggregator application with the possibility of booking seats"));
//            teamRepository.save(team10);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Д.")
//                    .lastName("Ибраева")
//                    .username("ibrayevad")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Automation of checking the attendance of students in the classroom at Astana IT University")
//                    .creator(userRepository.findByUsername("ibrayevad").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Аяулым")
//                    .lastName("Канафина")
//                    .middleName("Ерланқызы")
//                    .username("kanafinaa")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("MT", "MT-1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Аружан")
//                    .lastName("Кусаинова")
//                    .middleName("Тлешкызы")
//                    .username("kussainovaa")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("MT", "MT-1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ильяс")
//                    .lastName("Айтенов")
//                    .middleName("Алтайұлы")
//                    .username("aitenovi")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1904"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Алиби")
//                    .lastName("Дуйсеналиев")
//                    .middleName("Ерланұлы")
//                    .username("duisenaliyeva")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1905"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Канафина + Кусаинова + Айтенов + Дуйсеналиев")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("duisenaliyeva").get())
//                    .advisor(userRepository.findByUsername("ibrayevad").get())
//                    .reviewer(reviewerRepository.findByFullName("Хомпыш Ардабек"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kanafinaa").get(), teamRepository.findTeamByName("Канафина + Кусаинова + Айтенов + Дуйсеналиев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kussainovaa").get(),  teamRepository.findTeamByName("Канафина + Кусаинова + Айтенов + Дуйсеналиев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("aitenovi").get(),  teamRepository.findTeamByName("Канафина + Кусаинова + Айтенов + Дуйсеналиев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("duisenaliyeva").get(),  teamRepository.findTeamByName("Канафина + Кусаинова + Айтенов + Дуйсеналиев"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Automation of checking the attendance of students in the classroom at Astana IT University"))
//                    .team(teamRepository.findTeamByName("Канафина + Кусаинова + Айтенов + Дуйсеналиев"))
//                    .approved(true)
//                    .build());
//
//            Team team11 = teamRepository.findTeamByName("Канафина + Кусаинова + Айтенов + Дуйсеналиев");
//            team11.setTopic(topicRepository.findByName("Automation of checking the attendance of students in the classroom at Astana IT University"));
//            teamRepository.save(team11);
//
//            // --------------------//
//
//
//        };
//    }
}
