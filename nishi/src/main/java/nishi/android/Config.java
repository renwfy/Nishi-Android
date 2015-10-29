package nishi.android;

import com.lib.utils.AppLog;
import com.squareup.okhttp.Response;

import nishi.android.api.Api;
import nishi.android.net.NSCallback;
import nishi.android.net.NSRequestManager;

/**
 * Created by LSD on 15/10/19.
 */
public class Config {

    public static void initQiniuUrl() {
        Api.prefix(new NSCallback<String>(NSRequestManager.getInstance().getContext(), String.class) {
            @Override
            public void onSuccess(String s) {
                AppLog.d("NS_Config",s);
                Constants.QINIU_BASEURL = s;
            }
        });
    }
}
