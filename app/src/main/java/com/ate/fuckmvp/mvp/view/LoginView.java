package com.ate.fuckmvp.mvp.view;
// Created by Rayho on 2018/6/1.

/**
 * author: Rayho
 * date:   On 2018/6/1
 * view层:
 */
public interface LoginView {
    /**
     * 显示进度
     */
    void showLoading();

    /**
     * 隐藏进度
     */
    void hideLoading();

    /**
     * 显示Toast
     * @param msg
     */
    void showToast(String msg);

    /**
     * 显示错误信息
     * @param msg
     */
    void showErrorMessage(String msg);

    /**
     * 登录成功跳转主界面
     */
    void toMainActivity();
}
