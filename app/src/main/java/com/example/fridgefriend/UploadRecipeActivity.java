package com.example.fridgefriend;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

public class UploadRecipeActivity extends MainActivity implements AdapterView.OnItemSelectedListener {

    private static final String LOG_TAG = UploadRecipeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_recipe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Recipe Submitted For Review", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // spinner for time unit selection
        Spinner spinnerTime = findViewById(R.id.label_spinner);
        if (spinnerTime != null) {
            spinnerTime.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        if (spinnerTime != null) {
            spinnerTime.setAdapter(adapter);
        }
    }

    // Interface callback for when any spinner item is selected.
    @Override
    public void onItemSelected(AdapterView<?> adapterView,
                               View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        Log.d(LOG_TAG,"spinner time unit selected: " + spinnerLabel);
    }

    // Interface callback for when no spinner item is selected.
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing.
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_peanuts:
                if (checked) {
                    Log.d(LOG_TAG,"Peantus checkbox selected");
                } else {
                    // Remove the meat
                } break;
            case R.id.checkbox_gluten:
                Log.d(LOG_TAG,"Gluten checkbox selected");
                break;
            case R.id.checkbox_meat:
                Log.d(LOG_TAG,"Meat checkbox selected");
                break;
            case R.id.checkbox_dairy:
                Log.d(LOG_TAG,"Dairy checkbox selected");
                break;
            // TODO: Veggie sandwich
        }
    }

}
