package yapp11th.devcamp.co.kr.rebuilding01.calendarWork;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.util.Date;

import yapp11th.devcamp.co.kr.rebuilding01.R;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        final CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);


        final CaldroidListener listener = new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {
                // Do something
            }
            @Override
            public void onCaldroidViewCreated() {
                // Supply your own adapter to weekdayGridView (SUN, MON, etc)
                Button leftButton = caldroidFragment.getLeftArrowButton();
                Button rightButton = caldroidFragment.getRightArrowButton();
                TextView textView = caldroidFragment.getMonthTitleTextView();

                // Do customization here
                leftButton.setVisibility(View.GONE);
                rightButton.setVisibility(View.GONE);
                textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
        };

        caldroidFragment.setCaldroidListener(listener);

        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar, caldroidFragment);
        t.commit();
    }
}
