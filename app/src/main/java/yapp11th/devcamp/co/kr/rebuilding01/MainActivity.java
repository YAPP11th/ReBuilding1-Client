package yapp11th.devcamp.co.kr.rebuilding01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yapp11th.devcamp.co.kr.rebuilding01.calendarWork.CalendarActivity;
import yapp11th.devcamp.co.kr.rebuilding01.push.Example;
import yapp11th.devcamp.co.kr.rebuilding01.push.NetworkHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button calendar, setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, token + "");

        uiSetting();

        Call<Example> call = NetworkHelper.getInstance().usersPushExample("abcd", "efgh");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                String returnVal = response.body().getData1() + " / " + response.body().getData2();
                Toast.makeText(getApplicationContext(), returnVal, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

    void uiSetting() {
        calendar = (Button) findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
            }
        });

        setting = (Button) findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}