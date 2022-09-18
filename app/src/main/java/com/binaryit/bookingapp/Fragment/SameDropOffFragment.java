package com.binaryit.bookingapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.binaryit.bookingapp.databinding.FragmentSameDropOffBinding;

public class SameDropOffFragment extends Fragment {

    FragmentSameDropOffBinding binding;
    String address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentSameDropOffBinding.inflate(getLayoutInflater());

        binding.applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = binding.addressEditText.getText().toString().trim();
                System.out.println(address);
            }
        });



        return binding.getRoot();
    }
}