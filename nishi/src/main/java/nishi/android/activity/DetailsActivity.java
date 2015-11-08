package nishi.android.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nishi.android.R;
import nishi.android.fragment.ActivityFragment;
import nishi.android.fragment.DetailsFragment;
import nishi.android.fragment.MessageFragment;

public class DetailsActivity extends CommonActivity implements View.OnClickListener{
    @Bind(R.id.tv_title)TextView tv_title;
    @Bind(R.id.iv_favorites)ImageView iv_favorites;
    @Bind(R.id.iv_share)ImageView iv_share;
    @Bind(R.id.tv_details)TextView tv_details;
    @Bind(R.id.tv_message)TextView tv_message;
    @Bind(R.id.tv_activity)TextView tv_activity;
    @Bind(R.id.bottom_layout)LinearLayout bottom_layout;
    @Bind(R.id.tv_publish)TextView tv_publish;

    private int currentTabIndex;
    private int index;
    private Fragment[] fragments;
    private View[] mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        setupView();
    }

    public void setupView() {
        fragments = new Fragment[3];
        fragments[0] = new DetailsFragment();
        fragments[1]= new MessageFragment();
        fragments[2] = new ActivityFragment();

        mTabs = new View[3];
        mTabs[0] = tv_details;
        mTabs[1] = tv_message;
        mTabs[2] = tv_activity;


        mTabs[0].setSelected(true);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragments[0]).show(fragments[0])
                .commit();
        index = 0;

        iv_favorites.setOnClickListener(this);
        iv_share.setOnClickListener(this);
        tv_details.setOnClickListener(this);
        tv_message.setOnClickListener(this);
        tv_activity.setOnClickListener(this);
        tv_publish.setOnClickListener(this);

        bottom_layout.setVisibility(View.GONE);
    }

    /**切换*/
    private void tabSelect() {
        if (currentTabIndex != index) {
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            transaction.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                transaction.add(R.id.fragment_container, this.fragments[index]);
            }
            transaction.show(fragments[index]).commitAllowingStateLoss();
        }
        mTabs[currentTabIndex].setSelected(false);
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }

    @OnClick(R.id.iv_back)
    public void exit(){
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case   R.id.tv_details:
                bottom_layout.setVisibility(View.GONE);
                index = 0;
                tabSelect();
                break;
            case   R.id.tv_message:
                bottom_layout.setVisibility(View.GONE);
                index = 1;
                tabSelect();
                break;
            case   R.id.tv_activity:
                bottom_layout.setVisibility(View.VISIBLE);
                index = 2;
                tabSelect();
                break;
        }
    }
}
