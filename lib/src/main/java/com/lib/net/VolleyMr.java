package com.lib.net;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lib.AppLib;

import java.util.Map;

public class VolleyMr {
    private static String Tag = "VolleyMr";
    private static RequestQueue mQueue = Volley.newRequestQueue(AppLib.appContext);

    // GET
    public static void get(String url, final Map<String, String> header,NetCallback callback) {
        if (callback == null) {
            callback = DEFAULT_RESULT_CALLBACK;
        }
        final NetCallback cb = callback;
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // TODO Auto-generated method stub
                cb.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                error.printStackTrace();
                Log.e(Tag, error.getMessage());
                Log.e(Tag, "网络请求故障");
                cb.onFailure("", -2);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return header;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(4 * 1000, 1, 1.0f));
        mQueue.add(request);
        mQueue.start();
    }

    // POST
    public static void post(String url, final Map<String, String> header,final Map<String, String> params, NetCallback callback) {
        if (callback == null) {
            callback = DEFAULT_RESULT_CALLBACK;
        }
        final NetCallback cb = callback;
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // TODO Auto-generated method stub
                cb.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                error.printStackTrace();
                Log.e(Tag, error.getMessage());
                Log.e(Tag, "网络请求故障");
                cb.onFailure("", -2);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return header;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(4 * 1000, 1, 1.0f));
        mQueue.add(request);
        mQueue.start();
    }

    private final static NetCallback DEFAULT_RESULT_CALLBACK = new NetCallback() {
        @Override
        protected void onFailure(String error, int code) {
        }

        @Override
        protected void onResponse(String response) {
        }
    };
}
