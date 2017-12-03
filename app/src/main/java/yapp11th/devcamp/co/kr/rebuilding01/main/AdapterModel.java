package yapp11th.devcamp.co.kr.rebuilding01.main;

/**
 * Created by ridickle on 2017. 9. 23..
 */

interface AdapterModel {
    void add(Work work);
    Work remove(int position);
    Work getWork(int position);
    void clear();
    void refresh();
}
