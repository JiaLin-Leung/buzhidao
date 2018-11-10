package com.pda.pda_android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.me.ChangeBingQuActivity;
import com.pda.pda_android.activity.me.ChangePasswordActivity;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.Nursebean;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.utils.Util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 梁佳霖创建于：2018/10/17 15:07
 * 功能：
 */
public class MeFragment extends BaseFragment {
    /**
     * 版本号
     */
    private TextView ver_code;
    /**
     * 护士病区
     */
    private LinearLayout layoutChangeBingqu;
    /**
     * 更改密码
     */
    private LinearLayout layout_password;
    /**
     * 检测更新
     */
    private LinearLayout layoutCheckVersion;
    /**
     * 退出按钮
     */
    private  LinearLayout btnQuit;

    private Nursebean nursebean;
    private TextView tv_xingming;
    private TextView tv_gonghao;
    private TextView tv_bingqu;

    public static MeFragment newInstance(String s) {
        MeFragment meFragment = new MeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ContentUrl.ARGS, s);
        meFragment.setArguments(bundle);
        return meFragment;
    }

    @Override
    public void initData() {

        OkHttpManager.getInstance().getRequest(getActivity(), ContentUrl.TestUrl_local + ContentUrl.getNurseProfile, new LoadCallBack<String>(getActivity()) {
            @Override
            protected void onFailure(Call call, IOException e) {

            }

            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {

                Gson gson = new Gson();
                nursebean = gson.fromJson(s,Nursebean.class);
                LogUtils.showLog("22222222",nursebean.toString());
                tv_xingming.setText("姓名："+nursebean.getData().getName());
                tv_gonghao.setText("工号："+nursebean.getData().getCode());
                tv_bingqu.setText("病区："+nursebean.getData().getWards().get(0).getWard_name());
            }

        });
    }

    @Override
    public void initView(View view) {
        tv_xingming = view.findViewById(R.id.tv_xingming);
        tv_gonghao = view.findViewById(R.id.tv_gonghao);
        tv_bingqu = view.findViewById(R.id.tv_bingqu);
        ver_code = view.findViewById(R.id.ver_code);
        layoutChangeBingqu = view.findViewById(R.id.layoutChangeBingqu);
        layout_password = view.findViewById(R.id.layout_password);
        layoutCheckVersion = view.findViewById(R.id.layout_check_version);
        btnQuit = view.findViewById(R.id.btn_quit);
        layoutChangeBingqu.setOnClickListener(this);
        layout_password.setOnClickListener(this);
        layoutCheckVersion.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        ver_code.setText("当前版本号" + Util.getAppVersion(getActivity()));
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_me_content;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.layoutChangeBingqu:
                //切换病区
                Intent intent = new Intent();
                intent.setClass(getActivity(),ChangeBingQuActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_password:
                //更改密码
                Intent intent_password = new Intent();
                intent_password.setClass(getActivity(),ChangePasswordActivity.class);
                startActivity(intent_password);
                break;
            case R.id.layout_check_version:
                showVersionDialog(getActivity(),null,1);
                break;
        }
    }
}
