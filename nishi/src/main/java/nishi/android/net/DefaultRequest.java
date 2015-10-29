package nishi.android.net;

import com.lib.net.OkHttpClientMr;
import com.lib.utils.AppLog;
import com.lib.utils.AppTips;

import java.util.Map;

/**
 * Created by LSD on 15/10/18.
 */
public class DefaultRequest implements NSRequest {
    String Tag = DefaultRequest.class.getSimpleName();
    String url;
    NSCallback callback;
    Map<String, String> params = null;
    Map<String, String> header = null;

    DefaultRequest(String url, NSCallback callback) {
        this.url = url;
        this.callback = callback;
    }

    @Override
    public NSRequest doRequest() {
        if (null == params) {
            AppLog.d(Tag, url);
            OkHttpClientMr.getAsyn(url, header, null, callback);
        } else {
            AppLog.d(Tag, url + OkHttpClientMr.getStringReqParam(params));
            OkHttpClientMr.postAsyn(url, params, header, null, callback);
        }
        return this;
    }

    @Override
    public void cancelRequests(String tag) {
        OkHttpClientMr.cancelTag(tag);
    }

    @Override
    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public void setHeaders(Map<String, String> header) {
        this.header = header;
    }
}
