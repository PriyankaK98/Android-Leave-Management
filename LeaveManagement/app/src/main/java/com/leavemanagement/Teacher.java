package com.priyanka.leavemanagement;

/**
 * Created by priyanka on 02-10-2018.
 */

public class Teacher {
    private String name1;
    private String branch1;
    private String phone1;
    private String date1;
    private String leavetype1;
    private String reason1;

   Teacher() {};

    public Teacher(String name1, String branch1, String phone1, String date1, String leavetype1, String reason1) {
        this.name1 = name1;
        this.branch1 = branch1;
        this.phone1 = phone1;
        this.date1 = date1;
        this.leavetype1 = leavetype1;
        this.reason1 = reason1;
    }

    @Override
    public String toString() {
        return "Name=" + name1 + "\n" + "Branch=" + branch1 + "\n" +
                "Phone=" + phone1 + "\n" +
                "Date=" + date1 + "\n" +
                "Leavetype=" + leavetype1 + "\n" +
                "Reason=" + reason1 + "\n";
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getBranch1() {
        return branch1;
    }

    public void setBranch1(String branch1) {
        this.branch1 = branch1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getLeavetype1() {
        return leavetype1;
    }

    public void setLeavetype1(String leavetype1) {
        this.leavetype1 = leavetype1;
    }

    public String getReason1() {
        return reason1;
    }

    public void setReason1(String reason1) {
        this.reason1 = reason1;
    }
}
