package com.binaryit.bookingapp.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.binaryit.bookingapp.Activity.CarActivity;
import com.binaryit.bookingapp.Activity.CarListActivity;
import com.binaryit.bookingapp.Activity.HotelActivity;
import com.binaryit.bookingapp.R;
import com.binaryit.bookingapp.databinding.FragmentDifferentDropOffBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.ArrayList;

public class DifferentDropOffFragment extends Fragment {

    FragmentDifferentDropOffBinding binding;

    public String sourceAddress, destinationAddress, carType, date;
    Dialog dialog;

    ArrayList<String> arrayList;
    MaterialDatePicker materialDatePicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDifferentDropOffBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        /*return inflater.inflate(R.layout.fragment_different_drop_off, container, false);*/

        arrayList=new ArrayList<>();

        arrayList.add("Type A");
        arrayList.add("Type B");
        arrayList.add("Type C");
        arrayList.add("Type D");
        arrayList.add("Type E");


        materialDatePicker = MaterialDatePicker.Builder.dateRangePicker()
                .setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(),
                        MaterialDatePicker.todayInUtcMilliseconds())).build();

        binding.dateRangeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getChildFragmentManager(), "tag_picker");

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        date = materialDatePicker.getHeaderText();
                        binding.dateTextView.setText(date);
                    }
                });
            }
        });

        binding.selectLCarTypeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog=new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(950,1100);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                EditText editText=dialog.findViewById(R.id.edit_text);
                ListView listView=dialog.findViewById(R.id.list_view);

                ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,arrayList);

                listView.setAdapter(adapter);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        binding.carTypeTextView.setVisibility(View.VISIBLE);
                        binding.carTypeTextView.setText(adapter.getItem(position));
                        carType = adapter.getItem(position);

                        dialog.dismiss();
                    }
                });
            }
        });

        binding.applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sourceAddress = binding.sourceAddressEditText.getText().toString().trim();
                destinationAddress = binding.destinationAddressEditText.getText().toString().trim();
                binding.dateTextView.setVisibility(View.VISIBLE);

                if (sourceAddress.isEmpty()){
                    Toast.makeText(getContext(), "Enter Source Address", Toast.LENGTH_SHORT).show();
                    return;
                }

                else if (destinationAddress.isEmpty()){
                    Toast.makeText(getContext(), "Enter Destination Address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (binding.dateTextView.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(), "Enter Date", Toast.LENGTH_SHORT).show();
                    return;
                }

                else if (binding.carTypeTextView.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(), "Enter Car Type", Toast.LENGTH_SHORT).show();
                    return;
                }

                else {
                    Intent intent = new Intent(getActivity(), CarListActivity.class);

                    intent.putExtra("sourceAddress", sourceAddress);
                    intent.putExtra("destinationAddress", destinationAddress);
                    intent.putExtra("date", date);
                    intent.putExtra("carType", carType);

                    startActivity(intent);

                    System.out.println(sourceAddress );
                    System.out.println(destinationAddress);
                    System.out.println(date);
                    System.out.println(carType);
                }
            }
        });

        return binding.getRoot();
    }
}