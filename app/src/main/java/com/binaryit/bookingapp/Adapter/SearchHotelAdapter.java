package com.binaryit.bookingapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binaryit.bookingapp.Activity.HotelDetailsActivity;
import com.binaryit.bookingapp.Model.SearchPlaceModel;
import com.binaryit.bookingapp.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class SearchHotelAdapter extends RecyclerView.Adapter<SearchHotelAdapter.SearchPlaceViewHolder> {

    Context context;
    List<SearchPlaceModel> searchPlaceModelList;

    public SearchHotelAdapter(Context context, List<SearchPlaceModel> searchPlaceModelList) {
        this.context = context;
        this.searchPlaceModelList = searchPlaceModelList;
    }

    @NonNull
    @Override
    public SearchPlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_layout, parent, false);
        return new SearchPlaceViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SearchPlaceViewHolder holder, int position) {
        SearchPlaceModel model = searchPlaceModelList.get(position);

        Glide.with(context).load(model.getImage()).into(holder.hotelImageView);

        holder.placeNameTextView.setText(model.getName());
        holder.placeLocationTextView.setText(model.getLocation());
        holder.nearByLocationTextView.setText(model.getNearByLocation());
        holder.startTextView.setText(String.valueOf(model.getRating()));
        holder.previousPriceTextView.setText("BDT " + model.getPreviousPrice() + " Tk.");
        holder.newPriceTextView.setText("BDT "+model.getNewPrice()+" TK.");
        holder.offPercentageTextView.setText(model.getOffer()+ "% OFF");

        holder.previousPriceTextView.setPaintFlags(holder.previousPriceTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(context, HotelDetailsActivity.class);
                bundle.putInt("image", model.getImage());
                bundle.putFloat("star", model.getRating());
                bundle.putString("name", model.getName());
                bundle.putString("location", model.getLocation());
                bundle.putString("name", model.getName());
                bundle.putString("name", model.getName());
                bundle.putString("name", model.getName());
                intent.putExtras(bundle);
                /*intent.putExtra("name", model.getName());
                intent.putExtra("name", model.getName());
                intent.putExtra("name", model.getName());
                intent.putExtra("name", model.getName());
                intent.putExtra("name", model.getName());*/

                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return searchPlaceModelList.size();
    }

    public static class SearchPlaceViewHolder extends RecyclerView.ViewHolder {

        ImageView hotelImageView;
        TextView placeNameTextView, placeLocationTextView, nearByLocationTextView, previousPriceTextView,
                newPriceTextView, offPercentageTextView, startTextView;

        public SearchPlaceViewHolder(@NonNull View itemView) {

            super(itemView);

            hotelImageView = itemView.findViewById(R.id.hotelImageView);
            placeNameTextView = itemView.findViewById(R.id.placeNameTextView);
            placeLocationTextView = itemView.findViewById(R.id.placeLocationTextView);
            nearByLocationTextView = itemView.findViewById(R.id.nearByLocationTextView);
            previousPriceTextView = itemView.findViewById(R.id.previousPriceTextView);
            newPriceTextView = itemView.findViewById(R.id.newPriceTextView);
            offPercentageTextView = itemView.findViewById(R.id.offPercentageTextView);
            startTextView = itemView.findViewById(R.id.startTextView);
        }
    }
}
