package rs.aleph.android.zadatak3.activities.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;

import rs.aleph.android.zadatak3.R;

// Each activity extends Activity class
public class FirstActivity extends Activity {

    public static String getsVegan(){
        return Resources.getSystem().getString(R.string.vegan);
    }


	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) 	{



		// Each lifecycle method should call the method it overrides
		super.onCreate(savedInstanceState);
		// setContentView method draws UI
		setContentView(R.layout.activity_main);


        ImageView ivImage = (ImageView) findViewById(R.id.iv_1);
        InputStream is = null;
        try{
            is = getAssets().open("img_rest.png");
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        }catch(IOException e){
            e.printStackTrace();
        }


        //--------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------
        final String[]foods = getResources().getStringArray(R.array.food);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, foods);
        ListView listView = (ListView) findViewById(R.id.listoffoods);

        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });



    }
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------


}
