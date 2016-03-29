package nishi.android.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nishi.android.R;
import nishi.android.view.ViewActivityPublish;
import nishi.android.view.ViewFoodPublish;

/**
 * Created by LSD on 16/2/21.
 */
public class PublishActivity extends CommonActivity {
    @Bind(R.id.tv_save)
    TextView tvSave;
    @Bind(R.id.line1)
    View line1;
    @Bind(R.id.line2)
    View line2;
    @Bind(R.id.foodpublish)
    ViewFoodPublish foodpublish;
    @Bind(R.id.activitypublish)
    ViewActivityPublish activitypublish;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ButterKnife.bind(this);

        initView();
    }

    //INITVIEW
    @Override
    public void initView() {
        super.initView();
        tvTitle.setText("美食");
    }

    @OnClick(R.id.iv_back)
    public void back() {
        finish();
    }

    @OnClick(R.id.lla1)
    public void tab1Click() {
        tvTitle.setText("美食");
        foodpublish.setVisibility(View.VISIBLE);
        activitypublish.setVisibility(View.GONE);
        line1.setVisibility(View.VISIBLE);
        line2.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.lla2)
    public void tab2Click() {
        tvTitle.setText("活动");
        foodpublish.setVisibility(View.GONE);
        activitypublish.setVisibility(View.VISIBLE);
        line1.setVisibility(View.INVISIBLE);
        line2.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
