package nishi.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
 * Created by LSD on 16/1/15.
 */
public class SearchActivity extends CommonActivity {
    NSListView nsListView;
    NSAdapter adapter;
    NearMenuAdapter menuAdapter;

    private EditText etsearch;
    private TextView tvsearch;
    private View v1;
    private View v2;
    private View v3;
    private LinearLayout menubar;
    private LinearLayout llarea;
    private LinearLayout lltype;
    private LinearLayout llorder;
    private LinearLayout submenubar;
    private LinearLayout contentlayout;
    private GridView menugrid;


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
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        initView();
        nsListView.firstLoad();
    }

    //INITVIEW
    @Override
    public void initView() {
        super.initView();
        initialize();

        nsListView = new NSListView<Article>(mActivity, true) {
            @Override
            public void loadData() {
                SearchActivity.this.loadData();
            }

            @Override
            public void onItemClick(Article article) {
                mActivity.startActivity(new Intent(mActivity, DetailsActivity.class).putExtra(DetailsActivity.ARTICLE_ID, article.get_id()));
            }
        };
        adapter = new NSAdapter(mActivity);
        nsListView.setAdapter(adapter);
        contentlayout.addView(nsListView.getView());

        menugrid.setAdapter(menuAdapter = new NearMenuAdapter(mActivity));

        nsListView.getListView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                menugrid.setVisibility(View.GONE);
                return false;
            }
        });
        menugrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menugrid.setVisibility(View.GONE);
            }
        });
    }

    private void initialize() {
        etsearch = (EditText) findViewById(R.id.et_search);
        tvsearch = (TextView) findViewById(R.id.tv_search);
        v1 = (View) findViewById(R.id.v1);
        v2 = (View) findViewById(R.id.v2);
        v3 = (View) findViewById(R.id.v3);
        menubar = (LinearLayout) findViewById(R.id.menu_bar);
        llarea = (LinearLayout) findViewById(R.id.ll_area);
        lltype = (LinearLayout) findViewById(R.id.ll_type);
        llorder = (LinearLayout) findViewById(R.id.ll_order);
        submenubar = (LinearLayout) findViewById(R.id.sub_menu_bar);
        contentlayout = (LinearLayout) findViewById(R.id.content_layout);
        menugrid = (GridView) findViewById(R.id.menu_grid);
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

    @OnClick(R.id.ll1)
    public void reloadByTag(){
        v1.setVisibility(View.VISIBLE);
        v2.setVisibility(View.INVISIBLE);
        v3.setVisibility(View.INVISIBLE);
        submenubar.setVisibility(View.GONE);

        List<String> strings = new ArrayList<>();
        strings.add("新开张");
        strings.add("素食主义");
        strings.add("巴拉巴拉");
        strings.add("新开张");
        strings.add("素食主义");
        strings.add("巴拉巴拉");
        strings.add("新开张");
        strings.add("素食主义");
        strings.add("巴拉巴拉");
        menuAdapter.setData(strings);
    }

    @OnClick(R.id.ll2)
    public void reloadByCircle(){
        v1.setVisibility(View.INVISIBLE);
        v2.setVisibility(View.VISIBLE);
        v3.setVisibility(View.INVISIBLE);
        submenubar.setVisibility(View.GONE);

        List<String> strings = new ArrayList<>();
        strings.add("石路");
        strings.add("观前街");
        strings.add("时代广场");
        strings.add("石路");
        strings.add("观前街");
        strings.add("时代广场");
        strings.add("石路");
        strings.add("观前街");
        strings.add("时代广场");
        menuAdapter.setData(strings);
    }

    @OnClick(R.id.ll3)
    public void reloadByLimit(){
        v1.setVisibility(View.INVISIBLE);
        v2.setVisibility(View.INVISIBLE);
        v3.setVisibility(View.VISIBLE);
        submenubar.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.ll_area)
    public void reloadByArea() {
        menugrid.setVisibility(View.VISIBLE);
        List<String> strings = new ArrayList<>();
        strings.add("全部");
        strings.add("热度最高");
        strings.add("离我最近");
        menuAdapter.setData(strings);
    }


    @OnClick(R.id.ll_type)
    public void reloadByType() {
        menugrid.setVisibility(View.VISIBLE);
        List<String> strings = new ArrayList<>();
        strings.add("全部");
        strings.add("全部");
        menuAdapter.setData(strings);
    }

    @OnClick(R.id.ll_order)
    public void reloadByOrder() {
        menugrid.setVisibility(View.VISIBLE);
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
