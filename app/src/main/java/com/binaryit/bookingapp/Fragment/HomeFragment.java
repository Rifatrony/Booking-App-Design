package com.binaryit.bookingapp.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.binaryit.bookingapp.Activity.CarActivity;
import com.binaryit.bookingapp.Activity.HotelActivity;
import com.binaryit.bookingapp.Activity.TourActivity;
import com.binaryit.bookingapp.R;
import com.binaryit.bookingapp.ViewPagerAdapter.SelectCarViewPagerAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment implements View.OnClickListener {

    View view;

    CardView carCardView, hotelCardView, tourCardView;
    BottomSheetDialog bottomSheetDialog;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    SelectCarViewPagerAdapter selectCarViewPagerAdapter;

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
        bottomSheetDialog = new BottomSheetDialog(getContext());

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

    /*private void SearchCar() {

        bottomSheetDialog.setContentView(R.layout.select_car_bottom_layout);
        bottomSheetDialog.show();

        viewPager2 = bottomSheetDialog.findViewById(R.id.view_pager);
        tabLayout = bottomSheetDialog.findViewById(R.id.tab_layout);


        selectCarViewPagerAdapter = new SelectCarViewPagerAdapter(getActivity());
        viewPager2.setAdapter(selectCarViewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                super.onPageSelected(position);

                tabLayout.getTabAt(position).select();

            }
        });

    }*/
}