package com.six.jues.salon.call;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.six.jues.salon.R;
import com.six.jues.salon.entity.ShareEntity;
import com.six.jues.salon.utils.WXUtils;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;

/**
 * Created by Android Studio .
 * 作者：zhong
 * 日期：2018/5/15
 * 邮箱：15206394364@163.com
 * 介绍：
 * 修订：====================
 */
public class SharePopup {

    private static ImageView view1;
    private static ImageView view2;
    private static ImageView view3;
    private static PopupWindow popupWindow;

    protected static void showPopup(View rootView, ShareEntity entity) {
        Context context = rootView.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_share, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(context.getDrawable(R.drawable.bg_popup));
        view1 = view.findViewById(R.id.imageView);
        view2 = view.findViewById(R.id.imageView2);
        view3 = view.findViewById(R.id.imageView3);
        TextView textView = view.findViewById(R.id.textView);

        view1.setOnClickListener(v -> {
            WXUtils.getSingle().onShare(entity, SendMessageToWX.Req.WXSceneSession);
            popupWindow.dismiss();
        });
        view2.setOnClickListener(v -> {
            WXUtils.getSingle().onShare(entity, SendMessageToWX.Req.WXSceneTimeline);
            popupWindow.dismiss();
        });
        view3.setOnClickListener(v -> {
            WXUtils.getSingle().onShare(entity, SendMessageToWX.Req.WXSceneFavorite);
            popupWindow.dismiss();
        });
        textView.setOnClickListener(v -> popupWindow.dismiss());
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    public static void showTextPopup(View rootView, ShareEntity entity) {
        showPopup(rootView, entity);
        view1.setOnClickListener(v -> {
            WXUtils.getSingle().onShareText(entity, SendMessageToWX.Req.WXSceneSession);
            popupWindow.dismiss();
        });
        view2.setOnClickListener(v -> {
            WXUtils.getSingle().onShareText(entity, SendMessageToWX.Req.WXSceneTimeline);
            popupWindow.dismiss();
        });
        view3.setOnClickListener(v -> {
            WXUtils.getSingle().onShareText(entity, SendMessageToWX.Req.WXSceneFavorite);
            popupWindow.dismiss();
        });
    }

    public static void showWebPopup(View rootView, ShareEntity entity,String appId) {
        showPopup(rootView, entity);
        WXUtils.getSingle().onRegister(rootView.getContext(),appId);
        view1.setOnClickListener(v -> {
            WXUtils.getSingle().onShare(entity, SendMessageToWX.Req.WXSceneSession);
            popupWindow.dismiss();
        });
        view2.setOnClickListener(v -> {
            WXUtils.getSingle().onShare(entity, SendMessageToWX.Req.WXSceneTimeline);
            popupWindow.dismiss();
        });
        view3.setOnClickListener(v -> {
            WXUtils.getSingle().onShare(entity, SendMessageToWX.Req.WXSceneFavorite);
            popupWindow.dismiss();
        });
    }
}
