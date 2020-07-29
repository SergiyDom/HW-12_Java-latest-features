package com.domaranskiy.service;

import com.domaranskiy.user.Sex;
import com.domaranskiy.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager<T> {
    private static UserManager instance;
    private List<T> userList = new ArrayList<>();

    private UserManager() {
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(T user) {
        userList.add(user);
    }

    public void remove(T user) {
        userList.remove(user);
    }

    public void editUser(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("set new name");
        String name = scanner.nextLine();
        user.setName(name);
        System.out.println("set new age");
        int age = Integer.parseInt(scanner.nextLine());
        user.setAge(age);
        System.out.println("set new sex (male/female)");
        String sex = scanner.nextLine();
        if (sex.equals("male")) {
            user.setSex(Sex.MALE);
        } else {
            user.setSex(Sex.FEMALE);
        }
    }

    public boolean getUser(User user) {
        for (T t : userList) {
            if (user.equals((User) t)) {
                return true;
            }
        }
        return false;
    }

    public void printUsers() {
        for (T user : userList) {
            System.out.println(user);
        }
    }
}
