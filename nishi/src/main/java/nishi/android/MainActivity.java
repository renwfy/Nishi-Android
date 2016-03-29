package nishi.android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shizhefei.view.indicator.FragmentListPageAdapter;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nishi.android.activity.CommonActivity;
import nishi.android.activity.DetailsActivity;
import nishi.android.activity.LoginActivity;
import nishi.android.activity.NearActivity;
import nishi.android.activity.PublishActivity;
import nishi.android.activity.SearchActivity;
import nishi.android.activity.UserCenterActivity;
import nishi.android.api.Api;
import nishi.android.model.Article;
import nishi.android.net.NSCallback;
import nishi.android.view.NSFragment;

public class MainActivity extends CommonActivity {
    IndicatorViewPager indicatorViewPager;
    @Bind(R.id.tab_indicator)
    ScrollIndicatorView tab_indicator;
    @Bind(R.id.tab_viewPager)
    ViewPager tab_viewPager;

    String[] tabs = new String[]{"推荐", "美食", "活动", "周边游", "逛街"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    public void initView() {
        ColorBar colorBar = new ColorBar(this, Color.WHITE, 5);
        colorBar.setWidth(100);
        tab_indicator.setScrollBar(colorBar);
        int selectColorId = R.color.white;
        int unSelectColorId = R.color.white;
        tab_indicator.setOnTransitionListener(new OnTransitionTextListener().setColorId(this, selectColorId, unSelectColorId));

        tab_viewPager.setOffscreenPageLimit(2);
        indicatorViewPager = new IndicatorViewPager(tab_indicator, tab_viewPager);
        indicatorViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }

    //注解点击事件
    @OnClick(R.id.iv_near)
    public void homeNearClick(){
        startActivity(new Intent(mActivity, NearActivity.class));
    }
    @OnClick(R.id.iv_search)
    public void homeSearchClick(){
        startActivity(new Intent(mActivity, SearchActivity.class));
    }
    @OnClick(R.id.iv_user)
    public void userAcoutClick(){
       /* if(NSApplication.isLogined()){
            startActivity(new Intent(mActivity, UserCenterActivity.class));
        }else{
            startActivity(new Intent(mActivity, LoginActivity.class));
        }*/
        startActivity(new Intent(mActivity, LoginActivity.class));
    }

    @OnClick(R.id.iv_home_edit)
    public void userAcoutEdit(){
        startActivity(new Intent(mActivity, PublishActivity.class));
    }

    private class PagerAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        public PagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = LayoutInflater.from(container.getContext()).inflate(R.layout.view_tabitem, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabs[position % tabs.length]);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            NSFragment fragment = new NSFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(NSFragment.INTENT_INT_INDEX, position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getItemPosition(Object object) {
            return FragmentListPageAdapter.POSITION_NONE;
        }

    }
}
