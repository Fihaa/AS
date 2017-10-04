package com.alatheer.anwaralfyaha.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.alatheer.anwaralfyaha.Adapters.adapterPS;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.Connector;
import com.alatheer.anwaralfyaha.dataProccess.DataModel;
import com.alatheer.anwaralfyaha.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.alatheer.anwaralfyaha.Activities.Arcmenu.x;
import static com.alatheer.anwaralfyaha.Adapters.AdapterSchool.addresssc;
import static com.alatheer.anwaralfyaha.Adapters.AdapterSchool.emailsc;
import static com.alatheer.anwaralfyaha.Adapters.AdapterSchool.faxsc;
import static com.alatheer.anwaralfyaha.Adapters.AdapterSchool.idsc;
import static com.alatheer.anwaralfyaha.Adapters.AdapterSchool.latitude;
import static com.alatheer.anwaralfyaha.Adapters.AdapterSchool.longitude;
import static com.alatheer.anwaralfyaha.Adapters.AdapterSchool.namesc;
import static com.alatheer.anwaralfyaha.Adapters.AdapterSchool.phonesc;
import static com.alatheer.anwaralfyaha.dataProccess.JsonParser.amount;


public class PaySchool extends AppCompatActivity {
    final static String api = "http://anwaralfyaha.com/api/schoolpayment";
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
        else if (scp.contains(idsc.get(1))) {
            name.setText(namesc.get(1));
//            Toast.makeText(this, scp +"", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, idsc.get(1) +"", Toast.LENGTH_SHORT).show();
      //      Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc.get(1));
            address.setText(addresssc.get(1));
            email.setText(emailsc.get(1));
            fax.setText(faxsc.get(1));
            slatitude=latitude.get(1);
            slongitude=longitude.get(1);
            x=false;
        }
        else if (scp.contains(idsc.get(2))) {
            name.setText(namesc.get(2));
//            Toast.makeText(this, scp +"", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, idsc.get(2) +"", Toast.LENGTH_SHORT).show();
            //      Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc.get(2));
            address.setText(addresssc.get(2));
            email.setText(emailsc.get(2));
            fax.setText(faxsc.get(2));
            slatitude=latitude.get(2);
            slongitude=longitude.get(2);
            x=false;
        }

        else if (scp.contains(idsc.get(4))) {
            name.setText(namesc.get(4));
//            Toast.makeText(this, scp +"", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, idsc.get(3) +"", Toast.LENGTH_SHORT).show();
//      Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();
            phone.setText(phonesc.get(4));
            address.setText(addresssc.get(4));
            email.setText(emailsc.get(4));
            fax.setText(faxsc.get(4));
            slatitude=latitude.get(4);
            slongitude=longitude.get(4);
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

