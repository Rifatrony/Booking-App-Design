package com.binaryit.bookingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binaryit.bookingapp.Activity.CarDetailsActivity;
import com.binaryit.bookingapp.Model.CarModel;
import com.binaryit.bookingapp.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarViewHolder> {

    Context context;
    List<CarModel> carModelList;

    public CarListAdapter(Context context, List<CarModel> carModelList) {
        this.context = context;
        this.carModelList = carModelList;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_sample_layout, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        CarModel model = carModelList.get(position);
        Glide.with(context).load(model.getImage()).into(holder.imageView);
        holder.carNameTextView.setText(model.getCarName());
        holder.personTextView.setText(String.valueOf(model.getPerson()));
        holder.luggageTextView.setText(String.valueOf(model.getLuggage()));
        holder.doorTextView.setText(String.valueOf(model.getDoor()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                Intent intent = new Intent(context, CarDetailsActivity.class);
                bundle.putInt("image", model.getImage());
                bundle.putString("name", model.getCarName());
                bundle.putInt("person", model.getPerson());
                bundle.putInt("luggage", model.getLuggage());
                bundle.putInt("door", model.getDoor());

                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return carModelList.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {

        TextView carNameTextView, personTextView, luggageTextView, doorTextView;
        ImageView imageView;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            carNameTextView = itemView.findViewById(R.id.carNameTextView);
            personTextView = itemView.findViewById(R.id.personTextView);
            luggageTextView = itemView.findViewById(R.id.luggageTextView);
            doorTextView = itemView.findViewById(R.id.doorTextView);

        }
    }

}
