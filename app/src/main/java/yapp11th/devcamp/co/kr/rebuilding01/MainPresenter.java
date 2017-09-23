package yapp11th.devcamp.co.kr.rebuilding01;

import java.util.List;

import yapp11th.devcamp.co.kr.rebuilding01.workTimeLine.Work;

/**
 * Created by ridickle on 2017. 9. 23..
 */

public interface MainPresenter {
    // 2. 초기 데이터 세팅 (더미데이터시에만 활용)
    void initData();

    // 3. 뷰의 이벤트와 매치되어 실행할 이벤트 모음
    public interface View {
        // 해당 Presenter에서 사용할 View 구현
        void addDatas(List<Work> workList);
    }
}
