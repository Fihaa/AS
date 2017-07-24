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
import com.example.elashry.aseer.Activities.News;
import com.example.elashry.aseer.Activities.Sharf;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.DataModel;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AdapterSharf extends RecyclerView.Adapter<AdapterSharf.ViewHolder> implements View.OnClickListener {

    ArrayList<DataModel> arrayList;
    Context context;
    Sharf sharf;

    DataModel encap = new DataModel();

    public AdapterSharf(ArrayList<DataModel> arrayList, Context context, Sharf sharf) {
        this.arrayList = arrayList;
        this.context = context;
        this.sharf = sharf;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);

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

        holder.cardView.setTag(position);

        holder.textTitle.setText(encap.getSharaf_name());
        holder.textDesc.setText(encap.getSharaf_rank());
        Picasso.with(context).load(encap.getSharaf_img()).into(holder.imageNews);



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardView;
        ImageView imageNews;
        TextView textTitle;
        TextView textDesc;
        


        public ViewHolder(View layout) {
            super(layout);

            cardView = (CardView) layout.findViewById(R.id.list_row_container);
            imageNews = (ImageView) layout.findViewById(R.id.imgnews);
            textTitle = (TextView) layout.findViewById(R.id.titnews);
            textDesc = (TextView) layout.findViewById(R.id.detailnews);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();

           encap = arrayList.get(position);
/*
            Intent intent = new Intent(sharf, Detail.class);

            

            intent.putExtra("title", encap.getSharaf_name());
            intent.putExtra("desc", encap.getSharaf_rank());
            intent.putExtra("image", encap.getSharaf_img());

            sharf.startActivity(intent);*/

        }

    }

}
