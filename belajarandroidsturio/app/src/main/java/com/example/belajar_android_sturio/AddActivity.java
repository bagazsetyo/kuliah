package com.example.belajar_android_sturio;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private EditText inputName, inputPrice, inputQty;
    private Button btnSave;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Setup bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.menu_add:
                    return true;
                case R.id.menu_checkout:
                    startActivity(new Intent(getApplicationContext(), CheckoutActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
            }
            return false;
        });

        inputName = findViewById(R.id.input_name);
        inputPrice = findViewById(R.id.input_price);
        inputQty = findViewById(R.id.input_qty);
        btnSave = findViewById(R.id.btn_save);

        databaseHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString().trim();
                String priceStr = inputPrice.getText().toString().trim();
                String qtyStr = inputQty.getText().toString().trim();

                if (name.isEmpty() || priceStr.isEmpty() || qtyStr.isEmpty()) {
                    Toast.makeText(AddActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                double price = Double.parseDouble(priceStr);
                int qty = Integer.parseInt(qtyStr);

                databaseHelper.saveOrUpdateProduct(name, price, qty);
                Toast.makeText(AddActivity.this, "Product saved", Toast.LENGTH_SHORT).show();

                // Clear input fields
                inputName.setText("");
                inputPrice.setText("");
                inputQty.setText("");
            }
        });
    }
}