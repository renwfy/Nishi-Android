package nishi.android.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import nishi.android.R;
import nishi.android.model.ArticleDetails;

/**
 * Created by LSD on 15/11/8.
 */
public class U_NewsFragment extends CommonFragment {
    @Bind(R.id.iv1)
    ImageView iv1;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.iv_address)
    ImageView ivAddress;
    @Bind(R.id.adress_layout)
    RelativeLayout adressLayout;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.tv_price)
    TextView tvPrice;

    ArticleDetails article;

    @Override
    protected View getContentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_message, null);
    }

    @Override
    protected void onCreateViewCompleted() {
        super.onCreateViewCompleted();
        initData();
    }

    public void setData(ArticleDetails article) {
        this.article = article;
    }

    private void initData(){
        if(article == null){
            return;
        }
        tvName.setText(article.getName());
        tvAddress.setText(article.getSite());
    }
}
