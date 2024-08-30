package homework;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        int[] toplam = {1,2,3,4,5};

        Scanner scanner = new Scanner(System.in);

        System.out.print("To`plamdagi bor indexs ni kiriting: ");
        int num = scanner.nextInt();

        try {

            System.out.println(toplam[num]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.err.println("Siz toplamdagi bor indexsdan tashqari sonni kiritingiz!");

        }
    }
}
