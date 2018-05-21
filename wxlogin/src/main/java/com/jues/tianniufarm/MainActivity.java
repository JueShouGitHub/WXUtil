package com.jues.tianniufarm;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jues.tianniufarm.global.Global;
import com.jueshou.paylibrary.AliPayUtil;
import com.jueshou.paylibrary.callback.AliPayResult;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private static String TAG = "AliPayUtilLibrary";
    private IWXAPI mApi;
    private Context mContext;

    private String orderInfoTest = "app_id=2015052600090779&biz_content=%7B%22timeout_express%22%3A%223" +
            "0m%22%2C%22seller_id%22%3A%22%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%2" +
            "2total_amount%22%3A%220.02%22%2C%22subject%22%3A%221%22%2C%22body%22%3A%22%E6%88%91%E6" +
            "%98%AF%E6%B5%8B%E8%AF%95%E6%95%B0%E6%8D%AE%22%2C%22out_trade_no%22%3A%22314VYGIAGG7ZOY" +
            "Y%22%7D&charset=utf-8&method=alipay.trade.app.pay&sign_type=RSA2&timestamp=2016-08-15%" +
            "2012%3A12%3A15&version=1.0&sign=MsbylYkCzlfYLy9PeRwUUIg9nZPeN9SfXPNavUCroGKR5Kqvx0nEnd" +
            "3eRmKxJuthNUx4ERCXe552EV9PfwexqW%2B1wbKOdYtDIb4%2B7PL3Pc94RZL0zKaWcaY3tSL89%2FuAVUsQuF" +
            "qEJdhIukuKygrXucvejOUgTCfoUdwTi7z%2BZzQ%3D";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.button2).setOnClickListener(v -> {
            mApi = WXAPIFactory.createWXAPI(this, Global.APP_ID, true);
            mApi.registerApp(Global.APP_ID);
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wechat_sdk_demo_test";
            mApi.sendReq(req);
        });
        findViewById(R.id.button3).setOnClickListener(v -> {
//            View view = findViewById(R.id.rootView);
//            ShareEntity entity = new ShareEntity();
//            entity.setTitle("测试封装微信");
//            entity.setDescription("网页类型分享示例");
//            entity.setUrl("http://www.baidu.com");
//            entity.setImage(getResources(), R.drawable.herd_108);
//            SharePopup.showWebPopup(view, entity,"wx0a7db93e698f5b33");
        });
        findViewById(R.id.button).setOnClickListener(v -> {
            //支付宝支付，直接调用
            AliPayUtil.getInstance().onPay(mContext, orderInfoTest
                    , new AliPayResult<Map<String, String>>() {
                        @Override
                        public void onExecute(Map<String, String> stringStringMap) {
                            Log.d(TAG, "NULL");
                        }

                        @Override
                        public void onError(Throwable t) {
                            Log.d(TAG, t.getLocalizedMessage());
                        }
                    });
        });
    }
}
