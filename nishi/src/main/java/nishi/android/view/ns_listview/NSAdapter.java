package nishi.android.view.ns_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lib.adapter.SimpleAdapter;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import nishi.android.Constants;
import nishi.android.R;
import nishi.android.model.Article;

/**
 * Created by LSD on 15/10/20.
 */
public class NSAdapter extends SimpleAdapter<Article> {
    public NSAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, Article data, View convertView) {
        ViewHolde viewHolde;
        if (convertView == null) {
            convertView = (viewHolde = new ViewHolde(context)).convertView;
            convertView.setTag(viewHolde);
        } else {
            viewHolde = (ViewHolde) convertView.getTag();
        }
        viewHolde.tv_name.setText(data.getName());
        viewHolde.tv_address.setText(data.getSite());
        viewHolde.tv_collect.setText(data.getRecommend() + "");
        Picasso.with(context).load(Constants.QINIU_BASEURL+data.getPlaybill()).placeholder(R.drawable.ic_default_image_lagger).into(viewHolde.iv_list_pic);
        switch (data.getType()) {
            case 0:
                viewHolde.iv_type.setImageResource(R.drawable.ic_type_delicacy);
                break;
            default:
                viewHolde.iv_type.setImageResource(R.drawable.ic_type_delicacy);
        }
        return convertView;
    }

    public class ViewHolde {
        View convertView;
        @Bind(R.id.iv_list_pic)
        ImageView iv_list_pic;
        @Bind(R.id.iv_type)
        ImageView iv_type;
        @Bind(R.id.tv_name)
        TextView tv_name;
        @Bind(R.id.tv_address)
        TextView tv_address;
        @Bind(R.id.tv_collect)
        TextView tv_collect;

        public ViewHolde(Context context) {
            convertView = LayoutInflater.from(context).inflate(R.layout.view_nslist_item, null);
            ButterKnife.bind(this, convertView);
        }
    }
}
