package yapp11th.devcamp.co.kr.rebuilding01;

import android.app.Activity;
import android.app.Application;

import com.kakao.auth.KakaoSDK;

import yapp11th.devcamp.co.kr.rebuilding01.KaKao.KakaoSDKAdapter;

/**
 * Created by ridickle on 2017. 8. 19..
 */

public class MyApplication extends Application {

    private static MyApplication instance = null;
    private static volatile Activity currentActivity = null;

    public static MyApplication getInstance() {return instance;}

    public static String serverAddress = "http://52.79.87.95:3000";

    @Override
    public void onCreate() {
        super.onCreate();

        MyApplication.instance = this;
        KakaoSDK.init(new KakaoSDKAdapter());
    }

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        MyApplication.currentActivity = currentActivity;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
