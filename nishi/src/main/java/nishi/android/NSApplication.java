package nishi.android;

import android.app.Application;

import com.lib.AppLib;

import nishi.android.net.NSRequestManager;

/**
 * Created by LSD on 15/9/23.
 */
public class NSApplication extends Application {
    private static NSApplication app;

    public static NSApplication getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        AppLib.setDebug(Constants.DEBUG);
        AppLib.initFileUtil(Constants.BASE_FOLDER);

        NSRequestManager.init(this, Constants.BASE_URL);
        Config.initQiniuUrl();
    }
}
