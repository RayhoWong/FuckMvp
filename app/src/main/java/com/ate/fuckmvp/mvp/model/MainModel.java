package com.ate.fuckmvp.mvp.model;

import android.os.Handler;

import com.ate.fuckmvp.R;
import com.ate.fuckmvp.bean.MovieDetail;
import com.ate.fuckmvp.http.NetObserver;
import com.ate.fuckmvp.http.RetrofitLoader;
import com.ate.fuckmvp.http.exception.ApiException;
import com.ate.fuckmvp.mvp.CallBack;


/**
 * author: Rayho
 * date:   On 2018/6/4
 * describe:
 * 进行网络请求
 */
public class MainModel {
    /**
     * 请求网络获取数据
     *
     * @param callBack
     */
    public void getData(final CallBack<MovieDetail> callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RetrofitLoader.getInstance()
                        .getMovie()
                        .subscribe(new NetObserver<MovieDetail>() {
                            @Override
                            public void onNext(MovieDetail movieDetail) {
                                callBack.onSuccess(movieDetail);
                            }

                            @Override
                            public void onError(ApiException ex) {
                                callBack.onError(ex.getDisplayMessage());
                            }
                        });
            }
        }, 2000);
    }
}
