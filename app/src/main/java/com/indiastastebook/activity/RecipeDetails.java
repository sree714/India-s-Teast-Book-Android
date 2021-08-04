package com.indiastastebook.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.indiastastebook.R;

public class RecipeDetails extends AppCompatActivity {
    private ImageView backImage;
    private TextView title;
    private ImageView image;
    private TextView process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        initId();
        Intent intent=getIntent();


        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText(intent.getStringExtra("name"));
        process.setText(intent.getStringExtra("process"));

        Glide.with(this)
                .load(intent.getStringExtra("image"))
                .error(R.drawable.ic_baseline_account_circle_24)
                .into(image);

    }

    private void initId() {
        backImage = findViewById(R.id.recipe_details_back);
        title=findViewById(R.id.recipe_details_title);
        image=findViewById(R.id.recipe_details_image);
        process=findViewById(R.id.recipe_details_process);
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