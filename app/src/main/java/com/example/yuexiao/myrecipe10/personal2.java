package com.example.yuexiao.myrecipe10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class personal2 extends AppCompatActivity {

    static personal2 instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        instance=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal2);


        findViewById(R.id.ib_personal2_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.ib_personal2_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 4/2/16 检查更新资料

                Intent it=new Intent();
                it.setClass(personal2.this,personal3.class);
                startActivity(it);
            }
        });
    }

}
