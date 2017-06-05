package com.dom.bean;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class IUser {
    private String ID;
    private String userName;
    private int age;
public IUser(){}

    public IUser(String ID, String userName, int age) {
        this.ID = ID;
        this.userName = userName;
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "IUser{" +
                "ID='" + ID + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
