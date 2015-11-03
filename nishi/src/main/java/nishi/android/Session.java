package nishi.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.ArrayList;

import nishi.android.model.User;

/**
 * Created by LSD on 15/11/2.
 */
public class Session {
    private static final String key = Constants.DEBUG ? "debug_session":"session";
    public static Session INSTANCE;
    private User user;

    /**
     * 加载到内存
     */
    public static Session load(Context context){
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        String info = sp.getString(key, "");
        Session result  = null;
        if(TextUtils.isEmpty(info)){
            result = new Session();
        }else{
            result = new Gson().fromJson(info,Session.class);
        }
        return result;
    }

    /**
     * 持久化
     */
    public void save(Context context){
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String session = new Gson().toJson(this);
        editor.putString(key, session);
        editor.commit();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
