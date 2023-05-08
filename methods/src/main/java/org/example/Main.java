package org.example;

public class Main {

    public static void printAbcCaps() {
        Lib.println("ABC");
    }

    public static void printDefCaps() {
        Lib.println("DEF");
    }

    public static void main(String[] args) {
        Lib.println("Hello world");
        String name = Lib.readStrGui("enter name");

    }
}