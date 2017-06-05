package com.dom.mpresenter;

import android.content.Context;

import com.dom.bean.IUser;
import com.dom.model.IUserModel;
import com.dom.model.UserModel;
import com.dom.mview.IUserView;

/**
 * Created by chendom on 2017/6/1 0001.
 */

public class UserPresenter {
    private IUserView iUserView;
    private IUserModel iUserModel;
    public UserPresenter(IUserView view){
        this.iUserView=view;
        iUserModel=new UserModel(((Context)view));
    }
    public boolean saveUser(String ID,String userName,int age){
 /*       iUserModel.setID(ID);
        iUserModel.setUserName(userName);
        iUserModel.setAge(age);*/
    return iUserModel.saveUser(new IUser(ID,userName,age));


    }
    public void loadUser( String id) {
        IUser user = iUserModel.loadUser(id);
        iUserView.setUserName(user.getUserName());
        iUserView.setAge(user.getAge());
    }

}
