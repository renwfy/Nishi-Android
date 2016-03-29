package nishi.android.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import nishi.android.R;

/**
 * Created by LSD on 15/12/21.
 */
public class UserCenterActivity extends CommonActivity {
    @Bind(R.id.iv_cover)
    ImageView ivCover;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_favorites)
    ImageView ivFavorites;
    @Bind(R.id.iv_share)
    ImageView ivShare;
    @Bind(R.id.iv_sex)
    ImageView ivSex;
    @Bind(R.id.tv_username)
    TextView tvUsername;
    @Bind(R.id.tv_signname)
    TextView tvSignname;
    @Bind(R.id.ll_userinfo)
    LinearLayout llUserinfo;
    @Bind(R.id.line1)
    View line1;
    @Bind(R.id.ll_news)
    LinearLayout llNews;
    @Bind(R.id.line2)
    View line2;
    @Bind(R.id.ll_collect)
    LinearLayout llCollect;
    @Bind(R.id.line3)
    View line3;
    @Bind(R.id.ll_activity)
    LinearLayout llActivity;
    @Bind(R.id.line4)
    View line4;
    @Bind(R.id.ll_publish)
    LinearLayout llPublish;
    @Bind(R.id.menu_bar)
    LinearLayout menuBar;
    @Bind(R.id.fragment_container)
    FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usercenter);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
