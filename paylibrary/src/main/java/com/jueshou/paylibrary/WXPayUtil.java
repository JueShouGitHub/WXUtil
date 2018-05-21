package com.jueshou.paylibrary;

/**
 * Created by Android Studio .
 * 作者：zhong
 * 日期：2018/5/21
 * 邮箱：15206394364@163.com
 * 介绍：
 * 修订：====================
 */
public class WXPayUtil {
    private static WXPayUtil wxPayUtil;

    private WXPayUtil() {
    }

    public static WXPayUtil getInstance() {
        if (null == wxPayUtil) wxPayUtil = new WXPayUtil();
        return wxPayUtil;
    }
}
