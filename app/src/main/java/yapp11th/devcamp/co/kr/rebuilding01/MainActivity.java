package yapp11th.devcamp.co.kr.rebuilding01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, token + "");

        Call<Example> call = NetworkHelper.getInstance().usersPushExample("abcd", "efgh");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                String returnVal = response.body().data1 + " / " + response.body().data2;
                Toast.makeText(getApplicationContext(), returnVal, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }


}