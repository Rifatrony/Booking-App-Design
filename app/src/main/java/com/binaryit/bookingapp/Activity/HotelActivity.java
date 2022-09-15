package com.binaryit.bookingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.util.Pair;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.binaryit.bookingapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageBack, cancelImage;
    LinearLayout roomAndGuestLayout, selectLocationLayout, dateRangeLayout;
    AppCompatButton searchButton;

    TextView textview, checkInDateTextView, checkOutDateTextView, totalRoomTextView, totalGuestTextView,
            checkInAndOutDateTextView;

    TextView decreaseRoomTextView, totalRoomNumberTextView, increaseRoomTextView,
        decreaseAdultMemberTextView, totalAdultMemberTextView, increaseAdultMemberTextView,
            decreaseChildTextView, totalChildTextView, increaseChildTextView;

    AppCompatButton applyButton;

    ArrayList<String> arrayList;
    Dialog dialog;
    BottomSheetDialog bottomSheetDialog;
    String placeName;

    int countRoom = 1, countGuest = 2, countChildren = 0, totalGuest = 0;

    MaterialDatePicker materialDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        initialization();

        setListener();

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        materialDatePicker = MaterialDatePicker.Builder.dateRangePicker()
                .setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(),
                        MaterialDatePicker.todayInUtcMilliseconds())).build();


        // initialize array list

        // set value in array list
        arrayList.add("Cox’s Bazar");
        arrayList.add("Chittagong Hill Track");
        arrayList.add("Sundarban");
        arrayList.add("Srimagal");
        arrayList.add("Rangamati");
        arrayList.add("Paharpur");
        arrayList.add("Bisanakandi");

        arrayList.add("Jaflong");
        arrayList.add("Ratatgul Swamp Forest");
        arrayList.add("Lalakhal");
        arrayList.add("Malnicherra Tea Garden");
        arrayList.add("Inani Beach");

        arrayList.add("Sitakundu");
        arrayList.add("Nijhum Island");
        arrayList.add("Sajek Valley");
        arrayList.add("Patenga Sea Beach");
        arrayList.add("Foy’s Lake");
        arrayList.add("Kuakata Sea Beach");
        arrayList.add("Chimbuk Hill");
        arrayList.add("St. Martin Island");

    }

    private void initialization(){

        arrayList=new ArrayList<>();

        textview=findViewById(R.id.nameTextView);
        selectLocationLayout=findViewById(R.id.selectLocationLayout);
        dateRangeLayout=findViewById(R.id.dateRangeLayout);

        imageBack = findViewById(R.id.imageBack);
        roomAndGuestLayout = findViewById(R.id.roomAndGuestLayout);
        checkInDateTextView = findViewById(R.id.checkInDateTextView);
        totalGuestTextView = findViewById(R.id.totalGuestTextView);
        totalRoomTextView = findViewById(R.id.totalRoomTextView);
        checkInAndOutDateTextView = findViewById(R.id.checkInAndOutDateTextView);
        searchButton = findViewById(R.id.searchButton);
    }

    private void setListener(){
        selectLocationLayout.setOnClickListener(this);
        roomAndGuestLayout.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        dateRangeLayout.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.selectLocationLayout:
                SelectLocation();
                break;

            case R.id.roomAndGuestLayout:
                SetRoomAndGuest();
                break;

            case R.id.searchButton:
                Search();
                break;

            case R.id.dateRangeLayout:
                OpenCalender();
                break;
        }
    }

    private void SelectLocation() {
        dialog=new Dialog(HotelActivity.this);
        dialog.setContentView(R.layout.dialog_searchable_spinner);
        dialog.getWindow().setLayout(850,1000);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        EditText editText=dialog.findViewById(R.id.edit_text);
        ListView listView=dialog.findViewById(R.id.list_view);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(HotelActivity.this, android.R.layout.simple_list_item_1,arrayList);

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
                // when item selected from list
                // set selected item on textView
                textview.setVisibility(View.VISIBLE);
                textview.setText(adapter.getItem(position));
                placeName = adapter.getItem(position);
                System.out.println("\n\n"+placeName);

                // Dismiss dialog
                dialog.dismiss();
            }
        });
    }

    private void SetRoomAndGuest(){
        bottomSheetDialog = new BottomSheetDialog(HotelActivity.this);

        bottomSheetDialog.setContentView(R.layout.bottom_dialog);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();

        decreaseRoomTextView = bottomSheetDialog.findViewById(R.id.decreaseRoomTextView);
        totalRoomNumberTextView = bottomSheetDialog.findViewById(R.id.totalRoomNumberTextView);
        increaseRoomTextView = bottomSheetDialog.findViewById(R.id.increaseRoomTextView);

        decreaseAdultMemberTextView = bottomSheetDialog.findViewById(R.id.decreaseAdultMemberTextView);
        totalAdultMemberTextView = bottomSheetDialog.findViewById(R.id.totalAdultMemberTextView);
        increaseAdultMemberTextView = bottomSheetDialog.findViewById(R.id.increaseAdultMemberTextView);

        decreaseChildTextView = bottomSheetDialog.findViewById(R.id.decreaseChildTextView);
        totalChildTextView = bottomSheetDialog.findViewById(R.id.totalChildTextView);
        increaseChildTextView = bottomSheetDialog.findViewById(R.id.increaseChildTextView);

        applyButton = bottomSheetDialog.findViewById(R.id.applyButton);

        cancelImage = bottomSheetDialog.findViewById(R.id.cancelImage);

        cancelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        increaseRoomTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countRoom = countRoom + 1;
                totalRoomNumberTextView.setText(String.valueOf(countRoom));
            }
        });

        decreaseRoomTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countRoom == 1){
                    Toast.makeText(HotelActivity.this, "Minimum is 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    countRoom = countRoom - 1;
                    totalRoomNumberTextView.setText(String.valueOf(countRoom));
                }
            }
        });

        increaseAdultMemberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countGuest = countGuest + 1;
                totalAdultMemberTextView.setText(String.valueOf(countGuest));
            }
        });

        decreaseAdultMemberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countGuest == 1){
                    Toast.makeText(HotelActivity.this, "Minimum is 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    countGuest = countGuest - 1;
                    totalAdultMemberTextView.setText(String.valueOf(countRoom));
                }
            }
        });

        increaseChildTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countChildren = countChildren + 1;
                totalChildTextView.setText(String.valueOf(countChildren));
            }
        });

        decreaseChildTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countChildren == 1){
                    Toast.makeText(HotelActivity.this, "Minimum is 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    countChildren = countChildren - 1;
                    totalChildTextView.setText(String.valueOf(countChildren));
                }
            }
        });

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
                System.out.println("Total Room is : " + countRoom);
                System.out.println("Total Guest is : " + countGuest);
                System.out.println("Total Children is : " + countChildren);


                totalGuest = countGuest + countChildren;
                totalGuestTextView.setText(String.valueOf(totalGuest));
                totalRoomTextView.setText(String.valueOf(countRoom));


            }
        });


    }

    private void Search(){

        if (!textview.getText().toString().isEmpty()){
            Intent intent =  new Intent(getApplicationContext(), SearchHotelActivity.class);
            intent.putExtra("name", textview.getText().toString().trim());
            intent.putExtra("check_in_and_out", checkInAndOutDateTextView.getText().toString().trim());
            intent.putExtra("total_guest", totalGuestTextView.getText().toString().trim());
            intent.putExtra("total_room", totalRoomTextView.getText().toString().trim());
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Select Location", Toast.LENGTH_SHORT).show();
        }
    }

    private void OpenCalender(){

        materialDatePicker.show(getSupportFragmentManager(), "tag_picker");

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                System.out.println(materialDatePicker.getHeaderText());
                checkInAndOutDateTextView.setText(materialDatePicker.getHeaderText());
            }
        });
    }

}