package com.jues.tianniufarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.six.jues.salon.utils.WXUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button2).setOnClickListener(v -> {
            WXUtils.onRegister(this,"wx0a7db93e698f5b33");
            WXUtils.getSingle().onLogin();
        });
    }
}
