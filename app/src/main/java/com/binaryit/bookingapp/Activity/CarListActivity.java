package com.binaryit.bookingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.binaryit.bookingapp.Adapter.CarListAdapter;
import com.binaryit.bookingapp.Model.CarModel;
import com.binaryit.bookingapp.R;
import com.binaryit.bookingapp.databinding.ActivityCarListBinding;

import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends AppCompatActivity {

    ActivityCarListBinding binding;
    public String sourceAddress, destinationAddress, carType, date;

    CarListAdapter carListAdapter;
    List<CarModel> carModelList;
    RecyclerView recyclerView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sourceAddress = getIntent().getStringExtra("sourceAddress");
        destinationAddress = getIntent().getStringExtra("destinationAddress");
        date = getIntent().getStringExtra("date");
        carType = getIntent().getStringExtra("carType");

        System.out.println(sourceAddress );
        System.out.println(destinationAddress);
        System.out.println(date);
        System.out.println(carType);

        binding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.placeNameTextView.setText(sourceAddress + " to "+ destinationAddress);
        binding.dateTextView.setText(date);

        recyclerView = findViewById(R.id.carRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        carModelList = new ArrayList<>();

        carModelList.add(new CarModel(getString(R.string.carName1), R.drawable.car0, 4, 4, 5));
        carModelList.add(new CarModel(getString(R.string.carName2), R.drawable.car2, 4, 2, 5));
        carModelList.add(new CarModel(getString(R.string.carName3), R.drawable.car3, 4, 3, 4));
        carModelList.add(new CarModel(getString(R.string.carName4), R.drawable.car4, 4, 3, 6));

        carModelList.add(new CarModel(getString(R.string.carName1), R.drawable.car0, 4, 4, 5));
        carModelList.add(new CarModel(getString(R.string.carName3), R.drawable.car3, 4, 3, 4));
        carModelList.add(new CarModel(getString(R.string.carName2), R.drawable.car2, 4, 2, 5));
        carModelList.add(new CarModel(getString(R.string.carName4), R.drawable.car4, 4, 3, 6));

        carModelList.add(new CarModel(getString(R.string.carName3), R.drawable.car3, 4, 3, 4));
        carModelList.add(new CarModel(getString(R.string.carName1), R.drawable.car0, 4, 4, 5));
        carModelList.add(new CarModel(getString(R.string.carName2), R.drawable.car2, 4, 2, 5));
        carModelList.add(new CarModel(getString(R.string.carName4), R.drawable.car4, 4, 3, 6));

        carModelList.add(new CarModel(getString(R.string.carName2), R.drawable.car2, 4, 2, 5));
        carModelList.add(new CarModel(getString(R.string.carName1), R.drawable.car0, 4, 4, 5));
        carModelList.add(new CarModel(getString(R.string.carName4), R.drawable.car4, 4, 3, 6));
        carModelList.add(new CarModel(getString(R.string.carName3), R.drawable.car3, 4, 3, 4));

        carModelList.add(new CarModel(getString(R.string.carName2), R.drawable.car2, 4, 2, 5));
        carModelList.add(new CarModel(getString(R.string.carName1), R.drawable.car0, 4, 4, 5));
        carModelList.add(new CarModel(getString(R.string.carName4), R.drawable.car4, 4, 3, 6));
        carModelList.add(new CarModel(getString(R.string.carName3), R.drawable.car3, 4, 3, 4));

        carModelList.add(new CarModel(getString(R.string.carName2), R.drawable.car2, 4, 2, 5));
        carModelList.add(new CarModel(getString(R.string.carName1), R.drawable.car0, 4, 4, 5));
        carModelList.add(new CarModel(getString(R.string.carName4), R.drawable.car4, 4, 3, 6));
        carModelList.add(new CarModel(getString(R.string.carName3), R.drawable.car3, 4, 3, 4));

        /*carModelList.add(new CarModel("Toyota", R.drawable.car));
        carModelList.add(new CarModel("Toyota", R.drawable.hotel));
        carModelList.add(new CarModel("Toyota", R.drawable.hotel));
        carModelList.add(new CarModel("Toyota", R.drawable.hotel));

        carModelList.add(new CarModel("Toyota", R.drawable.car));
        carModelList.add(new CarModel("Toyota", R.drawable.hotel));
        carModelList.add(new CarModel("Toyota", R.drawable.hotel));
        carModelList.add(new CarModel("Toyota", R.drawable.hotel));

        carModelList.add(new CarModel("Toyota", R.drawable.car));
        carModelList.add(new CarModel("Toyota", R.drawable.hotel));
        carModelList.add(new CarModel("Toyota", R.drawable.hotel));
        carModelList.add(new CarModel("Toyota", R.drawable.hotel));*/

        carListAdapter = new CarListAdapter(this, carModelList);
        recyclerView.setAdapter(carListAdapter);

    }
}