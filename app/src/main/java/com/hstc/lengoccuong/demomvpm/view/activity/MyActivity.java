package com.hstc.lengoccuong.demomvpm.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hstc.lengoccuong.demomvpm.R;
import com.hstc.lengoccuong.demomvpm.presenter.MyPresenter;

public class MyActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUserName,edtPassword;
    private Button btnLogin;
    private MyPresenter myPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        initView();
    }

    private void initView() {

        myPresenter = new MyPresenter();
        myPresenter.setListener(new MyPresenter.OnCallBack() {
            @Override
            public void disableEditText() {
                edtUserName.setEnabled(false);
                edtPassword.setEnabled(false);
            }
        });

        edtUserName = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);

        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                myPresenter.login(edtUserName.getText().toString(),edtPassword.getText().toString());

                    /*if (myPresenter.login(edtUserName.getText().toString(),edtPassword.getText().toString())){
                        Toast.makeText(this,"Login success!",Toast.LENGTH_LONG).show();
                        return;
                    }
                Toast.makeText(this,"Invalid infomation",Toast.LENGTH_LONG).show();*/
                break;
        }
    }
}
