package com.binaryit.bookingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.binaryit.bookingapp.R;
import com.binaryit.bookingapp.databinding.ActivityTourDetailsBinding;

public class TourDetailsActivity extends AppCompatActivity {

    ActivityTourDetailsBinding binding;
    String tourName, tourLocation, duration, tourType, generalInformation, date, include,
            exclude, food, travelDetails, contact;

    double price;
    int groupSize, image;

    Bundle bundle;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTourDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });

        bundle = getIntent().getExtras();
        tourName = bundle.getString("tourName");
        tourLocation = bundle.getString("tourLocation");
        duration = bundle.getString("duration");
        tourType = bundle.getString("tourType");
        generalInformation = bundle.getString("generalInformation");
        date = bundle.getString("date");
        include = bundle.getString("include");
        exclude = bundle.getString("exclude");
        food = bundle.getString("food");
        travelDetails = bundle.getString("travelDetails");
        contact = bundle.getString("contact");
        groupSize = bundle.getInt("groupSize");
        image = bundle.getInt("image");
        price = bundle.getDouble("price");


        binding.imageView.setImageResource(image);
        binding.tourNameTextView.setText(tourName);
        binding.tourTitleTextView.setText(tourName);
        binding.tourLocationTextView.setText(tourLocation);
        binding.durationTextView.setText(duration);
        binding.tourTypeTextView.setText(tourType);
        binding.dateTextView.setText(date);
        binding.generalInformationTextView.setText(generalInformation);
        binding.includeTextView.setText(include);
        binding.excludeTextView.setText(exclude);
        binding.foodTextView.setText(food);
        binding.travelDetailsTextView.setText(travelDetails);
        binding.contactTextView.setText(contact);
        binding.priceTextView.setText(price + " Tk.");
        binding.groupSizeTextView.setText("Group Size "+ groupSize);


    }
}