package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Juris", "Kreilis",31);
        Faker faker = new Faker();
        String animalName = faker.animal().name();
        System.out.println(animalName);
//        for (int i = 0; i < 20 ; i++) {
//            System.out.println(faker.animal().name());
//        }
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.number().numberBetween(1,100);
        Employee employee2 = new Employee(name,lastName, age);
        Employee employee3 = new Employee(faker.name().firstName(),faker.name().lastName(),faker.number().numberBetween(1, 100));

        System.out.println(employee1.toString());
        System.out.println(employee2.toString());

        System.out.println(faker.pokemon().name());
        System.out.println(faker.chuckNorris().fact());
        System.out.println(faker.backToTheFuture().character());
        System.out.println(faker.harryPotter().character());
        System.out.println(faker.shakespeare().asYouLikeItQuote());
        System.out.println(faker.letterify("sdfs121???sdgs"));
    }
}
