package com.alatheer.anwaralfyaha.Activities;

import android.app.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alatheer.anwaralfyaha.Adapters.AdapterSchool;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.JsonParser;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.szugyi.circlemenu.view.CircleLayout;

import java.util.Locale;

import static com.alatheer.anwaralfyaha.Activities.Login.log;
import static com.alatheer.anwaralfyaha.Activities.Select.y;

public class Home extends AppCompatActivity implements CircleLayout.OnItemClickListener, CircleLayout.OnRotationFinishedListener {
    protected CircleLayout circleLayout;
    private Effectstype effect;
    ProgressDialog progressDialog;
    public static  String s ,n;
    NotificationManager mNotificationManager;
public  static   boolean x=true;

    // final static String api = "http://wefakhail.org/fihaa/api/schools";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private AdapterSchool adapter;
    //private float angle = 90;
    private SharedPreferences ref,idref;
    ImageView out,copy,pay;
    ImageView notfyy;
   TextView notfy_txt,tpay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Locale.getDefault().getLanguage().equals("en")) {
            setContentView(R.layout.econtent_home);
        } else {
            setContentView(R.layout.activity_home);
        }
        pay= (ImageView) findViewById(R.id.pay);
        tpay= (TextView) findViewById(R.id.rs);
        notfyy=(ImageView)findViewById(R.id.notfy);
        notfy_txt=(TextView) findViewById(R.id.notf_txt);
        circleLayout = (CircleLayout) findViewById(R.id.circle);
        circleLayout.setOnItemClickListener(this);
        Intent i = getIntent();
        s = i.getStringExtra("id");
        n = i.getStringExtra("name");
        notfyy.setVisibility( View.INVISIBLE );
        pay.setVisibility( View.INVISIBLE );
        tpay.setVisibility(View.INVISIBLE);

        Intent ii = getIntent();
        s = ii.getStringExtra("id");
        n = ii.getStringExtra("name");
        if (y.equals("2")|y.equals("3")){
            notfyy.setVisibility(View.VISIBLE);
            if (x==true){
            notfy_txt.setVisibility(View.VISIBLE);}
            ClickMe();
            notfyy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent i2 = new Intent(Home.this, Notification.class);
                        startActivity(i2);
                        notfy_txt.setVisibility(View.GONE);


                }
            });
        }else if (y.equals("4")){
            pay.setVisibility( View.VISIBLE );
            tpay.setVisibility(View.VISIBLE);
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Home.this, Arcmenu.class);
                    startActivity(i);
                }
            });
        }

        if (log==true)
        {

            Intent intent = getIntent();
            s = intent.getStringExtra("s");
            n = intent.getStringExtra("n");   }
       // progressDialog = new ProgressDialog(this);
     //   progressDialog.setCancelable(false);


        //  circleLayout.setOnRotationFinishedListener(this);
        copy = (ImageView) findViewById(R.id.btn_copy);
        out = (ImageView) findViewById(R.id.btn_out);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Home.this,Copy.class);
                startActivity(i);
            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  editor.remove("idName"); // will delete key key_name3

                SharedPreferences spref = getSharedPreferences("loginspref",MODE_PRIVATE);
                spref.edit().clear().commit();
                finish();

                SharedPreferences usref = getSharedPreferences("loginusref",MODE_PRIVATE);
                usref.edit().clear().commit();
                finish();

                SharedPreferences pref = getSharedPreferences("loginpref",MODE_PRIVATE);
                pref.edit().clear().commit();
                finish();

            }
        });


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
                }else {
                   // Toast.makeText(this, "هذا ليس من صلاحياتك ", Toast.LENGTH_LONG).show();
                    if (Locale.getDefault().getLanguage().equals("en")) {
                        try {
                            AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                            alertDialog.setTitle("Info");
                            alertDialog.setMessage("This not allow for you ");
                            alertDialog.setIcon(R.mipmap.logo);
                            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            alertDialog.show();
                        }
                        catch(Exception e)
                        {
                        }
                    } else {
                        try {
                            AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                            alertDialog.setTitle("تحذير");
                            alertDialog.setMessage("هذا ليس من صلاحياتك");
                            alertDialog.setIcon(R.mipmap.logo);
                            alertDialog.setButton("موافق", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            alertDialog.show();
                        }
                        catch(Exception e)
                        {
                        }


                }
                }
                break;
            case R.id.arrive:
                Intent i3 =new Intent(Home.this,Arcmenu.class);
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

                    startActivity(i4);}else {
                        if (Locale.getDefault().getLanguage().equals("en")) {
                            try {
                                AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                                alertDialog.setTitle("Info");
                                alertDialog.setMessage("This not allow for you ");
                                alertDialog.setIcon(R.mipmap.logo);
                                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                                alertDialog.show();
                            }
                            catch(Exception e)
                            {
                            }
                        } else {
                            try {
                                AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                                alertDialog.setTitle("تحذير");
                                alertDialog.setMessage("هذا ليس من صلاحياتك");
                                alertDialog.setIcon(R.mipmap.logo);
                                alertDialog.setButton("موافق", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                                alertDialog.show();
                            }
                            catch(Exception e)
                            {
                            }

                        }
                       }
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
                }else { if (Locale.getDefault().getLanguage().equals("en")) {
                    try {
                        AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                        alertDialog.setTitle("Info");
                        alertDialog.setMessage("This not allow for you ");
                        alertDialog.setIcon(R.mipmap.logo);
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        alertDialog.show();
                    }
                    catch(Exception e)
                    {
                    }
                } else {
                    try {
                        AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                        alertDialog.setTitle("تحذير");
                        alertDialog.setMessage("هذا ليس من صلاحياتك");
                        alertDialog.setIcon(R.mipmap.logo);
                        alertDialog.setButton("موافق", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {


                            }
                        });

                        alertDialog.show();
                    }
                    catch(Exception e)
                    {
                    }

                }
                }
                break;
            case R.id.table:
                if (y.equals("2")|y.equals("3")) {

                    Intent i7 = new Intent(Home.this, Table.class);
                    showProgress(view);

                    startActivity(i7);
                }else{

                    if (Locale.getDefault().getLanguage().equals("en")) {
                        try {
                            AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                            alertDialog.setTitle("Info");
                            alertDialog.setMessage("This not allow for you ");
                            alertDialog.setIcon(R.mipmap.logo);
                            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            alertDialog.show();
                        }
                        catch(Exception e)
                        {
                        }
                    } else {
                        try {
                            AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                            alertDialog.setTitle("تحذير");
                            alertDialog.setMessage("هذا ليس من صلاحياتك");
                            alertDialog.setIcon(R.mipmap.logo);
                            alertDialog.setButton("موافق", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {


                                }
                            });

                            alertDialog.show();
                        }
                        catch(Exception e)
                        {
                        }

                    }
                }
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
                }else { if (Locale.getDefault().getLanguage().equals("en")) {
                    try {
                        AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                        alertDialog.setTitle("Info");
                        alertDialog.setMessage("This not allow for you ");
                        alertDialog.setIcon(R.mipmap.logo);
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        alertDialog.show();
                    }
                    catch(Exception e)
                    {
                    }
                } else {
                    try {
                        AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                        alertDialog.setTitle("تحذير");
                        alertDialog.setMessage("هذا ليس من صلاحياتك");
                        alertDialog.setIcon(R.mipmap.logo);
                        alertDialog.setButton("موافق", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        alertDialog.show();
                    }
                    catch(Exception e)
                    {
                    }

                }
                }
                break;
        }
