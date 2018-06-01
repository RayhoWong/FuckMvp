package com.ate.fuckmvp.mvp.model;
// Created by Rayho on 2018/6/1.

/**
 * author: Rayho
 * date:   On 2018/6/1
 * model层:根据需求定义功能
 *         主要负责请求数据和处理数据 返回处理结果
 */
public interface LoginInteractor {

    interface OnLoginFinishedListener{
        //登录成功
        void onSuccess();
        //登录失败
        void onFailed();
    }

    //验证账号信息
    String validateInfo(String phone,String password);

    //登录
    void login(String phone,String password,OnLoginFinishedListener listener);
}
