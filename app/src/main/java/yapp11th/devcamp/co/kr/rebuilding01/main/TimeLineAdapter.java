package yapp11th.devcamp.co.kr.rebuilding01.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import yapp11th.devcamp.co.kr.rebuilding01.R;

/**
 * Created by ridickle on 2017. 8. 24..
 */

class TimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnItemMoveListener, AdapterModel {
    private ArrayList<Work> workList;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public TimeLineAdapter(Context context) {
        this.context = context;
        this.workList = new ArrayList<>();
    }

    @Override
    public void add(Work work) {
        workList.add(work);
    }

    @Override
    public Work remove(int position) {
        return workList.remove(position);
    }

    @Override
    public Work getWork(int position) {
        return workList.get(position);
    }

    @Override
    public void clear() {
        workList = new ArrayList<>();
    }

    @Override
    public void refresh() {
        notifyDataSetChanged();
    }

    public static class RoleHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLayout;
        public DragableTextView mTextView;

        public RoleHolder(View itemView) {
            super(itemView);
            mLayout = (LinearLayout) itemView.findViewById(R.id.item);
            mTextView = (DragableTextView) itemView.findViewById(R.id.item_text);
        }
    }

    public static class CenterHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLayout;

        public CenterHolder(View itemView) {
            super(itemView);
            mLayout = (LinearLayout) itemView.findViewById(R.id.item_line);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        // create a new view
        View convertView;

        if (viewType == 0 || viewType == 2) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.timeline_item, parent, false);

            return new RoleHolder(convertView);
        } else {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.timeline_center, parent, false);

            return new CenterHolder(convertView);
        }

        // set the view's size, margins, paddings and layout parameters
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        if (holder.getItemViewType() == 0 || holder.getItemViewType() == 2) {
            Work item = workList.get(position);
            textViewSetting(holder, item, position);
        } else {
            CenterHolder centerHolder = (CenterHolder) holder;
            ViewGroup.LayoutParams params = centerHolder.mLayout.getLayoutParams();
            params.width = (int) MainActivity.width / 9 * 1;
            params.height = (int) MainActivity.height / 7;
            centerHolder.mLayout.setLayoutParams(params);

            centerHolder.mLayout.requestLayout();
        }
    }

    @Override
    public int getItemCount() {
        return workList.size();
    }

    private void textViewSetting(RecyclerView.ViewHolder holder, Work item, final int position) {
        final RoleHolder roleHolder = (RoleHolder) holder;
        DragableTextView textView = roleHolder.mTextView;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "일일일 이름 : " + workList.get(position).getWork() + "\n"
                        + "일 책임자 : " + workList.get(position).getWorker() + "\n"
                        + "날짜 : " + workList.get(position).getDate() + "\n"
                        + "시작 시간 : " + workList.get(position).getStartTime() + ":00\n"
                        + "끝 시간 : " + workList.get(position).getEndTime() + ":00", Toast.LENGTH_SHORT).show();
            }
        });

        if (holder.getItemViewType() == 0) {
            textView.setRole(0);
        } else {
            textView.setRole(1);
        }
        textView.setTime(position / 3);

        if (item != null) {
            textView.setText(item.getWork());
        } else {
            textView.setText("");
        }

        ViewGroup.LayoutParams params = roleHolder.mLayout.getLayoutParams();
        params.width = (int) MainActivity.width / 9 * 4;
        params.height = (int) MainActivity.height / 7;
        roleHolder.mLayout.setLayoutParams(params);

        roleHolder.mLayout.requestLayout();
    }

    @Override
    public boolean onItemMove(RecyclerView.ViewHolder viewHolder, final int fromPosition, final int toPosition) {
        if ((fromPosition < 0) ||                       // fromPosition 이 1 아래거나
                (fromPosition >= workList.size()) ||    // fromPosition 이 최대길이보다 크거나
                (toPosition < 0) ||                     // toPosition 이 1 아래거나
                (toPosition >= workList.size()) ||      // toPosition 이 최대길이보다 크거나
                ((fromPosition % 3) == 1) ||            // fromPosition 이 센터 값이거나
                ((toPosition % 3) == 1)) {              // toPosition 이 센터 값이거나
            return false;
        }

        swapWork(fromPosition, toPosition);

        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    private void swapWork(int fromPosition, int toPosition) {
        Work temp = workList.get(fromPosition);

        workList.set(fromPosition, workList.get(toPosition));
        workList.set(fromPosition,  SpecifySetting(fromPosition));

        workList.set(toPosition, temp);
        workList.set(toPosition, SpecifySetting(toPosition));
    }

    private Work SpecifySetting(int position) {
        workList.get(position).setStartTime(position / 3);
        workList.get(position).setEndTime(position / 3 + 1);
        workList.get(position).setWorker(position % 3 == 0 ? "남편" : "아내");

        return workList.get(position);
    }

    @Override
    public void onItemDismiss(int position) {
        notifyDataSetChanged();
    }
}
