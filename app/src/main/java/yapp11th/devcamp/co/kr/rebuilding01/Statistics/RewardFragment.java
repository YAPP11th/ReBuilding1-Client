package yapp11th.devcamp.co.kr.rebuilding01.Statistics;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import yapp11th.devcamp.co.kr.rebuilding01.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RewardFragment extends Fragment {

    ArrayList<RewardData> datas = new ArrayList<RewardData>();
    ListView listView;

    public RewardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_reward, container, false);

        datas.add(new RewardData(R.drawable.temp,"50%","하루종일 컴퓨터 게임하기","500P"));
        datas.add(new RewardData(R.drawable.temp,"90%","양주 구입","240P"));
        datas.add(new RewardData(R.drawable.temp,"사용하기","친구들이랑 낚시 여행","200P"));
        datas.add(new RewardData(R.drawable.temp,"사용완료","프라모델 17/XMC 구이","100P"));
        datas.add(new RewardData(R.drawable.temp,"50%","하루종일 컴퓨터 게임하기","500P"));
        datas.add(new RewardData(R.drawable.temp,"50%","하루종일 컴퓨터 게임하기","500P"));
        datas.add(new RewardData(R.drawable.temp,"90%","양주 구입","240P"));

        listView = (ListView) view.findViewById(R.id.listview);

        RewardDataAdapter adapter = new RewardDataAdapter(getActivity().getLayoutInflater(), datas);
        listView.setAdapter(adapter);

        return view;
    }


}
