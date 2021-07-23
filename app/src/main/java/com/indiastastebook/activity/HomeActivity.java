package com.indiastastebook.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.indiastastebook.R;
import com.indiastastebook.fragment.FavouriteFragment;
import com.indiastastebook.fragment.HomeFragment;
import com.indiastastebook.utils.App;


public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private Button logout;
    private NavigationView navigation;
    private Fragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initId();
        openFragment(new HomeFragment());
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
                       openFragment(new HomeFragment());
                        break;

                    case R.id.menu_select_language:
                        App.toast(HomeActivity.this, "lan");
                        break;

                    case R.id.menu_favourite:
                        openFragment(new FavouriteFragment());
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

    private void openFragment(Fragment fragment) {
        selectedFragment =  fragment;
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();

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