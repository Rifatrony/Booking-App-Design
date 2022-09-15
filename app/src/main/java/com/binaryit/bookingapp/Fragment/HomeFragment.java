package com.binaryit.bookingapp.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.binaryit.bookingapp.Activity.CarActivity;
import com.binaryit.bookingapp.Activity.HotelActivity;
import com.binaryit.bookingapp.Activity.TourActivity;
import com.binaryit.bookingapp.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    View view;

    CardView carCardView, hotelCardView, tourCardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_home, container, false);


        initialization();
        setListener();

        return view;
    }

    private void initialization(){
        hotelCardView = view.findViewById(R.id.hotelCardView);
        tourCardView = view.findViewById(R.id.tourCardView);
        carCardView = view.findViewById(R.id.carCardView);
    }

    private void setListener(){
        hotelCardView.setOnClickListener(this);
        carCardView.setOnClickListener(this);
        tourCardView.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.hotelCardView:
                startActivity(new Intent(getContext(), HotelActivity.class));
                break;

            case R.id.carCardView:
                startActivity(new Intent(getContext(), CarActivity.class));
                break;


            case R.id.tourCardView:
                startActivity(new Intent(getContext(), TourActivity.class));
                break;
        }
    }
}