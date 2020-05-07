package com.example.fridgefriend;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class RecipeActivity extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.TESTER);
        Log.d("BLAH", "TESTER: " + message);

    }
}
