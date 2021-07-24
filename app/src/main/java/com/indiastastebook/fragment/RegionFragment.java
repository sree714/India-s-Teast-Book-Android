package com.indiastastebook.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.indiastastebook.R;

public class RegionFragment extends Fragment {

    private String title;
    private Toolbar toolbar;

    public RegionFragment(String title) {
        this.title = title;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_region, container, false);
        initId(view);
        toolbar.setTitle(title);
        return view;
    }

    private void initId(View view) {
        toolbar = view.findViewById(R.id.region_toolbar);
    }

}
