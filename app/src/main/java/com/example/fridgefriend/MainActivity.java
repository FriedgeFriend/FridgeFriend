package com.example.fridgefriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridgefriend.data.model.Ingredient;
import com.example.fridgefriend.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private List<Ingredient> mIngredientList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private String[] mIngredientsArray;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final String TESTER = "com.example.android.fridgefriend.MESSAGE";
    public static final int TEXT_REQUEST = 1; // Unique tag for the intent reply
    private EditText mMessageEditText;

    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity(this);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(getListData());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        Log.d(LOG_TAG, "BIGTEST");

    }

    private List<Ingredient> getListData() {

        mIngredientsArray = getResources().getStringArray(R.array.ingredients);
        mIngredientList = new ArrayList<>();
        for (int i = 0; i < mIngredientsArray.length; i++) {
            mIngredientList.add(new Ingredient(mIngredientsArray[i]));
        }
        Log.d(LOG_TAG, "VALUE" + String.valueOf(mIngredientList.get(0)));
        return mIngredientList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);
                return true;
            case R.id.action_recipe:
                Intent intentUpload = new Intent(this, UploadRecipeActivity.class);
                startActivity(intentUpload);
                return true;
            case R.id.action_fprofile:
                Intent intentFProfile= new Intent(this, RecipeActivity.class);
                startActivity(intentFProfile);
                return true;
            case R.id.action_settings:
                Intent intentSettings = new Intent(this, SettingsActivity.class);
                startActivity(intentSettings);
                return true;
            case R.id.action_search:
                // search page for word
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    public void launchSecondActivity(View.OnClickListener view) {
        String text = "";
        for (Ingredient ingredient : mIngredientList) {
            if (ingredient.isSelected()) {
                text += ingredient.getText();
            }
        }
        Log.d(LOG_TAG, "Output: " + text);
        Log.d(LOG_TAG, "Button clicked!");
        // startActivityForResult(intent, TEXT_REQUEST);
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(TESTER, "hello");
        startActivity(intent);
    }

//    public void trackItems(View view){
//        count++;
//        Snackbar.make(view, "Item Selected", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
//        Log.d(LOG_TAG, "Count" + count);
//    }

}
