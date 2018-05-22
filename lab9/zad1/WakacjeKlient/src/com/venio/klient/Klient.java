package com.venio.klient;

import com.venio.imported.Licznik;
import com.venio.imported.LicznikService;

public class Klient {
    public static void main(String[] argv) {
        LicznikService licznikService = new LicznikService();
        Licznik licznik = licznikService.getLicznikPort();
        System.out.println("Pozostało " + licznik.odlicz() + " dni do wakacji!");
    }
}
