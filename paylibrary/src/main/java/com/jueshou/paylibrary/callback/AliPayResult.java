package com.jueshou.paylibrary.callback;

/**
 * Created by Android Studio .
 * 作者：zhong
 * 日期：2018/5/21
 * 邮箱：15206394364@163.com
 * 介绍：
 * 修订：====================
 */
public abstract class AliPayResult<T> {
    public void onExecute(T t) {
    }

    public void onError(Throwable t) {
    }
}
