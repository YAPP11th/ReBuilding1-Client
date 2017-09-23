package yapp11th.devcamp.co.kr.rebuilding01.calendarWork;

/**
 * Created by ridickle on 2017. 9. 23..
 */

public interface CalendarPresenter {

    // 1. 뷰 설정
    void setView(CalendarPresenter.View view);

    // 2. 뷰 이벤트 확인
    void onConfirm();

    // 3. 뷰의 이벤트와 매치되어 실행할 이벤트 모음
    public interface View {
        void setConfirmText(String text);
    }
}
