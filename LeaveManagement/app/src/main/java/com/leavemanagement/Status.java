package com.priyanka.leavemanagement;

/**
 * Created by priyanka on 01-11-2018.
 */

public class Status {
    private String nam;
    private  int count=0;

    Status(){}

    public Status(String nam, int count) {
        this.nam = nam;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Status{" +
                "nam='" + nam + '\'' +
                ", count=" + count +
                '}';
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


