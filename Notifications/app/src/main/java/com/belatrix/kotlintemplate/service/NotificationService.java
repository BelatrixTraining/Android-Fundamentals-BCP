/**
 *
 */
package com.belatrix.kotlintemplate.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;

import com.belatrix.kotlintemplate.HomeActivity;
import com.belatrix.kotlintemplate.R;

public class NotificationService extends IntentService {

    private static final int NOTIFICATION_ID = 707;
    private static final long DUMMY_DELAY = 100L;
    private static final int MAX_PROGRESS = 100;

    public NotificationService() {
        super(NotificationService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentTitle("Downloading something...");
        builder.setContentText("Reading data...");
        builder.setSmallIcon(R.mipmap.ic_belatrix_min);
        builder.setProgress(MAX_PROGRESS, 0, true);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        builder.setOngoing(true);
        for (int i = 0; i <= MAX_PROGRESS; i++) {
            builder.setProgress(MAX_PROGRESS, i, false);
            builder.setContentText("Loading " + i + "%");
            notificationManager.notify(NOTIFICATION_ID, builder.build());
            try {
                Thread.sleep(DUMMY_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        builder.setOngoing(false);
        builder.setProgress(0, 0, false);
        builder.setContentText("Complete!!!!");
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);

        Intent resultIntent = new Intent(this, HomeActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getBaseContext());
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        builder.setContentIntent(pendingIntent);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
        stopSelf();
    }
}
