package com.venio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public class LicznikZnakow {
    @WebMethod
    public ArrayList<Integer> policz(String znaki) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add((int) znaki.codePoints().filter(Character::isLowerCase).count());
        lista.add((int) znaki.codePoints().filter(Character::isUpperCase).count());
        lista.add((int) znaki.codePoints().filter(Character::isDigit).count());
        lista.add((int) znaki.codePoints().filter(Character::isWhitespace).count());
        lista.add(znaki.length());
        return lista;
    }
}
