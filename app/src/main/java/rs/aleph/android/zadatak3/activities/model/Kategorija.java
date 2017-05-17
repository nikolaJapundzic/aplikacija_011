package rs.aleph.android.zadatak3.activities.model;

/**
 * Created by Nikola on 5/8/2017.
 */

public class Kategorija {
    private int id;
    private String zanrVeganMesoJed;
    private Food food;

    public Kategorija() {
    }


    public Kategorija(int id, String zanrVeganMesoJed) {
        this.id = id;
        this.zanrVeganMesoJed = zanrVeganMesoJed;
    }


    public String getZanrVeganMesoJed() {
        return zanrVeganMesoJed;
    }

    public void setZanrVeganMesoJed(String zanrVeganMesoJed) {
        this.zanrVeganMesoJed = zanrVeganMesoJed;
    }
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  zanrVeganMesoJed +" " + food;
    }
}
