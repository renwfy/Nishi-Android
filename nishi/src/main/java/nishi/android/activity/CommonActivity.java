package nishi.android.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import butterknife.ButterKnife;
import nishi.android.base.BaseActivity;

/**
 * Created by LSD on 15/10/18.
 */
public class CommonActivity extends BaseActivity {
    public CommonActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }

    @Override
    public void showProgressDialog(String msg) {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void notLogin() {

    }
    
    public void initView(){
        // TODO: 16/1/15 initview
    }
}
