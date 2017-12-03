package yapp11th.devcamp.co.kr.rebuilding01.statistics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import yapp11th.devcamp.co.kr.rebuilding01.R;

/**
 * Created by hayoung on 2017-09-24.
 */

public class RewardDataAdapter extends BaseAdapter {

    ArrayList<RewardData> datas;
    LayoutInflater inflater;

    public RewardDataAdapter(LayoutInflater inflater, ArrayList<RewardData> datas){
        this.datas = datas;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_reward,null);
        }

        ImageView img_heart = (ImageView)convertView.findViewById(R.id.img_heart);
        TextView rewardRate = (TextView)convertView.findViewById(R.id.reward_rate);
        TextView rewardName = (TextView)convertView.findViewById(R.id.reward_name);
        TextView rewardPoint = (TextView)convertView.findViewById(R.id.reward_point);

        img_heart.setImageResource(datas.get(position).getImgId());
        rewardRate.setText(datas.get(position).getRewardRate());
        rewardName.setText(datas.get(position).getRewardName());
        rewardPoint.setText(datas.get(position).getRewardPoint());

        return convertView;
    }
}
