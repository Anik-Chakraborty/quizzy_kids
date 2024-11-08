package com.quizzy.kids.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.quizzy.kids.R;
import com.quizzy.kids.databinding.UnfinishGamesItemBinding;
import com.quizzy.kids.services.AppService;
import com.squareup.picasso.Picasso;
import java.util.List;

public class UnFinishListAdapter extends RecyclerView.Adapter<UnFinishListAdapter.ViewHolder> {
    List data;
    Context context;

    public UnFinishListAdapter(List data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UnfinishGamesItemBinding binding = UnfinishGamesItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setTitle("First Title");
        holder.binding.setDescription("First Description");
        holder.binding.setValue(20);
        holder.binding.setColor(AppService.getIndicatorColor(context,20));
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVLAuN-IsU-fkhKTMiqVPrY1MlZGG-VsOyAVRpPu0o0Ew2mcNrfE_HvMp24kPw4j50gGk&usqp=CAU").into(holder.binding.actionImage);
        holder.binding.progressCircular.setIndicatorColor(AppService.getIndicatorColor(context,20));
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
        UnfinishGamesItemBinding binding;

        public ViewHolder(@NonNull UnfinishGamesItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }


}
