package com.yahyam.ecommerce;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddToBasket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_to_basket);

        ObjectItem objectItem = (ObjectItem) getIntent().getSerializableExtra("item");

        Toast.makeText(this, "name "+objectItem.getName(), Toast.LENGTH_SHORT).show();


    }
}