//      }else if (x==true){
//                switch (view.getId()) {
//
//                    case R.id.activity:
//                        Intent i1 =new Intent(Home.this,Anshta.class);
//                        showProgress(view);
//
//                        startActivity(i1);
//                        break;
//                    case R.id.news:
//                        Intent i2 =new Intent(Home.this,News.class);
//                        showProgress(view);
//
//                        startActivity(i2);
//                        break;
//                    case R.id.sharf:
//                        Intent i3 =new Intent(Home.this,Sharf.class);
//                        showProgress(view);
//
//                        startActivity(i3);
//
//                        break;
//                    case R.id.arrive:
//                        progressDialog.dismiss();
//                        Intent i4 =new Intent(Home.this,Arcmenu.class);
//                        showProgress(view);
//                        startActivity(i4);
//                        break;
//                    case R.id.table:
//                        break;
//                    case R.id.homework:
//                        break;
//                    case R.id.rsoom:
//                        break;
//                 }
//    }

        } else {

            if (Locale.getDefault().getLanguage().equals("en")) {
                try {
                    AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();

                    alertDialog.setTitle("Info");
                    alertDialog.setMessage("Internet not available, Cross check your internet connectivity and try again");
                    alertDialog.setIcon(R.mipmap.logo);
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    });

                    alertDialog.show();
                }
                catch(Exception e)
                {
                }
            } else {
                try {
                    AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create();
                    alertDialog.setTitle("تحذير");
                    alertDialog.setMessage("انترنت غير متاح حاليا من فضلك تحقق من الاتصال بالانترنت وحاول مره اخري");
                    alertDialog.setIcon(R.mipmap.logo);
                    alertDialog.setButton("موافق", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    alertDialog.show();
                }
                catch(Exception e)
                {
                }

            }

    }}

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

    @Override
    public void onBackPressed() {
        Intent i=new Intent(this,Select.class);
        startActivity(i);
        super.onBackPressed();
        x=false;
    }


    private void ClickMe() {
        //To set large icon in notification
        Bitmap icon1 = BitmapFactory.decodeResource(getResources(),
                R.drawable.notify);

        //Assign BigText style notification
        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText("تحقق من الرسوم هناك تغيير ف الامور الماليه الخاصه بك");
        bigText.setBigContentTitle("رساله تذكريه");
        bigText.setSummaryText("بواسطه: الادراه");

        //build notification
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notify)
                        .setContentTitle("رساله تذكريه")
                        .setContentText("الرسوم المدرسيه")
                        .setLargeIcon(icon1)
                        .setStyle(bigText);




        Intent resultIntent = new Intent(this, Notification.class);

        TaskStackBuilder stackBuilder =TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Notification.class);

        stackBuilder.addNextIntent(resultIntent);
// Gets a PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentIntent(resultPendingIntent);

        mBuilder.addAction(R.drawable.readme,"قراءه المزيد" ,resultPendingIntent);
        mBuilder.setAutoCancel(true);


        // Gets an instance of the NotificationManager service
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

         //NotificationManager mNotificationManager.cancellAll();

        //to post your notification to the notification bar
        mNotificationManager.notify(0, mBuilder.build());
    }



}
