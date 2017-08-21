package com.example.elashry.aseer.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elashry.aseer.Activities.Rsoom;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.DataModel;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by elashry on 7/19/2017.
 */

public class AdapterPayment extends RecyclerView.Adapter<AdapterPayment.ViewHolder> implements View.OnClickListener {

        ArrayList<DataModel> arrayList;
        Context context;
        Rsoom rsoom;

        DataModel model = new DataModel();

public AdapterPayment(ArrayList<DataModel> arrayList, Context context, Rsoom rsoom) {
        this.arrayList = arrayList;
        this.context = context;
        this.rsoom = rsoom;
        }



    @Override
public AdapterPayment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (Locale.getDefault().getLanguage().equals("en")) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pay, parent, false);

            ViewHolder viewHolder = new ViewHolder(layout);
            return viewHolder;        } else {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.eitem_pay, parent, false);

            ViewHolder viewHolder = new ViewHolder(layout);
            return viewHolder;        }

        }
/*

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
*/

@Override
public void onBindViewHolder(AdapterPayment.ViewHolder holder, int position) {
        model = arrayList.get(position);


        holder.oldleft.setText(model.getOld_left());
        holder.oldpaid.setText(model.getOld_left_paid());
//        holder.firstpay.setText(model.getFirst_class_payment());
//        holder.firstpaid.setText(model.getFirst_class_paid());
        holder.firsttrans.setText(model.getFirst_transport());
//        holder.secondpay.setText(model.getSecond_class_payment());
//        holder.secondpaid.setText(model.getSecond_class_paid());
        holder.secondtrans.setText(model.getSecond_transport());
        }

@Override
public int getItemCount() {
        return arrayList.size();
        }

@Override
public void onClick(View v) {

        }

class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView oldleft;
    TextView oldpaid;
    TextView firstpay;
    TextView firstpaid;
    TextView firsttrans;
    TextView secondpay;
    TextView secondpaid;
    TextView secondtrans;

    public ViewHolder(View layout) {
        super(layout);

        oldleft = (TextView) layout.findViewById(R.id.oldleft);
        oldpaid = (TextView) layout.findViewById(R.id.oldleftpaid);
     //   firstpay= (TextView) layout.findViewById(R.id.firstpay);
       // firstpaid = (TextView) layout.findViewById(R.id.firstpaid);
        firsttrans = (TextView) layout.findViewById(R.id.trans);
       // secondpay = (TextView) layout.findViewById(R.id.secondpay);
       // secondpaid = (TextView) layout.findViewById(R.id.secondpaid);
        secondtrans = (TextView) layout.findViewById(R.id.secondtrans);

    }


    @Override
    public void onClick(View v) {

    }
}

}