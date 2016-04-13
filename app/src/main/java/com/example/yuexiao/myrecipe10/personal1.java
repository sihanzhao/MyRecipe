package com.example.yuexiao.myrecipe10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class personal1 extends AppCompatActivity {
    static personal1 instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal1);

        instance=this;

        findViewById(R.id.ib_personal1_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 4/2/16 检查都填完后，更新个人资料

                Intent it=new Intent();
                it.setClass(personal1.this,personal2.class);
                startActivity(it);
            }
        });

    }
}
