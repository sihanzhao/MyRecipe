package com.example.yuexiao.myrecipe10;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


class PopWin extends PopupWindow {

    private Context mContext;

    private View view;


    public PopWin(Context mContext) {

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

public class MainActivity extends Activity implements android.view.View.OnClickListener {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private List<View> views = new ArrayList<View>();

    private LinearLayout iMenu;
    private LinearLayout iPlan;
    private LinearLayout iAlarm;
    private LinearLayout iMe;

    private ImageButton btnMenu;
    private ImageButton btnPlan;
    private ImageButton btnAlarm;
    private ImageButton btnMe;

    static private int currentItem;


    private AutoCompleteTextView autotext;
    private ArrayAdapter<String> arrayAdapter;
    final int CODE = 1;
    static private Boolean bool = true;
    public static PopWin popWin;

    private Context mContext;
    private View view;

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


        initView();
        initViewPage();

        initEvent();



    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.id_viewpage);

        iPlan = (LinearLayout) findViewById(R.id.ll_tab_plan);
        iAlarm = (LinearLayout) findViewById(R.id.ll_tab_alarm);
        iMe = (LinearLayout) findViewById(R.id.ll_tab_me);
        iMenu = (LinearLayout) findViewById(R.id.ll_tab_menu);

        btnAlarm = (ImageButton) findViewById(R.id.ib_tab_alarm);
        btnMe = (ImageButton) findViewById(R.id.ib_tab_me);
        btnMenu = (ImageButton) findViewById(R.id.ib_tab_menu);
        btnPlan = (ImageButton) findViewById(R.id.ib_tab_plan);

        iMenu.setOnClickListener(this);
        iMe.setOnClickListener(this);
        iAlarm.setOnClickListener(this);
        iPlan.setOnClickListener(this);

    }

    private void initViewPage() {

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        views.add(layoutInflater.inflate(R.layout.menu, null));
        views.add(layoutInflater.inflate(R.layout.plan, null));
        views.add(layoutInflater.inflate(R.layout.alarm, null));
        views.add(layoutInflater.inflate(R.layout.me, null));

        pagerAdapter = new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position));

            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = views.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {

                return arg0 == arg1;
            }

            @Override
            public int getCount() {

                return views.size();
            }
        };
        viewPager.setAdapter(pagerAdapter);


    }

    private void initEvent() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            public void onPageSelected(int arg0) {
                currentItem=viewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        resetImg();
                        btnMenu.setImageResource(R.drawable.back4);
                        findViewById(R.id.iv_main_filter).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showPopFormBottom(v);
                            }
                        });
                        break;
                    case 1:
                        resetImg();
                        btnPlan.setImageResource(R.drawable.back4);
                        break;
                    case 2:
                        resetImg();
                        btnAlarm.setImageResource(R.drawable.back4);
                        break;
                    case 3:
                        resetImg();
                        btnMe.setImageResource(R.drawable.back4);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }


        });


    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void showPopFormBottom(View view) {
        popWin = new PopWin(this);
        popWin.showAsDropDown(findViewById(R.id.tv_main_point), 0, 0, Gravity.RIGHT);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_tab_menu:
                viewPager.setCurrentItem(0);
                resetImg();
                btnMenu.setImageResource(R.drawable.back4);
                break;
            case R.id.ll_tab_me:
                viewPager.setCurrentItem(1);
                resetImg();
                btnMe.setImageResource(R.drawable.back4);
                break;
            case R.id.ll_tab_alarm:
                viewPager.setCurrentItem(2);
                resetImg();
                btnAlarm.setImageResource(R.drawable.back4);
                break;
            case R.id.ll_tab_plan:
                viewPager.setCurrentItem(3);
                resetImg();
                btnPlan.setImageResource(R.drawable.back4);
                break;

            default:
                break;


        }


    }


    private void resetImg() {
        btnMenu.setImageResource(R.drawable.plate);
        btnMe.setImageResource(R.drawable.person);
        btnPlan.setImageResource(R.drawable.plan);
        btnAlarm.setImageResource(R.drawable.alarm);

    }


}
