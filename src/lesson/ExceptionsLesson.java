package lesson;

import java.util.Scanner;

public class ExceptionsLesson {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Salom bu yerda matematik amallar ketma ketligi !");
        System.out.print("Bo'linuvchi son kiriting: ");
        int a = sc.nextInt();
        System.out.print("Bo'luvchi son kiriting: ");
        int b = sc.nextInt();

        try {
            System.out.println("a / b = " + a / b);
        } catch (RuntimeException e) {
            System.err.println("Iltimos bo'luvchini 0 kiritmang!");
        } finally {
            if (b == 0) {
                System.out.println("a / b = 0");
            }
        }

        System.out.println("Dastur shu yerda muvaffaqiyatli tugadi !");
    }
}
