package com.dom.model;

import com.dom.bean.IUser;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public interface IUserModel {
    public String getID() ;
    public void setID(String ID);
    public void setUserName(String userName);
    public void setAge(int age);
    public boolean saveUser(IUser user);
    public IUser loadUser(String ID);

}
