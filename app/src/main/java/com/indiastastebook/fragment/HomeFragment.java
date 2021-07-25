package com.indiastastebook.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.indiastastebook.R;

public class HomeFragment extends Fragment {
    private BottomNavigationView bottomNavigationView;
    private Fragment selectedFragment = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initId(view);
        if (selectedFragment == null) {
            openFragment(new RegionFragment("East"));
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        return view;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.btm_menu_east:
                    item.setChecked(true);
                    openFragment(new RegionFragment("East"));
                    break;

                case R.id.btm_menu_west:
                    item.setChecked(true);
                    openFragment(new RegionFragment("West"));
                    break;
                case R.id.btm_menu_north:
                    item.setChecked(true);
                    openFragment(new RegionFragment("North"));
                    break;
                case R.id.btm_menu_south:
                    item.setChecked(true);
                    openFragment(new RegionFragment("South"));
                    break;
            }
            return false;
        }
    };

    private void initId(View view) {
        bottomNavigationView = view.findViewById(R.id.btm_nav);
    }

    private void openFragment(Fragment fragment) {
        selectedFragment = fragment;
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment_home_frame, selectedFragment).commit();

    }
}
