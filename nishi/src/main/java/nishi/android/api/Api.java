package nishi.android.api;

import java.util.HashMap;
import java.util.Map;

import nishi.android.model.Article;
import nishi.android.net.NSCallback;
import nishi.android.net.NSHttpClent;

/**
 * Created by LSD on 15/10/19.
 */
public class Api extends NSHttpClent {

    /***
     * 获取七牛tocken
     *
     * @param callback
     */
    public static void qiniu_token(NSCallback callback) {
        String url = "/app/user/qiniu_token";
        get(url, null, callback);
    }

    /***
     * 获取七牛连接
     *
     * @param callback
     */
    public static void prefix(NSCallback callback) {
        String url = "/app/user/qiniu_prefix";
        get(url, null, callback);
    }

    /**
     * 获取验证码
     * <p/>
     * verificationCodeToken : Des3加密(手机号+ABC+时间戳+ABC+类型),加密时二进制转字符时选用base64编码
     *
     * @param mobile
     * @param type   0:注册 1:修改绑定手机 2:修改密码 3:忘记密码
     */
    public static void send_verification_code(String mobile, String type, NSCallback callback) {
        Map<String, String> pamas = new HashMap<>();
        pamas.put("mobile", mobile);
        pamas.put("type", type);

        String verificationCodeToken = "";
        pamas.put("verificationCodeToken", verificationCodeToken);

        String url = "/app/user/send_verification_code";
        post(url, pamas, callback);
    }

    /***
     * 验证 验证码
     */
    public static void verify_verification_code(String mobile, String type, String code, NSCallback callback) {
        Map<String, String> pamas = new HashMap<>();
        pamas.put("mobile", mobile);
        pamas.put("type", type);
        pamas.put("code", code);

        String url = "/app/user/verify_verification_code";
        post(url, pamas, callback);
    }

    /**
     * 注册
     *
     * @param mobile
     * @param password
     * @param callback
     */
    public static void register(String mobile, String password, NSCallback callback) {
        Map<String, String> pamas = new HashMap<>();
        pamas.put("mobile", mobile);
        pamas.put("password", password);

        String url = "/app/user/register";
        post(url, pamas, callback);
    }


    /***
     * 登陆
     *
     * @param mobile
     * @param password
     * @param callback
     */
    public static void login(String mobile, String password, NSCallback callback) {
        Map<String, String> pamas = new HashMap<>();
        pamas.put("mobile", mobile);
        pamas.put("password", password);

        String url = "/app/user/login";
        post(url, pamas, callback);
    }

    /***
     * 获取文章列表
     *
     * @param page        页码,从0开始
     * @param size
     * @param sortType    排序类型, 0:时间排序,1:地理位置排序,2人气排序
     * @param city        城市,暂时用苏州
     * @param tradingArea 商圈
     * @param type        文章类型,0:美食 1:周边游 2:逛街 3:活动
     * @param recommend   推荐等级,当不传,或传值小于等于0时,服务器会忽略
     * @param searchKey
     * @param longitude   经度,当sortType为1是必传
     * @param location    维度,当sortType为1是必传
     * @param callback
     */
    public static void articles(int page, int size, int sortType, String city, String tradingArea,
                                int type, int recommend, String searchKey, float longitude, float location,
                                NSCallback<Article> callback) {
        Map<String, String> pamas = new HashMap<>();
        pamas.put("page",page+"");
        pamas.put("size",size+"");
        pamas.put("sortType",sortType+"");
        pamas.put("city",city);
        pamas.put("tradingArea",tradingArea);
        pamas.put("type",type+"");
        pamas.put("recommend",recommend+"");
        pamas.put("searchKey",searchKey);
        pamas.put("longitude",longitude+"");
        pamas.put("location",location+"");

        String url = "/app/article/articles";
        post(url, pamas, callback);
    }



    public static void create(int page, int size, int sortType, String city, String tradingArea,
                                int type, int recommend, String searchKey, float longitude, float location,
                                NSCallback callback) {
        Map<String, String> pamas = new HashMap<>();
        pamas.put("page",page+"");
        pamas.put("size",size+"");
        pamas.put("sortType",sortType+"");
        pamas.put("city",city);
        pamas.put("tradingArea",tradingArea);
        pamas.put("type",type+"");
        pamas.put("recommend",recommend+"");
        pamas.put("searchKey",searchKey);
        pamas.put("longitude",longitude+"");
        pamas.put("location",location+"");

        String url = "/app/article/articles";
        get(url, pamas, callback);
    }
}
