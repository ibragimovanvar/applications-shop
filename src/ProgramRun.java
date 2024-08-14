import database.DatabaseObjects;
import model.Product;
import model.User;
import model.enums.Role;

import java.util.Scanner;

public class ProgramRun {
    static Scanner inNum = new Scanner(System.in);
    static Scanner inTxt = new Scanner(System.in);

    public static void main(String[] args) {

        while (true){
            System.out.println("--- PLEASE REGISTER OR LOGIN FIRST ----");
            System.out.println("1. REGISTER \n2. LOGIN");
            int registerChoice = inNum.nextInt();

            registerQism:
            switch (registerChoice){
                case 1 -> {
                    System.out.print("Toliq ismizni kiriitng:");
                    String fullName = inTxt.nextLine();
                    System.out.print("Telefon raqamizni kiriitng:");
                    String phoneNumber = inTxt.nextLine();
                    System.out.print("Parolizni kiriitng:");
                    String password = inTxt.nextLine();
                    System.out.print("Siz dasturchimisiz ? (xa/yoq):");
                    String role = inTxt.nextLine();
                    Role userRole;
                    if(role.equals("xa")){
                        userRole = Role.DEVELOPER;
                    }else{
                        userRole = Role.BUSINESS_OWNER;
                    }
                    User user = new User(fullName, phoneNumber, password, userRole);
                    DatabaseObjects.users.add(user);
                    System.out.println("Foydalanuvchi muvaffaqiyatli ro'yxatdan o'tdi!");
                }
                case 2 -> {
                    System.out.print("Telefon raqamizni kiriitng:");
                    String phoneNumber = inTxt.nextLine();
                    System.out.print("Parolizni kiriitng:");
                    String password = inTxt.nextLine();
                    User loggedUser = null;
                    for (User user : DatabaseObjects.users) {
                        if(user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)){
                            loggedUser = user;
                        }
                    }

                    if (loggedUser != null){
                        while (true){
                            switch (loggedUser.getRole()){
                                case DEVELOPER -> {
                                    System.out.println("1. Maxsulotni sotuvga qo'yish");
                                    System.out.println("2. Maxsulotni statusini o'zgartirish");
                                    System.out.println("3. Karta balansini tekshirish");
                                    System.out.println("4. Tizimdan chiqish");
                                    System.out.print("----------> ");
                                    int choice = inNum.nextInt();
                                    switch (choice){
                                        case 1 -> {
                                            System.out.print("Maxsulotni nomini kiriting:");
                                            String productName = inTxt.nextLine();
                                            System.out.print("Maxsulotni narxini kiriting:");
                                            int productPrice = inNum.nextInt();
                                            Product product = new Product(productName, productPrice, loggedUser);
                                            DatabaseObjects.products.add(product);
                                            System.out.println("Maxsulot muvaffaqiyatli qo'shildi");
                                        }
                                        case 2 -> {

                                        }
                                        case 4 -> {
                                            System.out.println("Siz tizimdan muvaffaqiyatli chiqib ketdingiz !");
                                            break registerQism;
                                        }
                                    }
                                }
                                case BUSINESS_OWNER -> {
                                    System.out.println("1. Maxsulotlarni ko'rish");
                                    System.out.println("2. Karta balansini tekshirish");
                                    System.out.println("3. Tizimdan chiqish");
                                    System.out.print("----------> ");
                                    int choice = inNum.nextInt();
                                    switch (choice){
                                        case 1 -> {
                                            for (Product product : DatabaseObjects.products) {
                                                System.out.print(product.getId() + " | ");
                                                System.out.print(product.getName());
                                                System.out.print(" | " + product.getPrice());
                                                System.out.print(" | " + product.getUserOwner().getFullName());
                                                System.out.print(" | " + product.getUserOwner().getPhoneNumber());
                                                System.out.print(" | " + (product.isActive() ? "✅" : "❌"));
                                            }
                                            System.out.println();
                                        }
                                        case 3 -> {
                                            System.out.println("Siz tizimdan muvaffaqiyatli chiqib ketdingiz !");
                                            break registerQism;
                                        }
                                    }
                                }
                            }

                        }
                    }else{
                        System.out.println("Bunday foydalanuvchi bazadan topilmadi !");
                    }
                }
            }
        }

    }
}