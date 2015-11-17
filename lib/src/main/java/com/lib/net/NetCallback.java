package com.lib.net;

/**
 * Created by LSD on 15/11/8.
 */
public abstract class NetCallback {
    protected void onBefore(com.squareup.okhttp.Request request) {
    }

    protected void onAfter() {
    }

    protected abstract void onFailure(final String error, final int code);

    protected abstract void onResponse(final String response);
}
