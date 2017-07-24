package com.example.elashry.aseer.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.elashry.aseer.R;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.szugyi.circlemenu.view.CircleImageView;
import com.szugyi.circlemenu.view.CircleLayout;

import static com.example.elashry.aseer.Activities.Login.editor;
import static com.example.elashry.aseer.Activities.Select.x;
import static com.example.elashry.aseer.Activities.Select.y;

public class Home extends AppCompatActivity implements CircleLayout.OnItemClickListener, CircleLayout.OnRotationFinishedListener {
    protected CircleLayout circleLayout;
    private Effectstype effect;
    ProgressDialog progressDialog;
    public static  String s ,n;

    //private float angle = 90;

Button out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        circleLayout = (CircleLayout) findViewById(R.id.circle);
        circleLayout.setOnItemClickListener(this);
        Intent i=getIntent();
        s=  i.getStringExtra("id");
        n=  i.getStringExtra("name");

        Intent ii=getIntent();
        s=  ii.getStringExtra("id");
        n=  ii.getStringExtra("name");
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);


        //  circleLayout.setOnRotationFinishedListener(this);
        out = (Button) findViewById(R.id.btn_out);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  editor.remove("idName"); // will delete key key_name3

                Intent i =new Intent(Home.this,Login.class);
                startActivity(i);




            }
        });


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

        progressDialog.setMessage("جارى التحميل ...");
        progressDialog.show();
        if (isOnline()){

            if (x==false ){

        switch (view.getId()) {

            case R.id.activity:
                Intent i1 =new Intent(Home.this,Anshta.class);
                startActivity(i1);
                progressDialog.dismiss();
                break;
            case R.id.apsent:
                Intent i2 =new Intent(Home.this,ghyaab.class);
                startActivity(i2);
                progressDialog.dismiss();
                break;
            case R.id.arrive:
                Intent i3 =new Intent(Home.this,MapsActivity.class);
                startActivity(i3);
                progressDialog.dismiss();

                break;
            case R.id.rsoom:
                if(y.equals("2")|y.equals("3")){
                    Intent ii =new Intent(Home.this,Rsoom.class);
                    startActivity(ii);
                    progressDialog.dismiss();
                }else {
                    Intent i4 =new Intent(Home.this,WebViiew.class);
                    startActivity(i4);
                    progressDialog.dismiss();
                }

                break;
            case R.id.sharf:
                Intent i5 =new Intent(Home.this,Sharf.class);
                startActivity(i5);
                progressDialog.dismiss();
                break;
            case R.id.state:
                Intent i6 =new Intent(Home.this,Elmstwa.class);
                startActivity(i6);
                progressDialog.dismiss();
                break;
            case R.id.table:
                Intent i7 =new Intent(Home.this,Table.class);
                startActivity(i7);
                progressDialog.dismiss();
                break;
            case R.id.news:
                Intent i8 =new Intent(Home.this,News.class);
                startActivity(i8);
                progressDialog.dismiss();
                break;
            case R.id.homework:
                Intent i9 =new Intent(Home.this,Works.class);
                startActivity(i9);
                progressDialog.dismiss();
                break;
        }
      }else if (x==true){
                switch (view.getId()) {

                    case R.id.activity:
                        Intent i1 =new Intent(Home.this,Anshta.class);
                        startActivity(i1);
                        progressDialog.dismiss();
                        break;
                    case R.id.news:
                        Intent i2 =new Intent(Home.this,News.class);
                        startActivity(i2);
                        progressDialog.dismiss();
                        break;
                    case R.id.sharf:
                        Intent i3 =new Intent(Home.this,Sharf.class);
                        startActivity(i3);
                        progressDialog.dismiss();

                        break;
                    case R.id.arrive:
                        Intent i4 =new Intent(Home.this,MapsActivity.class);
                        startActivity(i4);
                        progressDialog.dismiss();

                        break;
                    case R.id.table:

                        break;
                    case R.id.homework:

                        break;
                    case R.id.rsoom:
                        break;
            }
    }}else {
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
}
