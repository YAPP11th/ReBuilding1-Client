package yapp11th.devcamp.co.kr.rebuilding01.workTimeLine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.util.Log;

import yapp11th.devcamp.co.kr.rebuilding01.R;

public class TimeLineActivity extends AppCompatActivity {
    private static final String TAG = "TimeLineActivity";
    private RecyclerView mRecyclerView;
    private TimeLineAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static double width, height, density;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        recycerViewSetting();
        getDPSize();
    }

    private void recycerViewSetting() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use linear layout manager & specify an Adapter
        mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TimeLineAdapter(this, getDummyWorkList());

        // setting Drag and drop event in RecyclerView
        ItemTouchHelper.Callback callback =  new SimpleItemTouchHelperCallback(mAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.setAdapter(mAdapter);
    }

    private Work[] getDummyWorkList() {
        Work[] workList = new Work[18];

        for (int i = 0 ; i<18 ; i++){
            workList[i] = new Work.WorkBuilder()
                    .work("" + i)
                    .worker("")
                    .date("2017-08-24")
                    .startTime(i/3)
                    .endTime((i/3)+1)
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

    public void getDPSize(){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        width = metrics.widthPixels;
        height = metrics.heightPixels;
        density = metrics.densityDpi;

        // px to dp
        // ldpi : 1dp = 0.75px
        // mdpi : 1dp = 1px
        // hdpi : 1dp = 1.5px
        // xdpi : 1dp = 2px;
        Log.d (TAG, "widthPX : " + width + "\nheight : " + height + "\ndensity : " + density);

//        width = width * (160 / density);
//        height = height * (160 / density);
    }
}
