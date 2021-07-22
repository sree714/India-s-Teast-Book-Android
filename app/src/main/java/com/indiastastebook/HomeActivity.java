package com.indiastastebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.indiastastebook.utils.App;


public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private Button logout;
    private NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initId();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigation.setItemIconTintList(null);
        View header = navigation.getHeaderView(0);
        //TextView navName = header.findViewById(R.id.name);
        //TextView navPhone = header.findViewById(R.id.phone);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        App.toast(HomeActivity.this, "Home");
                        break;

                    case R.id.menu_select_language:
                        App.toast(HomeActivity.this, "lan");
                        break;

                    case R.id.menu_favourite:
                        App.toast(HomeActivity.this, "fav");
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            }
        });


    }

    private void initId() {
        drawerLayout = findViewById(R.id.drawer_layout);
        logout = findViewById(R.id.home_logout);
        toolbar = findViewById(R.id.toolbar_home);
        navigation = findViewById(R.id.nav_view);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}