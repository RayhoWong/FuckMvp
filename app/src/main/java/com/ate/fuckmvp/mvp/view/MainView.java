package com.ate.fuckmvp.mvp.view;

import android.view.View;

import com.ate.fuckmvp.mvp.BaseView;

/**
 * author: Rayho
 * date:   On 2018/6/4
 * describe:
 * 主界面点击按钮请求数据成功后显示一个Snackbar
 */
public interface MainView extends BaseView {
    void showSnackbar(View view,String content);
}
