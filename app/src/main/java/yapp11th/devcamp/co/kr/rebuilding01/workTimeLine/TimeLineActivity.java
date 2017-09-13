package yapp11th.devcamp.co.kr.rebuilding01.workTimeLine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import org.joda.time.DateTime;

import noman.weekcalendar.WeekCalendar;
import noman.weekcalendar.listener.OnDateClickListener;
import yapp11th.devcamp.co.kr.rebuilding01.R;

public class TimeLineActivity extends AppCompatActivity {
    private static final String TAG = "TimeLineActivity";
    public static final int ROLE = 0;
    public static final int CENTER = 1;

    private RecyclerView mRecyclerView;
    private TimeLineAdapter mAdapter;
    private GridLayoutManager mLayoutManager;
    private WeekCalendar mWeekCalendar;
    private EditText mDirectText;
    private ImageButton mDirectOK, mDirectCancel;
    public static double width, height;

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
    }

    private void recycerViewSetting() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mAdapter = new TimeLineAdapter(this, getDummyWorkList());
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

    private Work[] getDummyWorkList() {
        Work[] workList = new Work[18];

        for (int i = 0; i < 18; i++) {
            workList[i] = new Work.WorkBuilder()
                    .work("" + i)
                    .worker("")
                    .date("2017-08-24")
                    .startTime(i / 3)
                    .endTime((i / 3) + 1)
                    .build();
        }

        for (int i = 0; i < 6; i++) {
            workList[3 * i + (i % 2 == 0 ? 0 : 2)] = new Work.WorkBuilder()
                    .work("설거지하기" + i)
                    .worker(i % 2 == 0 ? "남편" : "아내")
                    .date("2017-08-24")
                    .startTime(i)
                    .endTime(i + 1)
                    .build();
        }

        return workList;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayout lL = (LinearLayout) findViewById(R.id.directInput);

        width = mRecyclerView.getWidth();
        height = mRecyclerView.getHeight() - lL.getHeight();

        Log.d(TAG, "width : " + width + "\nheight : " + height);
        recycerViewSetting();
    }

    private void directInputSetting(){
        mDirectText = (EditText) findViewById(R.id.directText);
        mDirectOK = (ImageButton) findViewById(R.id.directOK);
        mDirectCancel = (ImageButton) findViewById(R.id.directCancel);
    }
}
