package com.example.belajar_android_sturio;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rvObat;
    private ObatAdapter adapter;
    private ArrayList<Obat> listObat;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inisialisasi DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Inisialisasi RecyclerView dan ArrayList
        rvObat = findViewById(R.id.rv_obat);
        listObat = new ArrayList<>();
        adapter = new ObatAdapter(this, listObat);
        rvObat.setLayoutManager(new LinearLayoutManager(this));
        rvObat.setAdapter(adapter);

        // Setup bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    return true;
                case R.id.menu_add:
                    startActivity(new Intent(getApplicationContext(), AddActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.menu_checkout: // Menambahkan case untuk menu checkout
                    startActivity(new Intent(getApplicationContext(), CheckoutActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
            }
            return false;
        });

        // Setup swipe to delete
        ItemTouchHelper.SimpleCallback swipeToDeleteCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                // Hapus dari database
                Obat obat = listObat.get(position);
                databaseHelper.deleteProduct(obat.getId());
                // Hapus dari list
                listObat.remove(position);
                adapter.notifyItemRemoved(position);
            }
        };

        new ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(rvObat);

        // Load data awal
        loadObatData();
    }

    private void loadObatData() {
        listObat.clear();
        Cursor cursor = databaseHelper.getAllProducts();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                try {
                    int idIndex = cursor.getColumnIndexOrThrow("id");
                    int nameIndex = cursor.getColumnIndexOrThrow("name");
                    int priceIndex = cursor.getColumnIndexOrThrow("price");

                    long id = cursor.getLong(idIndex);
                    String nama = cursor.getString(nameIndex);
                    double harga = cursor.getDouble(priceIndex);

                    listObat.add(new Obat(id, nama, harga));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
            cursor.close();
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadObatData();
    }
}