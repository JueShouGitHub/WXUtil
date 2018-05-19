package com.jues.tianniufarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jues.tianniufarm.global.Global;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class MainActivity extends AppCompatActivity {

    private IWXAPI mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}
