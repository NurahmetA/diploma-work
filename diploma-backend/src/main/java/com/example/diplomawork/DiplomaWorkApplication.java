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
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Жартыбаева Макпал Галымбековна").careerGrade("Доктор phd").workPlace("ЕНУ имени Л.Н.Гумилева").profession("и.о. доцента кафедры «компьютерная и программная инженерия»").build());
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Укибасов Баубек Муратулы").careerGrade("Masters of Computer Science").workPlace("IITU").profession("Senior-lecturer").build());
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Александр Пак").careerGrade("Кандидат технических наук").workPlace("ФИТ КБТУ").profession("Ассоциированный профессор").build());
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Пягай Виктор Тимофеевич").careerGrade("MSc").workPlace("АО МУИТ").profession("Сениор-лектор кафедры Кибербезопасности").build());
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Сисенов Нурбек Маханбетулы").careerGrade("Магистр естественных наук").workPlace("ЕНУ им Л.Н.Гумилева").profession("Преподователь").build());
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Умаров Фахриддин Алишерович").careerGrade("PhD Candidate").workPlace("IITU").profession("Senior-lecturer, Information Systems Department").build());
//            reviewerRepository.save(Reviewer.builder().id(null).fullName("Дарибаев Беимбет Серикович").careerGrade("PHD").workPlace("КазНУ им Аль-Фараби, факультет информационных технологий").profession("Заведующий кафедры информатики").build());
//
//
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
//
//
//            groupRepository.save(new Group(null, "IT-1903", initialRepository.findByInitial("IT")));
//            groupRepository.save(new Group(null, "SE-1901", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "SE-1902", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "SE-1903", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "SE-1904", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "SE-1905", initialRepository.findByInitial("SE")));
//            groupRepository.save(new Group(null, "SE-1906", initialRepository.findByInitial("SE")));
//
//
//
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
//
//            //defence day 5
//            // start
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Н.")
//                    .lastName("Хаймульдин")
//                    .username("khaimuldinn")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a web application of the AITU schedule using API and graphic visual support")
//                    .creator(userRepository.findByUsername("khaimuldinn").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ғалымжан")
//                    .lastName("Балтабеков")
//                    .middleName("Нұржанұлы")
//                    .username("baltabekovb")
//                    .isHonor(true)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Олжас")
//                    .lastName("Ильясов")
//                    .middleName("Турабаевич")
//                    .username("ilyasovo")
//                    .isHonor(true)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Алибек")
//                    .lastName("Советкажиев")
//                    .middleName("Ермекулы")
//                    .username("sovetxhanove")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Балтабеков + Ильясов + Советкажиев")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("sovetxhanove").get())
//                    .advisor(userRepository.findByUsername("khaimuldinn").get())
//                    .reviewer(reviewerRepository.findByFullName("Пягай Виктор Тимофеевич"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("baltabekovb").get(), teamRepository.findTeamByName("Балтабеков + Ильясов + Советкажиев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("ilyasovo").get(),  teamRepository.findTeamByName("Балтабеков + Ильясов + Советкажиев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sovetxhanove").get(),  teamRepository.findTeamByName("Балтабеков + Ильясов + Советкажиев"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a web application of the AITU schedule using API and graphic visual support"))
//                    .team(teamRepository.findTeamByName("Балтабеков + Ильясов + Советкажиев"))
//                    .approved(true)
//                    .build());
//
//            Team team1 = teamRepository.findTeamByName("Балтабеков + Ильясов + Советкажиев");
//            //team1.setReviewer(reviewerRepository.findByFullName("Умаров Фахриддин Алишерович"));
//            team1.setTopic(topicRepository.findByName("Development of a web application of the AITU schedule using API and graphic visual support"));
//            teamRepository.save(team1);
//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("А.")
//                    .lastName("Турсынкулова")
//                    .username("tursunkulovaa")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Service to finding university and profession")
//                    .creator(userRepository.findByUsername("tursunkulovaa").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Алдияр")
//                    .lastName("Айткеш")
//                    .middleName("Дулатұлы")
//                    .username("aitkesha")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1905"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ернұр")
//                    .lastName("Баяшов")
//                    .middleName("Мадиярұлы")
//                    .username("bayasheve")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1905"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Айғаным")
//                    .lastName("Сағидоллинова")
//                    .middleName("Жақсылыққызы")
//                    .username("sagidollinovaa")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1906"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Айткеш + Баяшов + Сағидоллинова")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("sagidollinovaa").get())
//                    .advisor(userRepository.findByUsername("tursunkulovaa").get())
//                    .reviewer(reviewerRepository.findByFullName("Сисенов Нурбек Маханбетулы"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("aitkesha").get(), teamRepository.findTeamByName("Айткеш + Баяшов + Сағидоллинова"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("bayasheve").get(),  teamRepository.findTeamByName("Айткеш + Баяшов + Сағидоллинова"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sagidollinovaa").get(),  teamRepository.findTeamByName("Айткеш + Баяшов + Сағидоллинова"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Service to finding university and profession"))
//                    .team(teamRepository.findTeamByName("Айткеш + Баяшов + Сағидоллинова"))
//                    .approved(true)
//                    .build());
//
//            Team team2 = teamRepository.findTeamByName("Айткеш + Баяшов + Сағидоллинова");
//            team2.setTopic(topicRepository.findByName("Service to finding university and profession"));
//            teamRepository.save(team2);
//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("A.")
//                    .lastName("Хаймульдин")
//                    .username("khaimuldina")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of Cryptocurrency transferring service")
//                    .creator(userRepository.findByUsername("khaimuldina").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Алемхан")
//                    .lastName("Ергалиев")
//                    .middleName("Муратович")
//                    .username("ergsliyeva")
//                    .isHonor(true)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1903"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Сунгат")
//                    .lastName("Капаров")
//                    .middleName("Сагдатович")
//                    .username("kaparovs")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Султанбек")
//                    .lastName("Хасенов")
//                    .middleName("Анварович")
//                    .username("hasenovs")
//                    .isHonor(true)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1903"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Ергалиев + Капаров + Хасенов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("hasenovs").get())
//                    .advisor(userRepository.findByUsername("khaimuldina").get())
//                    .reviewer(reviewerRepository.findByFullName("Умаров Фахриддин Алишерович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("ergsliyeva").get(), teamRepository.findTeamByName("Ергалиев + Капаров + Хасенов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kaparovs").get(),  teamRepository.findTeamByName("Ергалиев + Капаров + Хасенов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("hasenovs").get(),  teamRepository.findTeamByName("Ергалиев + Капаров + Хасенов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of Cryptocurrency transferring service"))
//                    .team(teamRepository.findTeamByName("Ергалиев + Капаров + Хасенов"))
//                    .approved(true)
//                    .build());
//
//            Team team3 = teamRepository.findTeamByName("Ергалиев + Капаров + Хасенов");
//            //team1.setReviewer(reviewerRepository.findByFullName("Умаров Фахриддин Алишерович"));
//            team3.setTopic(topicRepository.findByName("Development of Cryptocurrency transferring service"));
//            teamRepository.save(team3);
//
//
//            topicRepository.save(Topic.builder()
//                    .name("Creating a service for online booking using Rest API and clean architecture")
//                    .creator(userRepository.findByUsername("khaimuldina").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Муратжан")
//                    .lastName("Адылканов")
//                    .middleName("Талгатович")
//                    .username("aldylkhanovm")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1904"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Айдар")
//                    .lastName("Тасыған")
//                    .middleName("Алмасұлы")
//                    .username("tasygana")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Әлібек")
//                    .lastName("Тоқсамбаев")
//                    .middleName("Гамальұлы")
//                    .username("toksanbayeva")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Адылканов + Тасыған + Тоқсамбаев")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("toksanbayeva").get())
//                    .advisor(userRepository.findByUsername("khaimuldina").get())
//                    .reviewer(reviewerRepository.findByFullName("Умаров Фахриддин Алишерович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("aldylkhanovm").get(), teamRepository.findTeamByName("Адылканов + Тасыған + Тоқсамбаев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("tasygana").get(),  teamRepository.findTeamByName("Адылканов + Тасыған + Тоқсамбаев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("toksanbayeva").get(),  teamRepository.findTeamByName("Адылканов + Тасыған + Тоқсамбаев"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Creating a service for online booking using Rest API and clean architecture"))
//                    .team(teamRepository.findTeamByName("Адылканов + Тасыған + Тоқсамбаев"))
//                    .approved(true)
//                    .build());
//
//            Team team4 = teamRepository.findTeamByName("Адылканов + Тасыған + Тоқсамбаев");
//            team4.setTopic(topicRepository.findByName("Creating a service for online booking using Rest API and clean architecture"));
//            teamRepository.save(team4);
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("С.")
//                    .lastName("Аубакиров")
//                    .username("aubakirovs")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Methods for simulating poor communication quality for testing mobile applications")
//                    .creator(userRepository.findByUsername("aubakirovs").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Сұлтан")
//                    .lastName("Аймағамбет")
//                    .middleName("Романұлы")
//                    .username("aimagambets")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1903"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Mұса")
//                    .lastName("Шаукенов")
//                    .middleName("Әлібекұлы")
//                    .username("shaulenovm")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1903"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Аймағамбет + Шаукенов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("shaulenovm").get())
//                    .advisor(userRepository.findByUsername("aubakirovs").get())
//                    .reviewer(reviewerRepository.findByFullName("Дарибаев Беимбет Серикович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("aimagambets").get(), teamRepository.findTeamByName("Аймағамбет + Шаукенов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("shaulenovm").get(),  teamRepository.findTeamByName("Аймағамбет + Шаукенов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Methods for simulating poor communication quality for testing mobile applications"))
//                    .team(teamRepository.findTeamByName("Аймағамбет + Шаукенов"))
//                    .approved(true)
//                    .build());
//
//            Team team5 = teamRepository.findTeamByName("Аймағамбет + Шаукенов");
//            team5.setTopic(topicRepository.findByName("Methods for simulating poor communication quality for testing mobile applications"));
//            teamRepository.save(team5);
//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Т.")
//                    .lastName("Мукатаев")
//                    .username("tleu13")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Build REST-API web-services using clean architecture")
//                    .creator(userRepository.findByUsername("tleu13").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Жансұлтан")
//                    .lastName("Салман")
//                    .middleName("Ерланұлы")
//                    .username("salmanzh")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Бексултан")
//                    .lastName("Тургунов")
//                    .middleName("Хамзаевич")
//                    .username("turgunovb")
//                    .isHonor(true)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Салман + Тургунов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("turgunovb").get())
//                    .advisor(userRepository.findByUsername("tleu13").get())
//                    .reviewer(reviewerRepository.findByFullName("Умаров Фахриддин Алишерович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("salmanzh").get(), teamRepository.findTeamByName("Салман + Тургунов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("turgunovb").get(),  teamRepository.findTeamByName("Салман + Тургунов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Build REST-API web-services using clean architecture"))
//                    .team(teamRepository.findTeamByName("Салман + Тургунов"))
//                    .approved(true)
//                    .build());
//
//            Team team6 = teamRepository.findTeamByName("Салман + Тургунов");
//            team6.setTopic(topicRepository.findByName("Build REST-API web-services using clean architecture"));
//            teamRepository.save(team6);
//
//        };
//    }
}
