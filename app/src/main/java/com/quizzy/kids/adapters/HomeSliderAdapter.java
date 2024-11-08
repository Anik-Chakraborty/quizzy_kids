package com.quizzy.kids.adapters;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quizzy.kids.activities.DashBoardActivity;
import com.quizzy.kids.databinding.HomeSliderItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeSliderAdapter extends RecyclerView.Adapter<HomeSliderAdapter.ViewHolder>{
    List data;
    Context context;
    int width;

    public HomeSliderAdapter(List data, Context context, int width) {
        this.data = data;
        this.context = context;
        this.width = width;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HomeSliderItemBinding binding = HomeSliderItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.parent.setMinimumWidth((int)(width));
        holder.binding.setTitle("Title");
        holder.binding.setDescription("Description");
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVLAuN-IsU-fkhKTMiqVPrY1MlZGG-VsOyAVRpPu0o0Ew2mcNrfE_HvMp24kPw4j50gGk&usqp=CAU").into(holder.binding.image);
    }

    @Override
    public int getItemCount() {
        return 5;
//        if (data == null || data.isEmpty()) {
//            return 0;
//        }
//        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        HomeSliderItemBinding binding;
        public ViewHolder(@NonNull HomeSliderItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

}
