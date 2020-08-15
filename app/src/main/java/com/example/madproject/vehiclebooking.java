package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class vehiclebooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehiclebooking);

        Spinner guidSpinner1 = (Spinner) findViewById(R.id.gspin111);
        ArrayAdapter<String> gAdapter = new ArrayAdapter<String>(vehiclebooking.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.vType));
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guidSpinner1.setAdapter(gAdapter);

        Spinner guidSpinner2 = (Spinner) findViewById(R.id.gspin222);
        ArrayAdapter<String> gAdapter1 = new ArrayAdapter<String>(vehiclebooking.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.vType1));
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guidSpinner2.setAdapter(gAdapter1);

        Spinner guidSpinner3 = (Spinner) findViewById(R.id.gspin333);
        ArrayAdapter<String> gAdapter2 = new ArrayAdapter<String>(vehiclebooking.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.vType2));
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guidSpinner3.setAdapter(gAdapter2);
    }
}