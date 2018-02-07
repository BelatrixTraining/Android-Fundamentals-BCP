package com.belatrix.kotlintemplate;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import com.belatrix.kotlintemplate.service.NotificationService;

public class MainNotificationsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NOTIFICATION_ID = 7777;

    public enum NotificationType {
        DEFAULT,
        WITH_BUTTONS,
        WITH_FLAGS,
        WITH_PENDING_INTENT
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notifications);
        init();
    }

    private void init() {
        findViewById(R.id.simpleNotificationButton).setOnClickListener(this);
        findViewById(R.id.buttonsNotificationButton).setOnClickListener(this);
        findViewById(R.id.flagsNotificationButton).setOnClickListener(this);
        findViewById(R.id.pendingIntentNotification).setOnClickListener(this);
        findViewById(R.id.notificationWithService).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.simpleNotificationButton:
                createNotification(NotificationType.DEFAULT);
                break;
            case R.id.buttonsNotificationButton:
                createNotification(NotificationType.WITH_BUTTONS);
                break;
            case R.id.flagsNotificationButton:
                createNotification(NotificationType.WITH_FLAGS);
                break;
            case R.id.pendingIntentNotification:
                createNotification(NotificationType.WITH_PENDING_INTENT);
                break;
            case R.id.notificationWithService:
                Intent intent = new Intent(
                        MainNotificationsActivity.this,
                        NotificationService.class
                );
                startService(intent);
                break;
        }
    }

    private void createNotification(NotificationType type) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("This is the title");
        builder.setContentText("This is the content text");
        builder.setSmallIcon(R.mipmap.ic_belatrix_logo);
        // builder.setContentInfo("This is a content info");
        // builder.setLargeIcon(bitmap);
        // builder.setTicker("This is a ticket text text 123345 123123123 123123123");
        // builder.setColor(0xFFFF0000);
        // builder.setWhen(System.currentTimeMillis());
        // builder.setShowWhen(true);
        // OTHER VALUES
        // builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        // builder.setAutoCancel(true);
        // builder.setStyle(new NotificationCompat.BigTextStyle().bigText(getString(R.string.big_text)));

        /*
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        String[] events = new String[6];
        events[0] = new String("This is first line....");
        events[1] = new String("This is second line...");
        events[2] = new String("This is third line...");
        events[3] = new String("This is 4th line...");
        events[4] = new String("This is 5th line...");
        events[5] = new String("This is 6th line...");

        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Big Title Details:");

        // Moves events into the big view
        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        builder.setStyle(inboxStyle);
        */

        switch (type) {
            case WITH_BUTTONS:
                builder.addAction(R.mipmap.ic_launcher, getString(android.R.string.ok), null);
                break;
            case WITH_FLAGS:
                builder.setDefaults(NotificationCompat.DEFAULT_LIGHTS);
                builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
                builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
                builder.setLights(0xff493C7C, 1000, 1000);
                // builder.setVibrate(new long[]{1,2,1,2,1});
                // builder.setSound(uri...);
                break;
            case WITH_PENDING_INTENT:
                Intent intent = new Intent(MainNotificationsActivity.this, HomeActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainNotificationsActivity.this,
                        0,
                        intent,
                        0
                );
                builder.addAction(R.mipmap.ic_launcher, getString(R.string.click_me), pendingIntent);
                break;
            case DEFAULT:
                // NOTHING TO DO HERE
        }
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());

        // Notification notification = builder.build();
        // notification.flags |= Notification.FLAG_AUTO_CANCEL;
        // notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        // notification.ledARGB = 0xFFff0000;
        // notification.ledOnMS = 100;
        // notification.ledOffMS = 100;


        // OTHERS
        // notificationManager.cancel(NOTIFICATION_ID);
        // notificationManager.cancelAll();
    }
}
