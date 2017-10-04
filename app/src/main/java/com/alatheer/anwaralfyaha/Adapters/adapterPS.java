package com.alatheer.anwaralfyaha.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alatheer.anwaralfyaha.Activities.PaySchool;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.DataModel;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by elashry on 7/23/2017.
 */

public class adapterPS extends RecyclerView.Adapter<adapterPS.ViewHolder> implements View.OnClickListener {

    ArrayList<DataModel> arrayList;
    Context context;
    PaySchool ps;
    DataModel encap = new DataModel();

    PhotoViewAttacher photoViewAttacher;
    public adapterPS(ArrayList<DataModel> arrayList, Context context, PaySchool ps) {
        this.arrayList = arrayList;
        this.context = context;
        this.ps = ps;
    }



    @Override
    public adapterPS.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ps, parent, false);

        adapterPS.ViewHolder viewHolder = new adapterPS.ViewHolder(layout);
        return viewHolder;

    }
/*

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
*/

    @Override
    public void onBindViewHolder(adapterPS.ViewHolder holder, int position) {
        encap = arrayList.get(position);


        holder.oldleft.setText(encap.getPayset_amount().toString() );
        holder.oldpaid.setText(encap.getPayset_transport());
       /* holder.firsttrans.setText(encap.getPayset_full_pay());
        holder.firstpay.setText(encap.getPayset_student_brother());
        holder.firstpaid.setText(encap.getPayset_stuff_kids());
        holder.secondpay.setText(encap.getPay_set_year());
        holder.secondpaid.setText(encap.getPayset_hijri_year());
*/
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


        public ViewHolder(View layout) {
            super(layout);

            oldleft = (TextView) layout.findViewById(R.id.t1);
            oldpaid = (TextView) layout.findViewById(R.id.t2);
           /* firstpay= (TextView) layout.findViewById(R.id.t3);
            firstpaid = (TextView) layout.findViewById(R.id.t4);
            firsttrans = (TextView) layout.findViewById(R.id.t5);
            secondpay = (TextView) layout.findViewById(R.id.t6);
            secondpaid = (TextView) layout.findViewById(R.id.t7);*/



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
