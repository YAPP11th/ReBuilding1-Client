package yapp11th.devcamp.co.kr.rebuilding01;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import org.joda.time.DateTime;

import noman.weekcalendar.WeekCalendar;
import noman.weekcalendar.listener.OnDateClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yapp11th.devcamp.co.kr.rebuilding01.Statistics.ChartActivity;
import yapp11th.devcamp.co.kr.rebuilding01.calendarWork.CalendarActivity;
import yapp11th.devcamp.co.kr.rebuilding01.push.Example;
import yapp11th.devcamp.co.kr.rebuilding01.push.NetworkHelper;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {
    private static final String TAG = "MainActivity";

    public static final int ROLE = 0;
    public static final int CENTER = 1;
    int flag = 0;
    MainPresenter mPresenter;

    private WeekCalendar mWeekCalendar;
    public static double width, height;
    public static ImageButton timeLineButton;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragmentFrame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, token + "");

        presentSetting();
        uiSetting();
        networkSetting();
    }

    private void presentSetting() {
        mPresenter = MainPresenterImpl.newInstance(this);
    }

    void uiSetting() {
        // Set a toolbar to  replace to action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mWeekCalendar = (WeekCalendar) findViewById(R.id.mainWeekCalendar);
        mWeekCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(DateTime dateTime) {
                mPresenter.dateClickEvent(dateTime);
            }
        });

        timeLineButton = (ImageButton) findViewById(R.id.mainTimeLineButton);
        timeLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = fragmentFrame instanceof MainFragment1 == true ?
                        MainFragment2.newInstance() : MainFragment1.newInstance();
                fragmentFrame = f;
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainFragment, fragmentFrame);
                fragmentTransaction.commit();
            }
        });
    }

    private void networkSetting() {
        Call<Example> call = NetworkHelper.getInstance().usersPushExample("abcd", "efgh");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                String returnVal = response.body().getData1() + " / " + response.body().getData2();
                Toast.makeText(getApplicationContext(), returnVal, Toast.LENGTH_SHORT).show();

                Call<Example> call2 = NetworkHelper.getInstance().usersAbcd(new Example("abcd","efgh"));
                call2.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        String returnVal = response.body().toString();
                        Toast.makeText(getApplicationContext(), returnVal, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

    // 해상도에 맞춰 recyclerView 설정
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        FrameLayout mainFragment = (FrameLayout) findViewById(R.id.mainFragment);

        width = mainFragment.getWidth();
        height = mainFragment.getHeight();

        Log.d(TAG, "width : " + width + "\nheight : " + height);

        FragmentManager fm = getFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        fragmentFrame = MainFragment1.newInstance();
        fragmentTransaction.add(R.id.mainFragment, fragmentFrame);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_calendar){
            startActivity(new Intent(this, CalendarActivity.class));
        }

        else if(id == R.id.action_chart){
            startActivity(new Intent(this, ChartActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void dateClick(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

    }
}