package com.ate.fuckmvp.mvp;
// Created by Rayho on 2018/6/4.

/**
 * author: Rayho
 * date:   On 2018/6/4
 * 提供一些公用的ui效果
 */
public interface BaseView {
    /**
     * 隐藏view
     */
    void hideView();

    /**
     * 显示view
     */
    void showView();

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
     * 跳转activity
     */
    void toActivity();
}
