package yapp11th.devcamp.co.kr.rebuilding01.push;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import yapp11th.devcamp.co.kr.rebuilding01.MyApplication;

/**
 * Created by ridickle on 2017. 8. 19..
 */

public class NetworkHelper {
    private static NetworkInterface instance;

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(MyApplication.serverAddress)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static synchronized NetworkInterface getInstance(){
        if(instance == null){
            instance = retrofit.create(NetworkInterface.class);
        }
        return instance;
    }

}
