package lesson;

public class Student {

    static {
        System.out.println("Static blok ishlamoqda!");
    }

    static String school = "185 Maktab";
    private String name;
    private int age;

    public Student(String name, int age) {
        this(name);
        this.age = age;
    }

    public Student(String name) {
        setName(name);
    }

    public Student(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if(name.toUpperCase().startsWith("A") || name.toUpperCase().startsWith("F")){
            this.name = name;
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

}
