package nishi.android.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.lib.net.OkHttpClientMr;
import com.lib.utils.AppLog;
import com.lib.utils.AppTips;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

import nishi.android.Constants;

/**
 * Created by LSD on 15/10/18.
 */
public abstract class NSCallback<T> extends OkHttpClientMr.OKCallback {
    private String Tag = NSCallback.class.getSimpleName();
    private Context context;
    private NSJsonParser nsJsonParser = new NSJsonParser();
    private boolean showProgressBar;
    private String msg;
    private Class<T> clazz;
    private OnShowProgressDialogListener onShowProgressDialogListener;
    private OnNotLoginListener onNotLoginListener;

    public NSCallback(Context context, Class<T> clazz) {
        this.context = context;
        this.clazz = clazz;
        showProgressBar = false;
        msg = "";
        if (context instanceof OnShowProgressDialogListener) {
            onShowProgressDialogListener = (OnShowProgressDialogListener) context;
        }
        if (context instanceof OnNotLoginListener) {
            onNotLoginListener = (OnNotLoginListener) context;
        }
    }

    public NSCallback(Context context, Class<T> clazz, boolean showProgressBar, String msg) {
        this.context = context;
        this.clazz = clazz;
        this.showProgressBar = showProgressBar;
        this.msg = msg;
        if (context instanceof OnShowProgressDialogListener) {
            onShowProgressDialogListener = (OnShowProgressDialogListener) context;
        }
        if (context instanceof OnNotLoginListener) {
            onNotLoginListener = (OnNotLoginListener) context;
        }
    }

    @Override
    protected void onResponse(String response) {
            nsJsonParser.parse(response, clazz, this);
    }

    @Override
    protected void onFailure(String error, int code) {
        onFail(code, error);
    }

    @Override
    protected void onBefore(Request request) {
        super.onBefore(request);
        if (showProgressBar) {
            String content = TextUtils.isEmpty(msg) ? "请稍后" : msg;
            if (onShowProgressDialogListener != null)
                onShowProgressDialogListener.showProgressDialog(content);
        }
    }

    @Override
    protected void onAfter() {
        super.onAfter();
        if (onShowProgressDialogListener != null)
            onShowProgressDialogListener.hideProgressDialog();
    }

    public void notLogin() {
        if (onNotLoginListener != null)
            onNotLoginListener.notLogin();
    }

    public void onSuccess(T t) {
    }

    public void onSuccess(List<T> t, int total) {
    }

    public void onFail(int code, String msg) {
        if (!TextUtils.isEmpty(msg)){
            AppTips.showToast(context,msg);
        }
    }


    /***
     * 显示dialog
     */
    public static interface OnShowProgressDialogListener {
        public void showProgressDialog(String msg);

        public void hideProgressDialog();
    }

    /***
     * 未登录
     */
    public interface OnNotLoginListener {
        public void notLogin();
    }

    /***
     * 需要登录
     */
    public static class NSTokenCallback<T> extends NSCallback<T> {
        public NSTokenCallback(Context context, Class<T> clazz) {
            super(context, clazz);
        }

        public NSTokenCallback(Context context, Class<T> clazz, boolean showProgressBar, String msg) {
            super(context, clazz, showProgressBar, msg);
        }
    }
}
