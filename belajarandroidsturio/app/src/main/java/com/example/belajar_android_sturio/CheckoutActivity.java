package com.example.belajar_android_sturio;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {
    private RecyclerView rvCheckoutItems;
    private TextView tvTotalPrice, tvChangeAmount;
    private EditText etPaymentAmount;
    private Button btnPay;
    private CheckoutItemAdapter adapter;
    private List<CheckoutItem> checkoutItems;
    private DatabaseHelper databaseHelper;
    private double totalPrice = 0;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(R.id.menu_checkout);
            bottomNavigationView.setOnItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.menu_add:
                        startActivity(new Intent(getApplicationContext(), AddActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.menu_checkout:
                        return true;
                }
                return false;
            });
        }


        rvCheckoutItems = findViewById(R.id.rv_checkout_items);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        tvChangeAmount = findViewById(R.id.tv_change_amount);
        etPaymentAmount = findViewById(R.id.et_payment_amount);
        btnPay = findViewById(R.id.btn_pay);

        databaseHelper = new DatabaseHelper(this);
        checkoutItems = new ArrayList<>();
        adapter = new CheckoutItemAdapter(this, checkoutItems);

        rvCheckoutItems.setLayoutManager(new LinearLayoutManager(this));
        rvCheckoutItems.setAdapter(adapter);

        loadCheckoutItems();
        setupPaymentCalculation();
        setupPayButton();
    }

    private void loadCheckoutItems() {
        Cursor cursor = databaseHelper.getCheckoutItems();
        checkoutItems.clear();
        totalPrice = 0;

        if (cursor != null && cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));

                checkoutItems.add(new CheckoutItem(id, name, price, quantity));
                totalPrice += (price * quantity);
            } while (cursor.moveToNext());
            cursor.close();
        }

        adapter.notifyDataSetChanged();
        tvTotalPrice.setText(String.format("Rp %,d", (int)totalPrice));
    }

    private void setupPaymentCalculation() {
        etPaymentAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculateChange();
            }
        });
    }

    private void calculateChange() {
        try {
            double paymentAmount = Double.parseDouble(etPaymentAmount.getText().toString());
            double change = paymentAmount - totalPrice;
            tvChangeAmount.setText(String.format("Rp %,d", (int)change));
            btnPay.setEnabled(change >= 0);
        } catch (NumberFormatException e) {
            tvChangeAmount.setText("Rp 0");
            btnPay.setEnabled(false);
        }
    }

    private void setupPayButton() {
        btnPay.setOnClickListener(v -> {
            if (checkoutItems.isEmpty()) {
                Toast.makeText(this, "Tidak ada item untuk dibayar", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double paymentAmount = Double.parseDouble(etPaymentAmount.getText().toString());
                if (paymentAmount < totalPrice) {
                    Toast.makeText(this, "Pembayaran kurang", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Proses pembayaran
                databaseHelper.clearCheckout();
                Toast.makeText(this, "Pembayaran berhasil", Toast.LENGTH_SHORT).show();

                // Perbarui daftar item dan reset input
                loadCheckoutItems();
                etPaymentAmount.setText("");
                tvChangeAmount.setText("Rp 0");
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Masukkan jumlah pembayaran", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
