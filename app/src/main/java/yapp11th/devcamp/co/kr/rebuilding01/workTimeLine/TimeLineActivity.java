package yapp11th.devcamp.co.kr.rebuilding01.workTimeLine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import org.joda.time.DateTime;

import java.util.List;

import noman.weekcalendar.WeekCalendar;
import noman.weekcalendar.listener.OnDateClickListener;
import yapp11th.devcamp.co.kr.rebuilding01.R;

public class TimeLineActivity extends AppCompatActivity implements WorkTimeLinePresenter.View{
    private static final String TAG = "TimeLineActivity";
    public static final int ROLE = 0;
    public static final int CENTER = 1;
    int flag = 0;
    WorkTimeLinePresenter mPresenter;

    private RecyclerView mRecyclerView;
    private TimeLineAdapter mAdapter;
    private GridLayoutManager mLayoutManager;
    private WeekCalendar mWeekCalendar;
    private EditText mDirectText;
    private ImageButton mDirectOK, mDirectCancel;
    public static double width, height;
    public static ImageButton timeLineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        mWeekCalendar = (WeekCalendar) findViewById(R.id.weekCalendar);

        mWeekCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(DateTime dateTime) {

            }
        });

        directInputSetting();

        timeLineButton = (ImageButton) findViewById(R.id.timeLineButton);
        timeLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycerViewSetting(flag);
                if(flag == 0)
                    flag = 1;
                else
                    flag = 0;
            }
        });
    }

    private void recycerViewSetting(int flag) {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mAdapter = new TimeLineAdapter(this, flag);
        mRecyclerView.setHasFixedSize(true);

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

        // setting Drag and drop event in RecyclerView
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayout lL = (LinearLayout) findViewById(R.id.directInput);

        width = mRecyclerView.getWidth();
        height = mRecyclerView.getHeight() - lL.getHeight();

        Log.d(TAG, "width : " + width + "\nheight : " + height);
        recycerViewSetting(0);
        flag = 1;
    }

    private void directInputSetting(){
        mDirectText = (EditText) findViewById(R.id.directText);
        mDirectOK = (ImageButton) findViewById(R.id.directOK);
        mDirectCancel = (ImageButton) findViewById(R.id.directCancel);
    }

    @Override
    public void addDatas(List<Work> datas) {

    }
}
