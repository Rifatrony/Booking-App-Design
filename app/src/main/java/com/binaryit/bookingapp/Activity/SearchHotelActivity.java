package com.binaryit.bookingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.binaryit.bookingapp.Adapter.SearchHotelAdapter;
import com.binaryit.bookingapp.Model.SearchPlaceModel;
import com.binaryit.bookingapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchHotelActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout editLinearLayout;
    ShimmerFrameLayout shimmerFrameLayout;
    ImageView imageBack;

    String name, check_in_And_Out, check_out, total_guest, total_room;

    TextView placeNameTextView, checkInDateTextView, checkOutDateTextView,
    totalRoomTextView, totalGuestTextView;

    RecyclerView recyclerView;
    List<SearchPlaceModel> searchPlaceModelList;
    SearchHotelAdapter searchPlaceAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hotel);

        name = getIntent().getStringExtra("name");
        check_in_And_Out = getIntent().getStringExtra("check_in_and_out");
        total_guest = getIntent().getStringExtra("total_guest");
        total_room = getIntent().getStringExtra("total_room");

        System.out.println("Total Room " + total_room);

        initialization();
        setListener();
        setToRecyclerView();

        placeNameTextView.setText(name);
        checkInDateTextView.setText(check_in_And_Out + "  |");
        totalGuestTextView.setText(total_guest + " Person  |  ");
        totalRoomTextView.setText(total_room + " Room");

        shimmerFrameLayout.startShimmer();

    }

    private void initialization(){

        imageBack = findViewById(R.id.imageBack);

        shimmerFrameLayout = findViewById(R.id.shimmer);

        placeNameTextView = findViewById(R.id.placeNameTextView);
        checkInDateTextView = findViewById(R.id.checkInDateTextView);
        totalGuestTextView = findViewById(R.id.totalGuestTextView);
        totalRoomTextView = findViewById(R.id.totalRoomTextView);

        editLinearLayout = findViewById(R.id.editLinearLayout);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchPlaceModelList = new ArrayList<>();

    }

    private void setListener(){
        imageBack.setOnClickListener(this);
        editLinearLayout.setOnClickListener(this);
    }

    private void setToRecyclerView(){

        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        searchPlaceModelList.add(new SearchPlaceModel(R.drawable.oceanparadise, "Ocean Paradise Hotel and Resort", "Kolatoli, Cox's Bazar", "0.66 km from Sea Inn Beach Point", 7800.0, 4300, 35, 5));
        searchPlaceModelList.add(new SearchPlaceModel(R.drawable.see_crown, "হোটেল সী সাইন", "Kolatoli, Cox's Bazar", "0.66 km from Sea Inn Beach Point", 7800.0, 4300, 35, 3));
        searchPlaceModelList.add(new SearchPlaceModel(R.drawable.ff, "Muscat Holiday Resort", "Kolatoli, Cox's Bazar", "0.66 km from Sea Inn Beach Point", 7800.0, 4300, 35, 2));
        searchPlaceModelList.add(new SearchPlaceModel(R.drawable.hotel_see_gurl, "SEAGULL Hotel", " Hotel Motel Zone, Cox's Bazar 4700", "0.66 km from Sea Inn Beach Point", 7800.0, 4300, 35, 5));
        searchPlaceModelList.add(new SearchPlaceModel(R.drawable.royel_reach_resort, " ROYAL BEACH RESORT", "Kolatoli, Cox's Bazar", "0.66 km from Sea Inn Beach Point", 7800.0, 4300, 35, 4));
        searchPlaceModelList.add(new SearchPlaceModel(R.drawable.saymon, "Sayeman beach resort", "Marine Drive, Road, Cox's Bazar 4700", "0.66 km from Sea Inn Beach Point", 7800.0, 4300, 35, 5));

        searchPlaceAdapter = new SearchHotelAdapter(this, searchPlaceModelList);

        recyclerView.setAdapter(searchPlaceAdapter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.editLinearLayout:
                EditDetails();
                break;

            case R.id.imageBack:
                onBackPressed();
                break;

        }
    }

    private void EditDetails() {
        Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
    }
}