package com.venio.klient;

import com.venio.imported.Kantor;
import com.venio.imported.KantorService;

public class Klient {
    public static void main(String[] args) {
        KantorService service = new KantorService();
        Kantor kantor = service.getKantorPort();
        System.out.println("1 GBP = " + kantor.sprawdzKurs("GBP") + " PLN");
        System.out.println("30 GBP = " + kantor.sprzedaj("GBP", 30.0) + " PLN");
        System.out.println("35 EUR = " + kantor.sprzedaj("EUR", 35.0) + " PLN");
        System.out.println("35 USD = " + kantor.sprzedaj("USD", 35.0) + " PLN");
    }
}
