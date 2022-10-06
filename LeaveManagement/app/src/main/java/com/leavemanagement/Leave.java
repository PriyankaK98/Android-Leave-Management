package com.priyanka.leavemanagement;

/**
 * Created by priyanka on 03-10-2018.
 */

public class Leave {

    private String name;
    private String branch;
    private String phone;
    private String date;
    private String leavetype;
    private String reason;


   Leave(){}

    public Leave(String name, String branch, String phone, String date, String leavetype, String reason) {
        this.name = name;
        this.branch = branch;
        this.phone = phone;
        this.date = date;
        this.leavetype = leavetype;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Name=" + name + "\n" +
                "Branch=" + branch + "\n" +
                "Phone=" + phone + "\n" +
                "Date=" + date + "\n" +
                "Leavetype=" + leavetype + "\n" +
                "Reason=" + reason + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
