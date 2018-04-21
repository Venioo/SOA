package zadanie4;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@SessionScoped
public class Ankieta {
    //czesc1
    private String imie, wyksztalcenie, plec, email;
    private String wiek, wzrost, biust, miseczka, talia, biodra, noga, klatka, pas;
    private List<String> wyksztalcenieLista = new ArrayList<>(Arrays.asList("Podstawowe", "Średnie", "Wyższe"));
    private List<String> plecLista = new ArrayList<>(Arrays.asList("Kobieta", "Mężczyzna"));
    //czesc2
    private String pytanie1, pytanie2, pytanie3, pytanie5, pytanie6, pytanie7, uwagi;
    private List<String> pytanie4;
    private List<String> pytanieLista1 = new ArrayList<>(Arrays.asList("do 100zł", "100-500zł", "500-1000zł", "powyżej 1000zł"));
    private List<String> pytanieLista2 = new ArrayList<>(Arrays.asList("Codziennie", "Raz w tygodniu", "Raz w miesiącu", "Kilka razy w roku"));
    private List<String> pytanieLista3 = new ArrayList<>(Arrays.asList("Kolorowo-jaskrawych", "Stonowanych w szarościach", "W czerni i bieli", "W samej czerni"));
    private List<String> pytanieLista4M = new ArrayList<>(Arrays.asList("Spodnie", "Spodenki", "Garnitury", "Koszule", "Krawaty"));
    private List<String> pytanieLista4K = new ArrayList<>(Arrays.asList("Garsonki", "Bluzki", "Spódniczki", "Spodnie"));
    private List<String> pytanieLista5 = new ArrayList<>(Arrays.asList("Spodnie", "Spodenki", "Garnitury", "Koszule", "Krawaty"));
    private List<String> pytanieLista6 = new ArrayList<>(Arrays.asList("Wczoraj", "W zeszłym tygodniu", "W zeszłym miesiącu", "Kilka miesięcy temu", "Nie pamiętam"));
    private List<String> pytanieLista7 = new ArrayList<>(Arrays.asList("Tak", "Raczej tak", "Raczej nie", "Nie", "Nie wiem"));

    public String getEmail() {
        return email;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getWyksztalcenie() {
        return wyksztalcenie;
    }

    public void setWyksztalcenie(String wyksztalcenie) {
        this.wyksztalcenie = wyksztalcenie;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getWiek() {
        return wiek;
    }

    public void setWiek(String wiek) {
        this.wiek = wiek;
    }

    public String getWzrost() {
        return wzrost;
    }

    public void setWzrost(String wzrost) {
        this.wzrost = wzrost;
    }

    public String getBiust() {
        return biust;
    }

    public void setBiust(String biust) {
        this.biust = biust;
    }

    public String getMiseczka() {
        return miseczka;
    }

    public void setMiseczka(String miseczka) {
        this.miseczka = miseczka;
    }

    public String getTalia() {
        return talia;
    }

    public void setTalia(String talia) {
        this.talia = talia;
    }

    public String getBiodra() {
        return biodra;
    }

    public void setBiodra(String biodra) {
        this.biodra = biodra;
    }

    public String getNoga() {
        return noga;
    }

    public void setNoga(String noga) {
        this.noga = noga;
    }

    public String getKlatka() {
        return klatka;
    }

    public void setKlatka(String klatka) {
        this.klatka = klatka;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public List<String> getWyksztalcenieLista() {
        return wyksztalcenieLista;
    }

    public void setWyksztalcenieLista(List<String> wyksztalcenieLista) {
        this.wyksztalcenieLista = wyksztalcenieLista;
    }

    public List<String> getPlecLista() {
        return plecLista;
    }

    public void setPlecLista(List<String> plecLista) {
        this.plecLista = plecLista;
    }

    public String getPytanie1() {
        return pytanie1;
    }

    public void setPytanie1(String pytanie1) {
        this.pytanie1 = pytanie1;
    }

    public String getPytanie2() {
        return pytanie2;
    }

    public void setPytanie2(String pytanie2) {
        this.pytanie2 = pytanie2;
    }

    public String getPytanie3() {
        return pytanie3;
    }

    public void setPytanie3(String pytanie3) {
        this.pytanie3 = pytanie3;
    }

    public List<String> getPytanieLista1() {
        return pytanieLista1;
    }

    public void setPytanieLista1(List<String> pytanieLista1) {
        this.pytanieLista1 = pytanieLista1;
    }

    public List<String> getPytanieLista2() {
        return pytanieLista2;
    }

    public void setPytanieLista2(List<String> pytanieLista2) {
        this.pytanieLista2 = pytanieLista2;
    }

    public List<String> getPytanieLista3() {
        return pytanieLista3;
    }

    public void setPytanieLista3(List<String> pytanieLista3) {
        this.pytanieLista3 = pytanieLista3;
    }

    public List<String> getPytanieLista4M() {
        return pytanieLista4M;
    }

    public void setPytanieLista4M(List<String> pytanieLista4M) {
        this.pytanieLista4M = pytanieLista4M;
    }

    public List<String> getPytanieLista4K() {
        return pytanieLista4K;
    }

    public void setPytanieLista4K(List<String> pytanieLista4K) {
        this.pytanieLista4K = pytanieLista4K;
    }

    public List<String> getPytanie4() {
        return pytanie4;
    }

    public void setPytanie4(List<String> pytanie4) {
        this.pytanie4 = pytanie4;
    }

    public List<String> getPytanieLista5() {
        return pytanieLista5;
    }

    public void setPytanieLista5(List<String> pytanieLista5) {
        this.pytanieLista5 = pytanieLista5;
    }

    public List<String> getPytanieLista6() {
        return pytanieLista6;
    }

    public void setPytanieLista6(List<String> pytanieLista6) {
        this.pytanieLista6 = pytanieLista6;
    }

    public List<String> getPytanieLista7() {
        return pytanieLista7;
    }

    public void setPytanieLista7(List<String> pytanieLista7) {
        this.pytanieLista7 = pytanieLista7;
    }

    public String getPytanie5() {
        return pytanie5;
    }

    public void setPytanie5(String pytanie5) {
        this.pytanie5 = pytanie5;
    }

    public String getPytanie6() {
        return pytanie6;
    }

    public void setPytanie6(String pytanie6) {
        this.pytanie6 = pytanie6;
    }

    public String getPytanie7() {
        return pytanie7;
    }

    public void setPytanie7(String pytanie7) {
        this.pytanie7 = pytanie7;
    }
}
