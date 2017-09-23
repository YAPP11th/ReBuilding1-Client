package yapp11th.devcamp.co.kr.rebuilding01.workTimeLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ridickle on 2017. 9. 23..
 */

class WorkTimeLinePresenter {
    private WorkTimeLinePresenter.View view;

    public WorkTimeLinePresenter(WorkTimeLinePresenter.View view) {
        this.view = view;
    }

    public void initData() {
        List<Work> datas = getDummyWorkList();
//        datas.add(new Work());
//        datas.add(new Work());
        view.addDatas(datas);
    }

    public interface View {
        void addDatas(List<Work> datas);
    }


    private ArrayList<Work> getDummyWorkList() {
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
