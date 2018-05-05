package com.venio.soa;

import com.venio.soa.entity.AppUser;
import com.venio.soa.entity.Pies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class PsyMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Scanner scanner = new Scanner(System.in);
        String line = "";
        while (true) {
            System.out.println("1. Dodaj");
            System.out.println("2. Wyświetl");
            System.out.println("3. Koniec");
            System.out.print("Podaj numer komendy: ");
            line = scanner.nextLine();
            if (Integer.parseInt(line) == 3)
                break;
            switch (Integer.parseInt(line)) {
                case 1:
                    Pies pies = new Pies();
                    System.out.print("Nazwa: ");
                    line = scanner.nextLine();
                    pies.setNazwa(line);
                    System.out.print("Rasa: ");
                    line = scanner.nextLine();
                    pies.setRasa(line);
                    System.out.print("Wiek: ");
                    line = scanner.nextLine();
                    pies.setWiek(Integer.parseInt(line));
                    session.beginTransaction();
                    session.save(pies);
                    session.getTransaction().commit();
                    break;
                case 2:
                    List<Pies> psy = session.createQuery("FROM Pies").list();
                    System.out.println("--------------------------------------------");
                    System.out.println("LISTA PSÓW:");
                    for (Pies piesek : psy) {
                        System.out.println(piesek.getId() + ". " + piesek.getNazwa() + " " + piesek.getRasa() + " " + piesek.getWiek());
                    }
                    System.out.println("--------------------------------------------");
                    break;
                default:
                    System.out.println("Niepoprawny numerek.");
            }
        }
        session.close();
    }
}
