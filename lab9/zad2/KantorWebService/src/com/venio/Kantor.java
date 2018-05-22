package com.venio;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Kantor {
    private Double eur = 4.28;
    private Double usd = 3.63;
    private Double gbp = 4.88;
    @WebMethod
    public Double sprzedaj(String waluta, Double kwota) {
        switch (waluta) {
            case "EUR":
                return eur * kwota;
            case "USD":
                return usd * kwota;
            case "GBP":
                return gbp * kwota;
            default:
                return kwota;
        }
    }

    @WebMethod
    public Double sprawdzKurs(String waluta) {
        switch (waluta) {
            case "EUR":
                return eur;
            case "USD":
                return usd;
            case "GBP":
                return gbp;
            default:
                return 0.0;
        }
    }
}
