package com.example.yuexiao.myrecipe10;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity{
    private Button btnGetStart;
    private ImageView ivBack;
    private TextView tvLogin;

    private class clickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_signup_back:
                    back();
                    break;
                case R.id.tv_signup_login:
                    logIn();
                    break;
                case R.id.btn_signup_getstart:
                    getStart();
                    break;

            }
        }
    }

    private void back() {

        finish();
    }

    private void logIn() {
        Intent it = new Intent();
        it.setClass(this, LogIn.class);
        startActivity(it);
        finish();
    }

    private void getStart() {

        if (false) {
            //case1: 账号已存在，直接login或换名字
        } else {
            //case2: 新账号
            if (true) {
                //case2.1:密码与确认密码一致
                // TODO: 3/31/16 保存账户信息，注册成功

                Dialog alertDialog = new AlertDialog.Builder(this).setTitle("对话框").setMessage("Complete your Information Now?")
                        .setPositiveButton("Now", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent();
                                intent.setClass(SignUp.this,personal1.class);
                                startActivity(intent);
                                AccountInit.instance.finish();
                                dialog.dismiss();
                                finish();
                            }
                        })
                        .setNegativeButton("Later", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent();
                                intent.setClass(SignUp.this,MainActivity.class);
                                startActivity(intent);

                                AccountInit.instance.finish();

                                dialog.dismiss();
                                finish();
                            }
                        })
                        .setIcon(R.drawable.plate).create();
                alertDialog.show();

            } else {
                //case2.2:不一致
                Toast toast = Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT);
                toast.setMargin(0f, 0.55f);
                toast.show();
            }

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnGetStart = (Button) findViewById(R.id.btn_signup_getstart);
        tvLogin = (TextView) findViewById(R.id.tv_signup_login);
        ivBack = (ImageView) findViewById(R.id.iv_signup_back);

        btnGetStart.setOnClickListener(new clickListener());
        tvLogin.setOnClickListener(new clickListener());
        ivBack.setOnClickListener(new clickListener());
    }
}
