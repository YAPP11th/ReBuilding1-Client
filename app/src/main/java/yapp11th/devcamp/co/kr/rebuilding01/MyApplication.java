package yapp11th.devcamp.co.kr.rebuilding01;

import android.app.Application;

/**
 * Created by ridickle on 2017. 8. 19..
 */

public class MyApplication extends Application {

    public static String serverAddress = "http://52.79.87.95:3000";

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
