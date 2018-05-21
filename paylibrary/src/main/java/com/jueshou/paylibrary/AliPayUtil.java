package com.jueshou.paylibrary;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.alipay.sdk.app.PayTask;
import com.jues.zlibrary.api.BaseObserver;
import com.jueshou.paylibrary.callback.AliPayResult;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Introduce:
 * <p>
 * Create By JueShou -- 2018/5/19.22:16
 * Project: WXUtil
 * Email: 152063943642@163.com
 */
public class AliPayUtil {
    private static AliPayUtil mPayUtil;
    private static String TAG = "AliPayUtilLibrary";

    private AliPayUtil() {
    }

    public static AliPayUtil getInstance() {
        if (null == mPayUtil) mPayUtil = new AliPayUtil();
        return mPayUtil;
    }

    public void onPay(Context context, String orderInfo, AliPayResult<Map<String, String>> payResult) {
        Observable.create((ObservableEmitter<Map<String, String>> emitter) -> {
            PayTask alipay = new PayTask((Activity) context);
            Map<String, String> result = alipay.payV2(orderInfo, true);
            emitter.onNext(result);
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Map<String, String>>(context) {
                    @Override
                    protected void onExecute(Map<String, String> stringStringMap) {
                        //todo 支付结果成功回调
                        payResult.onExecute(stringStringMap);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        //todo 支付结果失败回调
                        Log.d(TAG, t.getLocalizedMessage());
                        payResult.onError(t);
                    }
                });
    }
    //new BaseObserver<Map<String, String>>(context) {
    //                    @Override
    //                    protected void onExecute(Map<String, String> stringStringMap) {
    //                        //todo 支付结果成功回调
    //                        Log.d(TAG, stringStringMap.toString());
    //                    }
    //
    //                    @Override
    //                    public void onError(Throwable t) {
    //                        super.onError(t);
    //                        //todo 支付结果失败回调
    //                        Log.d(TAG, t.getLocalizedMessage());
    //                    }
    //                }
}
