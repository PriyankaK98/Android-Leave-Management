package com.priyanka.leavemanagement;

/**
 * Created by HP on 07-10-2018.
 */

public class Final {

    private String name2;
    private String branch2;
    private String date2;
    private String leavetype2;

    Final(){}

    public Final(String name2, String branch2, String date2, String leavetype2) {
        this.name2 = name2;
        this.branch2 = branch2;
        this.date2 = date2;
        this.leavetype2 = leavetype2;
    }

    @Override
    public String toString() {
        return
                "Name=" + name2 + "\n" +
                "Branch='" + branch2 + "\n" +
                "Date=" + date2 + "\n" +
                "Leavetype2=" + leavetype2 + "\n";
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getBranch2() {
        return branch2;
    }

    public void setBranch2(String branch2) {
        this.branch2 = branch2;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getLeavetype2() {
        return leavetype2;
    }

    public void setLeavetype2(String leavetype2) {
        this.leavetype2 = leavetype2;
    }
}
