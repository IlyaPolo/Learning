package Homework3;

import java.util.*;

public class HomeLessonThree {
    private static final String[] DATA = {"a", "c", "v", "c", "v", "v", "b", "n", "h", "g", "y", "e", "r", "t"};

    public static void main(String[] args) {
        HashMap<Object, Integer> chars = new HashMap<>();
        for (String s: DATA) {
            chars.put(s, chars.getOrDefault(s,0)+1);
        }
        System.out.println(chars);
        //////////////////////////////////////////////////////////////

        Phonebook book = new Phonebook();
        book.addContact("Коля", "5689965");
        book.addContact("Илья", "878978");
        book.addContact("Матвей", "65662");
        book.addContact("Сергей", "5464685");
        book.addContact("Матвей", "325485");
        book.addContact("Коля", "8456465");


        book.findAndPrint("Коля");
        book.findAndPrint("Илья");
        book.findAndPrint("Сергей");

    }
}
