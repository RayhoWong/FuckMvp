package com.ate.fuckmvp.mvp;

/**
 * author: Rayho
 * date:   On 2018/6/4
 * describe:
 * Presenter中可共用的代码就是对View引用的方法了，
 * 值得注意的是，上面已经定义好了BaseView，所以我们希望Presenter中持有的View都是BaseView的子类，
 * 这里同样需要泛型来约束：
 */
public class BasePresenter <V extends BaseView> {
    //继承BaseView子类的对象
    private V mView;

    //绑定activity
    public void attachView(V mView){
        this.mView = mView;
    }

    //取消绑定
    public void detachView(){
        this.mView = null;
    }

    //判断activity的引用是否为空
    public boolean isViewAttached(){
        return mView != null;
    }

    //返回activity引用
    public V getView(){
        return mView;
    }
}
