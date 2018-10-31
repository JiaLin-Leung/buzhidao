package com.pda.pda_android.base.others;

/**
 * 梁佳霖创建于：2018/10/8 14:26
 * 功能：存放服务器和接口地址
 */
public class ContentUrl {

    public static final String ARGS = "args";
    public static final String TestUrl_local = "http://192.168.7.100:8999";//本地接口地址
    public static final String login = "/apps/login";//登录接口地址
    public static final String getUsersList = "/apps/sync/patient/list"; //获取患者列表
    public static final String getUsersCheckList = "/apps/sync/patient/checking/list"; //获取患者检查列表
}
