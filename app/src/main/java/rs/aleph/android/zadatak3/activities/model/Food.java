package rs.aleph.android.zadatak3.activities.model;

import java.util.ArrayList;

/**
 * Created by Nikola on 5/8/2017.
 */

public class Food {
    private int id;
    private String slika;
    private String naziv;
    private String opis;
    private Kategorija kategorija;
    private String sastojci;
    private double kalorijskaVrednost;
    private double cena;
    private float rating;
    private ArrayList<Food> foods;

    public Food() {
        foods = new ArrayList<Food>();
    }

    public Food(int id, String slika, String naziv, String opis, String sastojci, double kalorijskaVrednost, double cena, float rating) {
        this.id = id;
        this.slika = slika;
        this.naziv = naziv;
        this.opis = opis;
        this.sastojci = sastojci;
        this.kalorijskaVrednost = kalorijskaVrednost;
        this.cena = cena;
        this.rating = rating;
        foods = new ArrayList<Food>();
    }

    public int getId() {
        return id;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public String getSastojci() {
        return sastojci;
    }

    public void setSastojci(String sastojci) {
        this.sastojci = sastojci;
    }

    public double getKalorijskaVrednost() {
        return kalorijskaVrednost;
    }

    public void setKalorijskaVrednost(double kalorijskaVrednost) {
        this.kalorijskaVrednost = kalorijskaVrednost;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", slika='" + slika + '\'' +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", kategorija=" + kategorija +
                ", sastojci='" + sastojci + '\'' +
                ", kalorijskaVrednost=" + kalorijskaVrednost +
                ", cena=" + cena +
                ", rating=" + rating +
                ", foods=" + foods +
                '}';
    }
}
