package com.vppank.cricketadventure.service.fcm;

import android.util.Log;
import android.webkit.URLUtil;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.vppank.cricketadventure.helper.Utils;

/**
 * Created by QUYLE on 3/17/18.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
        } else if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            Utils.showOpenAppNotification(this, remoteMessage.getNotification().getBody());
        }
    }
}
