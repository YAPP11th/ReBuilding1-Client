package yapp11th.devcamp.co.kr.rebuilding01.push;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ridickle on 2017. 8. 19..
 */

public interface NetworkInterface {
    @FormUrlEncoded

    @POST("/users/pushExample")
    Call<Example> usersPushExample(@Field("data1") String data1, @Field("data2") String data2);
}
