package com.binaryit.bookingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.binaryit.bookingapp.R;
import com.binaryit.bookingapp.databinding.ActivityCarDetailsBinding;

public class CarDetailsActivity extends AppCompatActivity {

    ActivityCarDetailsBinding binding;
    String name;
    int image, person, luggage, door;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCarDetailsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        name = bundle.getString("name");
        image = bundle.getInt("image");
        person = bundle.getInt("person");
        luggage = bundle.getInt("luggage");
        door = bundle.getInt("door");


        binding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.imageView.setImageResource(image);
        binding.titleTextView.setText(name);
        binding.nameTextView.setText(name);



    }
}