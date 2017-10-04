package com.alatheer.anwaralfyaha.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alatheer.anwaralfyaha.Activities.Notification;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.NotifyModel;

import java.util.ArrayList;


public class AdapterNotify extends RecyclerView.Adapter<AdapterNotify.ViewHolder> implements View.OnClickListener {

    ArrayList<NotifyModel> arrayList;
    Context context;
    Notification notification;
    public static String s;

    public static String x,y,z;

    NotifyModel nmodel = new NotifyModel();

    public AdapterNotify(ArrayList<NotifyModel> arrayList, Context context, Notification notification) {
        this.arrayList = arrayList;
        this.context = context;
        this.notification = notification;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notif, parent, false);

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
        nmodel = arrayList.get(position);

        holder.payment.setText(nmodel.getInvoice_payment());
        holder.left.setText(nmodel.getInvoice_left());
        holder.date.setText(nmodel.getInvoice_date());

        x=nmodel.getInvoice_payment();
        y=nmodel.getInvoice_left();
        z=nmodel.getInvoice_date();



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView payment;
        TextView left;
        TextView date;



        public ViewHolder(View layout) {
            super(layout);

            payment = (TextView) layout.findViewById(R.id.pay);
            left = (TextView) layout.findViewById(R.id.left);
            date = (TextView) layout.findViewById(R.id.date);


        }


        @Override
        public void onClick(View v) {

        }
    }

}
