package com.binaryit.bookingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.binaryit.bookingapp.R;
import com.binaryit.bookingapp.ViewPagerAdapter.SelectCarViewPagerAdapter;
import com.binaryit.bookingapp.databinding.ActivityCarBinding;
import com.google.android.material.tabs.TabLayout;

public class CarActivity extends AppCompatActivity {

    ActivityCarBinding binding;
    //ViewPager2 viewPager2;
    SelectCarViewPagerAdapter selectCarViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        selectCarViewPagerAdapter = new SelectCarViewPagerAdapter(this);
        binding.viewPager.setAdapter(selectCarViewPagerAdapter);

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                super.onPageSelected(position);

                binding.tabLayout.getTabAt(position).select();

            }
        });


    }
}