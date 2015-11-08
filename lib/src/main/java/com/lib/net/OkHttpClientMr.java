package com.lib.net;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.lib.utils.AppLog;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhy on 15/8/17.
 */
public class OkHttpClientMr {
    String Tag = "OkHttpClientMr";
    private static OkHttpClientMr mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;

    private GetDelegate mGetDelegate = new GetDelegate();
    private PostDelegate mPostDelegate = new PostDelegate();

    private OkHttpClientMr() {
        mOkHttpClient = new OkHttpClient();
        mDelivery = new Handler(Looper.getMainLooper());
    }

    public static OkHttpClientMr getInstance() {
        if (mInstance == null) {
            synchronized (OkHttpClientMr.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpClientMr();
                }
            }
        }
        return mInstance;
    }

    public GetDelegate getGetDelegate() {
        return mGetDelegate;
    }

    public PostDelegate getPostDelegate() {
        return mPostDelegate;
    }

    /**
     * Get
     */
    public static void getAsyn(String url, Map<String, String> header, Object tag, OKCallback callback) {
        getInstance().getGetDelegate().getAsyn(url, header, tag, callback);
    }

    /**
     * POST
     */
    public static void postAsyn(String url, Map<String, String> params, Map<String, String> header, Object tag, final OKCallback callback) {
        getInstance().getPostDelegate().postAsyn(url, params, header, tag, callback);
    }

    public static String getStringReqParam(Map<String, String> mapparams) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<?> iterator = mapparams.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            stringBuffer.append(key + "=" + mapparams.get(key) + "&");
        }
        String stringReqParam = stringBuffer.toString();
        return stringReqParam.substring(0, stringReqParam.length() - 1);
    }


    private void deliveryResult(OKCallback callback, final Request request) {
        if (callback == null) callback = DEFAULT_RESULT_CALLBACK;
        final OKCallback resCallBack = callback;
        //UI thread
        resCallBack.onBefore(request);
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Request request, final IOException e) {
                if(e != null){
                    e.printStackTrace();
                    Log.e(Tag, e.getMessage());
                    Log.e(Tag,"网络请求故障");
                }
                sendFailedStringCallback("", -2, resCallBack);
            }

            @Override
            public void onResponse(final Response response) {
                String body = "";
                try {
                    body = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                AppLog.d(Tag,body);
                sendSuccessResultCallback(body, resCallBack);
            }
        });
    }

    private void sendFailedStringCallback(final String error, final int code, final OKCallback callback) {
       mDelivery.post(new Runnable() {
           @Override
           public void run() {
               callback.onFailure(error,code);
               callback.onAfter();
           }
       });
    }

    private void sendSuccessResultCallback(final String response, final OKCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onResponse(response);
                callback.onAfter();
            }
        });
    }

    public static void cancelTag(Object tag) {
        getInstance()._cancelTag(tag);
    }

    private void _cancelTag(Object tag) {
        mOkHttpClient.cancel(tag);
    }

    public static OkHttpClient getClinet() {
        return getInstance().client();
    }

    public OkHttpClient client() {
        return mOkHttpClient;
    }


    public static abstract class OKCallback {
        protected void onBefore(Request request) {
        }

        protected void onAfter() {
        }

        protected abstract void onFailure(final String error,final int code);

        protected abstract void onResponse(final String response);
    }

    private final OKCallback DEFAULT_RESULT_CALLBACK = new OKCallback() {
        @Override
        protected void onFailure(String error, int code) {

        }

        @Override
        protected void onResponse(String response) {

        }
    };


    /***
     * PostDelegate
     */
    public class PostDelegate {
        private final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream;charset=utf-8");
        private final MediaType MEDIA_TYPE_STRING = MediaType.parse("text/plain;charset=utf-8");
        private final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

        /**
         * 直接将bodyStr以写入请求体
         */
        public void postAsyn(String url, String bodyStr, final OKCallback callback, Object tag) {
            postAsynWithMediaType(url, bodyStr, MEDIA_TYPE_STRING, callback, tag);
        }

        /**
         * 直接将bodyBytes以写入请求体
         */
        public void postAsyn(String url, byte[] bodyBytes, final OKCallback callback, Object tag) {
            postAsynWithMediaType(url, bodyBytes, MEDIA_TYPE_STREAM, callback, tag);
        }

        /**
         * 直接将bodyFile以写入请求体
         */
        public void postAsyn(String url, File bodyFile, final OKCallback callback, Object tag) {
            postAsynWithMediaType(url, bodyFile, MEDIA_TYPE_STREAM, callback, tag);
        }

        /**
         * 直接将bodyStr以写入请求体
         */
        public void postAsynWithMediaType(String url, String bodyStr, MediaType type, final OKCallback callback, Object tag) {
            RequestBody body = RequestBody.create(type, bodyStr);
            Request request = buildPostRequest(url, body, tag);
            deliveryResult(callback, request);
        }

        /**
         * 直接将bodyBytes以写入请求体
         */
        public void postAsynWithMediaType(String url, byte[] bodyBytes, MediaType type, final OKCallback callback, Object tag) {
            RequestBody body = RequestBody.create(type, bodyBytes);
            Request request = buildPostRequest(url, body, tag);
            deliveryResult(callback, request);
        }

        /**
         * 直接将bodyFile以写入请求体
         */
        public void postAsynWithMediaType(String url, File bodyFile, MediaType type, final OKCallback callback, Object tag) {
            RequestBody body = RequestBody.create(type, bodyFile);
            Request request = buildPostRequest(url, body, tag);
            deliveryResult(callback, request);
        }

        /**
         * post构造Request的方法
         *
         * @param url
         * @param body
         * @return
         */
        private Request buildPostRequest(String url, RequestBody body, Object tag) {
            Request.Builder builder = new Request.Builder()
                    .url(url)
                    .post(body);
            if (tag != null) {
                builder.tag(tag);
            }
            Request request = builder.build();
            return request;
        }


        /**
         * 异步的post请求
         */
        public void postAsyn(String url, Map<String, String> params, Map<String, String> header, Object tag, final OKCallback callback) {
            Request request = buildPostFormRequest(url, params, header, tag);
            deliveryResult(callback, request);
        }

        private Request buildPostFormRequest(String url, Map<String, String> params, Map<String, String> header, Object tag) {
            if (params == null) {
                params = new HashMap<>();
            }
            String jsonStr = new Gson().toJson(params).toString();
            RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, jsonStr);
            Request.Builder reqBuilder = new Request.Builder();
            reqBuilder.url(url)
                    .post(requestBody);
            if (header != null) {
                reqBuilder.headers(Headers.of(header));
            }
            if (tag != null) {
                reqBuilder.tag(tag);
            }
            return reqBuilder.build();
        }
    }

    /****
     * GetDelegate
     */
    public class GetDelegate {
        private Request buildGetRequest(String url, Map<String, String> header, Object tag) {
            Request.Builder builder = new Request.Builder()
                    .url(url);
            if (header != null) {
                builder.headers(Headers.of(header));
            }
            if (tag != null) {
                builder.tag(tag);
            }
            return builder.build();
        }

        public void getAsyn(String url, Map<String, String> header, Object tag, final OKCallback callback) {
            final Request request = buildGetRequest(url, header, tag);
            getAsyn(request, callback);
        }

        public void getAsyn(Request request, OKCallback callback) {
            deliveryResult(callback, request);
        }
    }
}