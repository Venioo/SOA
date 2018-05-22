package com.venio;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class Klient {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/WakacjeWebService_war_exploded/Licznik?wsdl");
            //1st argument service URI, refer to wsdl document above
            //2nd argument is service name, refer to wsdl document above
            QName qName = new QName("http://venio.com/", "LicznikService");
            Service service = Service.create(url, qName);
            Licznik licznik = service.getPort(Licznik.class);
            System.out.println("Do rozpoczęcia wakacji pozostało " + licznik.odlicz() + " dni");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}