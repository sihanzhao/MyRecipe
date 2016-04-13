package com.example.yuexiao.myrecipe10;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;


class TakePhotoPopWin extends PopupWindow {

    private Context mContext;

    private View view;

    private Button btn_take_photo, btn_pick_photo, btn_cancel;



    public TakePhotoPopWin(Context mContext, View.OnClickListener itemsOnClick) {

        this.view = LayoutInflater.from(mContext).inflate(R.layout.filter_pop, null);
        // TODO: 4/12/16 filter xml 界面设计与交互

        this.setOutsideTouchable(true);

        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.view.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = view.findViewById(R.id.pop_layout).getTop();

                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {

                        dismiss();
                    }
                }
                return true;
            }
        });


        this.setContentView(this.view);
        this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setWidth(600);
        this.setFocusable(true);

         //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);

        this.setAnimationStyle(R.style.filter_anim);


    }
}

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView autotext;
    private ArrayAdapter<String> arrayAdapter;
    final int CODE = 1;
    static private Boolean bool = true;
    public static TakePhotoPopWin takePhotoPopWin;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //初始化界面只出现一次
        if (bool) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Initial.class);
            startActivity(intent);
            finish();
            bool = false;
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.iv_main_filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopFormBottom(v);
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void showPopFormBottom(View view) {
        takePhotoPopWin = new TakePhotoPopWin(this, onClickListener);
        takePhotoPopWin.showAsDropDown(findViewById(R.id.ll_activitymain_1), 0, 0, Gravity.RIGHT);
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.alpha = 0.7F; //0.0-1.0
//        getWindow().setAttributes(lp);
        

    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };



}
