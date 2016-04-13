package com.example.yuexiao.myrecipe10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class personal3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal3);


        findViewById(R.id.ib_personal3_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.ib_personal3_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 4/2/16 检查更新信息

                Intent intent=new Intent();
                intent.setClass(personal3.this,MainActivity.class);
                startActivity(intent);
                personal1.instance.finish();
                personal2.instance.finish();
                finish();
            }
        });




    }
}
