package com.example.belajar_android_sturio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CheckoutItemAdapter extends RecyclerView.Adapter<CheckoutItemAdapter.ViewHolder> {
    private List<CheckoutItem> items;
    private Context context;

    public CheckoutItemAdapter(Context context, List<CheckoutItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_checkout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CheckoutItem item = items.get(position);
        holder.tvName.setText(item.getName());
        holder.tvPrice.setText(String.format("Rp %,d x%d", (int)item.getPrice(), item.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvPrice = itemView.findViewById(R.id.tv_item_price);
        }
    }
}