package com.venio.soa.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Wypozyczenie {
    private int id;
    private Date dataWypozyczenia;
    private Date dataZwrotu;
    private Ksiazka ksiazka;
    private Czytelnik czytelnik;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(Date dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public Date getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(Date dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }

    @ManyToOne
    public Czytelnik getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
    }

    @Override
    public String toString() {
        return "Wypozyczenie{" +
                "id=" + id +
                ", dataWypozyczenia=" + dataWypozyczenia +
                ", dataZwrotu=" + dataZwrotu +
                ", ksiazka=" + ksiazka +
                ", czytelnik=" + czytelnik +
                '}';
    }
}