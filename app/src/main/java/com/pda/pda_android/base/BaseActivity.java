package com.pda.pda_android.base;


import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.pda.pda_android.R;


import androidx.appcompat.app.AppCompatActivity;

/**
 * 梁佳霖创建于：2018/10/8 13:48
 * 功能：Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(setLayoutId());
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    /**
     * 布局文件引入方法
     *
     * @return 布局资源
     */
    public abstract int setLayoutId();

    /**
     * 初始化控件方法
     */
    public abstract void initView();

    /**
     * 初始化数据方法
     */
    public abstract void initData();

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_back_users:
                finish();
                break;
            case R.id.user_list_back:
                finish();
                break;
        }
    }
    /**
     * 设置标题,不包含右边完成按钮
     *
     * @param title 标题的文本
     */
    public void setTitle(String title) {
        TextView baseTitle = findViewById(R.id.teacher_details_users);
        baseTitle.setText(title);
    }

    /**
     * Toast 公共Toast方法
     *
     * @param message 需要展示的信息
     */
    public void showShortToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
