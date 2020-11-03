package mx.uv.fiee.iinf.mp3player;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class app extends Application {
    public static final String CHANNEL_ID = "ForegroundService";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel service = new NotificationChannel(
                    CHANNEL_ID,"Foreground", NotificationManager.IMPORTANCE_DEFAULT
            );
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(service);
        }
    }
}
