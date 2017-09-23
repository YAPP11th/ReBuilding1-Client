package yapp11th.devcamp.co.kr.rebuilding01.calendarWork;

import android.app.Activity;

/**
 * Created by ridickle on 2017. 9. 23..
 */

public class CalndarPresenterImpl implements CalendarPresenter {
    private Activity activity;
    private CalendarModel calendarModel;
    private CalendarPresenter.View view;

    public CalndarPresenterImpl(Activity activity) {
        this.activity = activity;
        this.calendarModel = new CalendarModel();
    }

    // 1. 뷰 설정
    @Override
    public void setView(CalendarPresenter.View view) {
        this.view = view;
    }

    // 2. 뷰 이벤트 확인
    @Override
    public void onConfirm() {
        if (view != null) {
            // 3. 뷰의 이벤트와 매치되어 실행할 이벤트
            view.setConfirmText(calendarModel.getClickedText());
        }
    }
}
