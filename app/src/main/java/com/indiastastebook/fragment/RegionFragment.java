package com.indiastastebook.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.indiastastebook.R;
import com.indiastastebook.adaptor.FoodList;

import java.util.ArrayList;
import java.util.List;

public class RegionFragment extends Fragment {

    private String title;
    private RecyclerView foodList;

    public RegionFragment(String title) {
        this.title = title;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_region, container, false);
        initId(view);

        FoodList food = new FoodList(view.getContext());
        foodList.setAdapter(food);
        List<String> list = new ArrayList<>();
        list.add("https://firebasestorage.googleapis.com/v0/b/india-s-taste-book.appspot.com/o/fish%20curry.jpg?alt=media&token=c71d6570-33f2-467b-ac20-b695374a170b");
        list.add("https://firebasestorage.googleapis.com/v0/b/india-s-taste-book.appspot.com/o/Shukto.jpg?alt=media&token=4dfe3166-c4e7-44de-9d6e-f771b3175bb4");
        food.updateData(list);


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference mainCollection = db.collection("Food Table");
        mainCollection.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot document = task.getResult();
                    for (int i = 0; i < document.getDocuments().size(); i++) {
                        Log.e("LOGDATA", document.getDocuments().get(i).getData().get("Region").toString());
                        String docId = document.getDocuments().get(i).getId();
                        CollectionReference recipe = mainCollection.document(docId).collection("Recipe");
                        recipe.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    QuerySnapshot document1 = task.getResult();
                                    for (int j = 0; j < document1.getDocuments().size(); j++) {
                                        Log.e("LOGDATA_1", document1.getDocuments().get(j).getData().toString());
                                    }

                                }
                            }
                        });
                    }

                }
            }
        });


        return view;
    }

    private void initId(View view) {
        foodList = view.findViewById(R.id.food_list);

    }

}
