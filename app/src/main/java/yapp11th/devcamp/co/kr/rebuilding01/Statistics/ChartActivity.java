package yapp11th.devcamp.co.kr.rebuilding01.Statistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import yapp11th.devcamp.co.kr.rebuilding01.R;

public class ChartActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        uiSetting();
    }

    public void uiSetting(){
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("CalendarActivity");
    }
}
