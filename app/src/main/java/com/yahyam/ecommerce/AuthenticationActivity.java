package com.yahyam.ecommerce;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AuthenticationActivity extends AppCompatActivity {

    String name;
    EditText textName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authentication);

        textName = findViewById(R.id.edit_text_name);


    }

    public void goToMain(View view) {
        if (!textName.getText().toString().equals("")){

            name = textName.getText().toString();
            putSheardPre(name);
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);
        }

    }

    public void putSheardPre(String name){
        // Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
        myEdit.putString("name", name);

// Once the changes have been made, we need to commit to apply those changes made,
// otherwise, it will throw an error
        myEdit.apply();
    }

}