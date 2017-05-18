package rs.aleph.android.zadatak3.activities.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import rs.aleph.android.zadatak3.activities.provider.JeloInfoProvider;
import rs.aleph.android.zadatak3.activities.provider.KategorijaProvider;

/**
 * Created by Nikola on 5/18/2017.
 */

public class DetailFragment extends Fragment {
    // Position of the item to be displayed in the detail fragment
    private int position = 0;

    Button btn_buy;
    Button kamera;




    static final int REQUEST_IMAGE_CAPTURE = 1;


    // onCreate method is a life-cycle method that is called when creating the fragment.
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    // onActivityCreated method is a life-cycle method that is called when the fragment's activity has been created and this fragment's view hierarchy instantiated.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);



        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloInfoProvider.getFoodPoIDju(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(JeloInfoProvider.getFoodPoIDju(position).getNaziv());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(JeloInfoProvider.getFoodPoIDju(position).getOpis());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.spinner);
        List<String> categories = KategorijaProvider.getKategorijaImena();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
       // category.setSelection((int)JeloInfoProvider.getFoodPoIDju(position).getKategorija().getId());

        // Finds "rbRating" RatingBar and sets "rating" property
        RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_rating);
        rbRating.setRating(JeloInfoProvider.getFoodPoIDju(position).getRating());

        TextView tvComponents = (TextView) getView().findViewById(R.id.tv_Components);
        tvComponents.setText(getString(R.string.Components)+ " " +JeloInfoProvider.getFoodPoIDju(position).getSastojci());

        String kalorije = String.valueOf(JeloInfoProvider.getFoodPoIDju(position).getKalorijskaVrednost());
        TextView tvCalories = (TextView) getView().findViewById(R.id.tv_Calories);
        tvCalories.setText(getString(R.string.Calories)+ " " +kalorije + " [cal]");

        // Finds "btnBuy" Button and sets "onClickListener" listener
        btn_buy = (Button) getView().findViewById(R.id.btn_buy);
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), getString(R.string.dilevery), Toast.LENGTH_LONG);
                toast.show();
            }
        });
        kamera = (Button)getView().findViewById(R.id.button3);

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,REQUEST_IMAGE_CAPTURE);
            }
        });



    }

    // onSaveInstanceState method is a life-cycle method that is called to ask the fragment to save its current dynamic state, so it can later be reconstructed in a new instance of its process is restarted.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);


        savedInstanceState.putInt("position", position);
    }

    // onCreateView method is a life-cycle method that is called  to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Finds view in the view hierarchy and returns it.
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    // onDestroyView method is a life-cycle method that is called when the view previously created by onCreateView(LayoutInflater, ViewGroup, Bundle) has been detached from the fragment.
    @Override
    public void onDestroyView() {

        super.onDestroyView();

    }

    // Called to set fragment's content.
    public void setContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "setContent() sets position to " + position);
    }

    // Called to update fragment's content.
    public void updateContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "updateContent() sets position to " + position);


        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloInfoProvider.getFoodPoIDju(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(JeloInfoProvider.getFoodPoIDju(position).getNaziv());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(JeloInfoProvider.getFoodPoIDju(position).getOpis());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.spinner);
        List<String> categories = KategorijaProvider.getKategorijaImena();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        //category.setSelection((int)JeloInfoProvider.getFoodPoIDju(position).getKategorija().getId());

        // Finds "rbRating" RatingBar and sets "rating" property
        RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_rating);
        rbRating.setRating(JeloInfoProvider.getFoodPoIDju(position).getRating());

        TextView tvComponents = (TextView) getView().findViewById(R.id.tv_Components);
        tvComponents.setText(getString(R.string.Components)+ " " +JeloInfoProvider.getFoodPoIDju(position).getSastojci());

        String kalorije = String.valueOf(JeloInfoProvider.getFoodPoIDju(position).getKalorijskaVrednost());
        TextView tvCalories = (TextView) getView().findViewById(R.id.tv_Calories);
        tvCalories.setText(getString(R.string.Calories)+ " " +kalorije + " [cal]");




        // Finds "btnBuy" Button and sets "onClickListener" listener
        btn_buy = (Button) getView().findViewById(R.id.btn_buy);
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), getString(R.string.dilevery), Toast.LENGTH_LONG);
                toast.show();
            }
        });
        kamera = (Button)getView().findViewById(R.id.button3);

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,REQUEST_IMAGE_CAPTURE);
            }
        });
    }
}
