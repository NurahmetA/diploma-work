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

    @Bean
    @Transactional
    CommandLineRunner run(ReviewerRepository reviewerRepository, RoleRepository roleRepository, TopicRepository topicRepository, UserRepository userRepository, GroupRepository groupRepository, InitialRepository initialRepository, TeamRepository teamRepository, TeamTopicRepository teamTopicRepository, UserTeamRepository userTeamRepository, StageRepository stageRepository) {
        return args -> {

            reviewerRepository.save(Reviewer.builder().id(null).fullName("Байшемиров Жарасбек Дуйсембекович").careerGrade("PhD").workPlace("Кафедра математики и математического моделирования КазНПУ им.Абая").profession("ассоциированный профессор").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Укибасов Баубек Муратулы").careerGrade("Masters of Computer Science").workPlace("IITU").profession("Senior-lecturer").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Александр Пак").careerGrade("Кандидат технических наук").workPlace("ФИТ КБТУ").profession("Ассоциированный профессор").build());

            reviewerRepository.save(Reviewer.builder().id(null).fullName("Жартыбаева Макпал Галымбековна").careerGrade("Доктор phd").workPlace("ЕНУ имени Л.Н.Гумилева").profession("и.о. доцента кафедры «компьютерная и программная инженерия»").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Дарибаев Беимбет Серикович").careerGrade("PHD").workPlace("КазНУ им Аль-Фараби, факультет информационных технологий").profession("Заведующий кафедры информатики").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Сисенов Нурбек Маханбетулы").careerGrade("Магистр естественных наук").workPlace("ЕНУ им Л.Н.Гумилева").profession("Преподователь").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Умаров Фахриддин Алишерович").careerGrade("PhD Candidate").workPlace("IITU").profession("Senior-lecturer, Information Systems Department").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Пягай Виктор Тимофеевич").careerGrade("MSc").workPlace("АО МУИТ").profession("Сениор-лектор кафедры Кибербезопасности").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Olzhas Shaiken").careerGrade("MSc in Information Technology").workPlace("Aitu-Dala").profession("DevOps engineer").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Zhussupov Abay").careerGrade("MSc in Engineering").workPlace(" 'Tech Savvy' LLP").profession("System administrator").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Иманкулов Тимур Сакенович").careerGrade("PhD").workPlace("КазНУ им. аль-Фараби").profession("доцент кафедры информатики").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Алибек Полатов").careerGrade("Магистр наук").workPlace("ИТ компания продуктов Conversion").profession("директор").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Абдиахметова Зухра Муратовна").careerGrade("PhD по ИВТУ").workPlace("ФИТ  КазНУ им аль -Фараби").profession("Зам Завкаф по УиВР кафедры Информатики").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Канат Ахатов").careerGrade("").workPlace("DLP, MSSP.Global").profession("Руководитель отдела интеграции Киберстраж").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Сансызбай Қанибек Мұратбекұлы").careerGrade("PhD").workPlace("Академия логистики и транспорта").profession("Заведующий кафедрой «Автоматизация и управление»").build());
            reviewerRepository.save(Reviewer.builder().id(null).fullName("Кожамжарова Динара Ханатовна").careerGrade("Магистр Естественных наук").workPlace("Международный Университет Информационных Технологий").profession("Сениор-лектор").build());



            roleRepository.save(new Role(null, "ROLE_ADMIN"));
            roleRepository.save(new Role(null, "ROLE_STUDENT"));
            roleRepository.save(new Role(null, "ROLE_COMMISSION"));
            roleRepository.save(new Role(null, "ROLE_SECRETARY"));
            roleRepository.save(new Role(null, "ROLE_ADVISOR"));

            // --------------------//
            initialRepository.save(Initial.builder().initial("IT").build());
            initialRepository.save(Initial.builder().initial("SE").build());

            groupRepository.save(new Group(null, "IT-1901", initialRepository.findByInitial("IT")));
            groupRepository.save(new Group(null, "IT-1902", initialRepository.findByInitial("IT")));
            groupRepository.save(new Group(null, "IT-1903", initialRepository.findByInitial("IT")));
            groupRepository.save(new Group(null, "SE-1901", initialRepository.findByInitial("SE")));
            groupRepository.save(new Group(null, "SE-1902", initialRepository.findByInitial("SE")));
            groupRepository.save(new Group(null, "SE-1903", initialRepository.findByInitial("SE")));
            groupRepository.save(new Group(null, "SE-1904", initialRepository.findByInitial("SE")));
            groupRepository.save(new Group(null, "SE-1905", initialRepository.findByInitial("SE")));
            groupRepository.save(new Group(null, "SE-1906", initialRepository.findByInitial("SE")));
            groupRepository.save(new Group(null, "SE-1907", initialRepository.findByInitial("SE")));
            groupRepository.save(new Group(null, "SE-1908", initialRepository.findByInitial("SE")));
            groupRepository.save(new Group(null, "ITM-1903", initialRepository.findByInitial("SE")));
            groupRepository.save(new Group(null, "ITM-1904", initialRepository.findByInitial("SE")));




            stageRepository.save(Stage.builder().name("DEFENCE").build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("admin")
                    .lastName("admin")
                    .middleName(null)
                    .username("admin")
                    .role(roleRepository.findByName("ROLE_ADMIN"))
                    .password(new BCryptPasswordEncoder().encode("admin"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Б.")
                    .lastName("Амиргалиев")
                    .middleName(null)
                    .username("amirgaliyev")
                    .role(roleRepository.findByName("ROLE_COMMISSION"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("О.")
                    .lastName("Аймухамбетов")
                    .middleName(null)
                    .username("aimukhambetov")
                    .role(roleRepository.findByName("ROLE_COMMISSION"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Б.")
                    .lastName("Башеев")
                    .middleName(null)
                    .username("basheeyev")
                    .role(roleRepository.findByName("ROLE_COMMISSION"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Д.")
                    .lastName("Аябекова")
                    .middleName(null)
                    .username("ayabekova")
                    .role(roleRepository.findByName("ROLE_COMMISSION"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("А.")
                    .lastName("Смайыл")
                    .middleName(null)
                    .username("smaiyl")
                    .role(roleRepository.findByName("ROLE_COMMISSION"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Б.")
                    .lastName("Кумалаков")
                    .middleName(null)
                    .username("kumalakov")
                    .role(roleRepository.findByName("ROLE_COMMISSION"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Secretar")
                    .lastName("Secretar")
                    .middleName("Secretar")
                    .username("sec")
                    .role(roleRepository.findByName("ROLE_SECRETARY"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());




            // defence 10.06 //
            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Б")
                    .lastName("Амиргалиев")
                    .username("amirgalievb")
                    .role(roleRepository.findByName("ROLE_ADVISOR"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            topicRepository.save(Topic.builder()
                    .name("Development of algorithms for safe driving behavior identification")
                    .creator(userRepository.findByUsername("amirgalievb").get())
                    .selected(true)
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Аида")
                    .lastName("Қожабай")
                    .middleName("Бердібекқызы")
                    .username("kozhabaya")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1906"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Маржан")
                    .lastName("Нұралы")
                    .middleName("Занғарқызы")
                    .username("nuralym")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Айдана")
                    .lastName("Орунбасарова")
                    .middleName("Джалгасбаевна")
                    .username("orunbasarova")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1906"))
                    .build());



            teamRepository.save(Team.builder()
                    .name("Қожабай + Нұралы + Орунбасарова")
                    .confirmed(true)
                    .creator(userRepository.findByUsername("kozhabaya").get())
                    .advisor(userRepository.findByUsername("amirgalievb").get())
                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
                    .build());

            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kozhabaya").get(), teamRepository.findTeamByName("Қожабай + Нұралы + Орунбасарова"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("nuralym").get(),  teamRepository.findTeamByName("Қожабай + Нұралы + Орунбасарова"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("orunbasarova").get(),  teamRepository.findTeamByName("Қожабай + Нұралы + Орунбасарова"), true));

            teamTopicRepository.save(TeamTopic.builder()
                    .topic(topicRepository.findByName("Development of algorithms for safe driving behavior identification"))
                    .team(teamRepository.findTeamByName("Қожабай + Нұралы + Орунбасарова"))
                    .approved(true)
                    .build());

            Team team1 = teamRepository.findTeamByName("Қожабай + Нұралы + Орунбасарова");
            team1.setTopic(topicRepository.findByName("Development of algorithms for safe driving behavior identification"));
            teamRepository.save(team1);

            // --------------------//


            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Г.")
                    .lastName("Егембердиева")
                    .username("egemberdievag")
                    .role(roleRepository.findByName("ROLE_ADVISOR"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            topicRepository.save(Topic.builder()
                    .name("Development of web application related to apartments assessments")
                    .creator(userRepository.findByUsername("egemberdievag").get())
                    .selected(true)
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Шерхан")
                    .lastName("Хансейт")
                    .middleName("Жолыбекұлы")
                    .username("hanseitsh")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1903"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Жарасбек")
                    .lastName("Шырақбай")
                    .middleName("Абайұлы")
                    .username("shyrakbayzh")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1908"))
                    .build());



            teamRepository.save(Team.builder()
                    .name("Хансейт + Шырақбай")
                    .confirmed(true)
                    .creator(userRepository.findByUsername("shyrakbayzh").get())
                    .advisor(userRepository.findByUsername("egemberdievag").get())
                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
                    .build());

            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("hanseitsh").get(), teamRepository.findTeamByName("Хансейт + Шырақбай"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("shyrakbayzh").get(),  teamRepository.findTeamByName("Хансейт + Шырақбай"), true));

            teamTopicRepository.save(TeamTopic.builder()
                    .topic(topicRepository.findByName("Development of web application related to apartments assessments"))
                    .team(teamRepository.findTeamByName("Хансейт + Шырақбай"))
                    .approved(true)
                    .build());

            Team team2 = teamRepository.findTeamByName("Хансейт + Шырақбай");
            team2.setTopic(topicRepository.findByName("Development of web application related to apartments assessments"));
            teamRepository.save(team2);

            // --------------------//
            userRepository.save(User.builder()
                    .id(null)
                    .firstName("А.")
                    .lastName("Смайыл")
                    .username("smayla")
                    .role(roleRepository.findByName("ROLE_ADVISOR"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            topicRepository.save(Topic.builder()
                    .name("Development of a system for healthcare")
                    .creator(userRepository.findByUsername("smayla").get())
                    .selected(true)
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Мағжан")
                    .lastName("Бекетов")
                    .middleName("Нағиұлы")
                    .username("beketovm")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1906"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Диас")
                    .lastName("Әуелбаев")
                    .middleName("Ғаниұлы")
                    .username("auelbaievd")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1906"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Аян")
                    .lastName("Сұлтан")
                    .middleName("Даниярұлы")
                    .username("sultana")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1906"))
                    .build());

            teamRepository.save(Team.builder()
                    .name("Бекетов + Әуелбаев + Сұлтан")
                    .confirmed(true)
                    .creator(userRepository.findByUsername("sultana").get())
                    .advisor(userRepository.findByUsername("smayla").get())
                    .reviewer(reviewerRepository.findByFullName("Сансызбай Қанибек Мұратбекұлы"))
                    .build());

            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("beketovm").get(), teamRepository.findTeamByName("Бекетов + Әуелбаев + Сұлтан"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("auelbaievd").get(), teamRepository.findTeamByName("Бекетов + Әуелбаев + Сұлтан"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sultana").get(), teamRepository.findTeamByName("Бекетов + Әуелбаев + Сұлтан"), true));

            teamTopicRepository.save(TeamTopic.builder()
                    .topic(topicRepository.findByName("Development of a system for healthcare"))
                    .team(teamRepository.findTeamByName("Бекетов + Әуелбаев + Сұлтан"))
                    .approved(true)
                    .build());

            Team team3 = teamRepository.findTeamByName("Бекетов + Әуелбаев + Сұлтан");
            team3.setTopic(topicRepository.findByName("Development of a system for healthcare"));
            teamRepository.save(team3);

            // --------------------//



            topicRepository.save(Topic.builder()
                    .name("Development of theoretical and technical issues of software engineering for car-sharing service")
                    .creator(userRepository.findByUsername("amirgalievb").get())
                    .selected(true)
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Аружан")
                    .lastName("Бахазатханова")
                    .middleName("Базаркулкызы")
                    .username("bahazathanovaa")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Айнур")
                    .lastName("Курсабаева")
                    .middleName("Арманкызы")
                    .username("kursabaevaa")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
                    .build());


            teamRepository.save(Team.builder()
                    .name("Бахазатханова + Курсабаева")
                    .confirmed(true)
                    .creator(userRepository.findByUsername("kursabaevaa").get())
                    .advisor(userRepository.findByUsername("amirgalievb").get())
                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
                    .build());

            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("bahazathanovaa").get(), teamRepository.findTeamByName("Бахазатханова + Курсабаева"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kursabaevaa").get(),  teamRepository.findTeamByName("Бахазатханова + Курсабаева"), true));

            teamTopicRepository.save(TeamTopic.builder()
                    .topic(topicRepository.findByName("Development of theoretical and technical issues of software engineering for car-sharing service"))
                    .team(teamRepository.findTeamByName("Бахазатханова + Курсабаева"))
                    .approved(true)
                    .build());

            Team team4 = teamRepository.findTeamByName("Бахазатханова + Курсабаева");
            team4.setTopic(topicRepository.findByName("Development of theoretical and technical issues of software engineering for car-sharing service"));
            teamRepository.save(team4);

            // --------------------//

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Ш.")
                    .lastName("Саймасаева")
                    .username("saimasayevash")
                    .role(roleRepository.findByName("ROLE_ADVISOR"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            topicRepository.save(Topic.builder()
                    .name("Development of an information system for distributing the university academic load")
                    .creator(userRepository.findByUsername("saimasayevash").get())
                    .selected(true)
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Рахымжан")
                    .lastName("Абдугали")
                    .middleName("Алтайұлы")
                    .username("abdugalir")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Алмас")
                    .lastName("Айтенов")
                    .middleName("Саматұлы")
                    .username("aitenova")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Аружан")
                    .lastName("Али")
                    .middleName("Абдисалимқызы")
                    .username("alia")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1901"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Арайлым")
                    .lastName("Талғатқызы")
                    .middleName("")
                    .username("talgatkyzya")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1901"))
                    .build());


            teamRepository.save(Team.builder()
                    .name("Абдугали + Айтенов + Али + Талғатқызы")
                    .confirmed(true)
                    .creator(userRepository.findByUsername("talgatkyzya").get())
                    .advisor(userRepository.findByUsername("saimasayevash").get())
                    .reviewer(reviewerRepository.findByFullName("Сансызбай Қанибек Мұратбекұлы"))
                    .build());

            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kozhabaya").get(), teamRepository.findTeamByName("Абдугали + Айтенов + Али + Талғатқызы"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kozhabaya").get(), teamRepository.findTeamByName("Абдугали + Айтенов + Али + Талғатқызы"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kozhabaya").get(), teamRepository.findTeamByName("Абдугали + Айтенов + Али + Талғатқызы"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kozhabaya").get(), teamRepository.findTeamByName("Абдугали + Айтенов + Али + Талғатқызы"), true));

            teamTopicRepository.save(TeamTopic.builder()
                    .topic(topicRepository.findByName("Development of an information system for distributing the university academic load"))
                    .team(teamRepository.findTeamByName("Абдугали + Айтенов + Али + Талғатқызы"))
                    .approved(true)
                    .build());

            Team team5 = teamRepository.findTeamByName("Абдугали + Айтенов + Али + Талғатқызы");
            team5.setTopic(topicRepository.findByName("Development of an information system for distributing the university academic load"));
            teamRepository.save(team5);

            //-------//

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Ж.")
                    .lastName("Сарсенова")
                    .username("sarsenovazh")
                    .role(roleRepository.findByName("ROLE_ADVISOR"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .build());

            topicRepository.save(Topic.builder()
                    .name("Development of a system for analysis, visualization and prediction of air pollution data in Nur- Sultan")
                    .creator(userRepository.findByUsername("sarsenovazh").get())
                    .selected(true)
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Жазира")
                    .lastName("Даулетбай")
                    .middleName("Маратқызы")
                    .username("dauletbaizh")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1901"))
                    .build());

            userRepository.save(User.builder()
                    .id(null)
                    .firstName("Толганай")
                    .lastName("Шаймерденова")
                    .middleName("Канатовна")
                    .username("shaimerdent")
                    //.isHonor(false)
                    .role(roleRepository.findByName("ROLE_STUDENT"))
                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1901"))
                    .build());




            teamRepository.save(Team.builder()
                    .name("Даулетбай + Шаймерденова")
                    .confirmed(true)
                    .creator(userRepository.findByUsername("shaimerdent").get())
                    .advisor(userRepository.findByUsername("sarsenovazh").get())
                    .reviewer(reviewerRepository.findByFullName("Кожамжарова Динара Ханатовна"))
                    .build());

            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("dauletbaizh").get(), teamRepository.findTeamByName("Даулетбай + Шаймерденова"), true));
            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("shaimerdent").get(), teamRepository.findTeamByName("Даулетбай + Шаймерденова"), true));

            teamTopicRepository.save(TeamTopic.builder()
                    .topic(topicRepository.findByName("Development of a system for analysis, visualization and prediction of air pollution data in Nur- Sultan"))
                    .team(teamRepository.findTeamByName("Даулетбай + Шаймерденова"))
                    .approved(true)
                    .build());

            Team team6 = teamRepository.findTeamByName("Даулетбай + Шаймерденова");
            team6.setTopic(topicRepository.findByName("Development of a system for analysis, visualization and prediction of air pollution data in Nur- Sultan"));
            teamRepository.save(team6);


            // --------------------//

//            topicRepository.save(Topic.builder()
//                    .name("Development of a fast and convenient service for booking tables shop")
//                    .creator(userRepository.findByUsername("kalpakove").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ерқанат")
//                    .lastName("Өмірзақ")
//                    .middleName("")
//                    .username("omirzake")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Батыржан")
//                    .lastName("Кудайбергенов")
//                    .middleName("")
//                    .username("kudaibergenovb")
//                    .isHonor(false)
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("ITM", "ITM-1903"))
//                    .build());
//
//
//            teamRepository.save(Team.builder()
//                    .name("Өмірзақ + Кудайбергенов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("kudaibergenovb").get())
//                    .advisor(userRepository.findByUsername("kalpakove").get())
//                    .reviewer(reviewerRepository.findByFullName("Хомпыш Ардабек"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("omirzake").get(), teamRepository.findTeamByName("Өмірзақ + Кудайбергенов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kudaibergenovb").get(),  teamRepository.findTeamByName("Өмірзақ + Кудайбергенов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a fast and convenient service for booking tables shop"))
//                    .team(teamRepository.findTeamByName("Өмірзақ + Кудайбергенов"))
//                    .approved(true)
//                    .build());
//
//            Team team7 = teamRepository.findTeamByName("Өмірзақ + Кудайбергенов");
//            team7.setTopic(topicRepository.findByName("Development of a fast and convenient service for booking tables shop"));
//            teamRepository.save(team7);

            //--------------------//

            //defence day 2 -> 02.06.2022

//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Д.")
//                    .lastName("Лебедев")
//                    .username("lebedevd")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a module for the Competitive Contract Commission for domestic and foreign teaching staff for Astana IT University")
//                    .creator(userRepository.findByUsername("lebedevd").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ерасыл")
//                    .lastName("Болат")
//                    .middleName("Жұмағазыұлы")
//                    .username("bolate")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Анияр")
//                    .lastName("Калиев")
//                    .middleName("Ануарбекович")
//                    .username("kaliyeva")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Айбын")
//                    .lastName("Сағындық")
//                    .middleName("Бекенұлы")
//                    .username("sagyndyka")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ален")
//                    .lastName("Туякбаев")
//                    .middleName("Сакенович")
//                    .username("tuyakbayeva")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1902"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Болат + Калиев + Сағындық + Туякбаев")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("tuyakbayeva").get())
//                    .advisor(userRepository.findByUsername("lebedevd").get())
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("bolate").get(), teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kaliyeva").get(),  teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sagyndyka").get(),  teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("tuyakbayeva").get(),  teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a module for the Competitive Contract Commission for domestic and foreign teaching staff for Astana IT University"))
//                    .team(teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев"))
//                    .approved(true)
//                    .build());
//
//            Team team7 = teamRepository.findTeamByName("Болат + Калиев + Сағындық + Туякбаев");
//            team7.setTopic(topicRepository.findByName("Development of a module for the Competitive Contract Commission for domestic and foreign teaching staff for Astana IT University"));
//            teamRepository.save(team7);
//
//            // --------------------//
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
//                    .name("Development of data analyzer system to find available job positions from open source")
//                    .creator(userRepository.findByUsername("khaimuldina").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Азатқали")
//                    .lastName("Нұрұмғалиев")
//                    .middleName("Берикқалиұлы")
//                    .username("nurumgaliyeva")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1905"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Нұрым")
//                    .lastName("Сиырбаев")
//                    .middleName("Айзатұлы")
//                    .username("siyrbayevn")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1905"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Мадияр")
//                    .lastName("Усабеков")
//                    .middleName("Нурланович")
//                    .username("ussabekovm")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1905"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Нұрұмғалиев + Сиырбаев + Усабеков")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("ussabekovm").get())
//                    .advisor(userRepository.findByUsername("khaimuldina").get())
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("nurumgaliyeva").get(), teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("siyrbayevn").get(),  teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("ussabekovm").get(),  teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of data analyzer system to find available job positions from open source"))
//                    .team(teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков"))
//                    .approved(true)
//                    .build());
//
//            Team team8 = teamRepository.findTeamByName("Нұрұмғалиев + Сиырбаев + Усабеков");
//            team8.setTopic(topicRepository.findByName("Development of data analyzer system to find available job positions from open source"));
//            teamRepository.save(team8);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ж.")
//                    .lastName("Сарсенова")
//                    .username("sarsenovaz")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of system for translating manga and comics with automatic identification and replacement of text")
//                    .creator(userRepository.findByUsername("sarsenovaz").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Динмухаммед")
//                    .lastName("Еримбетов")
//                    .middleName("Ермекулы")
//                    .username("erimbetovd")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Мағжан")
//                    .lastName("Жақуда")
//                    .middleName("Ардақұлы")
//                    .username("zhakudam")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Рахат")
//                    .lastName("Шаяхметов")
//                    .middleName("Серикулы")
//                    .username("shayahmetovr")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1906"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Еримбетов + Жақуда + Шаяхметов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("shayahmetovr").get())
//                    .advisor(userRepository.findByUsername("sarsenovaz").get())
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("erimbetovd").get(), teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zhakudam").get(),  teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("shayahmetovr").get(),  teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of system for translating manga and comics with automatic identification and replacement of text"))
//                    .team(teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов"))
//                    .approved(true)
//                    .build());
//
//            Team team9 = teamRepository.findTeamByName("Еримбетов + Жақуда + Шаяхметов");
//            team9.setTopic(topicRepository.findByName("Development of system for translating manga and comics with automatic identification and replacement of text"));
//            teamRepository.save(team9);
//
//            //------------------------//
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
//                    .name("Development of MDM system for restaurants")
//                    .creator(userRepository.findByUsername("aubakirovs").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Адильхан")
//                    .lastName("Кенжетаев")
//                    .middleName("Сырымбетович")
//                    .username("kenzhetayeva")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1906"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Ақылбек")
//                    .lastName("Қонысқайров")
//                    .middleName("Ерланұлы")
//                    .username("konyskaiyrova")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1905"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Асфандияр")
//                    .lastName("Марат")
//                    .middleName("Русланулы")
//                    .username("marata")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1904"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Кенжетаев + Қонысқайров + Марат")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("marata").get())
//                    .advisor(userRepository.findByUsername("aubakirovs").get())
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kenzhetayeva").get(), teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("konyskaiyrova").get(),  teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("marata").get(),  teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of MDM system for restaurants"))
//                    .team(teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат"))
//                    .approved(true)
//                    .build());
//
//            Team team10 = teamRepository.findTeamByName("Кенжетаев + Қонысқайров + Марат");
//            team10.setTopic(topicRepository.findByName("Development of MDM system for restaurants"));
//            teamRepository.save(team10);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("T.")
//                    .lastName("Мукатаев")
//                    .username("tleu13")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Implementation of blokchain in Go")
//                    .creator(userRepository.findByUsername("tleu13").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Мирас")
//                    .lastName("Алимов")
//                    .middleName("Сакенович")
//                    .username("alimovm")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Амиран")
//                    .lastName("Құрман")
//                    .middleName("Мәлікұлы")
//                    .username("kurmana")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Бекнұр")
//                    .lastName("Раисов")
//                    .middleName("Кенжебекұлы")
//                    .username("raissovb")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1901"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Алимов + Құрман + Раисов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("raissovb").get())
//                    .advisor(userRepository.findByUsername("tleu13").get())
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("alimovm").get(), teamRepository.findTeamByName("Алимов + Құрман + Раисов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kurmana").get(),  teamRepository.findTeamByName("Алимов + Құрман + Раисов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("raissovb").get(),  teamRepository.findTeamByName("Алимов + Құрман + Раисов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Implementation of blokchain in Go"))
//                    .team(teamRepository.findTeamByName("Алимов + Құрман + Раисов"))
//                    .approved(true)
//                    .build());
//
//            Team team11 = teamRepository.findTeamByName("Алимов + Құрман + Раисов");
//            team11.setTopic(topicRepository.findByName("Implementation of blokchain in Go"));
//            teamRepository.save(team11);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Д.")
//                    .lastName("Лебедев")
//                    .username("levedevd")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of the “Digital University” information system using microservice architecture")
//                    .creator(userRepository.findByUsername("levedevd").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Алихан")
//                    .lastName("Жомартов")
//                    .middleName("Мадиұлы")
//                    .username("zhomartova")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "1903"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Жомартов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("zhomartova").get())
//                    .advisor(userRepository.findByUsername("levedevd").get())
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zhomartova").get(), teamRepository.findTeamByName("Жомартов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of the “Digital University” information system using microservice architecture"))
//                    .team(teamRepository.findTeamByName("Жомартов"))
//                    .approved(true)
//                    .build());
//
//            Team team12 = teamRepository.findTeamByName("Жомартов");
//            team12.setTopic(topicRepository.findByName("Development of the “Digital University” information system using microservice architecture"));
//            teamRepository.save(team12);

            // --------------------//



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

//            //defence day 4 -> 04.06.2022
//
//
//            userRepository.save(User.builder()  //руководитель
//                    .id(null)
//                    .firstName("Г.")    // имя
//                    .lastName("Егембердиева")   //фамилия
//                    .username("yegemberdiyeva")     //юзернейм
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a system for educational purposes") //топик
//                    .creator(userRepository.findByUsername("yegemberdiyeva").get())   //юзернейм руководителя
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()      //член команды
//                    .id(null)
//                    .firstName("Данияр")    //имя студента
//                    .lastName("Амантаев")    //фамилия студента
//                    .middleName("Бейбiтұлы")  //отчество студента
//                    .username("amantayevd")      //юзернейм студента
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Мөлдір")
//                    .lastName("Қуанышбаева")
//                    .middleName("Болатбекқызы")
//                    .username("kuanyshbaevam")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1903"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Сагат")
//                    .lastName("Мусабаев")
//                    .middleName("Даниялович")
//                    .username("musabaevs")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1901"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Мусабаев + Амантаев + Қуанышбаева")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("musabaevs").get())    //юзернейм последнего члена команды
//                    .advisor(userRepository.findByUsername("yegemberdiyeva").get()) //юзернейм руководителя
//                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("amantayevd").get(), teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kuanyshbaevam").get(),  teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("musabaevs").get(),  teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a system for educational purposes"))
//                    .team(teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева"))
//                    .approved(true)
//                    .build());
//
//            Team team7 = teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева");
//            team7.setTopic(topicRepository.findByName("Development of a system for educational purposes"));
//            teamRepository.save(team7);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("О.")
//                    .lastName("Ахметов")
//                    .username("Akhmetovo")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Methods for developing high-load applications in java")
//                    .creator(userRepository.findByUsername("Akhmetovo").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Әділбек")
//                    .lastName("Ахмет")
//                    .middleName("Жарқынұлы")
//                    .username("akhmete")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1901"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Ахмет")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("akhmete").get())
//                    .advisor(userRepository.findByUsername("Akhmetovo").get())
//                    .reviewer(reviewerRepository.findByFullName("Александр Пак"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("akhmete").get(), teamRepository.findTeamByName("Ахмет"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Methods for developing high-load applications in java"))
//                    .team(teamRepository.findTeamByName("Ахмет"))
//                    .approved(true)
//                    .build());
//
//            Team team8 = teamRepository.findTeamByName("Ахмет");
//            team8.setTopic(topicRepository.findByName("Methods for developing high-load applications in java"));
//            teamRepository.save(team8);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Б.")
//                    .lastName("Амиргалиев")
//                    .username("Amirgalievb")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a model and a method for processing the initial data obtained from devices installed in the car")
//                    .creator(userRepository.findByUsername("Amirgalievb").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Жахангир")
//                    .lastName("Ануарбек")
//                    .middleName("Бағланұлы")
//                    .username("anuarbekj")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1904"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Ануарбек")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("anuarbekj").get())
//                    .advisor(userRepository.findByUsername("Amirgalievb").get())
//                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("akhmete").get(), teamRepository.findTeamByName("Ануарбек"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a model and a method for processing the initial data obtained from devices installed in the car"))
//                    .team(teamRepository.findTeamByName("Ануарбек"))
//                    .approved(true)
//                    .build());
//
//            Team team9 = teamRepository.findTeamByName("Ануарбек");
//            team9.setTopic(topicRepository.findByName("Development of a model and a method for processing the initial data obtained from devices installed in the car"));
//            teamRepository.save(team9);
//
//            // --------------------//
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of system for IELTS preparation")
//                    .creator(userRepository.findByUsername("yegemberdiyeva").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Алима")
//                    .lastName("Башеева")
//                    .middleName("Бақтығалиқызы")
//                    .username("bashaevaa")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Башеева")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("bashaevaa").get())
//                    .advisor(userRepository.findByUsername("yegemberdiyeva").get())
//                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("bashaevaa").get(), teamRepository.findTeamByName("Башеева"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of system for IELTS preparation"))
//                    .team(teamRepository.findTeamByName("Башеева"))
//                    .approved(true)
//                    .build());
//
//            Team team10 = teamRepository.findTeamByName("Башеева");
//            team10.setTopic(topicRepository.findByName("Development of system for IELTS preparation"));
//            teamRepository.save(team10);
//            // --------------------//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("З.")
//                    .lastName("Файзуллина")
//                    .username("Faizullinaz")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a rating system")
//                    .creator(userRepository.findByUsername("Faizullinaz").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Айша")
//                    .lastName("Қожамсеитова")
//                    .middleName("Абу- Алиқызы")
//                    .username("kozhamseitovaa")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Бекжан")
//                    .lastName("Малбагаров")
//                    .middleName("Есенжанұлы")
//                    .username("malbagarovb")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Дәулет")
//                    .lastName("Чинасылов")
//                    .middleName("Нұрланұлы")
//                    .username("chinasylovd")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Қожамсеитова + Малбагаров + Чинасылов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("chinasylovd").get())
//                    .advisor(userRepository.findByUsername("Faizullinaz").get())
//                    .reviewer(reviewerRepository.findByFullName("Укибасов Баубек Муратулы"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kozhamseitovaa").get(), teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("malbagarovb").get(),  teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("chinasylovd").get(),  teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a rating system"))
//                    .team(teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов"))
//                    .approved(true)
//                    .build());
//
//            Team team11 = teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов");
//            team11.setTopic(topicRepository.findByName("Development of a rating system"));
//            teamRepository.save(team11);
//
//            //------------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("А.")
//                    .lastName("Адамова")
//                    .username("adamovaa")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of an application for a virtual tour of the university")
//                    .creator(userRepository.findByUsername("adamovaa").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Әлима")
//                    .lastName("Аглакова")
//                    .middleName("Маратқызы")
//                    .username("algakova")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Гүлден")
//                    .lastName("Зейнолла")
//                    .middleName("Габиденқызы")
//                    .username("zeinollag")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1904"))
//                    .build());
//
//
//
//            teamRepository.save(Team.builder()
//                    .name("Аглакова + Зейнолла")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("zeinollag").get())
//                    .advisor(userRepository.findByUsername("adamovaa").get())
//                    .reviewer(reviewerRepository.findByFullName("Жартыбаева Макпал Галымбековна"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("algakova").get(), teamRepository.findTeamByName("Аглакова + Зейнолла"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zeinollag").get(),  teamRepository.findTeamByName("Аглакова + Зейнолла"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of an application for a virtual tour of the university"))
//                    .team(teamRepository.findTeamByName("Аглакова + Зейнолла"))
//                    .approved(true)
//                    .build());
//
//            Team team12 = teamRepository.findTeamByName("Аглакова + Зейнолла");
//            team12.setTopic(topicRepository.findByName("Development of an application for a virtual tour of the university"));
//            teamRepository.save(team12);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("А.")
//                    .lastName("Саекова")
//                    .username("saekovaa")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Electronic online libraly with full-text search")
//                    .creator(userRepository.findByUsername("saekovaa").get())
//                    .selected(true)
//                    .build());
//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Мейіржан")
//                    .lastName("Қален")
//                    .middleName("Қанатұлы")
//                    .username("kalenm")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Нұрдаулет")
//                    .lastName("Қарабаев")
//                    .middleName("Ерланұлы")
//                    .username("karabayevn")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Қари")
//                    .lastName("Сәбит")
//                    .middleName("Әнуарбекұлы")
//                    .username("sabitk")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Қален + Қарабаев + Қари")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("sabitk").get())
//                    .advisor(userRepository.findByUsername("saekovaa").get())
//                    .reviewer(reviewerRepository.findByFullName("Укибасов Баубек Муратулы"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kalenm").get(), teamRepository.findTeamByName("Қален + Қарабаев + Қари"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("karabayevn").get(),  teamRepository.findTeamByName("Қален + Қарабаев + Қари"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sabitk").get(),  teamRepository.findTeamByName("Қален + Қарабаев + Қари"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Electronic online libraly with full-text search"))
//                    .team(teamRepository.findTeamByName("Қален + Қарабаев + Қари"))
//                    .approved(true)
//                    .build());
//
//            Team team13 = teamRepository.findTeamByName("Қален + Қарабаев + Қари");
//            team13.setTopic(topicRepository.findByName("Electronic online libraly with full-text search"));
//            teamRepository.save(team13);
//
//            // --------------------//

//            //defence day 4 -> 04.06.2022
//
//
//            userRepository.save(User.builder()  //руководитель
//                    .id(null)
//                    .firstName("Г.")    // имя
//                    .lastName("Егембердиева")   //фамилия
//                    .username("yegemberdiyeva")     //юзернейм
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a system for educational purposes") //топик
//                    .creator(userRepository.findByUsername("yegemberdiyeva").get())   //юзернейм руководителя
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()      //член команды
//                    .id(null)
//                    .firstName("Данияр")    //имя студента
//                    .lastName("Амантаев")    //фамилия студента
//                    .middleName("Бейбiтұлы")  //отчество студента
//                    .username("amantayevd")      //юзернейм студента
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1901"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Мөлдір")
//                    .lastName("Қуанышбаева")
//                    .middleName("Болатбекқызы")
//                    .username("kuanyshbaevam")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1903"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Сагат")
//                    .lastName("Мусабаев")
//                    .middleName("Даниялович")
//                    .username("musabaevs")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1901"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Мусабаев + Амантаев + Қуанышбаева")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("musabaevs").get())    //юзернейм последнего члена команды
//                    .advisor(userRepository.findByUsername("yegemberdiyeva").get()) //юзернейм руководителя
//                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("amantayevd").get(), teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kuanyshbaevam").get(),  teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("musabaevs").get(),  teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a system for educational purposes"))
//                    .team(teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева"))
//                    .approved(true)
//                    .build());
//
//            Team team7 = teamRepository.findTeamByName("Мусабаев + Амантаев + Қуанышбаева");
//            team7.setTopic(topicRepository.findByName("Development of a system for educational purposes"));
//            teamRepository.save(team7);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("О.")
//                    .lastName("Ахметов")
//                    .username("Akhmetovo")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Methods for developing high-load applications in java")
//                    .creator(userRepository.findByUsername("Akhmetovo").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Әділбек")
//                    .lastName("Ахмет")
//                    .middleName("Жарқынұлы")
//                    .username("akhmete")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1901"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Ахмет")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("akhmete").get())
//                    .advisor(userRepository.findByUsername("Akhmetovo").get())
//                    .reviewer(reviewerRepository.findByFullName("Александр Пак"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("akhmete").get(), teamRepository.findTeamByName("Ахмет"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Methods for developing high-load applications in java"))
//                    .team(teamRepository.findTeamByName("Ахмет"))
//                    .approved(true)
//                    .build());
//
//            Team team8 = teamRepository.findTeamByName("Ахмет");
//            team8.setTopic(topicRepository.findByName("Methods for developing high-load applications in java"));
//            teamRepository.save(team8);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Б.")
//                    .lastName("Амиргалиев")
//                    .username("Amirgalievb")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a model and a method for processing the initial data obtained from devices installed in the car")
//                    .creator(userRepository.findByUsername("Amirgalievb").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Жахангир")
//                    .lastName("Ануарбек")
//                    .middleName("Бағланұлы")
//                    .username("anuarbekj")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1904"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Ануарбек")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("anuarbekj").get())
//                    .advisor(userRepository.findByUsername("Amirgalievb").get())
//                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("akhmete").get(), teamRepository.findTeamByName("Ануарбек"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a model and a method for processing the initial data obtained from devices installed in the car"))
//                    .team(teamRepository.findTeamByName("Ануарбек"))
//                    .approved(true)
//                    .build());
//
//            Team team9 = teamRepository.findTeamByName("Ануарбек");
//            team9.setTopic(topicRepository.findByName("Development of a model and a method for processing the initial data obtained from devices installed in the car"));
//            teamRepository.save(team9);
//
//            // --------------------//
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of system for IELTS preparation")
//                    .creator(userRepository.findByUsername("yegemberdiyeva").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Алима")
//                    .lastName("Башеева")
//                    .middleName("Бақтығалиқызы")
//                    .username("bashaevaa")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("IT", "IT-1902"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Башеева")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("bashaevaa").get())
//                    .advisor(userRepository.findByUsername("yegemberdiyeva").get())
//                    .reviewer(reviewerRepository.findByFullName("Байшемиров Жарасбек Дуйсембекович"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("bashaevaa").get(), teamRepository.findTeamByName("Башеева"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of system for IELTS preparation"))
//                    .team(teamRepository.findTeamByName("Башеева"))
//                    .approved(true)
//                    .build());
//
//            Team team10 = teamRepository.findTeamByName("Башеева");
//            team10.setTopic(topicRepository.findByName("Development of system for IELTS preparation"));
//            teamRepository.save(team10);
//            // --------------------//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("З.")
//                    .lastName("Файзуллина")
//                    .username("Faizullinaz")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of a rating system")
//                    .creator(userRepository.findByUsername("Faizullinaz").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Айша")
//                    .lastName("Қожамсеитова")
//                    .middleName("Абу- Алиқызы")
//                    .username("kozhamseitovaa")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Бекжан")
//                    .lastName("Малбагаров")
//                    .middleName("Есенжанұлы")
//                    .username("malbagarovb")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Дәулет")
//                    .lastName("Чинасылов")
//                    .middleName("Нұрланұлы")
//                    .username("chinasylovd")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Қожамсеитова + Малбагаров + Чинасылов")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("chinasylovd").get())
//                    .advisor(userRepository.findByUsername("Faizullinaz").get())
//                    .reviewer(reviewerRepository.findByFullName("Укибасов Баубек Муратулы"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kozhamseitovaa").get(), teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("malbagarovb").get(),  teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("chinasylovd").get(),  teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of a rating system"))
//                    .team(teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов"))
//                    .approved(true)
//                    .build());
//
//            Team team11 = teamRepository.findTeamByName("Қожамсеитова + Малбагаров + Чинасылов");
//            team11.setTopic(topicRepository.findByName("Development of a rating system"));
//            teamRepository.save(team11);
//
//            //------------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("А.")
//                    .lastName("Адамова")
//                    .username("adamovaa")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Development of an application for a virtual tour of the university")
//                    .creator(userRepository.findByUsername("adamovaa").get())
//                    .selected(true)
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Әлима")
//                    .lastName("Аглакова")
//                    .middleName("Маратқызы")
//                    .username("algakova")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1902"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Гүлден")
//                    .lastName("Зейнолла")
//                    .middleName("Габиденқызы")
//                    .username("zeinollag")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1904"))
//                    .build());
//
//
//
//            teamRepository.save(Team.builder()
//                    .name("Аглакова + Зейнолла")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("zeinollag").get())
//                    .advisor(userRepository.findByUsername("adamovaa").get())
//                    .reviewer(reviewerRepository.findByFullName("Жартыбаева Макпал Галымбековна"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("algakova").get(), teamRepository.findTeamByName("Аглакова + Зейнолла"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("zeinollag").get(),  teamRepository.findTeamByName("Аглакова + Зейнолла"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Development of an application for a virtual tour of the university"))
//                    .team(teamRepository.findTeamByName("Аглакова + Зейнолла"))
//                    .approved(true)
//                    .build());
//
//            Team team12 = teamRepository.findTeamByName("Аглакова + Зейнолла");
//            team12.setTopic(topicRepository.findByName("Development of an application for a virtual tour of the university"));
//            teamRepository.save(team12);
//
//            // --------------------//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("А.")
//                    .lastName("Саекова")
//                    .username("saekovaa")
//                    .role(roleRepository.findByName("ROLE_ADVISOR"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .build());
//
//            topicRepository.save(Topic.builder()
//                    .name("Electronic online libraly with full-text search")
//                    .creator(userRepository.findByUsername("saekovaa").get())
//                    .selected(true)
//                    .build());
//
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Мейіржан")
//                    .lastName("Қален")
//                    .middleName("Қанатұлы")
//                    .username("kalenm")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Нұрдаулет")
//                    .lastName("Қарабаев")
//                    .middleName("Ерланұлы")
//                    .username("karabayevn")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            userRepository.save(User.builder()
//                    .id(null)
//                    .firstName("Қари")
//                    .lastName("Сәбит")
//                    .middleName("Әнуарбекұлы")
//                    .username("sabitk")
//                    .role(roleRepository.findByName("ROLE_STUDENT"))
//                    .password(new BCryptPasswordEncoder().encode("verySecret3$"))
//                    .group(groupRepository.findByInitialInitialAndName("SE", "SE-1907"))
//                    .build());
//
//            teamRepository.save(Team.builder()
//                    .name("Қален + Қарабаев + Қари")
//                    .confirmed(true)
//                    .creator(userRepository.findByUsername("sabitk").get())
//                    .advisor(userRepository.findByUsername("saekovaa").get())
//                    .reviewer(reviewerRepository.findByFullName("Укибасов Баубек Муратулы"))
//                    .build());
//
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("kalenm").get(), teamRepository.findTeamByName("Қален + Қарабаев + Қари"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("karabayevn").get(),  teamRepository.findTeamByName("Қален + Қарабаев + Қари"), true));
//            userTeamRepository.save(new UserTeam(null, userRepository.findByUsername("sabitk").get(),  teamRepository.findTeamByName("Қален + Қарабаев + Қари"), true));
//
//            teamTopicRepository.save(TeamTopic.builder()
//                    .topic(topicRepository.findByName("Electronic online libraly with full-text search"))
//                    .team(teamRepository.findTeamByName("Қален + Қарабаев + Қари"))
//                    .approved(true)
//                    .build());
//
//            Team team13 = teamRepository.findTeamByName("Қален + Қарабаев + Қари");
//            team13.setTopic(topicRepository.findByName("Electronic online libraly with full-text search"));
//            teamRepository.save(team13);
//
//            // --------------------//

            //defence day 5
            // start
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

        };
    }
}
