package com.example.mahesh.delenassignment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class BillActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myRef;
    private StorageReference mStorageRef;
    private Bill bill;
    private static final String TAG = "34e";
    private TextView service,date,status,address,isJobAssigned,rate,SGST,CGST,discount,grandTotal;
    private TextView startTime,endTime,totalTime,paymentStatus,requireFor,requiredWhere;
    private CircleImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        setReferences();
        mStorageRef = FirebaseStorage.getInstance().getReference();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("My Orders");
        Intent intent = getIntent();
        final int key = intent.getIntExtra("KEY",0);
        Log.d(TAG, "onCreate: "+key);

        myRef.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        bill = dataSnapshot.child(String.valueOf(key)).getValue(Bill.class);

                        setData(bill);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );

    }

    private void setReferences(){
        service = findViewById(R.id.service);
        date = findViewById(R.id.date);
        status = findViewById(R.id.status);
        address = findViewById(R.id.address);
        isJobAssigned = findViewById(R.id.isJobAssigned);
        rate = findViewById(R.id.rate);
        SGST = findViewById(R.id.SGST);
        CGST = findViewById(R.id.CGST);
        icon  = findViewById(R.id.icon);
        discount = findViewById(R.id.discount);
        grandTotal = findViewById(R.id.grandTotal);
        startTime = findViewById(R.id.startTime);
        endTime = findViewById(R.id.endTime);
        totalTime = findViewById(R.id.totalTime);
        paymentStatus = findViewById(R.id.paymentStatus);
        requireFor = findViewById(R.id.requiredFor);
        requiredWhere = findViewById(R.id.requiredWhere);
    }

    private void setData(Bill bill){
        service.setText(bill.getService());
        date.setText(bill.getDate());
        status.setText(bill.getStatus());
        address.setText(bill.getAddress().formatAddress());
        isJobAssigned.setText(bill.getJob_status());
        rate.setText(bill.getRate());
        SGST.setText("\u20b9 "+String.valueOf(bill.getTax().getSgst()));
        CGST.setText("\u20b9 "+String.valueOf(bill.getTax().getCgst()));
        Picasso.get().load(bill.getImageUrl()).into(icon);
//        discount.setText(bill.getDiscount());
        grandTotal.setText("\u20b9 "+String.valueOf(bill.getGrand_total()));
        startTime.setText(bill.getStart_time());
        endTime.setText(bill.getEnd_time());
        totalTime.setText(bill.getTotal_time());
        paymentStatus.setText(bill.getPayment_status());
        requireFor.setText(bill.getRequired_for());
        requiredWhere.setText(bill.getRequired_where());

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("BN "+String.valueOf(bill.getBill_no()));
        }
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
