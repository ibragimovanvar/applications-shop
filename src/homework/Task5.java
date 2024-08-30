package homework;

public class Task5 {
    public static void main(String[] args) {

        int[] ints = null;

        try {
            System.out.println(ints[0]);
        }catch (NullPointerException e){
            System.err.println("Xatolik massiv nulligicha qolib ketdi !");
        }

    }
}
