package com.example.mahesh.delenassignment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyOrdersRecyclerView extends RecyclerView.Adapter<MyOrdersRecyclerView.ViewHolder>{

    private Context context;
    private List<Bill> billList;
    URL url;

    public MyOrdersRecyclerView(Context context, List<Bill> billList) {
        this.context = context;
        this.billList = billList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        TextView date, status, bill_no, service;
        LinearLayout entryLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.icon);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
            bill_no = itemView.findViewById(R.id.bill_no);
            service = itemView.findViewById(R.id.service);
            entryLayout = itemView.findViewById(R.id.entry_layout);

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.adapter_list_front_page, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Bill bill = billList.get(position);
        Picasso.get().load(bill.getImageUrl()).into(holder.circleImageView);
        holder.date.setText(bill.getDate());
        holder.status.setText(bill.getStatus());
        holder.bill_no.setText(String.valueOf(bill.getBill_no()));
        holder.service.setText(bill.getService());

        holder.entryLayout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, BillActivity.class);
                        intent.putExtra("KEY",bill.getId());
                        context.startActivity(intent);

                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return billList.size();
    }

    class Asycn extends AsyncTask<Void,Bitmap,Void>{
        Bill bill;
        ViewHolder holder;

        Asycn(Bill bill, ViewHolder holder){
            this.bill = bill;
            this.holder = holder;
        }
        @Override
        protected Void doInBackground(Void[] objects) {
            try {

                url = new URL(bill.getImageUrl());
                Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                publishProgress(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Bitmap... values) {
            holder.circleImageView.setImageBitmap(values[0]);

        }
    }

}
