package com.example.elashry.aseer.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elashry.aseer.Activities.Works;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.DataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by elashry on 7/13/2017.
 */


public class AdapterWork extends RecyclerView.Adapter<AdapterWork.ViewHolder> implements View.OnClickListener {

    ArrayList<DataModel> arrayList;
    Context context;
    Works works;
    DataModel encap = new DataModel();
    public AdapterWork(ArrayList<DataModel> arrayList, Context context, Works works) {
        this.arrayList = arrayList;
        this.context = context;
        this.works = works;
    }



    @Override
    public AdapterWork.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

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
    public void onBindViewHolder(AdapterWork.ViewHolder holder, int position) {
        encap = arrayList.get(position);

//        holder.cardView.setTag(position);

        holder.wid.setText(encap.getWid());
        Picasso.with(context).load(encap.getImgwork()).into(holder.imgwork);
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
        ImageView imgwork ;
        TextView wid;

        public ViewHolder(View layout) {
            super(layout);

            cardView = (CardView) layout.findViewById(R.id.list_row_container);
            imgwork= (ImageView) layout.findViewById(R.id.imagetable);
            wid = (TextView) layout.findViewById(R.id.title1);


        }


        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();

            encap = arrayList.get(position);

           /* Intent intent1 = new Intent(table, Detail.class);

            intent1.putExtra("title1", encap.getTitle());
            intent1.putExtra("image1", encap.getImg());

            table.startActivity(intent1);*/

        }

    }

}
