package com.indiastastebook.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.indiastastebook.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class FoodList extends RecyclerView.Adapter<FoodList.ViewHolder> {
    List<String> foodList = new ArrayList<>();
    Context context;

    public FoodList(Context context) {
        this.context = context;
    }

    public void updateData(List<String> foodLists) {
        foodList.clear();
        foodList.addAll(foodLists);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_foodlist, parent, false);

        return (new ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(context, position, foodList.get(position));
    }

    @Override
    public int getItemCount() {
        return (foodList.size());
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView circleImageView;

        ViewHolder(View itemview) {
            super(itemview);
            circleImageView = itemview.findViewById(R.id.food_list_pic);
        }

        public void bind(Context context, int position, String s) {
            Glide.with(context)
                    .load(s)
                    .error(R.drawable.ic_baseline_account_circle_24)
                    .into(circleImageView);
        }
    }
}
