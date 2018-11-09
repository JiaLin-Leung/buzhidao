package com.pda.pda_android.fragment.wjbqs;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.adapter.wjbqs.WjbqsDetailAdapter;
import com.pda.pda_android.adapter.wjbqs.WjbqsEndDetailAdapter;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.WjbEndBean;
import com.pda.pda_android.bean.WjbqsBean;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.fragment.app.Fragment;
import okhttp3.Call;
import okhttp3.Response;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

import static com.pda.pda_android.adapter.wjbqs.WjbqsDetailAdapter.ITEM_SIZE;

/**
 * 无菌包签收已确认
 */

public class WjbqsendFragment extends Fragment {
    private RefreshLayout refreshLayout;
    private StickyListHeadersListView stickyListHeadersListView;
    private WjbqsEndDetailAdapter mainAdapter;
    private  String Patient_no,name;
    private List<WjbEndBean.DataBean> wjbqsBeanListBeans = new ArrayList<>();
    private WjbEndBean wjbEndBean;
    private View view;
    private LinearLayout no_data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_wjbqsend, container, false);
        init(view);
        initData();
        return view;
    }
    private void initData() {
        Map<String, String> params = new HashMap<>(); //提交数据包
//        params.put("page", 1+""); //将姓名参数添加到数据包
        OkHttpManager.getInstance().postRequest(getActivity(), ContentUrl.TestUrl_local + ContentUrl.sign_list, new LoadCallBack<String>(getActivity()) {
            @Override
            protected void onFailure(Call call, IOException e) {
            }
            @Override
            protected void onSuccess(Call call, Response response, String s)  {
                Gson gson = new Gson();
                wjbEndBean = gson.fromJson(s,WjbEndBean.class);
                wjbqsBeanListBeans = wjbEndBean.getData();
                if (wjbqsBeanListBeans.size()==0){
                    no_data.setVisibility(View.GONE);
                }
                mainAdapter = new WjbqsEndDetailAdapter(getActivity(),wjbqsBeanListBeans);
                stickyListHeadersListView.setAdapter(mainAdapter);
            }
        },params);
    }

    private void init(View view) {
        refreshLayout=view.findViewById(R.id.refreshLayout1);
        stickyListHeadersListView=view.findViewById(R.id.wsjqs_end_list);
        no_data=view.findViewById(R.id.no_data);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(1500,true);
            }
        });
        //设置 Header 为 ClassicsHeader
        refreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        stickyListHeadersListView.setStickyHeaderTopOffset(1);
        //设置头部改变的监听
        stickyListHeadersListView.setOnStickyHeaderChangedListener(new StickyListHeadersListView.OnStickyHeaderChangedListener() {
            @Override
            public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {
                header.findViewById(R.id.item_end_shaixuan).setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Patient_no = "ZY040000469876";
        name = "1231231";
    }
}
