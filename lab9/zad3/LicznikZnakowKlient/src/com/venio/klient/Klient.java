package com.venio.klient;

import com.venio.imported.LicznikZnakow;
import com.venio.imported.LicznikZnakowService;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    public static void main(String[] args) {
        LicznikZnakowService service = new LicznikZnakowService();
        LicznikZnakow licznikZnakow = service.getLicznikZnakowPort();
        String znaki = "Av3 0  x51Z\n4s";
        List<Integer> wyniki = licznikZnakow.policz(znaki);
        System.out.println(znaki);
        System.out.println("Małe litery: " + wyniki.get(0));
        System.out.println("Wielkie litery: " + wyniki.get(1));
        System.out.println("Cyfry: " + wyniki.get(2));
        System.out.println("Białe znaki: " + wyniki.get(3));
        System.out.println("Wszystkie znaki: " + wyniki.get(4));
    }
}
