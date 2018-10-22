package com.ate.fuckmvp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ate.fuckmvp.R;
import com.ate.fuckmvp.mvp.presenter.LoginPresenter;
import com.ate.fuckmvp.mvp.view.LoginView;

/**
 * View的实现类 只负责ui的显示
 */
public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private static final String TAG = "test";
    private EditText mPhone;

    private EditText mPassword;

    private Button mLogin;

    private ProgressDialog mDialog;

    private LoginPresenter presenter;

    private String phone;

    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPhone = findViewById(R.id.et_phone);
        mPassword = findViewById(R.id.et_pwd);
        mLogin = findViewById(R.id.bt_login);

        mDialog = new ProgressDialog(this);
        mDialog.setCancelable(false);
        mDialog.setMessage("正在加载...");

        mLogin.setOnClickListener(this);

        presenter = new LoginPresenter(this);

        Log.d(TAG, "onCreate: "+"test损失的发生");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showLoading() {
        if (!mDialog.isShowing()){
            mDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mDialog.isShowing()){
            mDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String msg) {}

    @Override
    public void toMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    //点击事件 负责传参
    @Override
    public void onClick(View v) {
        phone = mPhone.getText().toString().trim();
        password = mPassword.getText().toString().trim();
        presenter.validate(phone,password);
    }
}
