package com.example.elashry.aseer.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elashry.aseer.Activities.Detail;
import com.example.elashry.aseer.Activities.Elmstwa;
import com.example.elashry.aseer.Activities.News;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterExam extends RecyclerView.Adapter<AdapterExam.ViewHolder> implements View.OnClickListener {

    ArrayList<DataEncap> arrayList;
    Context context;
    Elmstwa elmstwa;

    DataEncap encap = new DataEncap();

    public AdapterExam(ArrayList<DataEncap> arrayList, Context context, Elmstwa elmstwa) {
        this.arrayList = arrayList;
        this.context = context;
        this.elmstwa = elmstwa;
    }

    @Override
    public AdapterExam.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table, parent, false);

        ViewHolder viewHolder = new ViewHolder(layout);
        return viewHolder;
    }
/*

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
*/

    @Override
    public void onBindViewHolder(AdapterExam.ViewHolder holder, int position) {
        encap = arrayList.get(position);


        holder.exame.setText(encap.getExam());
        holder.sub.setText(encap.getSub());
        holder.mon.setText(encap.getMon());
        holder.max.setText(encap.getMax());
        holder.min.setText(encap.getMin());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView exame;
        TextView sub;
        TextView mon;
        TextView max;
        TextView min;
        TextView name;


        public ViewHolder(View layout) {
            super(layout);

            exame = (TextView) layout.findViewById(R.id.txtexam1);
            sub = (TextView) layout.findViewById(R.id.txtsub1);
            mon= (TextView) layout.findViewById(R.id.txtmon1);
            max = (TextView) layout.findViewById(R.id.txtmax1);
            min = (TextView) layout.findViewById(R.id.txtmin1);
            name = (TextView) layout.findViewById(R.id.txtname);

        }


        @Override
        public void onClick(View v) {

        }
    }

}
