package nishi.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nishi.android.R;
import nishi.android.adapter.NearMenuAdapter;
import nishi.android.api.Api;
import nishi.android.model.Article;
import nishi.android.net.NSCallback;
import nishi.android.view.ns_listview.NSAdapter;
import nishi.android.view.ns_listview.NSListView;

/**
 * Created by LSD on 16/1/2.
 */
public class NearActivity extends CommonActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.content_layout)
    LinearLayout contentLayout;
    @Bind(R.id.menu_grid)
    GridView menuGrid;
    NSListView nsListView;
    NSAdapter adapter;
    NearMenuAdapter menuAdapter;

    int extType = 0;
    int size = 10;
    int page = 0;
    int sortType = 0;//排序类型
    String city = "苏州";
    String tradingArea = "";//商圈
    int type = 0;//文章类型
    int recommend = 0;//推荐等级
    String searchKey = "";
    float longitude = 0;
    float location = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near);
        ButterKnife.bind(this);

        initView();
        nsListView.firstLoad();
    }

    //INITVIEW
    public void initView() {
        nsListView = new NSListView<Article>(mActivity, true) {
            @Override
            public void loadData() {
                NearActivity.this.loadData();
            }

            @Override
            public void onItemClick(Article article) {
                mActivity.startActivity(new Intent(mActivity, DetailsActivity.class).putExtra(DetailsActivity.ARTICLE_ID, article.get_id()));
            }
        };
        adapter = new NSAdapter(mActivity);
        nsListView.setAdapter(adapter);
        contentLayout.addView(nsListView.getView());

        menuGrid.setAdapter(menuAdapter = new NearMenuAdapter(mActivity));

        nsListView.getListView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                menuGrid.setVisibility(View.GONE);
                return false;
            }
        });
        menuGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menuGrid.setVisibility(View.GONE);
            }
        });
    }


    //LOADDATA
    private void loadData() {
        //,0:美食 1:周边游 2:逛街 3:活动
        if (extType == 0 || extType == 1) {
            type = 0;
        }
        if (extType == 2) {
            type = 3;
        }
        if (extType == 3) {
            type = 1;
        }
        if (extType == 4) {
            type = 2;
        }
        Api.articles(page, size, sortType, city, tradingArea, type, recommend,
                searchKey, longitude, location, new NSCallback<Article>(mActivity, Article.class) {
                    @Override
                    public void onSuccess(List<Article> t, int total) {
                        if (t == null || t.size() <= 0) {
                            t = new ArrayList<>();
                            Article article = new Article();
                            article.setTitle("这是一个标题");
                            article.setSite("内容简介");
                            article.setCollectUserNumber(3);
                            article.setType(type);
                            t.add(article);
                            t.add(article);
                            t.add(article);
                        }
                        adapter.setData(t);
                        nsListView.loadFinish();
                    }

                    @Override
                    public void onFail(int code, String msg) {
                        List<Article> t = new ArrayList<>();
                        Article article = new Article();
                        article.setTitle("这是一个标题");
                        article.setSite("内容简介");
                        article.setCollectUserNumber(3);
                        article.setType(type);
                        t.add(article);
                        t.add(article);
                        t.add(article);
                        adapter.setData(t);
                        nsListView.loadFinish();
                    }
                });
    }


    //CLICK
    @OnClick(R.id.iv_back)
    public void activityFinish() {
        finish();
    }

    @OnClick(R.id.ll_type)
    public void reloadByType() {
        menuGrid.setVisibility(View.VISIBLE);
        List<String> strings = new ArrayList<>();
        strings.add("全部");
        strings.add("全部");
        menuAdapter.setData(strings);
    }

    @OnClick(R.id.ll_order)
    public void reloadByOrder() {
        menuGrid.setVisibility(View.VISIBLE);
        List<String> strings = new ArrayList<>();
        strings.add("距离");
        strings.add("热度");
        strings.add("评分");
        menuAdapter.setData(strings);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
