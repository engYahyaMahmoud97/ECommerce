package com.yahyam.ecommerce;

import static com.yahyam.ecommerce.ImageViewBindingAdapter.bindImage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.circularreveal.cardview.CircularRevealCardView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    TextView helloName;
    List<ObjectItem> listFood = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        helloName = findViewById(R.id.hello_name);
        CircularRevealCardView my_basket = findViewById(R.id.my_basket);
        my_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,OrderlistActivity.class));
            }
        });

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        viewPager.setUserInputEnabled(false); // disable swipe

        viewPager.setAdapter(new ViewPagerAdapter(this));
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("Hottest");
                    } else if (position == 1) {
                        tab.setText("Popular");
                    } else if (position == 2) {
                        tab.setText("New combo");
                    } else if (position == 3) {
                        tab.setText("Top");
                    }
                }
        ).attach();
//        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                currunt = position;
//            }
//        });






        try {
            String name = getIntent().getStringExtra("name");
            assert name != null;
            if (!name.isEmpty())
                helloName.setText("Hello "+name);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        @SuppressLint("UseCompatLoadingForDrawables") Drawable image = getResources().getDrawable(R.drawable.image1);
        @SuppressLint("UseCompatLoadingForDrawables") Drawable image2 = getResources().getDrawable(R.drawable.image2);
        @SuppressLint("UseCompatLoadingForDrawables") Drawable image3 = getResources().getDrawable(R.drawable.a);
        @SuppressLint("UseCompatLoadingForDrawables") Drawable image4 = getResources().getDrawable(R.drawable.b);
        listFood.add(new ObjectItem("Berry mango combo","210","https://i.postimg.cc/hj3yq3Qp/temp-Imagem-Yj-RTk.avif"));
        listFood.add(new ObjectItem("Honey lime combo","320","https://i.postimg.cc/hj3yq3Qp/temp-Imagem-Yj-RTk.avif"));
        listFood.add(new ObjectItem("Quinoa fruit salad","120","https://i.postimg.cc/hj3yq3Qp/temp-Imagem-Yj-RTk.avif"));
        listFood.add(new ObjectItem("Tropical fruit salad","170","https://i.postimg.cc/hj3yq3Qp/temp-Imagem-Yj-RTk.avif"));


        RecyclerView recyclerView = findViewById(R.id.my_recycler_view1);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(this, listFood);
        adapter.setClickListener(MainActivity.this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this,AddToBasket.class);
        intent.putExtra("item",listFood.get(position));
        startActivity(intent);
    }
}
class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentA();
            case 1:
                return new FragmentB();
            case 2:
                return new FragmentC();
            case 3:
                return new FragmentD();
        }
        return new FragmentA();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}