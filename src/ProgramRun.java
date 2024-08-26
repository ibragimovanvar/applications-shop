import database.DatabaseObjects;
import model.Product;
import model.User;
import model.enums.AppLanguage;
import model.enums.Role;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramRun {
    static Scanner inNum = new Scanner(System.in);
    static Scanner inTxt = new Scanner(System.in);
    static Map<String, String> languageMap = Map.of(
            "ENG_REGISTER", "PLEASE REGISTER OR LOGIN FIRST!\n1. REGISTER \n2. LOGIN\n3. CHOOSE ANOTHER LANGUAGE",
            "RUS_REGISTER", "Пожалуйста регистрируйте или сделайте логин!\n1. РЕГИСТРАТЦИЯ \n2. ЛОГИН\n3. ИЗМЕНИТЬ ЯЗЫК",
            "UZB_REGISTER", "Iltimos registratsiyadan o'ting yoki login qiling!\n1. REGISTRATSIYA \n2. LOGIN\n3. TILNI ALISHTIRISH",
            "ENG_REGISTER_CHOICE", "Enter your fullname:_Enter your phone number:_Enter your password:_Are you developer ? (y/n):",
            "RUS_REGISTER_CHOICE", "Введите ваш имя фамилия:_Введите ваш номер:_Введите ваш пароль:_А вы программисты? (y/n):",
            "UZB_REGISTER_CHOICE", "Toliq ismizni kiriting:_Raqamizni kiriting:_Parolizni kiriting:_Siz dasturchimisiz ? (y/n):",
            "ENG_REGISTER_SUCCESS", "You successfully registered in the system!",
            "RUS_REGISTER_SUCCESS", "Вы успешно регисьрирован нашего сервера!",
            "UZB_REGISTER_SUCCESS", "Foydalanuvchi muvaffaqiyatli ro'yxatdan o'tdi!"
    );

    static AppLanguage appLanguage = null;

    public static void main(String[] args) {

        while (true) {
            if (appLanguage == null) {
                System.out.println("Qaysi tilni tanlamoqchisiz:");
                for (int i = 0; i < appLanguage.values().length; i++) {
                    System.out.println(i + 1 + "." + appLanguage.values()[i]);
                }
                int languageChoice = inNum.nextInt();
                appLanguage = appLanguage.values()[languageChoice - 1];
            }

            String langPrefix = appLanguage.toString();
            System.out.println(languageMap.get(langPrefix + "_REGISTER"));
            int registerChoice = inNum.nextInt();

            registerQism:
            switch (registerChoice) {
                case 1 -> {
                    System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[0]);
                    String fullName = inTxt.nextLine();
                    System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[1]);
                    String phoneNumber = inTxt.nextLine();
                    System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[2]);
                    String password = inTxt.nextLine();
                    System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[3]);
                    String role = inTxt.nextLine();
                    Role userRole;
                    if (role.equals("y")) {
                        userRole = Role.DEVELOPER;
                    } else {
                        userRole = Role.BUSINESS_OWNER;
                    }
                    User user = new User(fullName, phoneNumber, password, userRole);
                    DatabaseObjects.users.add(user);
                    System.out.println(languageMap.get(langPrefix + "_REGISTER_SUCCESS"));
                }
                case 2 -> {
                    System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[1]);
                    String phoneNumber = inTxt.nextLine();
                    System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[2]);
                    String password = inTxt.nextLine();
                    User loggedUser = null;
                    for (User user : DatabaseObjects.users) {
                        if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                            loggedUser = user;
                        }
                    }

                    if (loggedUser != null) {
                        while (true) {
                            switch (loggedUser.getRole()) {
                                case DEVELOPER -> {
                                    System.out.println("1. Maxsulotni sotuvga qo'yish");
                                    System.out.println("2. Maxsulotni statusini o'zgartirish");
                                    System.out.println("3. Karta balansini tekshirish");
                                    System.out.println("4. Tizimdan chiqish");
                                    System.out.print("----------> ");
                                    int choice = inNum.nextInt();
                                    switch (choice) {
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
                                    switch (choice) {
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
                    } else {
                        System.out.println("Bunday foydalanuvchi bazadan topilmadi !");
                    }
                }
                case 3 -> {
                    appLanguage = null;
                }
            }
        }

    }
}