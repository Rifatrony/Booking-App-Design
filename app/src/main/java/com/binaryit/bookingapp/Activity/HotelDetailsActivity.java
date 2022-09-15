package com.binaryit.bookingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.binaryit.bookingapp.R;

public class HotelDetailsActivity extends AppCompatActivity {

    String name, location;
    float star;
    int image;

    TextView hotelNameTextView, hotelTitleNameTextView, locationTextView;
    ImageView imageView, imageBack;
    RatingBar hotelRating;

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

        imageView.setImageResource(image);
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

    }

    private void initialization() {
        imageBack = findViewById(R.id.imageBack);
        imageView = findViewById(R.id.imageView);
        hotelTitleNameTextView = findViewById(R.id.hotelTitleNameTextView);
        hotelNameTextView = findViewById(R.id.hotelNameTextView);
        locationTextView = findViewById(R.id.locationTextView);
        hotelRating = findViewById(R.id.hotelRating);
    }
}