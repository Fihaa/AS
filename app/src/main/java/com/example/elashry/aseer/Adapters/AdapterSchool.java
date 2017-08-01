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
import android.widget.Toast;

import com.example.elashry.aseer.Activities.Arcmenu;
import com.example.elashry.aseer.Activities.Detail;
import com.example.elashry.aseer.Activities.Home;
import com.example.elashry.aseer.Activities.News;
import com.example.elashry.aseer.Activities.School;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AdapterSchool extends RecyclerView.Adapter<AdapterSchool.ViewHolder> implements View.OnClickListener {

    ArrayList<DataEncap> arrayList;
    Context context;
    Arcmenu arc;
    Home school;
   public static ArrayList<String> idsc;
    public static String namesc,phonesc,emailsc ,faxsc,addressc,scid;

    DataEncap encap = new DataEncap();

    public AdapterSchool(ArrayList<DataEncap> arrayList, Context context, Arcmenu arc) {
        this.arrayList = arrayList;
        this.context = context;
        this.arc = arc;
    }
    public AdapterSchool(ArrayList<DataEncap> arrayList, Context context, Home school) {
        this.arrayList = arrayList;
        this.context = context;
        this.school = school;
    }


    @Override
    public AdapterSchool.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.sc_item, parent, false);

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
    public void onBindViewHolder(AdapterSchool.ViewHolder holder, int position) {
        encap = arrayList.get(position);

       /* holder.cardView.setTag(position);

        holder.textTitle.setText(encap.getTitle());
        holder.textDesc.setText(encap.getDesc());
        Picasso.with(context).load(encap.getImg()).into(holder.imageNews);

        String v = encap.getDate();
        Long v2 = Long.parseLong(v);
        String dateFormat = new SimpleDateFormat("dd /MM/yyyy").format(v2);
        holder.date.setText(dateFormat);
*/
        holder.t1.setText(encap.getSchool_name());
        holder.t2.setText(encap.getSchool_adress());
        holder.t3.setText(encap.getSchool_fax());
        holder.t4.setText(encap.getSchool_email());
        holder.t5.setText(encap.getSchool_phone());
        holder.t6.setText(encap.getSchool_latitude());
        holder.t7.setText(encap.getSchool_longitude());
        holder.t8.setText(encap.getSchool_id());

        namesc=encap.getSchool_name();
        phonesc=encap.getSchool_phone();
        addressc=encap.getSchool_adress();
        faxsc=encap.getSchool_fax();
        emailsc=encap.getSchool_email();
        scid= (String) holder.t8.getText();




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView t1,t2,t3,t4 ,t5,t6,t7,t8;



        public ViewHolder(View layout) {
            super(layout);

//            cardView = (CardView) layout.findViewById(R.id.list_row_container);
//            imageNews = (ImageView) layout.findViewById(R.id.imgnews);
//            textTitle = (TextView) layout.findViewById(R.id.titnews);
//            textDesc = (TextView) layout.findViewById(R.id.detailnews);
//            date= (TextView) layout.findViewById(R.id.datnews);
//            cardView.setOnClickListener(this);


            t1= (TextView) layout.findViewById(R.id.t1);
            t2= (TextView) layout.findViewById(R.id.t2);
            t3= (TextView) layout.findViewById(R.id.t3);
            t4= (TextView) layout.findViewById(R.id.t4);
            t5= (TextView) layout.findViewById(R.id.t5);
            t6= (TextView) layout.findViewById(R.id.t6);
            t7= (TextView) layout.findViewById(R.id.t7);
            t8= (TextView) layout.findViewById(R.id.t8);

        }

        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();

            encap = arrayList.get(position);

//            Intent intent = new Intent(news, Detail.class);
//
//            String v = encap.getDate();
//            Long v2 = Long.parseLong(v);
//            String dateFormat = new SimpleDateFormat("dd /MM/yyyy").format(v2);
//
//            intent.putExtra("title", encap.getTitle());
//            intent.putExtra("desc", encap.getDesc());
//            intent.putExtra("date", dateFormat);
//            intent.putExtra("image", encap.getImg());
//
//            news.startActivity(intent);

        }

    }

}
