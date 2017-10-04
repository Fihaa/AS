package com.alatheer.anwaralfyaha.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alatheer.anwaralfyaha.Activities.Anshta;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.DataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.ailis.pherialize.MixedArray;
import de.ailis.pherialize.Pherialize;
import ooo.oxo.library.widget.TouchImageView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by elashry on 7/23/2017.
 */

public class adapterEvent extends RecyclerView.Adapter<adapterEvent.ViewHolder> implements View.OnClickListener {

    ArrayList<DataModel> arrayList;
    Context context;
    Anshta anshta;
    DataModel encap = new DataModel();

    PhotoViewAttacher photoViewAttacher;
    public adapterEvent(ArrayList<DataModel> arrayList, Context context, Anshta anshta) {
        this.arrayList = arrayList;
        this.context = context;
        this.anshta = anshta;
    }



    @Override
    public adapterEvent.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        adapterEvent.ViewHolder viewHolder = new adapterEvent.ViewHolder(layout);
        return viewHolder;

    }
/*

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
*/

    @Override
    public void onBindViewHolder(adapterEvent.ViewHolder holder, int position) {
        encap = arrayList.get(position);

        holder.cardView.setTag(position);

        holder.title.setText(encap.getEvent_title());
        MixedArray a = Pherialize.unserialize(encap.getEvent_imgs()).toArray();
   //     Picasso.with(context).load(encap.getEvent_imgs()).into(holder.img);
     //   Picasso.with(context).load(encap.getEvent_imgs()).into(holder.img2);


       // Toast.makeText(getContext(),a.getString(0)+"\n"+a.getString(1), Toast.LENGTH_SHORT).show();

        Picasso.with(context).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(0)).into(holder.img);

        Picasso.with(context).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(1)).into(holder.img2);
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
        TextView title;
        TouchImageView img,img2 ;


        public ViewHolder(View layout) {
            super(layout);

            cardView = (CardView) layout.findViewById(R.id.list_row_containertable);
            img = (TouchImageView) layout.findViewById(R.id.imagetable);
            img2 = (TouchImageView) layout.findViewById(R.id.image2);

            title = (TextView) layout.findViewById(R.id.title1);
            cardView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

//            int position = (int) view.getTag();
//
//            encap = arrayList.get(position);
//
//            Intent intent1 =new Intent(table,detailrable.class);
//
//            intent1.putExtra("title1", encap.getTitletable());
//            intent1.putExtra("image1", encap.getImgtable());
//
//            table.startActivity(intent1);

        }

    }

}
