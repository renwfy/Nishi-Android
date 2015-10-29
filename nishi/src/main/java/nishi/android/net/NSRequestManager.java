package nishi.android.net;

import android.content.Context;

import nishi.android.Constants;

/**
 * Created by LSD on 15/10/19.
 */
public class NSRequestManager {
    private static NSRequestManager INSTANCE;
    private Context context;


    public static NSRequestManager init(Context context, String baseUrl) {
        INSTANCE = new NSRequestManager();
        INSTANCE.context = context;
        NSHttpClent.init(baseUrl);
        return INSTANCE;
    }

    public static NSRequestManager getInstance() {
        if (INSTANCE == null) {
            throw new RuntimeException("ZMVolley 未初始化!");
        }
        return INSTANCE;
    }

    public Context getContext() {
        return context;
    }
}
