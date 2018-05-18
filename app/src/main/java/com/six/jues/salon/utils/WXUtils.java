package com.six.jues.salon.utils;

import android.content.Context;
import android.graphics.Bitmap;

import com.six.jues.salon.entity.ShareEntity;
import com.six.jues.salon.global.Global;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import static com.six.jues.salon.global.Global.THUMB_SIZE;


/**
 * Created by Android Studio .
 * 作者：zhong
 * 日期：2018/5/14
 * 邮箱：15206394364@163.com
 * 介绍：
 * 修订：====================
 */
public class WXUtils {
    private static WXUtils wxUtils;
    private static IWXAPI mApi;

    private WXUtils() {
    }

    public static WXUtils getSingle() {
        if (null == wxUtils) wxUtils = new WXUtils();
        return wxUtils;
    }

    /**
     * 向微信APP注册你的id
     * 要使你的程序启动后微信终端能响应你的程序，必须在代码中向微信终端注册你的id。
     *
     * @param context
     * @param app_id
     */
    public static void onRegister(Context context, String app_id) {
        Global.APP_ID = app_id;
        mApi = WXAPIFactory.createWXAPI(context, Global.APP_ID, true);
        mApi.registerApp(Global.APP_ID);
    }

    public void onLogin() {
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        mApi.sendReq(req);
    }

    public void onShare(ShareEntity shareEntity, int WXSceneType) {
        //mApi = WXAPIFactory.createWXAPI(context, Global.APP_ID);
        //Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.herd_108);
        //初始化WXImageObject和WXMediaMessage对象
        //WXImageObject imageObject = new WXImageObject(shareEntity.getImage());
        //网页类型分享示例
        WXWebpageObject webpageObject = new WXWebpageObject();
        webpageObject.webpageUrl = shareEntity.getUrl();
        WXMediaMessage mediaMessage = new WXMediaMessage(webpageObject);
        //mediaMessage.mediaObject = imageObject;

        //设置缩略图
        if (null != shareEntity.getImage()) {
            Bitmap thumbBmp = Bitmap.createScaledBitmap(shareEntity.getImage(), THUMB_SIZE, THUMB_SIZE, true);
            shareEntity.getImage().recycle();
            mediaMessage.thumbData = Util.bmpToByteArray(thumbBmp, true);
        }

        mediaMessage.description = shareEntity.getDescription();
        mediaMessage.title = shareEntity.getTitle();

        //构造一个Req
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        //transaction唯一标识一个请求
        req.transaction = buildTransaction("webpage");
        req.message = mediaMessage;
        //发送到聊天界面——WXSceneSession = 0
        //发送到朋友圈——WXSceneTimeline = 1
        //添加到微信收藏——WXSceneFavorite = 2
        //req.scene = SendMessageToWX.Req.WXSceneSession;
        req.scene = WXSceneType;
        mApi.sendReq(req);
    }

    public void onShareText(ShareEntity shareEntity, int WXSceneType) {
        WXTextObject textObj = new WXTextObject();
        textObj.text = shareEntity.getText();
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;
        msg.description = shareEntity.getText();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("text");
        req.message = msg;
        req.scene = WXSceneType;
        mApi.sendReq(req);
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }
}
