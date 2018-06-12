package com.ate.fuckmvp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ate.fuckmvp.R;
import com.ate.fuckmvp.base.BaseApp;
import com.ate.fuckmvp.mvp.presenter.MainPresenter;
import com.ate.fuckmvp.mvp.view.MainView;
import com.ate.fuckmvp.utils.NetworkUtils;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    Button mBtSend;
    ProgressDialog mDialog;
    RelativeLayout mRl;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRl = findViewById(R.id.rl);
        mBtSend = findViewById(R.id.bt_send);
        mBtSend.setOnClickListener(this);

        mDialog = new ProgressDialog(this);
        mDialog.setCancelable(false);
        mDialog.setMessage("正在加载...");

        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);


    }

    @Override
    public void showSnackbar(String content) {
        Snackbar.make(mRl,content,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        mainPresenter.getData();
    }

    @Override
    public void showLoading() {
        if(!mDialog.isShowing()){
            mDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if(mDialog.isShowing()){
            mDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideView() {}

    @Override
    public void showView() {}

    @Override
    public void showErrorMessage(String msg) {}

    @Override
    public void toActivity() {}
}
