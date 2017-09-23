package yapp11th.devcamp.co.kr.rebuilding01;

import android.support.v7.widget.RecyclerView;

/**
 * Created by ridickle on 2017. 8. 25..
 */

public interface OnItemMoveListener {
    boolean onItemMove(RecyclerView.ViewHolder viewHolder, int fromPosition, int toPosition);
    void onItemDismiss(int position);
}