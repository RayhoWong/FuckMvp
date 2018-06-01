package com.ate.fuckmvp.mvp.model;
// Created by Rayho on 2018/6/1.

import android.text.TextUtils;
import android.os.Handler;

/**
 * author: Rayho
 * date:   On 2018/6/1
 * model的实现类:主要负责请求数据和处理数据 返回处理结果
 */
public class LoginInteractorImpl implements LoginInteractor {

    public static final String PHONE_NULL = "手机号码不能为空";

    public static final String PASSWORD_NULL = "密码不能为空";

    public static final String NOT_NULL = "SUCCESS";

    @Override
    public String validateInfo(String phone, String password) {
        if(TextUtils.isEmpty(phone)){
            return "手机号码不能为空";
        }
        if (TextUtils.isEmpty(password)){
            return "密码不能为空";
        }
        return "SUCCESS";
    }

    @Override
    public void login(final String phone, final String password, final OnLoginFinishedListener listener) {
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
                if(phone.equals("18814118201") && password.equals("123456")){
                    listener.onSuccess();
                }else {
                    listener.onFailed();
                }
           }
       },2000);
    }
}
