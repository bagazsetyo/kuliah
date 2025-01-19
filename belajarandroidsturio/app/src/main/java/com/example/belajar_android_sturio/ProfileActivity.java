package com.example.belajar_android_sturio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
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
}
