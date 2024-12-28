package com.yahyam.ecommerce;

import static com.yahyam.ecommerce.ImageViewBindingAdapter.bindImage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.circularreveal.cardview.CircularRevealCardView;

import java.util.Collections;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<ObjectItem> mData ;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<ObjectItem> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ObjectItem food = mData.get(position);
        holder.nameFood.setText(food.getName());
        holder.priceFood.setText(food.getPrice());
        bindImage(holder.photoFood,food.getImage(),holder.progressBar,holder.text_download);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameFood;
        TextView priceFood;
        TextView text_download;
        ImageView photoFood;
        ProgressBar progressBar;
        CircularRevealCardView likeButton , pluseButton;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameFood = itemView.findViewById(R.id.name_food);
            priceFood = itemView.findViewById(R.id.price_food);
            photoFood = itemView.findViewById(R.id.image_view);
            likeButton = itemView.findViewById(R.id.like_button);
            pluseButton = itemView.findViewById(R.id.pluse_button);
            progressBar = itemView.findViewById(R.id.progress_circular);
            text_download = itemView.findViewById(R.id.text_download);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
//    String getItem(int id) {
//        return mData.get(id);
//    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;

    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
