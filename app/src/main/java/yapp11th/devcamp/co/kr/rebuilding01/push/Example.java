package yapp11th.devcamp.co.kr.rebuilding01.push;

/**
 * Created by ridickle on 2017. 8. 19..
 */

public class Example {
    String data1;
    String data2;

    private Example(String data1, String data2){
        this.data1 = data1;
        this.data2 = data2;
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public Example setData1(String data1) {
        this.data1 = data1;
        return this;
    }

    public Example setData2(String data2) {
        this.data2 = data2;
        return this;
    }

    public Example build(){
        return new Example(data1, data2);
    }
}
