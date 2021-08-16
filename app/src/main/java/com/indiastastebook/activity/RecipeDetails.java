package com.indiastastebook.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.indiastastebook.R;

public class RecipeDetails extends AppCompatActivity {
    //UI variable
    private ImageView backImage;
    private TextView title;
    private ImageView image;
    private TextView process;
    private ToggleButton toggleButton;

    //Global variable
    private String recipeId = "";
    private FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        initId();
        Intent intent = getIntent();
        recipeId = intent.getStringExtra("docId");


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
        db = FirebaseFirestore.getInstance();

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("recipe_details", recipeId + "\t " + firebaseUser.getUid());
                CollectionReference reference = db.collection("User");
                Abc abc = new Abc(firebaseUser.getUid(), recipeId);
                reference.add(abc).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(RecipeDetails.this, "insert successful", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RecipeDetails.this, "insert unsuccessful" + e.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }

    private void initId() {
        backImage = findViewById(R.id.recipe_details_back);
        title = findViewById(R.id.recipe_details_title);
        image = findViewById(R.id.recipe_details_image);
        process = findViewById(R.id.recipe_details_process);
        toggleButton = findViewById(R.id.toggle_star_details);
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
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

class Abc {
    String id;
    String fid;

    public Abc(String id, String fid) {
        this.id = id;
        this.fid = fid;
    }

}