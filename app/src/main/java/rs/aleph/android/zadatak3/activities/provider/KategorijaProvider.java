package rs.aleph.android.zadatak3.activities.provider;

import java.util.ArrayList;
import java.util.List;


import rs.aleph.android.zadatak3.activities.model.Kategorija;

/**
 * Created by Nikola on 5/10/2017.
 */


public class KategorijaProvider {
    public static List<Kategorija>getKategorije(){
        List<Kategorija> categories = new ArrayList<>();
        categories.add(new Kategorija(0, "Vegan"));
        categories.add(new Kategorija(1, "Full of fat energy"));
        categories.add(new Kategorija(2, "Fast food"));
        return categories;
        //final String[]foods = getResources().getStringArray(R.array.food);
    }
   // String vegan = Resources.getSystem().getString(R.string.vegan);
    public static List<String> getKategorijaImena(){


        //String veganS = context.getResources().getString(R.string.vegan);
        //String vegan = getString(R.string.vegan);

        List<String> names = new ArrayList<>();
        names.add("Vegan");
        names.add("Full of fat energy");
        names.add("Fast food");
        return names;
    }

    public static Kategorija getKategorijaPoIDju(int id){
        switch(id){
            case 0:
                return new Kategorija(0, "Vegan");
            case 1:
                return new Kategorija(1, "Full of fat energy");
            case 2:
                return new Kategorija(2, "Fast food");
            default:
                return null;

        }
    }
}
