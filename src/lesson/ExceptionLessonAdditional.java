package lesson;

import java.util.Scanner;

public class ExceptionLessonAdditional {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        try {
            if(i < 0) {
                throw new IllegalArgumentException("Siz no'ldan kichik son kiritdiz !!");
            }
        }catch (IllegalArgumentException ex){
            System.err.println(ex.getMessage());
        }

        System.out.println("i = " + i);
    }
}
