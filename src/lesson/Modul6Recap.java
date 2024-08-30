package lesson;

public class Modul6Recap {
    public static void main(String[] args) {

        System.out.println("Salom main ishladi");

        Student student = new Student("Firdavs", 15);
        student.setName("Orifjon");

        System.out.println(student.getName() + " | " + student.getAge() + " | " + Student.school);

    }
}
