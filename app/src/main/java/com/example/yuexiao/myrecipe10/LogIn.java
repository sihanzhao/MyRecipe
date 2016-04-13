package com.example.yuexiao.myrecipe10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    private Button btnGetStart;
    private ImageView ivBack;
    private TextView tvSignUp;

    private class clickListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_login_back:
                    back();
                    break;
                case R.id.tv_login_signup:
                    signUp();
                    break;
                case R.id.btn_login_getstart:
                    getStart();


            }
        }
    }

    private void back() {
        finish();
    }

    private void signUp() {
        Intent intent = new Intent();
        intent.setClass(this, SignUp.class);
        startActivity(intent);
        finish();

    }

    private void getStart() {
        String account="1";
        String password="2";
        //验证密码
        if (true) {
            Intent intent=new Intent();
            intent.setClass(this, MainActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("Account",account);
            bundle.putString("Password", password);
            intent.putExtras(bundle);
            startActivity(intent);

            //结束accountInit activity
            AccountInit.instance.finish();


            finish();


        } else {
            //查有输入账号是否存在
            if (true) {
                //没有对应账号
                Toast toast=Toast.makeText(this, "Account Not Exist!", Toast.LENGTH_SHORT);
                toast.setMargin(0f,0.55f);
                        toast.show();
            } else {
                //有账号，密码不对
                Toast toast=Toast.makeText(this, "Incorrect Password!", Toast.LENGTH_SHORT);
                toast.setMargin(0f,0.55f);
                toast.show();

            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        btnGetStart = (Button) findViewById(R.id.btn_login_getstart);
        tvSignUp = (TextView) findViewById(R.id.tv_login_signup);
        ivBack = (ImageView) findViewById(R.id.iv_login_back);

        btnGetStart.setOnClickListener(new clickListener());
        tvSignUp.setOnClickListener(new clickListener());
        ivBack.setOnClickListener(new clickListener());

    }

}
