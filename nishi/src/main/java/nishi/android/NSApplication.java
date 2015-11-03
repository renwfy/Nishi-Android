package nishi.android;

import android.app.Application;
import android.text.TextUtils;

import com.lib.AppLib;

import nishi.android.config.Config;
import nishi.android.model.User;
import nishi.android.net.NSRequestManager;

/**
 * Created by LSD on 15/9/23.
 */
public class NSApplication extends Application {
    private static NSApplication app;
    private static Session SESSION;

    public static NSApplication getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        SESSION = Session.INSTANCE = Session.load(app);

        AppLib.setDebug(Constants.DEBUG);
        AppLib.initFileUtil(Constants.BASE_FOLDER);

        NSRequestManager.init(this, Constants.BASE_URL);
        Config.initQiniuUrl();
    }

    public void login(User user){
        Session.INSTANCE.setUser(user);
        Session.INSTANCE.save(app);
    }

    public static boolean isLogined(){
        try {
            return !TextUtils.isEmpty(SESSION.getUser().getAuthToken());
        }catch (Exception e){}
        return  false;
    }
}
