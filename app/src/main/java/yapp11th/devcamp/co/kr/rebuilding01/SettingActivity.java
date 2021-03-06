package yapp11th.devcamp.co.kr.rebuilding01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch allSwitch;
    private CheckBox cb1; //할일 5분전 알림
    private CheckBox cb2; //행사 알림
    private CheckBox cb3; //부탁해요 알림
    private CheckBox cb4; //알림 팝업
    private CheckBox cb5; //알림음
    private CheckBox cb6; //보상 요청 알림

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        allSwitch = (Switch)findViewById(R.id.switch_all_noti);
        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb3 = (CheckBox)findViewById(R.id.checkBox3);
        cb4 = (CheckBox)findViewById(R.id.checkBox4);
        cb5 = (CheckBox)findViewById(R.id.checkBox5);
        cb6 = (CheckBox)findViewById(R.id.checkBox6);

        allSwitch.setOnCheckedChangeListener(this);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);
        cb6.setOnCheckedChangeListener(this);

        //처음에 switch 상태 확인함
        if(allSwitch.isChecked()) //처음 switch 상태에 따라 체크박스 활성화 or 비활성화시켜둠
            switchChecked();
        else
            switchUnchecked();
    }

    public void switchChecked()
    {
        //전체 체크박스 활성화
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
        cb4.setEnabled(true);
        cb5.setEnabled(true);
        cb6.setEnabled(true);
    }

    public void switchUnchecked()
    {
        //전체 체크박스 비활성화
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
        cb4.setEnabled(false);
        cb5.setEnabled(false);
        cb6.setEnabled(false);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        int checkedId = buttonView.getId();

        switch(checkedId){
            case R.id.switch_all_noti:
                if(allSwitch.isChecked()) {
                    //전체 체크박스 다시 활성화
                    switchChecked();

                    //체크 되어있는 체크박스 기능 on
                    if(cb1.isChecked())
                        Toast.makeText(getApplicationContext(), cb1.getText() + " 체크", Toast.LENGTH_SHORT).show();
                    if(cb2.isChecked())
                        Toast.makeText(getApplicationContext(), cb2.getText() + " 체크", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked())
                        Toast.makeText(getApplicationContext(), cb3.getText() + " 체크", Toast.LENGTH_SHORT).show();
                    if(cb4.isChecked())
                        Toast.makeText(getApplicationContext(), cb4.getText() + " 체크", Toast.LENGTH_SHORT).show();
                    if(cb5.isChecked())
                        Toast.makeText(getApplicationContext(), cb5.getText() + " 체크", Toast.LENGTH_SHORT).show();
                    if(cb6.isChecked())
                        Toast.makeText(getApplicationContext(), cb6.getText() + " 체크", Toast.LENGTH_SHORT).show();
                }
                else {
                    //전체 체크박스 다시 비활성화
                    switchUnchecked();

                    //전체 알림 기능 off
                    Toast.makeText(getApplicationContext(),"전체 알림 기능 off",Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.checkBox1:
                if(cb1.isChecked())
                    Toast.makeText(getApplicationContext(), cb1.getText() + " 체크", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), cb1.getText() + " 체크 해제", Toast.LENGTH_SHORT).show();
                break;

            case R.id.checkBox2:
                if(cb2.isChecked())
                    Toast.makeText(getApplicationContext(), cb2.getText() + " 체크", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), cb2.getText() + " 체크 해제", Toast.LENGTH_SHORT).show();
                break;

            case R.id.checkBox3:
                if(cb3.isChecked())
                    Toast.makeText(getApplicationContext(), cb3.getText() + " 체크", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), cb3.getText() + " 체크 해제", Toast.LENGTH_SHORT).show();
                break;

            case R.id.checkBox4:
                if(cb4.isChecked())
                    Toast.makeText(getApplicationContext(), cb4.getText() + " 체크", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), cb4.getText() + " 체크 해제", Toast.LENGTH_SHORT).show();
                break;

            case R.id.checkBox5:
                if(cb5.isChecked())
                    Toast.makeText(getApplicationContext(), cb5.getText() + " 체크", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), cb5.getText() + " 체크 해제", Toast.LENGTH_SHORT).show();
                break;

            case R.id.checkBox6:
                if(cb6.isChecked())
                    Toast.makeText(getApplicationContext(), cb6.getText() + " 체크", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), cb6.getText() + " 체크 해제", Toast.LENGTH_SHORT).show();
                break;
        }

    }


}

