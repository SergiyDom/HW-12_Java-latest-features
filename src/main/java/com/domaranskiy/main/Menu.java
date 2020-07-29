package com.domaranskiy.main;

import com.domaranskiy.service.UserManager;
import com.domaranskiy.user.Sex;
import com.domaranskiy.user.User;

import java.util.Scanner;

public class Menu {
    MainMenu mainMenu = new MainMenu();
    UserManager<User> users = UserManager.getInstance();
    User user;

    public void printMenu() {
        String[] text = {
                "1. Add User",
                "2. Remove User",
                "3. Edit User",
                "4. Print all users",
        };
        mainMenu.show(text);
    }

    public void run() {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        switch (str) {
            case "1":
                System.out.println("set name");
                String name = scanner.nextLine();
                System.out.println("set age");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("set sex (male/female)");
                String sex = scanner.nextLine();
                if (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("m")) {
                    users.addUser(new User(name, age, Sex.MALE));
                } else if (sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("f")) {
                    users.addUser(new User(name, age, Sex.FEMALE));
                } else {
                    System.out.println("wrong");
                }
                run();
                break;
            case "2":
                System.out.println("set name");
                name = scanner.nextLine();
                System.out.println("set age");
                age = Integer.parseInt(scanner.nextLine());
                System.out.println("set sex (male/female)");
                sex = scanner.nextLine();
                if (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("m")) {
                    user = new User(name, age, Sex.MALE);
                } else if (sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("f")) {
                    user = new User(name, age, Sex.FEMALE);
                } else {
                    System.out.println("wrong");
                }
                if (users.getUser(user)) {
                    users.remove(user);
                } else {
                    System.out.println("User don't exist");
                }
                run();
                break;
            case "3":
                System.out.println("set name");
                name = scanner.nextLine();
                System.out.println("set age");
                age = Integer.parseInt(scanner.nextLine());
                System.out.println("set sex (male/female)");
                sex = scanner.nextLine();
                if (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("m")) {
                    user = new User(name, age, Sex.MALE);
                } else if (sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("f")) {
                    user = new User(name, age, Sex.FEMALE);
                } else {
                    System.out.println("wrong");
                }
                if (users.getUser(user)) {
                    users.editUser(user);
                } else {
                    System.out.println("User don't exist");
                }
                run();
                break;
            case "4":
                users.printUsers();
                run();
                break;
            case "0":
                mainMenu.exit();
            default:
                System.out.println("You enter wrong number. Good bue");
                System.exit(666);
        }
    }
}
