package nishi.android.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.lib.utils.AppLog;
import com.lib.utils.AppTips;
import com.lib.widget.CountDownButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nishi.android.NSApplication;
import nishi.android.R;
import nishi.android.api.Api;
import nishi.android.model.User;
import nishi.android.net.NSCallback;

/**
 * Created by LSD on 15/10/28.
 */
public class RegisterActivity extends CommonActivity {
    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.et_userpass)
    EditText et_userpass;
    @Bind(R.id.et_vercode)
    EditText et_vercode;

    @Bind(R.id.getvercode)
    CountDownButton getvercode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initView();
    }

    public void initView(){
    }

    @OnClick(R.id.iv_back)
    public void goBack() {
        finish();
    }

    public void getVerCode(){
        String phone = et_phone.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            AppTips.showToast(mActivity, "手机号不能为空");
            return;
        }
        getvercode.startCountDown();
        Api.send_verification_code(phone, 0, new NSCallback<String>(mActivity, String.class) {
            @Override
            public void onSuccess(String s) {
                getvercode.stopCountDown();
            }

            @Override
            public void onFail(int code, String msg) {
                super.onFail(code, msg);
                getvercode.stopCountDown();
            }
        });
    }

    public void verifyCodeServer(){
        String phone = et_phone.getText().toString();
        String vercode = et_vercode.getText().toString();
        Api.verify_verification_code(phone, "0", vercode, new NSCallback<String>(mActivity,String.class) {
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                register();
            }
        });
    }

    @OnClick(R.id.tv_register)
    public void register() {
        String phone = et_phone.getText().toString();
        String pass = et_userpass.getText().toString();
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pass)) {
            AppTips.showToast(mActivity, "用户名或密码不能为空");
            return;
        }
        Api.register(phone, pass, new NSCallback<User>(mActivity,User.class) {
            @Override
            public void onSuccess(User user) {
                NSApplication.getInstance().login(user);
                AppTips.showToast(mActivity,"登陆成功");
                finish();
            }
        });
    }
}
