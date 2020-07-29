package com.domaranskiy.main;

import java.util.Scanner;

public class MainMenu {
    public void show(String[] text) {
        System.out.println("*******************");
        for (String s : text) {
            System.out.println(s);
        }
        System.out.println("*******************");
        System.out.println("0. Exit");
    }

    public void exit() {
        System.exit(666);

    }
}