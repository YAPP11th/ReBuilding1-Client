package yapp11th.devcamp.co.kr.rebuilding01.main;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by ridickle on 2017. 8. 26..
 */

public class DragableTextView extends android.support.v7.widget.AppCompatTextView {
    private int time;   // 시작시간 (ex> 11~12 : 11)
    private int role;   // 책임자  (남편 : 0, 부인 : 1)

    public DragableTextView(Context context) {
        super(context);
    }

    public DragableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


}
