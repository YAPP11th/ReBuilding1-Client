package yapp11th.devcamp.co.kr.rebuilding01.main;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by ridickle on 2017. 9. 23..
 */

public interface MainPresenter {
    // 2. 초기 데이터 세팅 (더미데이터시에만 활용)
    void initData();
    void dateClickEvent(DateTime dateTime);

    // 3. 액티비티와 매치되어 있음
    public interface View {
        // 해당 Presenter에서 사용할 View 구현
        void dateClick(String string);
    }

    // 3. 프레그먼트와 매치되어 있음
    public interface Fragment {
        // 해당 Presenter에서 사용할 Fragment 구현
        void addDatas(List<Work> workList);
    }
}
