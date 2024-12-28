package com.yahyam.ecommerce;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class FragmentA extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {

    public FragmentA() {

    }

    private RecyclerView courseRV;
    // ...
    ArrayList<ObjectItem> productArrayList = new ArrayList<>();

    ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        courseRV = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progress_circular);


        productArrayList.add(new ObjectItem("Berry mango combo","210","https://i.postimg.cc/hj3yq3Qp/temp-Imagem-Yj-RTk.avif"));
        productArrayList.add(new ObjectItem("Tropical fruit salad","170","https://i.postimg.cc/hj3yq3Qp/temp-Imagem-Yj-RTk.avif"));

        //firebase
/*
        db = FirebaseFirestore.getInstance();
        addToFirestore();


        new ProductFetcher().fetchInitialProducts(10);
*/


        //
        courseRV.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

        courseRV.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
//                linearLayoutManager.setReverseLayout(true);
//                linearLayoutManager.setStackFromEnd(true);
        courseRV.setLayoutManager(linearLayoutManager);

        // adding our array list to our recycler view adapter class.
        MyRecyclerViewAdapter courseRVAdapter = new MyRecyclerViewAdapter(getContext(), productArrayList);
        courseRVAdapter.setClickListener(this);

        // setting adapter to our recycler view.
        courseRV.setAdapter(courseRVAdapter);
        try {
//            courseRV.setVisibility(View.GONE);
//            progressBar.setVisibility(View.VISIBLE);

        } catch (Exception exception) {

        }


        // adding our array list to our recycler view adapter class.

        return view;
    }


    @Override
    public void onItemClick(View view, int position) {
        startActivity(new Intent(getContext(),AddToBasket.class));
    }
}
