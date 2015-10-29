package nishi.android.view;

import android.os.Bundle;
import android.view.View;

import com.lib.utils.AppLog;

import java.util.ArrayList;
import java.util.List;

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

    int size = 10;
    int page;
    int sortType;//排序类型
    String city = "苏州";
    String tradingArea;//商圈
    int type;//文章类型
    int recommend;//推荐等级
    String searchKey="";
    float longitude;
    float location;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nsFragment = this;
    }

    @Override
    protected View getContentView() {
        nsListView = new NSListView<Article>(mActivity, true) {
            @Override
            public void loadData() {
                nsFragment.loadData();
            }

            @Override
            public void onItemClick(Article article) {

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
        Api.articles(page, size, sortType, city, tradingArea, type, recommend,
                searchKey, longitude, location, new NSCallback<Article>(mActivity, Article.class) {
                    @Override
                    public void onSuccess(List<Article> t, int total) {
                        adapter.setData(t);
                        nsListView.loadFinish();
                    }
        });
    }
}
