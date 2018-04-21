package com.vppank.cricketadventure.helper;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.app.CricketApplication;
import com.vppank.cricketadventure.screen.main.MainActivity;

public class Utils {
    public static boolean isConnected() {
        ConnectivityManager connectivitymanager = (ConnectivityManager) CricketApplication.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivitymanager.getActiveNetworkInfo() != null
                && connectivitymanager.getActiveNetworkInfo().isAvailable()
                && connectivitymanager.getActiveNetworkInfo().isConnected();
    }

    public static AlertDialog.Builder newBuilderAlertDialog(Context context) {
        return new AlertDialog.Builder(context, R.style.DialogStyle);
    }

    public static void showOpenAppNotification(Context context, String message) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Drawable d = context.getDrawable(R.mipmap.ic_launcher);
        Bitmap bitmap = ((BitmapDrawable) d).getBitmap();

        displayNotification(context, bitmap, message, pendingIntent);

    }

    private static void displayNotification(Context context, Bitmap bitmap, String description, PendingIntent pendingIntent) {
        String channelId = context.getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(bitmap)
                        .setContentTitle(context.getString(R.string.app_name))
                        .setContentText(description)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    context.getString(R.string.default_notification_channel_name),
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

}
