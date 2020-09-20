package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ViewRooms extends AppCompatActivity {

    DatabaseReference db;
    ListView listView;
    ArrayList<String> arraylist = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    Button btndel;
    Module module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rooms);
        db = FirebaseDatabase.getInstance().getReference().child("Rooms");
        listView = (ListView) findViewById(R.id.list);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist);
        listView.setAdapter(arrayAdapter);
        module=(Module)getApplicationContext();
        btndel =(Button)findViewById(R.id.btndelete);

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String det = dataSnapshot.getValue(RoomModel.class).getDetails();
                arraylist.add(det);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                module.setGetRoomID(arraylist.get(position));
                String tempid = module.getGetRoomID().substring(9,11);

                //Toast.makeText(module, "ID is "+tempid, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ViewRooms.this,EditRooms.class);
                intent.putExtra("RoomID",tempid);
                startActivity(intent);
            }
        });

        /*btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String str = module.getGetRoomID().substring(9,11).trim();
                if (str=="") {
                    Toast.makeText(ViewRooms.this, "Please select an item before Delete", Toast.LENGTH_SHORT).show();
                }else{
                    db.child("Rooms").child(str).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            db.child(str).removeValue();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    Toast.makeText(ViewRooms.this, "Room is deleted!!!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ViewRooms.class);
                    startActivity(intent);
                }
            }
        });*/
    }
}