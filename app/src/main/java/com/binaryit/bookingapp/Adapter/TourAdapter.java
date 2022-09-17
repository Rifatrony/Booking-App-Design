package com.binaryit.bookingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binaryit.bookingapp.Activity.TourDetailsActivity;
import com.binaryit.bookingapp.Model.TourModel;
import com.binaryit.bookingapp.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {

    Context context;
    List<TourModel> tourModelList;

    public TourAdapter(Context context, List<TourModel> tourModelList) {
        this.context = context;
        this.tourModelList = tourModelList;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tour_layout, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        TourModel model = tourModelList.get(position);
        holder.tourNameTextView.setText(model.getTourName());
        holder.priceTextView.setText(String.valueOf(model.getPrice()));
        holder.durationTextView.setText(model.getDuration());

        Glide.with(context).load(model.getImage()).into(holder.packageImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                Intent intent = new Intent(context, TourDetailsActivity.class);
                bundle.putInt("image", model.getImage());
                bundle.putString("tourName", model.getTourName());
                bundle.putString("tourLocation", model.getTourLocation());
                bundle.putString("duration", model.getDuration());
                bundle.putString("tourType", model.getTourType());
                bundle.putString("generalInformation", model.getGeneralInformation());
                bundle.putString("date", model.getDate());
                bundle.putString("include", model.getInclude());
                bundle.putString("exclude", model.getExclude());
                bundle.putString("food", model.getFood());
                bundle.putString("travelDetails", model.getTravelDetails());
                bundle.putString("contact", model.getContact());
                bundle.putDouble("price", model.getPrice());
                bundle.putDouble("price", model.getPrice());
                bundle.putInt("groupSize", model.getGroupSize());
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tourModelList.size();
    }

    public class TourViewHolder extends RecyclerView.ViewHolder {

        ImageView packageImage;
        TextView tourNameTextView, priceTextView, durationTextView;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);

            packageImage = itemView.findViewById(R.id.packageImage);
            tourNameTextView = itemView.findViewById(R.id.tourNameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            durationTextView = itemView.findViewById(R.id.durationTextView);

        }
    }

}
