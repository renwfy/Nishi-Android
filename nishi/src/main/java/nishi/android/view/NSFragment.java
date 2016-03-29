package nishi.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.lib.utils.AppLog;

import java.util.ArrayList;
import java.util.List;

import nishi.android.activity.DetailsActivity;
import nishi.android.api.Api;
import nishi.android.fragment.CommonFragment;
import nishi.android.model.Article;
import nishi.android.net.NSCallback;
import nishi.android.view.ns_listview.NSAdapter;
import nishi.android.view.ns_listview.NSListView;

/**
 * Created by LSD on 15/10/20.
 */
public class NSFragment extends CommonFragment {
    public static final String INTENT_INT_INDEX = "intent_int_index";
    NSFragment nsFragment;
    NSListView nsListView;
    NSAdapter adapter;

    int extType = 0;
    int size = 10;
    int page = 0;
    int sortType = 0;//排序类型
    String city = "苏州";
    String tradingArea = "";//商圈
    int type = 0;//文章类型
    int recommend = 0;//推荐等级
    String searchKey="";
    float longitude =0;
    float location = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extType = getArguments().getInt(INTENT_INT_INDEX);
        nsFragment = this;
    }

    @Override
    protected View getContentView(LayoutInflater inflater) {
        nsListView = new NSListView<Article>(mActivity, true) {
            @Override
            public void loadData() {
                nsFragment.loadData();
            }

            @Override
            public void onItemClick(Article article) {
                mActivity.startActivity(new Intent(mActivity, DetailsActivity.class).putExtra(DetailsActivity.ARTICLE_ID,article.get_id()));
            }
        };
        return nsListView.getView();
    }

    @Override
    protected void onCreateViewCompleted() {
        adapter = new NSAdapter(mActivity);
        nsListView.setAdapter(adapter);

        nsListView.firstLoad();
    }

    private void loadData() {
        //,0:美食 1:周边游 2:逛街 3:活动
        if(extType == 0 || extType == 1){
            type = 0;
        }
        if(extType == 2){
            type = 3;
        }
        if(extType == 3){
            type = 1;
        }
        if(extType == 4){
            type = 2;
        }
        Api.articles(page, size, sortType, city, tradingArea, type, recommend,
                searchKey, longitude, location, new NSCallback<Article>(mActivity, Article.class) {
                    @Override
                    public void onSuccess(List<Article> t, int total) {
                        if(t== null || t.size()<= 0){
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
}
