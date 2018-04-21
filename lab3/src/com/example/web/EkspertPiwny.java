package com.example.web;

import java.util.ArrayList;

public class EkspertPiwny {
    public ArrayList<String> znajdzMarki(String kolor) {
        ArrayList<String> marki = new ArrayList();

        if (kolor.equals("bursztynowy")) {
            marki.add("Lech");
            marki.add("Zywiec");
        } else if (kolor.equals("jasny")) {
            marki.add("Heineken");
            marki.add("Perla");
        } else if (kolor.equals("ciemny")) {
            marki.add("Harnas");
        }
        return marki;
    }
}
