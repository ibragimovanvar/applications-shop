package lesson;

import exceptions.StudentNotFoundException;

public class CustomExceptionExample {
    public static void main(String[] args) {

        String[] students = new String[]{
                "Firdavs", "Abdujalil", "Farangiz", "Akmal"
        };

        boolean topildi = false;

        for (String student : students) {
            if(student.equals("Abdujali")){
                topildi = true;
            }
        }

        if(topildi){
            System.out.println("Qidirilgan o'quvchi bor!");
        }else{
            throw new StudentNotFoundException("Qidirilgan o'quvchi topilmadi!");
        }

    }
}
