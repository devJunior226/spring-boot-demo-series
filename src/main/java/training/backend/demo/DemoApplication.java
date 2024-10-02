package training.backend.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    /**
     * Main method of the application, the entry of all methods.
     *
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * We use the CommandLineRunner to generate a list of 10 students.
     * @param schoolService
     * @param mapper
     * @return 10 students
     */
//    @Bean
//    public CommandLineRunner commandLineRunner(
//            final UniversityService schoolService,
//            final MapperService mapper
//    ) {
//        final int numberOfStudents = 10;
//        final int highestAge = 100;
//        return args -> {
//            for (int i = 0; i < numberOfStudents; i++) {
//                Faker faker = new Faker();
//
//                StudentDto studentDto = new StudentDto();
//                Student student = mapper.mapToStudent(studentDto);
//                student.setFirstName(faker.name().firstName());
//                student.setLastName(faker.name().lastName());
//                student.setEmail(faker.internet().emailAddress());
//                student.setAge(faker.number().numberBetween(1, highestAge));
//
//                schoolService.createStudent(mapper.mapToStudentDto(student));
//            }
//        };
//    }
}
