package com.binaryit.bookingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.binaryit.bookingapp.Adapter.SliderAdapter;
import com.binaryit.bookingapp.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HotelDetailsActivity extends AppCompatActivity {

    String name, location;
    float star;
    int image;

    TextView hotelNameTextView, hotelTitleNameTextView, locationTextView;
    ImageView imageView, imageBack;
    RatingBar hotelRating;
    int images[] = {
            R.drawable.see_crown,
            R.drawable.seebeach,
            R.drawable.hotel_see_gurl,
    };

    SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        initialization();

        Bundle bundle = getIntent().getExtras();
        star = bundle.getFloat("star");
        name = bundle.getString("name");
        image = bundle.getInt("image");
        location = bundle.getString("location");
        System.out.println(star);
        System.out.println(name);

        //imageView.setImageResource(image);
        hotelNameTextView.setText(name);
        hotelTitleNameTextView.setText(name);
        locationTextView.setText(location);
        hotelRating.setRating(star);

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }

        });

        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

    }

    private void initialization() {
        sliderView = findViewById(R.id.imageView);
        imageBack = findViewById(R.id.imageBack);
        hotelTitleNameTextView = findViewById(R.id.hotelTitleNameTextView);
        hotelNameTextView = findViewById(R.id.hotelNameTextView);
        locationTextView = findViewById(R.id.locationTextView);
        hotelRating = findViewById(R.id.hotelRating);
    }
}