package com.example.elashry.aseer.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.elashry.aseer.Adapters.adapterPS;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataModel;
import com.example.elashry.aseer.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.example.elashry.aseer.Activities.Arcmenu.x;
import static com.example.elashry.aseer.Adapters.AdapterSchool.addresssc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.emailsc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.faxsc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.idsc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.latitude;
import static com.example.elashry.aseer.Adapters.AdapterSchool.longitude;
import static com.example.elashry.aseer.Adapters.AdapterSchool.namesc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.phonesc;
import static com.example.elashry.aseer.dataProccess.JsonParser.amount;


public class PaySchool extends AppCompatActivity {
    final static String api = "http://wefakhail.org/fihaa/api/schoolpayment";
   // final static String apiS = "http://wefakhail.org/fihaa/api/schools";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private adapterPS adapter;
    public static Double slatitude;
    public static Double slongitude;

    // public static String sp;
  public static   ArrayList<String> scp;
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
       //   sp = ii.getStringExtra("i");

        scp=new ArrayList<>();
        scp.add( ii.getStringExtra("i1"));
      //  scp.add( ii.getStringExtra("i2"));
       // scp.add( ii.getStringExtra("i3"));
        scp.add( ii.getStringExtra("i4"));
        scp.add( ii.getStringExtra("i5"));
       scp.add( ii.getStringExtra("i6"));
//        Toast.makeText(this, idsc +"", Toast.LENGTH_SHORT).show();
     //   Toast.makeText(this, idsc.get(3) +"", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, scp +"", Toast.LENGTH_SHORT).show();
//       Toast.makeText(this, idsc +"", Toast.LENGTH_SHORT).show();
//
//        Toast.makeText(this, idsc.get(0) +"", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, idsc.get(6) +"", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, idsc.get(3) +"", Toast.LENGTH_SHORT).show();

        if(scp.contains(idsc.get(0))){
            name.setText(namesc.get(0));
//            Toast.makeText(this, scp +"", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, idsc.get(0) +"", Toast.LENGTH_SHORT).show();
            //      Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc.get(0));
            address.setText(addresssc.get(0));
            email.setText(emailsc.get(0));
            fax.setText(faxsc.get(0));
            slatitude=latitude.get(0);
            slongitude=longitude.get(0);
            x=false;

        }
        else if (scp.contains(idsc.get(6))) {
            name.setText(namesc.get(6));
//            Toast.makeText(this, scp +"", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, idsc.get(6) +"", Toast.LENGTH_SHORT).show();
      //      Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc.get(6));
            address.setText(addresssc.get(6));
            email.setText(emailsc.get(6));
            fax.setText(faxsc.get(6));
            slatitude=latitude.get(6);
            slongitude=longitude.get(6);
            x=false;
        }
        else if (scp.contains(idsc.get(3))) {
            name.setText(namesc.get(3));
//            Toast.makeText(this, scp +"", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, idsc.get(3) +"", Toast.LENGTH_SHORT).show();
            //      Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc.get(3));
            address.setText(addresssc.get(3));
            email.setText(emailsc.get(3));
            fax.setText(faxsc.get(3));
            slatitude=latitude.get(3);
            slongitude=longitude.get(3);
            x=false;
        }

        else if (scp.contains(idsc.get(9))) {
            name.setText(namesc.get(9));
//            Toast.makeText(this, scp +"", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, idsc.get(3) +"", Toast.LENGTH_SHORT).show();
            //      Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc.get(9));
            address.setText(addresssc.get(9));
            email.setText(emailsc.get(9));
            fax.setText(faxsc.get(9));
            slatitude=latitude.get(9);
            slongitude=longitude.get(9);
            x=false;
        }
//        phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String p= (String) phone.getText();
//
//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(p));
//                startActivity(intent);
//            }
//        });
//
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaySchool.this, MapsActivity.class);
                startActivity(intent);
            }
        });

       /* else if (idsc.get(3).equals(scp)) { name.setText(namesc);
            Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc);
            address.setText(addressc);
            email.setText(emailsc);
            fax.setText(faxsc);}
        else if (idsc.get(3).equals(scp)) { name.setText(namesc);
            Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc);
            address.setText(addressc);
            email.setText(emailsc);
            fax.setText(faxsc);}
        else if (idsc.get(3).equals(scp)) { name.setText(namesc);
            Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc);
            address.setText(addressc);
            email.setText(emailsc);
            fax.setText(faxsc);}*/

       // Toast.makeText(this, sp, Toast.LENGTH_SHORT).show();
        Connector connector = new Connector();

        try {

            ArrayList<DataModel> arraymList = parser.JsonProcessPs(connector.execute(api).get());
           // Toast.makeText(this, ""+amount, Toast.LENGTH_SHORT).show();
           //  Toast.makeText(this, ""+namesc, Toast.LENGTH_SHORT).show();

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
        Intent i=new Intent(this,Home.class);
        startActivity(i);
        return true;
    }



}

