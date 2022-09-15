package com.binaryit.bookingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binaryit.bookingapp.Model.SuggestionHotelModel;
import com.binaryit.bookingapp.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class SuggestionHotelAdapter extends RecyclerView.Adapter<SuggestionHotelAdapter.SuggestionViewHolder> {

    Context context;
    List<SuggestionHotelModel> suggestionHotelModelList;

    public SuggestionHotelAdapter(Context context, List<SuggestionHotelModel> suggestionHotelModelList) {
        this.context = context;
        this.suggestionHotelModelList = suggestionHotelModelList;
    }

    @NonNull
    @Override
    public SuggestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.hotel_sample_layout, parent, false);
        return new SuggestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestionViewHolder holder, int position) {
        SuggestionHotelModel model = suggestionHotelModelList.get(position);
        holder.placeNameTextView.setText(model.getPlaceName());
        holder.locationTextView.setText(model.getPlaceLocation());
        Glide.with(context).load(model.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return suggestionHotelModelList.size();
    }

    public class SuggestionViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView placeNameTextView, locationTextView;

        public SuggestionViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            placeNameTextView = itemView.findViewById(R.id.placeNameTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);

        }
    }

}
