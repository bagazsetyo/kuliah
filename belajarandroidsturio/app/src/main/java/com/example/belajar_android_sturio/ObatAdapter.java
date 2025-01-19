package com.example.belajar_android_sturio;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ObatAdapter extends RecyclerView.Adapter<ObatAdapter.ObatViewHolder> {
    private Context context;
    private ArrayList<Obat> listObat;
    private DatabaseHelper databaseHelper;

    public ObatAdapter(Context context, ArrayList<Obat> listObat) {
        this.context = context;
        this.listObat = listObat;
        this.databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ObatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_obat, parent, false);
        return new ObatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObatViewHolder holder, int position) {
        Obat obat = listObat.get(position);
        holder.tvNamaObat.setText(obat.getNama());
        holder.tvHargaObat.setText("Rp " + obat.getHarga());

        holder.btnCheckout.setOnClickListener(v -> {
            databaseHelper.addToCheckout(obat.getId(), 1);
            Toast.makeText(context, "Berhasil menambahkan " + obat.getNama() + " ke checkout",
                    Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return listObat.size();
    }

    public static class ObatViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaObat, tvHargaObat;
        ImageButton btnCheckout;

        public ObatViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaObat = itemView.findViewById(R.id.tv_nama_obat);
            tvHargaObat = itemView.findViewById(R.id.tv_harga_obat);
            btnCheckout = itemView.findViewById(R.id.btn_checkout);
        }
    }
}