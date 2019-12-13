package com.hstc.lengoccuong.demomvpm.presenter;

import com.hstc.lengoccuong.demomvpm.manager.UserManager;

public class MyPresenter {

    private OnCallBack listener;

    public void setListener(OnCallBack listener) {
        this.listener = listener;
    }

    public MyPresenter() {

        UserManager.getInstance().addUser("cuong","123456");
    }

    /*public boolean login(String userName,String password){

        return UserManager.getInstance().validInfomartion(userName,password);
    }*/

    public void login(String userName,String password){

        if (UserManager.getInstance().validInfomartion(userName,password)){
            listener.disableEditText();
        }

    }
    public interface OnCallBack{
        void disableEditText();
    }
}
