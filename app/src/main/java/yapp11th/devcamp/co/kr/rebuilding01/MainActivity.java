package yapp11th.devcamp.co.kr.rebuilding01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.List;

import noman.weekcalendar.WeekCalendar;
import yapp11th.devcamp.co.kr.rebuilding01.Statistics.ChartActivity;
import yapp11th.devcamp.co.kr.rebuilding01.calendarWork.CalendarActivity;
import yapp11th.devcamp.co.kr.rebuilding01.workTimeLine.Work;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {
    private static final String TAG = "MainActivity";

    public static final int ROLE = 0;
    public static final int CENTER = 1;
    int flag = 0;
    MainPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private MainTimeLineAdapter mAdapter;
    private GridLayoutManager mLayoutManager;
    private WeekCalendar mWeekCalendar;
    public static double width, height;
    public static ImageButton timeLineButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, token + "");

        presentSetting();
        uiSetting();
//        networkSetting();
    }

    private void presentSetting() {
        mPresenter = new MainPresenterImpl(this);
    }

    void uiSetting() {
        mWeekCalendar = (WeekCalendar) findViewById(R.id.mainWeekCalendar);

        timeLineButton = (ImageButton) findViewById(R.id.mainTimeLineButton);
        timeLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycerViewSetting(flag);
                flag = (flag == 0 ? 1 : 0);
            }
        });

        // Set a toolbar to  replace to action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
    }

//    private void networkSetting() {
//        Call<Example> call = NetworkHelper.getInstance().usersPushExample("abcd", "efgh");
//        call.enqueue(new Callback<Example>() {
//            @Override
//            public void onResponse(Call<Example> call, Response<Example> response) {
//                String returnVal = response.body().getData1() + " / " + response.body().getData2();
//                Toast.makeText(getApplicationContext(), returnVal, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<Example> call, Throwable t) {
//
//            }
//        });
//    }

    private void recycerViewSetting(int flag) {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mAdapter = new MainTimeLineAdapter(this, flag);
        mRecyclerView.setHasFixedSize(true);
        mPresenter.initData();

        // use linear layout manager & specify an Adapter
        mLayoutManager = new GridLayoutManager(this, 9);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position % 3 == CENTER)
                    return 1;
                else
                    return 4;
            }
        });

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    // 해상도에 맞춰 recyclerView 설정
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        mRecyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);

        width = mRecyclerView.getWidth();
        height = mRecyclerView.getHeight();

        Log.d(TAG, "width : " + width + "\nheight : " + height);
        recycerViewSetting(0);
        flag = 1;
    }

    @Override
    public void addDatas(List<Work> datas) {
        for (Work data : datas) {
            mAdapter.add(data);
        }
        mAdapter.notifyDataSetChanged();
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
}