package com.ate.fuckmvp.mvp.presenter;
// Created by Rayho on 2018/6/1.

import com.ate.fuckmvp.mvp.model.LoginInteractor;
import com.ate.fuckmvp.mvp.model.LoginInteractorImpl;
import com.ate.fuckmvp.mvp.view.LoginView;

/**
 * author: Rayho
 * date:   On 2018/6/1
 * presenter层负责model和view的交互
 * 需要传入view的实例和model的实例
 * 根据model定义的业务 实现功能
 * 根据处理结果通过view层更新ui
 */
public class LoginPresenter {

    LoginView loginView;

    LoginInteractorImpl interactorImpl;

    private String phone;

    private String password;

    private String result;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        interactorImpl = new LoginInteractorImpl();
    }

    /**
     * 每次调用view层的方法时 判断view的引用是否为空 这里的view一般指activity或者fragment
     * @return
     */
    public boolean isViewAttached() {
        return loginView != null;
    }

    //在Activity被销毁时 解除presenter对activity的引用 防止报空指针异常
    public void detachView() {
        loginView = null;
    }

    /**
     * 验证账号的信息
     *
     * @param phone
     * @param password
     */
    public void validate(String phone, String password) {
        this.phone = phone;
        this.password = password;
        //得到账号信息验证的结果
        result = interactorImpl.validateInfo(phone, password);
        if (isViewAttached()) {
            loginView.showLoading();
        }
        switch (result) {
            case LoginInteractorImpl.PHONE_NULL:
                if (isViewAttached()) {
                    loginView.hideLoading();
                    loginView.showToast(LoginInteractorImpl.PHONE_NULL);
                }
                break;
            case LoginInteractorImpl.PASSWORD_NULL:
                if (isViewAttached()) {
                    loginView.hideLoading();
                    loginView.showToast(LoginInteractorImpl.PASSWORD_NULL);
                }
                break;
            case LoginInteractorImpl.NOT_NULL:
                login();
                break;
        }
    }

    /**
     * 账号信息都不为空开始登录操作
     */
    private void login() {
        interactorImpl.login(phone, password, new LoginInteractor.OnLoginFinishedListener() {
            @Override
            public void onSuccess() {
                if (isViewAttached()) {
                    loginView.hideLoading();
                    loginView.showToast("登录成功");
                    loginView.toMainActivity();
                }
            }

            @Override
            public void onFailed() {
                if (isViewAttached()) {
                    loginView.hideLoading();
                    loginView.showToast("登录失败 手机号或者密码不对");
                }
            }
        });
    }
}
