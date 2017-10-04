package com.alatheer.anwaralfyaha.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alatheer.anwaralfyaha.Activities.ghyaab;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.DataEncap;

import java.util.ArrayList;


public class AdapterAbsent extends RecyclerView.Adapter<AdapterAbsent.ViewHolder> implements View.OnClickListener {

    ArrayList<DataEncap> arrayList;
    Context context;
    ghyaab ghyeeb;
    public static String s;

    DataEncap encap = new DataEncap();

    public AdapterAbsent(ArrayList<DataEncap> arrayList, Context context, ghyaab ghyaab) {
        this.arrayList = arrayList;
        this.context = context;
        this.ghyeeb = ghyaab;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.absent, parent, false);

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        encap = arrayList.get(position);

        holder.sudname.setText(encap.getSudname());
        holder.attenstatue.setText(encap.getAttstatue());
        holder.absentdate.setText(encap.getAbsentdate());
        s=encap.getAttstatue();




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView sudname;
        TextView attenstatue;
        TextView absentdate;



        public ViewHolder(View layout) {
            super(layout);

            sudname = (TextView) layout.findViewById(R.id.sudname);
            attenstatue = (TextView) layout.findViewById(R.id.attstatue);
            absentdate = (TextView) layout.findViewById(R.id.absdate);


        }


        @Override
        public void onClick(View v) {

        }
    }

}
