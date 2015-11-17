package nishi.android.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lib.picasso.CircleTransform;
import com.lib.picasso.RoundedTransformation;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import nishi.android.Constants;
import nishi.android.R;
import nishi.android.api.Api;
import nishi.android.model.Article;
import nishi.android.model.ArticleDetails;

/**
 * Created by LSD on 15/11/3.
 */
public class DetailsFragment extends CommonFragment {
    @Bind(R.id.iv_avstar)
    ImageView iv_avstar;
    @Bind(R.id.tv_nick)
    TextView tv_nick;
    @Bind(R.id.content_layout)
    LinearLayout content_layout;

    ArticleDetails article;

    @Override
    protected View getContentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_detail, null);
    }

    @Override
    protected void onCreateViewCompleted() {
        setupView();
    }

    public void setupView() {
        ImageView imageView = new ImageView(mActivity);
        imageView.setImageResource(R.drawable.iv_details_selector);
        content_layout.addView(imageView);

        TextView textView = new TextView(mActivity);
        textView.setText("测试数据********");
        content_layout.addView(textView);

        initData();
    }

    public void setData(ArticleDetails article) {
        this.article = article;
    }

    public void initData() {
        tv_nick.setText(article.getCreatorNickname());
        Picasso.with(mActivity).load(Constants.QINIU_BASEURL + article.getCreatorPortraitUri()).placeholder(R.drawable.ic_avstar).transform(new CircleTransform()).into(iv_avstar);
    }
}
