package yapp11th.devcamp.co.kr.rebuilding01.Statistics;

/**
 * Created by hayoung on 2017-09-24.
 */

public class RewardData{

    String rewardName, rewardPoint, rewardRate;
    int imgId; // 하트 아이콘 리소스 아이디

    public RewardData(int imgId, String rewardRate, String rewardName, String rewardPoint){
        this.imgId = imgId;
        this.rewardRate = rewardRate;
        this.rewardName = rewardName;
        this.rewardPoint = rewardPoint;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setRewardRate(String rewardRate) {
        this.rewardRate = rewardRate;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public void setRewardPoint(String rewardPoint) {
        this.rewardPoint = rewardPoint;
    }


    public int getImgId() {
        return imgId;
    }

    public String getRewardRate() {
        return rewardRate;
    }

    public String getRewardName() {return rewardName;}

    public String getRewardPoint(){return rewardPoint;}

}
