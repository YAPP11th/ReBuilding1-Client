package yapp11th.devcamp.co.kr.rebuilding01;

/**
 * Created by ridickle on 2017. 8. 24..
 */

public class Work{
    private String work;        // 설거지 하기
    private String worker;      // 남편
    private String date;        // 2017-08-21
    private int startTime;   // 6
    private int endTime;     // 7

    private Work(WorkBuilder builder) {
        work = builder.work;
        worker = builder.worker;
        date = builder.date;
        startTime = builder.startTime;
        endTime = builder.endTime;
    }

    public String getWork() {
        return work;
    }
    public String getWorker() {
        return worker;
    }
    public String getDate() {
        return date;
    }
    public int getStartTime() {
        return startTime;
    }
    public int getEndTime() {
        return endTime;
    }
    public void setWork(String work) {
        this.work = work;
    }
    public void setWorker(String worker) {
        this.worker = worker;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    // Builder Class (static 으로 선언해야 함)
    public static class WorkBuilder {
        String work;        // 설거지 하기
        String worker;      // 남편
        String date;        // 2017-08-21
        int startTime;   // 06:00
        int endTime;     // 07:00

        public WorkBuilder work(String work) {
            this.work = work;
            return this;
        }

        public WorkBuilder worker(String worker) {
            this.worker = worker;
            return this;
        }

        public WorkBuilder date(String date) {
            this.date = date;
            return this;
        }

        public WorkBuilder startTime(int startTime) {
            this.startTime = startTime;
            return this;
        }

        public WorkBuilder endTime(int endTime) {
            this.endTime = endTime;
            return this;
        }

        public Work build(){
            return new Work(this);
        }
    }
}
