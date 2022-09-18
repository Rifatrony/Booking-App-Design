package com.binaryit.bookingapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.binaryit.bookingapp.Activity.CarActivity;
import com.binaryit.bookingapp.R;
import com.binaryit.bookingapp.databinding.FragmentDifferentDropOffBinding;

public class DifferentDropOffFragment extends Fragment {

    FragmentDifferentDropOffBinding binding;

    String sourceAddress, destinationAddress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDifferentDropOffBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        /*return inflater.inflate(R.layout.fragment_different_drop_off, container, false);*/



        binding.applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CarActivity.class));

                sourceAddress = binding.sourceAddressEditText.getText().toString().trim();
                destinationAddress = binding.destinationAddressEditText.getText().toString().trim();
                System.out.println(sourceAddress );
                System.out.println(destinationAddress);
            }
        });







        return binding.getRoot();
    }
}