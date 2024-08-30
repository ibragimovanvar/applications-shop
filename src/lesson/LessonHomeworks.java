package lesson;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LessonHomeworks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner scTxt = new Scanner(System.in);

        try {
            System.out.print("Bitta son kiriting: ");
            int i = sc.nextInt();
            System.out.println("Kiritilgan son: " + i);
        }catch (InputMismatchException e){
            System.err.println("Siz son so'ralgan yerga harf kiritdiz.");
        }


        System.out.print("Raqam kiriting:");
        String number1 = scTxt.next();


        System.out.println("Dastur yakunlandi!");
    }
}
