package com.six.jues.salon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.six.jues.salon.call.SharePopup;
import com.six.jues.salon.entity.ShareEntity;
import com.six.jues.salon.utils.WXUtils;

import static com.six.jues.salon.global.Global.APP_ID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WXUtils.getSingle().onRegister(this, "wxe3c8a4a0d3b2ab42");

        findViewById(R.id.textView).setOnClickListener(v -> {
            View view = findViewById(R.id.rootView);
            ShareEntity entity = new ShareEntity();
            entity.setTitle("测试封装微信");
            entity.setDescription("网页类型分享示例");
            entity.setUrl("http://www.baidu.com");
            entity.setImage(getResources(), R.drawable.herd_108);
            SharePopup.showWebPopup(view, entity,"wxe3c8a4a0d3b2ab42");
        });
        findViewById(R.id.button).setOnClickListener(v -> {
            WXUtils.getSingle().onLogin();
        });
    }
}
