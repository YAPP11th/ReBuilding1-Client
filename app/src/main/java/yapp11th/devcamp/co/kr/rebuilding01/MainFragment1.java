package yapp11th.devcamp.co.kr.rebuilding01;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ridickle on 2017. 9. 24..
 */

public class MainFragment1 extends Fragment implements MainPresenter.Fragment  {
    private static final String TAG = "MainFragment1";

    public static final int ROLE = 0;
    public static final int CENTER = 1;
    MainPresenter mPresenter;
    static MainFragment1 fragment;

    private MainTimeLineAdapter mAdapter;
    private GridLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public MainFragment1() {
        // Required empty public constructor
    }

    public static synchronized MainFragment1 newInstance() {
        if(fragment == null) {
            fragment = new MainFragment1();
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView = inflater.inflate(R.layout.fragment_main_fragment1, container, false);
        presentSetting();
        uiSetting(convertView);

        recycerViewSetting();
        return convertView;
    }

    private void presentSetting() {
        mPresenter = MainPresenterImpl.newInstance(this);
    }

    void uiSetting(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mainRecyclerView);
    }

    private void recycerViewSetting() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mAdapter = new MainTimeLineAdapter(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mPresenter.initData();

        // use linear layout manager & specify an Adapter
        mLayoutManager = new GridLayoutManager(getActivity(), 9);
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

    @Override
    public void addDatas(List<Work> datas) {
        mAdapter.clear();
        for (Work data : datas) {
            mAdapter.add(data);
        }
        mAdapter.notifyDataSetChanged();
    }
}
