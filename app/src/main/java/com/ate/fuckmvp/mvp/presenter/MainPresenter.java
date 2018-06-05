package com.ate.fuckmvp.mvp.presenter;

import com.ate.fuckmvp.bean.MovieDetail;
import com.ate.fuckmvp.mvp.BasePresenter;
import com.ate.fuckmvp.mvp.CallBack;
import com.ate.fuckmvp.mvp.model.MainModel;
import com.ate.fuckmvp.mvp.view.MainView;

/**
 * author: Rayho
 * date:   On 2018/6/4
 * describe:
 * 对model层返回的请求结果进行处理,通过view更新ui
 */
public class MainPresenter extends BasePresenter<MainView>{

    private MainModel mainModel;

    public MainPresenter(){
        mainModel = new MainModel();
    }

    public void getData(){
        if(!isViewAttached()){
            return;
        }
        getView().showLoading();
        mainModel.getData(new CallBack<MovieDetail>() {
            @Override
            public void onSuccess(MovieDetail data) {
                if(data != null){
                    if(isViewAttached()){
                        getView().hideLoading();
                        getView().showSnackbar(data.title);
                    }
                }else {
                    if (isViewAttached()){
                        getView().hideLoading();
                        getView().showToast("请求失败 数据为空");
                    }
                }
            }

            @Override
            public void onFailure(String msg) {}

            @Override
            public void onError(String error) {
                if (isViewAttached()){
                    getView().hideLoading();
                    getView().showToast(error);
                }
            }

            @Override
            public void onComplete() {}
        });
    }




}
