package com.binaryit.bookingapp.ViewPagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.binaryit.bookingapp.Fragment.DifferentDropOffFragment;
import com.binaryit.bookingapp.Fragment.SameDropOffFragment;

public class SelectCarViewPagerAdapter extends FragmentStateAdapter {

    public SelectCarViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new SameDropOffFragment();

            case 1:
                return new DifferentDropOffFragment();

            default:
                return new SameDropOffFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
