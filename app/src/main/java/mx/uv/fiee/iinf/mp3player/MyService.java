package mx.uv.fiee.iinf.mp3player;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.media.MediaActionSound;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.io.IOException;

public class MyService extends Service {


    @Override
    public void onCreate () {
        super.onCreate();


    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

     Intent intent1 = new Intent(this,DetailsActivity.class);
     PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent1,0);
        Notification notification = new NotificationCompat.Builder(this,app.CHANNEL_ID)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.toString())
                .setSmallIcon(R.mipmap.ic_launchermusic)
                .setContentIntent(pendingIntent)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.library))
                .build();
        startForeground(1,notification);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }


    }