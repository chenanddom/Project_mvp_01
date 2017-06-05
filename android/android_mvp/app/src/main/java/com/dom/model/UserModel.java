package com.dom.model;

import android.content.Context;

import com.dom.bean.IUser;
import com.dom.db.MyDB;

/**
 * Created by chendom on 2017/6/1 0001.
 */
public class UserModel implements IUserModel {
    private String ID;
    private String userName;
    private int age;
    private MyDB db;
   public UserModel(Context context){
       db = new MyDB(context);
    }
    @Override
    public String getID() {
        return this.ID!=null?this.ID:null;
    }
    @Override
    public void setID(String ID) {
        this.ID=ID;
    }
    @Override
    public void setUserName(String userName) {
        this.userName=userName;
    }
    @Override
    public void setAge(int age) {
        this.age=age;
    }
    @Override
    public boolean saveUser(IUser user) {
        return db.addUser(user);
    }
    @Override
    public IUser loadUser(String ID) {
        return db.findUserById(ID);
    }
}
