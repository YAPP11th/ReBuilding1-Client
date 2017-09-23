package yapp11th.devcamp.co.kr.rebuilding01;

import android.app.Activity;

import java.util.ArrayList;

import yapp11th.devcamp.co.kr.rebuilding01.workTimeLine.Work;

/**
 * Created by ridickle on 2017. 9. 23..
 */

public class MainPresenterImpl implements MainPresenter, MainModel{
    private Activity activity;
    private MainPresenter.View view;

    // 1. 뷰 설정
    public MainPresenterImpl(MainPresenter.View view) {
        this.view = view;
    }

    @Override
    public void initData() {
//        List<Work> datas = new ArrayList<>();
//        datas.add();
//        datas.add();
        view.addDatas(getDummyWorkList());
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
