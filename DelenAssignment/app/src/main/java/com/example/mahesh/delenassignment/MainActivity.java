package com.example.mahesh.delenassignment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference myRef;
    FirebaseDatabase database;
    private StorageReference mStorageRef;
    private static final String TAG = "taggers";
    List<Bill> billList;
    RecyclerView recyclerView;
    MyOrdersRecyclerView myOrdersRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("My Orders");
        }




        recyclerView = findViewById(R.id.recyclerView);

        billList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();
        myRef = database.getReference("My Orders");

        Log.d(TAG, "onCreate: "+myRef.toString());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    billList.add(dataSnapshot1.getValue(Bill.class));
                }
                Log.d(TAG, "onDataChange: "+billList.get(1).getId());
                myOrdersRecyclerView = new MyOrdersRecyclerView(getApplicationContext(),billList);
                recyclerView.setAdapter(myOrdersRecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Log.d(TAG, "onDataChange:sdsdsd "+billList.toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

}
