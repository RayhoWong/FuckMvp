package com.ate.fuckmvp.mvp.presenter;
// Created by Rayho on 2018/6/1.

import com.ate.fuckmvp.mvp.model.LoginInteractor;
import com.ate.fuckmvp.mvp.model.LoginInteractorImpl;
import com.ate.fuckmvp.mvp.view.LoginView;

/**
 * author: Rayho
 * date:   On 2018/6/1
 * presenter层负责model和view的交互
 *          需要传入view的实例和model的实例
 *          根据model定义的业务 实现功能
 *          根据处理结果通过view层更新ui
 */
public class LoginPresenter {

    LoginView loginView;

    LoginInteractorImpl interactorImpl;

    private String phone;

    private String password;

    private String result;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        interactorImpl = new LoginInteractorImpl();
    }

    public void detachView(){
        loginView = null;
    }

    /**
     * 验证账号的信息
     * @param phone
     * @param password
     */
    public void validate(String phone,String password){
        this.phone = phone;
        this.password = password;
        result = interactorImpl.validateInfo(phone,password);
        loginView.showLoading();
        switch (result){
            case LoginInteractorImpl.PHONE_NULL:
                loginView.hideLoading();
                loginView.showToast(LoginInteractorImpl.PHONE_NULL);
                break;
            case LoginInteractorImpl.PASSWORD_NULL:
                loginView.hideLoading();
                loginView.showToast(LoginInteractorImpl.PASSWORD_NULL);
                break;
            case LoginInteractorImpl.NOT_NULL:
                login();
                break;
        }
    }

    /**
     * 账号信息都不为空开始登录操作
     */
    private void login(){
        interactorImpl.login(phone, password, new LoginInteractor.OnLoginFinishedListener() {
            @Override
            public void onSuccess() {
//                Log.d(TAG, "onSuccess: "+"test");
                loginView.hideLoading();
                loginView.showToast("登录成功");
            }

            @Override
            public void onFailed() {
//                Log.d(TAG, "onSuccess: "+"test");
                loginView.hideLoading();
//                loginView.showErrorMessage("登录失败 手机号或者密码不对");
                loginView.showToast("登录失败 手机号或者密码不对");
            }
        });
    }
}
