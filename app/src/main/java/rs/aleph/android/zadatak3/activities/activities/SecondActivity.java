package rs.aleph.android.zadatak3.activities.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import rs.aleph.android.zadatak3.R;
import rs.aleph.android.zadatak3.activities.model.Food;
import rs.aleph.android.zadatak3.activities.provider.JeloInfoProvider;
import rs.aleph.android.zadatak3.activities.provider.KategorijaProvider;

// Each activity extends Activity class
public class SecondActivity extends AppCompatActivity {

    Button btn_buy;
    private int position = 0;





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
                Toast toast = Toast.makeText(getBaseContext(), getString(R.string.dilevery), Toast.LENGTH_SHORT);
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
        tvName.setText(getString(R.string.Name) + " " + JeloInfoProvider.getFoodPoIDju(position).getNaziv());

        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText(getString(R.string.Description)+ " " + JeloInfoProvider.getFoodPoIDju(position).getOpis());

        TextView tvMoney = (TextView) findViewById(R.id.tv_money);
        String price = String.valueOf(JeloInfoProvider.getFoodPoIDju(position).getCena());
        tvMoney.setText("$ "+price);



        TextView tvComponents = (TextView) findViewById(R.id.tv_Components);
        tvComponents.setText(getString(R.string.Components)+ " " +JeloInfoProvider.getFoodPoIDju(position).getSastojci());

        String kalorije = String.valueOf(JeloInfoProvider.getFoodPoIDju(position).getKalorijskaVrednost());
        TextView tvCalories = (TextView) findViewById(R.id.tv_Calories);
        tvCalories.setText(getString(R.string.Calories)+ " " +kalorije + " [cal]");

        RatingBar rbRating = (RatingBar) findViewById(R.id.rb_rating);
        rbRating.setRating(JeloInfoProvider.getFoodPoIDju(position).getRating());

        ImageView ivImage = (ImageView) findViewById(R.id.iv_image);
        InputStream is = null;
        try{
            is = getAssets().open(JeloInfoProvider.getFoodPoIDju(position).getSlika());
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
