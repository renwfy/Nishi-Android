package nishi.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lib.utils.AppTips;

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
public class LoginActivity extends CommonActivity {
    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.et_userpass)
    EditText et_userpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void goBack() {
        finish();
    }

    @OnClick(R.id.tv_register)
    public void register() {
        startActivity(new Intent(mActivity, RegisterActivity.class));
    }

    @OnClick(R.id.tv_forgot)
    public void forgot() {
    }

    @OnClick(R.id.tv_login)
    public void login() {
        String phone = et_phone.getText().toString();
        String pass = et_userpass.getText().toString();
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pass)) {
            AppTips.showToast(mActivity, "用户名或密码不能为空");
            return;
        }
        Api.login(phone, pass, new NSCallback<User>(mActivity, User.class, true, "正在登陆") {
            @Override
            public void onSuccess(User user) {
                AppTips.showToast("登陆成功");
                NSApplication.getInstance().login(user);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
