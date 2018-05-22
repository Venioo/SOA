package com.venio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Licznik {
    @WebMethod
    public long odlicz() {
        LocalDate dzis = LocalDate.now();
        LocalDate wakacje = LocalDate.of(2018, 7, 1);
        long roznica = ChronoUnit.DAYS.between(dzis, wakacje);
        return roznica;
    }
}
