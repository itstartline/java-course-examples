package org.example;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lib {

    /**
     * Выводит в терминал строку s и делает перевод курсора на следующую строку
     * @param s
     */
    public static void println(String s) {
        System.out.println(s);
    }

    public static void println(int i) {
        System.out.println(i);
    }

    /**
     * Выводит в терминал строку s
     * @param s
     */
    public static void print(String s) {
        System.out.print(s);
    }

    public static void print(int i) {
        System.out.print(i);
    }

    /**
     * Выводит в терминал каждый символ строки s с задержкой, в сумме приблизительно в течение duration миллисекунд
     * @param s
     * @param duration приблизительная длительность вывода строки в миллисекундах
     */
    public static void printSlow(String s, int duration) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new
                    FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int delay = 1000 / (s.length() + 1);
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            Lib.delay(delay);
        }
        System.out.println();
    }


    /**
     * Читает строку из терминала и возвращает результат
     * @param message - вопрос пользователю
     * @return
     */
    public static String readStr(String message) {
        Console c = System.console();
        String inp = c.readLine(message);
        return inp;
    }

    /**
     * Открывает окно диалога и читает оттуда строку, возвращает результат
     * @param message - вопрос пользователю
     * @return
     */
    public static String readStrGui(String message) {
        String s = JOptionPane.showInputDialog(
                null,
                message,
                message,
                JOptionPane.PLAIN_MESSAGE);
        if (s != null) {
            return s;
        } else {
            return "";
        }
    }

    public static int readOptionGui(String message, String... options) {
        int x = JOptionPane.showOptionDialog(null, message,
                message,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x;
    }

    /**
     * Открывает окно диалога и выводит туда сообщение
     * @param message
     */
    public static void printStrGui(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Делает задержку в миллисекундах
     * @param ms
     */
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Вернет реверсированную строку s
     * @param s
     * @return
     */
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Вернет строку длиной length из случайно взятых
     * символов из строки elems
     * @param elems
     * @param length
     * @return
     */
    public static String random(String elems, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int elem = (int) (Math.random() * elems.length());
            sb.append(elems.charAt(elem));
        }
        return sb.toString();
    }

    /**
     * Возвращает "произведение" строки s на число n,
     * например, "abc" * 3 = "abcabcabc"
     * @param s
     * @param n
     * @return
     */
    public static String multiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * Возвращает отсортрованную строку s,
     * например для "cdeсaa" вернет "aaccde"
     * @param s
     * @return
     */
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * Возвращает строку с переставленными в случайном порядке символами
     * @param s
     * @return
     */
    public static String shuffle(String s) {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            chars.add(s.charAt(i));
        }
        Collections.shuffle(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            sb.append(chars.get(i));
        }
        return sb.toString();
    }

    /**
     * Вернет строку s с замененными символами с помощью
     * "карты" перестановок c1 и c2
     * @param s
     * @param c1
     * @param c2
     * @return
     */
    public static String replaceChars(String s, String c1, String c2) {
        if (c1.length() != c2.length()) {
            throw new RuntimeException("replacement maps lengths must be equal, was c1=[" + c1 + "], c2=[" + c2 + "]");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int pos = c1.indexOf(s.charAt(i));
            if (pos >= 0) {
                sb.append(c2.charAt(pos));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
