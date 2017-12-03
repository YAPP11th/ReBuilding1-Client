package yapp11th.devcamp.co.kr.rebuilding01.statistics;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_pager);
        uiSetting();

        Fragment arrFragments[] = new Fragment[2];
        arrFragments[0] = new ChartFragment();
        arrFragments[1] = new RewardFragment();

        ChartPagerAdapter chartPagerAdapter = new ChartPagerAdapter(getSupportFragmentManager(), arrFragments);
        viewPager.setAdapter(chartPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        // tab 메뉴 아이콘 설정
        tabLayout.getTabAt(0).setIcon(R.drawable.temp);
        tabLayout.getTabAt(1).setIcon(R.drawable.temp);
    }

    private class ChartPagerAdapter extends FragmentPagerAdapter{

        private Fragment[] arrFragments;

        public ChartPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }
    }

    public void uiSetting(){
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("CalendarActivity");
    }

}
