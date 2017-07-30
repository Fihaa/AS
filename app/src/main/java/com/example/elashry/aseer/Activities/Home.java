package com.example.elashry.aseer.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.elashry.aseer.Adapters.AdapterSchool;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.example.elashry.aseer.dataProccess.JsonParser;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.szugyi.circlemenu.view.CircleImageView;
import com.szugyi.circlemenu.view.CircleLayout;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import static com.example.elashry.aseer.Activities.Login.editor;
import static com.example.elashry.aseer.Activities.Select.x;
import static com.example.elashry.aseer.Activities.Select.y;

public class Home extends AppCompatActivity implements CircleLayout.OnItemClickListener, CircleLayout.OnRotationFinishedListener {
    protected CircleLayout circleLayout;
    private Effectstype effect;
    ProgressDialog progressDialog;
    public static  String s ,n;
    final static String api = "http://wefakhail.org/fihaa/api/schools";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private AdapterSchool adapter;
    //private float angle = 90;

Button out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Locale.getDefault().getLanguage().equals("en")) {
            setContentView(R.layout.econtent_home);

        } else {
            setContentView(R.layout.activity_home);


        }
        circleLayout = (CircleLayout) findViewById(R.id.circle);
        circleLayout.setOnItemClickListener(this);
        Intent i = getIntent();
        s = i.getStringExtra("id");
        n = i.getStringExtra("name");


        Intent ii = getIntent();
        s = ii.getStringExtra("id");
        n = ii.getStringExtra("name");
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);


        //  circleLayout.setOnRotationFinishedListener(this);
        out = (Button) findViewById(R.id.btn_out);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  editor.remove("idName"); // will delete key key_name3

                finish();


            }
        });

     //   if (y.equals("2")|y.equals("3")) {


            //  Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

      /*  Connector connector = new Connector();

        try {

            ArrayList<DataEncap> arrayList = parser.JsonProcessschool(connector.execute(api).get());
          //  Toast.makeText(this,arrayList.toString(), Toast.LENGTH_SHORT).show();

            recyclerMain();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    else {}}
    private void recyclerMain() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    adapter = new AdapterSchool(parser.getlist(), getApplicationContext(), this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter.notifyDataSetChanged();


    }*/
        }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onItemClick(View view) {
        String name = null;
//        if (view instanceof CircleImageView) {
//            name = ((CircleImageView) view).getName();
//            // The angle where the first menu item will be drawn
//
//        }
    //   Toast.makeText(this, "select "+name, Toast.LENGTH_SHORT).show();


        if (isOnline()){

            if (x==false ){

        switch (view.getId()) {

            case R.id.activity:
                Intent i1 =new Intent(Home.this,Anshta.class);
                showProgress(view);
                startActivity(i1);
                break;
            case R.id.apsent:
                if (y.equals("2")|y.equals("3")) {

                    Intent i2 = new Intent(Home.this, ghyaab.class);
                    showProgress(view);
                    startActivity(i2);
                }else {}
                break;
            case R.id.arrive:
                Intent i3 =new Intent(Home.this,MapsActivity.class);
                showProgress(view);

                startActivity(i3);

                break;
            case R.id.rsoom:
                if(y.equals("2")|y.equals("3")){
                    Intent ii =new Intent(Home.this,Rsoom.class);
                    showProgress(view);

                    startActivity(ii);
                }else {
                    if (y.equals("1")){
                    Intent i4 =new Intent(Home.this,WebViiew.class);
                    showProgress(view);

                    startActivity(i4);}
                }

                break;
            case R.id.sharf:
                Intent i5 =new Intent(Home.this,Sharf.class);
                showProgress(view);

                startActivity(i5);
                break;
            case R.id.state:
                if (y.equals("2")|y.equals("3")) {
                    Intent i6 = new Intent(Home.this, Elmstwa.class);
                    showProgress(view);

                    startActivity(i6);
                }else {}
                break;
            case R.id.table:
                Intent i7 =new Intent(Home.this,Table.class);
                showProgress(view);

                startActivity(i7);
                break;
            case R.id.news:
                Intent i8 =new Intent(Home.this,News.class);
                showProgress(view);

                startActivity(i8);
                break;
            case R.id.homework:
                if (y.equals("2")|y.equals("3")) {

                    Intent i9 = new Intent(Home.this, Works.class);
                    showProgress(view);

                    startActivity(i9);
                }else {}
                break;
        }
      }else if (x==true){
                switch (view.getId()) {

                    case R.id.activity:
                        Intent i1 =new Intent(Home.this,Anshta.class);
                        showProgress(view);

                        startActivity(i1);
                        break;
                    case R.id.news:
                        Intent i2 =new Intent(Home.this,News.class);
                        showProgress(view);

                        startActivity(i2);
                        break;
                    case R.id.sharf:
                        Intent i3 =new Intent(Home.this,Sharf.class);
                        showProgress(view);

                        startActivity(i3);

                        break;
                    case R.id.arrive:
                        progressDialog.dismiss();
                        Intent i4 =new Intent(Home.this,MapsActivity.class);
                        showProgress(view);

                        startActivity(i4);

                        break;
                    case R.id.table:

                        break;
                    case R.id.homework:

                        break;
                    case R.id.rsoom:
                        break;
            }
    }                x=false;

        }else {
            NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(Home.this);

            effect=Effectstype.Flipv;
            dialogBuilder
                    .withTitle("مدرسه أنوار الفيحاء")                           //.withTitle(null)  no title
                    .withTitleColor("#FFFFFF")                                  //def
                    .withDividerColor("#d0f5eb")                              //def
                    .withMessage("يرجى التاكد من الاتصال بالانترنت")                     //.withMessage(null)  no Msg
                    .withMessageColor("#FFFFFFF")                              //def  | withMessageColor(int resid)
                    .withDialogColor("#d0f5eb")                               //def  | withDialogColor(int resid)                               //def
                    .withIcon(getResources().getDrawable(R.drawable.logo))
                    .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                    .withDuration(700)                                          //def
                    .withEffect(effect)                                         //def Effectstype.Slidetop
                    .withButton1Text("موافق")                                      //def gone
                    .withButton2Text("الغاء")                                  //def gone
                    .setCustomView(R.layout.custom_view,Home.this)         //.setCustomView(View or ResId,context)
                    .setButton1Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    })
                    .setButton2Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();                        }
                    })
                    .show();

        }
    }

    @Override
    public void onRotationFinished(View view) {
        String name = null;
//        if (view instanceof CircleImageView) {
//            name = ((CircleImageView) view).getName();
//        }
//        Toast.makeText(this, "select "+name, Toast.LENGTH_SHORT).show();

    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
           // Toast.makeText(this, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public  void showProgress(View view) {
        final int THREE_SECONDS = 2*1000;
        final ProgressDialog dlg = new ProgressDialog(this);

        if (Locale.getDefault().getLanguage().equals("en")){
            dlg.setMessage("Looding ...");

        }else{

            dlg.setMessage("جارى التحميل ...");

        }
        dlg.setCancelable(true);
        dlg.setProgress(0);
        dlg.show();

//        final int totalProgressTime = 100;
//        final Thread t = new Thread() {
//            @Override
//            public void run() {
//                int jumpTime = 0;
//
//                while(jumpTime < totalProgressTime) {
//                    try {
//                        sleep(200);
//                        jumpTime += 5;
//                        dlg.setProgress(jumpTime);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        t.start();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                dlg.dismiss();
            }
        }, THREE_SECONDS);
    }
}
