package com.example.elashry.aseer.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elashry.aseer.Adapters.adapterPS;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.example.elashry.aseer.dataProccess.DataModel;
import com.example.elashry.aseer.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.example.elashry.aseer.Adapters.AdapterSchool.addressc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.emailsc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.faxsc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.namesc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.phonesc;
import static com.example.elashry.aseer.dataProccess.JsonParser.amount;



public class PaySchool extends AppCompatActivity {
    final static String api = "http://wefakhail.org/fihaa/api/schoolpayment";
   // final static String apiS = "http://wefakhail.org/fihaa/api/schools";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private adapterPS adapter;
    public static String sp;
    TextView name,phone ,address,email ,fax ,t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_school);

         t1= (TextView) findViewById(R.id.t11);
         t2= (TextView) findViewById(R.id.t22);
         name= (TextView) findViewById(R.id.namesc);
         phone= (TextView) findViewById(R.id.phonesc);
         address= (TextView) findViewById(R.id.address);
         email= (TextView) findViewById(R.id.email);
         fax= (TextView) findViewById(R.id.fax);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        Intent ii = getIntent();
         sp = ii.getStringExtra("i");
        Toast.makeText(this, sp, Toast.LENGTH_SHORT).show();
        Connector connector = new Connector();

        try {

            ArrayList<DataModel> arraymList = parser.JsonProcessPs(connector.execute(api).get());
           // Toast.makeText(this, ""+amount, Toast.LENGTH_SHORT).show();
            t1.setText( (amount/2)+"");
            t2.setText( (amount/2)+"");

            recyclerMain();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

      /*  try {
            parser.JsonProcessschool(connector.execute(apiS).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        name.setText(namesc);
        phone.setText(phonesc);
        address.setText(addressc);
        email.setText(emailsc);
        fax.setText(faxsc);
//        Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, phonesc
//                , Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, addressc, Toast.LENGTH_SHORT).show();

    }
    private void recyclerMain() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new adapterPS(parser.getmlist(), getApplicationContext(), this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter.notifyDataSetChanged();

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

