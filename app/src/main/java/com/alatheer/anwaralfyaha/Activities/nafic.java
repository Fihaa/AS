package com.alatheer.anwaralfyaha.Activities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.alatheer.anwaralfyaha.R;

import static com.alatheer.anwaralfyaha.Adapters.AdapterNotify.x;
import static com.alatheer.anwaralfyaha.Adapters.AdapterNotify.y;
import static com.alatheer.anwaralfyaha.Adapters.AdapterNotify.z;

public class nafic extends AppCompatActivity {
    NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nafic);
       // NotificationManager xmanager;
        Button btn;

            btn = (Button) findViewById(R.id.idBtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClickMe();
                }
            });
        }
    private void ClickMe() {
        //To set large icon in notification
        Bitmap icon1 = BitmapFactory.decodeResource(getResources(),
                R.drawable.notify);

        //Assign BigText style notification
        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText(x);
        bigText.setBigContentTitle(y);
        bigText.setBigContentTitle(z);
        bigText.setSummaryText("By: الادراه");

        //build notification
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notify)
                        .setContentTitle("رساله تذكريه")
                        .setContentText("الرسوم المدرسيه")
                        .setLargeIcon(icon1)
                        .setStyle(bigText);




        Intent resultIntent = new Intent(this, TargetActivity.class);

        TaskStackBuilder stackBuilder =TaskStackBuilder.create(this);
        stackBuilder.addParentStack(TargetActivity.class);

        stackBuilder.addNextIntent(resultIntent);
// Gets a PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentIntent(resultPendingIntent);

        mBuilder.addAction(R.drawable.readme,"Read It" ,resultPendingIntent);


        // Gets an instance of the NotificationManager service
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

       // NotificationManager mNotificationManager.cancellAll();

        //to post your notification to the notification bar
        mNotificationManager.notify(0, mBuilder.build());
    }

}
