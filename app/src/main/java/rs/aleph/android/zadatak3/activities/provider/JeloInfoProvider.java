package rs.aleph.android.zadatak3.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.zadatak3.activities.model.Food;

/**
 * Created by Nikola on 5/17/2017.
 */

public class JeloInfoProvider {
    public static List<Food> getFood(){
        List<Food> hrana = new ArrayList<>();
        hrana.add(new Food(0, "bruscheta.jpg", "Bruscheta", "Delicious first class tomato on garlic bread","Bread, salt, frensh fries, onion on top + tomato", 3000.0, 10.0, 4.0f));
        hrana.add(new Food(1, "fishandchips.jpg", "Fish and chips", "Delicious first class fish with tartar","Fish, salt, frensh fries, tartar, ketchup", 1000.0, 15.0, 4.0f));
        hrana.add(new Food(2, "garlicbread.jpg", "Garlic bread", "Delicious first class snack","Bread, salt, frensh fries, onion on top", 2800.0, 9.0, 4.0f));
        hrana.add(new Food(3, "lazylobster.jpg", "Lazy lobster", "Delicious first class meat from best lobster","Lobster-prepared, salt, baked potato, butter, lemon", 2090.0, 31.0, 4.0f));
        hrana.add(new Food(4, "primeribs.jpg", "Prime ribs", "Delicious first class ribs with frensh fries","Ribs, salt, frensh fries, 1000 island dresses", 2600.0, 22.0, 4.0f));
        hrana.add(new Food(5, "wholelobster.jpg", "Lobster whole", "Top meni","Lobster, salt, baked potato, butter, lemon", 2000.0, 35.0, 1.5f));
        return hrana;
    }

    public static List<String> getFoodImena(){
        List<String> names = new ArrayList<>();
        names.add("Bruscheta");
        names.add("Fish and chips");
        names.add("Garlic bread");
        names.add("Lazy lobster");
        names.add("Prime ribs");
        names.add("Lobster whole");
        names.add("Lobster whole");
        return names;
    }

    public static  Food getFoodPoIDju(int id){
        switch (id){
            case 0:
                return new Food(0, "bruscheta.jpg", "Bruscheta", "Delicious first class tomato on garlic bread","Bread, salt, frensh fries, onion on top + tomato", 3000.0, 10.0, 4.0f);
            case 1:
                return new Food(1, "fishandchips.jpg", "Fish and chips", "Delicious first class fish with tartar","Fish, salt, frensh fries, tartar, ketchup", 1000.0, 15.0, 4.0f);
            case 2:
                return new Food(2, "garlicbread.jpg", "Garlic bread", "Delicious first class snack","Bread, salt, frensh fries, onion on top", 2800.0, 9.0, 4.0f);
            case 3:
                return new Food(3, "lazylobster.jpg", "Lazy lobster", "Delicious first class meat from best lobster","Lobster-prepared, salt, baked potato, butter, lemon", 2090.0, 31.0, 4.0f);
            case 4:
                return new Food(4, "primeribs.jpg", "Prime ribs", "Delicious first class ribs with frensh fries","Ribs, salt, frensh fries, 1000 island dresses", 2600.0, 22.0, 4.0f);
            case 5:
                return new Food(5, "wholelobster.jpg", "Lobster whole", "Top meni","Lobster, salt, baked potato, butter, lemon", 2000.0, 35.0, 1.5f);
            default:
                return null;
        }
    }
}

