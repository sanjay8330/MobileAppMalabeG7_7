package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class roomBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roombooking);

        Spinner guidSpinner1 = (Spinner) findViewById(R.id.gspin11);
        ArrayAdapter<String> gAdapter = new ArrayAdapter<String>(roomBooking.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.bType));
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guidSpinner1.setAdapter(gAdapter);

        Spinner guidSpinner2 = (Spinner) findViewById(R.id.gspin22);
        ArrayAdapter<String> gAdapter1 = new ArrayAdapter<String>(roomBooking.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.bType1));
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guidSpinner2.setAdapter(gAdapter1);

        Spinner guidSpinner3 = (Spinner) findViewById(R.id.gspin33);
        ArrayAdapter<String> gAdapter2 = new ArrayAdapter<String>(roomBooking.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.bType2));
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guidSpinner3.setAdapter(gAdapter2);
    }
}