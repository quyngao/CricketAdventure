package com.vppank.cricketadventure.service.backgroundservices;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vppank.cricketadventure.R;

import com.vppank.cricketadventure.screen.splash.SplashActivity;
import com.vppank.cricketadventure.service.api.model.Notification;
import com.vppank.cricketadventure.service.api.model.VPMeoNotifcation;
import com.vppank.cricketadventure.storage.share.UserInfo;

public class MessingService extends Service {
    public MessingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        listenMessage();

        return START_STICKY;
    }

    private void listenMessage() {
        Log.e("listenMessage", UserInfo.getInstance().getUser().getId());
        FirebaseDatabase.getInstance()
                .getReference("users/" +  UserInfo.getInstance().getUser().getId() + "/notification")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.e("Noti", dataSnapshot.toString());
                        VPMeoNotifcation notification = dataSnapshot.getValue(VPMeoNotifcation.class);
                        if (notification != null){
                            sendEventNotification(notification, MessingService.this);
                            FirebaseDatabase.getInstance()
                                    .getReference("users" +  UserInfo.getInstance().getUser().getId() + "/notification")
                                    .setValue(null);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    public static void sendEventNotification(VPMeoNotifcation notification, Context context) {

        Intent intent = new Intent(context, SplashActivity.class);
        intent.setAction("" + Math.random());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            assert notificationManager != null;

            if (notificationManager.getNotificationChannel("VPMEO_NOTIFICATION_CHANNEL") == null){
                CharSequence name = context.getString(R.string.channel_name);
                String des = context.getString(R.string.channel_description);
                NotificationChannel channel =
                        new NotificationChannel(
                                "VPMEO_NOTIFICATION_CHANNEL"
                                , name
                                , NotificationManager.IMPORTANCE_DEFAULT);
                channel.setDescription(des);
                notificationManager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "VPMEO_NOTIFICATION_CHANNEL")
                    .setSmallIcon(android.R.drawable.star_on)
                    .setContentTitle("VPMeo")
                    .setContentText(notification.body)
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setOngoing(false)
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true);

            notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
        } else {
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "VPMEO_NOTIFICATION_CHANNEL")
                    .setSmallIcon(android.R.drawable.star_on)
                    .setContentTitle("VPMeo")
                    .setContentText(notification.body)
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setOngoing(false)
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

            notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());

        }
    }
}
