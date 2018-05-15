package com.venio.soa;

import com.venio.soa.entities.Autor;
import com.venio.soa.entities.Czytelnik;
import com.venio.soa.entities.Ksiazka;
import com.venio.soa.entities.Wypozyczenie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void wyswietlMenu() {
        System.out.println("----------------------------------");
        System.out.println("1. Wyświetl ksiażki");
        System.out.println("2. Wyświetl autorów");
        System.out.println("3. Wyświetl czytelników");
        System.out.println("4. Wyświetl wypożyczenia");
        System.out.println("5. Dodaj ksiażkę");
        System.out.println("6. Dodaj autora");
        System.out.println("7. Dodaj czytelnika");
        System.out.println("8. Dodaj wypożyczenie");
        System.out.println("9. Zadanie 1");
        System.out.println("10. Zadanie 2");
        System.out.println("11. Zadanie 3");
        System.out.println("12. Zadanie 4");
        System.out.println("----------------------------------");
        System.out.println("Twój wybór: ");
    }

    public static void init(Session session) {
        Autor autor1 = new Autor();
        autor1.setImie("Henryk");
        autor1.setNazwisko("Sienkiewicz");

        Ksiazka ksiazka1 = new Ksiazka();
        ksiazka1.setTytul("Krzyżacy");
        ksiazka1.setAutor(autor1);
        autor1.dodajKsiazke(ksiazka1);

        Ksiazka ksiazka2 = new Ksiazka();
        ksiazka2.setTytul("Quo Vadis");
        ksiazka2.setAutor(autor1);
        autor1.dodajKsiazke(ksiazka2);

        Autor autor2 = new Autor();
        autor2.setImie("Bolesław");
        autor2.setNazwisko("Prus");

        Ksiazka ksiazka3 = new Ksiazka();
        ksiazka3.setTytul("Lalka");
        ksiazka3.setAutor(autor2);
        autor2.dodajKsiazke(ksiazka3);

        Ksiazka ksiazka4 = new Ksiazka();
        ksiazka4.setTytul("Kamizelka");
        ksiazka4.setAutor(autor2);
        autor2.dodajKsiazke(ksiazka4);

        Ksiazka ksiazka5 = new Ksiazka();
        ksiazka5.setTytul("Katarynka");
        ksiazka5.setAutor(autor2);
        autor2.dodajKsiazke(ksiazka5);

        Czytelnik czytelnik1 = new Czytelnik();
        czytelnik1.setImie("Tomasz");
        czytelnik1.setNazwisko("Adamski");

        Czytelnik czytelnik2 = new Czytelnik();
        czytelnik2.setImie("Jan");
        czytelnik2.setNazwisko("Kowalski");

        Wypozyczenie wypozyczenie1 = new Wypozyczenie();
        wypozyczenie1.setCzytelnik(czytelnik1);
        wypozyczenie1.setDataWypozyczenia(new Date(118, 1, 11));
        wypozyczenie1.setDataZwrotu(new Date(118, 2, 11));
        wypozyczenie1.setKsiazka(ksiazka1);

        Wypozyczenie wypozyczenie2 = new Wypozyczenie();
        wypozyczenie2.setCzytelnik(czytelnik1);
        wypozyczenie2.setDataWypozyczenia(new Date(118, 3, 22));
        wypozyczenie2.setDataZwrotu(new Date(118, 4, 22));
        wypozyczenie2.setKsiazka(ksiazka2);

        Wypozyczenie wypozyczenie3 = new Wypozyczenie();
        wypozyczenie3.setCzytelnik(czytelnik1);
        wypozyczenie3.setDataWypozyczenia(new Date(118, 4, 5));
        wypozyczenie3.setDataZwrotu(new Date(118, 5, 5));
        wypozyczenie3.setKsiazka(ksiazka3);

        Wypozyczenie wypozyczenie4 = new Wypozyczenie();
        wypozyczenie4.setCzytelnik(czytelnik2);
        wypozyczenie4.setDataWypozyczenia(new Date(118, 3, 6));
        wypozyczenie4.setDataZwrotu(new Date(118, 7, 8));
        wypozyczenie4.setKsiazka(ksiazka1);


        session.save(autor1);
        session.save(autor2);
        session.save(ksiazka1);
        session.save(ksiazka2);
        session.save(ksiazka3);
        session.save(ksiazka4);
        session.save(ksiazka5);
        session.save(czytelnik1);
        session.save(czytelnik2);
        session.save(wypozyczenie1);
        session.save(wypozyczenie2);
        session.save(wypozyczenie3);
        session.save(wypozyczenie4);
        session.getTransaction().commit();

    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        init(session);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            wyswietlMenu();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    wyswietlKsiazki(session);
                    break;
                case 2:
                    wyswietlAutorzy(session);
                    break;
                case 3:
                    wyswietlCzytelnicy(session);
                    break;
                case 4:
                    wyswietlWypozyczenia(session);
                    break;
                case 5:
                    dodajKsiazke(session, scanner);
                    break;
                case 6:
                    dodajAutora(session, scanner);
                    break;
                case 7:
                    dodajCzytelnika(session, scanner);
                    break;
                case 8:
                    dodajWypozyczenie(session, scanner);
                    break;
                case 9:
                    zadanie1(session);
                    break;
                case 10:
                    zadanie2(session);
                    break;
                case 11:
                    zadanie3(session);
                    break;
                case 12:
                    zadanie4(session);
                    break;
                default:
                    System.out.println("Zły numer");
            }
        }
    }

    public static void wyswietlKsiazki(Session session) {
        List<Ksiazka> list = session.createQuery("FROM Ksiazka").list();
        for (Ksiazka ksiazka : list) {
            System.out.println(ksiazka);
        }
    }

    public static void wyswietlAutorzy(Session session) {
        List<Autor> list = session.createQuery("FROM Autor").list();
        for (Autor autor : list) {
            System.out.println(autor);
        }
    }

    public static void wyswietlCzytelnicy(Session session) {
        List<Czytelnik> list = session.createQuery("FROM Czytelnik").list();
        for (Czytelnik czytelnik : list) {
            System.out.println(czytelnik);
        }
    }

    public static void wyswietlWypozyczenia(Session session) {
        List<Wypozyczenie> list = session.createQuery("FROM Wypozyczenie").list();
        for (Wypozyczenie wypozyczenie : list) {
            System.out.println(wypozyczenie);
        }
    }

    public static void dodajKsiazke(Session session, Scanner scanner) {
        session.beginTransaction();
        Ksiazka ksiazka = new Ksiazka();
        System.out.println("Podaj tytuł: ");
        ksiazka.setTytul(scanner.nextLine());
        System.out.println("Podaj id autora: ");
        Autor autor = session.get(Autor.class, Integer.parseInt(scanner.nextLine()));
        ksiazka.setAutor(autor);
        autor.dodajKsiazke(ksiazka);
        session.save(ksiazka);
        session.getTransaction().commit();
    }

    public static void dodajAutora(Session session, Scanner scanner) {
        session.beginTransaction();
        Autor autor = new Autor();
        System.out.println("Podaj imie: ");
        autor.setImie(scanner.nextLine());
        System.out.println("Podaj naziwsko: ");
        autor.setNazwisko(scanner.nextLine());
        session.save(autor);
        session.getTransaction().commit();
    }

    public static void dodajCzytelnika(Session session, Scanner scanner) {
        session.beginTransaction();
        Czytelnik czytelnik = new Czytelnik();
        System.out.println("Podaj imie: ");
        czytelnik.setImie(scanner.nextLine());
        System.out.println("Podaj naziwsko: ");
        czytelnik.setNazwisko(scanner.nextLine());
        session.save(czytelnik);
        session.getTransaction().commit();
    }

    public static void dodajWypozyczenie(Session session, Scanner scanner) {
        session.beginTransaction();
        Wypozyczenie wypozyczenie = new Wypozyczenie();
        System.out.println("Podaj id ksiazki: ");
        Ksiazka ksiazka = session.get(Ksiazka.class, Integer.parseInt(scanner.nextLine()));
        wypozyczenie.setKsiazka(ksiazka);
        System.out.println("Podaj id czytelnika: ");
        Czytelnik czytelnik = session.get(Czytelnik.class, Integer.parseInt(scanner.nextLine()));
        wypozyczenie.setCzytelnik(czytelnik);
        System.out.println("Podaj date wypozyczenia (yyyy-MM-dd): ");
        wypozyczenie.setDataWypozyczenia(java.sql.Date.valueOf(scanner.nextLine()));
        System.out.println("Podaj date zwrotu (yyyy-MM-dd): ");
        wypozyczenie.setDataZwrotu(java.sql.Date.valueOf(scanner.nextLine()));
        session.save(wypozyczenie);
        session.getTransaction().commit();
    }

    // Podaj wszystkich czytelników, którzy pożyczyli książki danego autora  w podanym okresie
    public static void zadanie1(Session session) {
        Query query = session.createQuery("SELECT distinct cz FROM Wypozyczenie as w JOIN w.czytelnik as cz JOIN w.ksiazka as k JOIN k.autor as a WHERE a.imie = :imie AND a.nazwisko = :nazwisko AND w.dataWypozyczenia > :dataOd AND w.dataWypozyczenia < :dataDo");
        query.setParameter("imie", "Henryk");
        query.setParameter("nazwisko", "Sienkiewicz");
        query.setParameter("dataOd", new Date(118, 1, 1));
        query.setParameter("dataDo", new Date(118, 5, 1));
        List list = query.list();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // Kto przeczytał daną książkę w podanym okresie
    public static void zadanie2(Session session) {
        Query query = session.createQuery("SELECT distinct cz FROM Wypozyczenie as w JOIN w.czytelnik as cz JOIN w.ksiazka as k" +
                " WHERE k.tytul = :tytul AND w.dataWypozyczenia > :dataOd AND w.dataWypozyczenia < :dataDo");
        query.setParameter("tytul", "Krzyżacy");
        query.setParameter("dataOd", new Date(117, 1, 1));
        query.setParameter("dataDo", new Date(119, 5, 1));
        List list = query.list();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // Wszyszcy autorzy których książki pożyczył dany czytelnik
    public static void zadanie3(Session session) {
        Query query = session.createQuery("SELECT distinct a.imie, a.nazwisko FROM Wypozyczenie as w JOIN w.czytelnik as cz JOIN w.ksiazka as k " +
                "JOIN k.autor as a WHERE cz.imie = :imie AND cz.nazwisko = :nazwisko");
        query.setParameter("imie", "Tomasz");
        query.setParameter("nazwisko", "Adamski");
        List<Object[]> list = (List<Object[]>) query.list();
        for (Object[] e : list) {
            System.out.println(e[0] + " " + e[1]);
        }
    }

    // Jakiego autora czyta się najwięcej
    public static void zadanie4(Session session) {
        Query query = session.createQuery("SELECT a.nazwisko, count(*) as c FROM Wypozyczenie as w JOIN w.czytelnik as cz JOIN w.ksiazka as k JOIN k.autor as a GROUP BY a ORDER BY c DESC");
        query.setMaxResults(1);
        List<Object[]> list = (List<Object[]>) query.list();
        for (Object[] e : list) {
            System.out.println(e[0] + " " + e[1]);
        }
    }
}