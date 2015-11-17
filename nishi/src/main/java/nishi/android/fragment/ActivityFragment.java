package nishi.android.fragment;

import android.view.LayoutInflater;
import android.view.View;

import nishi.android.R;
import nishi.android.model.Article;
import nishi.android.model.ArticleDetails;

/**
 * Created by LSD on 15/11/8.
 */
public class ActivityFragment extends CommonFragment {
    @Override
    protected View getContentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_activity,null);
    }

    public void setData(ArticleDetails article){

    }
}
