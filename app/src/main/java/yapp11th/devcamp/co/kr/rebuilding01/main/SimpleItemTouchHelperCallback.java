package yapp11th.devcamp.co.kr.rebuilding01.main;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by ridickle on 2017. 8. 25..
 */

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback{
    private OnItemMoveListener mItemMoveListener;
    int dragFrom = -1;
    int dragTo = -1;

    public SimpleItemTouchHelperCallback(OnItemMoveListener mItemMoveListener) {
        this.mItemMoveListener = mItemMoveListener;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mItemMoveListener.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    // 어느 방향으로 움직일 것에 따라 flag 값을 받는다
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, 0); // swipe를 넣기 싫은 경우 0을 넣는다
    }

    @Override
    // 움직이면 어떻게 할 것인지 구현
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();

        if(dragFrom == -1) {
            dragFrom =  fromPosition;
        }
        dragTo = toPosition;

        return true;
    }

    private void reallyMoved(RecyclerView.ViewHolder viewHolder, int from, int to) {
        // I guessed this was what you want...
        mItemMoveListener.onItemMove(viewHolder, from, to);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);

        if(dragFrom != -1 && dragTo != -1 && dragFrom != dragTo) {
            reallyMoved(viewHolder, dragFrom, dragTo);
        }

        dragFrom = dragTo = -1;
    }
}
