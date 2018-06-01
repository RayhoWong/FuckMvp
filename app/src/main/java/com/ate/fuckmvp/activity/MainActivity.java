package com.ate.fuckmvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ate.fuckmvp.R;
import com.ate.fuckmvp.mvp.presenter.LoginPresenter;
import com.ate.fuckmvp.mvp.view.LoginView;

/**
 * View的实现类 只负责ui的显示
 */
public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText mPhone;

    private EditText mPassword;

    private Button mLogin;

    private ProgressBar mProgress;

    private LoginPresenter presenter;

    private String phone;

    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhone = findViewById(R.id.et_phone);
        mPassword = findViewById(R.id.et_pwd);
        mLogin = findViewById(R.id.bt_login);
        mProgress = findViewById(R.id.pb);

        mLogin.setOnClickListener(this);

        presenter = new LoginPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showLoading() {
        if (!mProgress.isShown()){
            mProgress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideLoading() {
        if (mProgress.isShown()){
            mProgress.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String msg) {}

    //点击事件 负责传参
    @Override
    public void onClick(View v) {
        phone = mPhone.getText().toString().trim();
        password = mPassword.getText().toString().trim();
        presenter.validate(phone,password);
    }
}
