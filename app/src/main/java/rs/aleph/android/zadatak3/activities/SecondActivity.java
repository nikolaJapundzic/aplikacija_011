package rs.aleph.android.zadatak3.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import rs.aleph.android.zadatak3.R;
import rs.aleph.android.zadatak3.activities.provider.KategorijaProvider;

// Each activity extends Activity class
public class SecondActivity extends AppCompatActivity {

    Button btn_buy;
    private int position = 0;


    private Food[]foods = new Food[]{
            new Food("bruscheta.jpg", "Bruscheta", "Delicious first class tomato on garlic bread","Bread, salt, frensh fries, onion on top + tomato", 3000.0, 10.0, 4.0f),
            new Food("fishandchips.jpg", "Fish and chips", "Delicious first class fish with tartar","Fish, salt, frensh fries, tartar, ketchup", 1000.0, 15.0, 4.0f),
            new Food("garlicbread.jpg", "Garlic bread", "Delicious first class snack","Bread, salt, frensh fries, onion on top", 2800.0, 9.0, 4.0f),
            new Food("lazylobster.jpg", "Lazy lobster", "Delicious first class meat from best lobster","Lobster-prepared, salt, baked potato, butter, lemon", 2090.0, 31.0, 4.0f),
            new Food("primeribs.jpg", "Prime ribs", "Delicious first class ribs with frensh fries","Ribs, salt, frensh fries, 1000 island dresses", 2600.0, 22.0, 4.0f),
            new Food("wholelobster.jpg", "Lobster whole", "Top meni","Lobster, salt, baked potato, butter, lemon", 2000.0, 35.0, 1.5f)
    };





    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button kamera;


    // onCreate method is a lifecycle method called when he activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);
        // setContentView method draws UI
        setContentView(R.layout.activity_second);




        btn_buy = (Button) findViewById(R.id.btn_buy);
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getBaseContext(), "Your order coming in 15 min.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Spinner kateg = (Spinner) findViewById(R.id.spinner);
        List<String> categories = KategorijaProvider.getKategorijaImena();
        ArrayAdapter<String>adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categories);
        kateg.setAdapter(adapter);




    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
        final int position = getIntent().getIntExtra("position", 0);

        TextView tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText("Name: " +foods[position].getNaziv());

        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText("Descripion: " +foods[position].getOpis());

        TextView tvMoney = (TextView) findViewById(R.id.tv_money);
        String price = String.valueOf(foods[position].getCena());
        tvMoney.setText("$ "+price);



        TextView tvComponents = (TextView) findViewById(R.id.tv_Components);
        tvComponents.setText("Components: " +foods[position].getSastojci());

        String kalorije = String.valueOf(foods[position].getKalorijskaVrednost());
        TextView tvCalories = (TextView) findViewById(R.id.tv_Calories);
        tvCalories.setText("Calories: " +kalorije + " [cal]");

        RatingBar rbRating = (RatingBar) findViewById(R.id.rb_rating);
        rbRating.setRating(foods[position].getRating());

        ImageView ivImage = (ImageView) findViewById(R.id.iv_image);
        InputStream is = null;
        try{
            is = getAssets().open(foods[position].getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        }catch(IOException e){
            e.printStackTrace();
        }


    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
        kamera = (Button)findViewById(R.id.button3);

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,REQUEST_IMAGE_CAPTURE);
            }
        });
    }
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------




}
