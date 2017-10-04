package com.alatheer.anwaralfyaha.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alatheer.anwaralfyaha.Activities.Table;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.DataEncap;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ooo.oxo.library.widget.TouchImageView;
import uk.co.senab.photoview.PhotoViewAttacher;


public class AdapterTable extends RecyclerView.Adapter<AdapterTable.ViewHolder> implements View.OnClickListener {

    ArrayList<DataEncap> arrayList;
    Context context;
    Table table;
    DataEncap encap = new DataEncap();

    PhotoViewAttacher photoViewAttacher;
    public AdapterTable(ArrayList<DataEncap> arrayList, Context context, Table table) {
        this.arrayList = arrayList;
        this.context = context;
        this.table = table;
    }



    @Override
    public AdapterTable.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

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
    public void onBindViewHolder(AdapterTable.ViewHolder holder, int position) {
        encap = arrayList.get(position);

        holder.cardView.setTag(position);

        holder.title.setText(encap.getTitletable());
        Picasso.with(context).load(encap.getImgtable()).into(holder.img);
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
        TouchImageView img ;


        public ViewHolder(View layout) {
            super(layout);

            cardView = (CardView) layout.findViewById(R.id.list_row_containertable);
            img = (TouchImageView) layout.findViewById(R.id.imagetable);
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
