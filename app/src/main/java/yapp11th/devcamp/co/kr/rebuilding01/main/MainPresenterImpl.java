package yapp11th.devcamp.co.kr.rebuilding01.main;

import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by ridickle on 2017. 9. 23..
 */

public class MainPresenterImpl implements MainPresenter, MainModel{
    private static MainPresenterImpl instance = null;
    private MainPresenter.View view;
    private MainPresenter.Fragment fragment;

    public MainPresenterImpl() {
    }

    // 1. view 설정
    public static synchronized MainPresenterImpl newInstance(MainPresenter.View view){
        if(instance == null) {
            instance = new MainPresenterImpl();
        }

        instance.view = view;

        return instance;
    }

    // 1-2. fragment 설정
    public static synchronized MainPresenterImpl newInstance(MainPresenter.Fragment fragment){
        if(instance == null) {
            instance = new MainPresenterImpl();
        }

        instance.fragment = fragment;

        return instance;
    }


    @Override
    public void initData() {
//        List<Work> datas = new ArrayList<>();
//        datas.add();
//        datas.add();
        instance.fragment.addDatas(getDummyWorkList());
    }

    @Override
    public void dateClickEvent(DateTime dateTime) {
        instance.view.dateClick(dateTime.toString());
    }

    @Override
    public ArrayList<Work> getDummyWorkList() {
        ArrayList<Work> workList = new ArrayList<>();

        for (int i = 0; i < 18; i++) {
            String work = "";
            String worker = "";

            if(i%3 == 0){
                work = "설거지하기";
                worker = "남편";
            }

            else if(i%3 == 2){
                work = "설거지하기";
                worker = "아내";
            }

            workList.add(new Work.WorkBuilder()
                    .work(work + i)
                    .worker(worker)
                    .date("2017-08-24")
                    .startTime(i / 3)
                    .endTime((i / 3) + 1)
                    .build());
        }

        return workList;
    }
}
