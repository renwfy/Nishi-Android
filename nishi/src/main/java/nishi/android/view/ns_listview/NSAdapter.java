package nishi.android.view.ns_listview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lib.adapter.SimpleAdapter;
import com.lib.utils.AppLog;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nishi.android.Constants;
import nishi.android.R;
import nishi.android.api.Api;
import nishi.android.model.Article;
import nishi.android.net.NSCallback;

/**
 * Created by LSD on 15/10/20.
 */
public class NSAdapter extends SimpleAdapter<Article> {
    public NSAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, final Article data, View convertView) {
        ViewHolde viewHolde;
        if (convertView == null) {
            convertView = (viewHolde = new ViewHolde(context)).convertView;
            convertView.setTag(viewHolde);
        } else {
            viewHolde = (ViewHolde) convertView.getTag();
        }
        viewHolde.tv_name.setText(data.getTitle());
        viewHolde.tv_address.setText(data.getSite());
        viewHolde.tv_collect.setText(data.getCollectUserNumber() + "");
        viewHolde.tv_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api.collect(data.get_id(), new NSCallback(context,String.class) {
                    @Override
                    public void onSuccess(Object o) {
                        super.onSuccess(o);
                    }
                });
            }
        });
        setDrawableTop(viewHolde.tv_collect, data.isHasCollect());
        Picasso.with(context).load(Constants.QINIU_BASEURL+data.getPlaybill()).placeholder(R.drawable.ic_default_image_lagger).into(viewHolde.iv_list_pic);
        //,0:美食 1:周边游 2:逛街 3:活动
        switch (data.getType()) {
            case 0:
                viewHolde.iv_type.setImageResource(R.drawable.ic_type_delicacy);
                break;
            case 1:
                viewHolde.iv_type.setImageResource(R.drawable.ic_type_tour);
                break;
            case 2:
                viewHolde.iv_type.setImageResource(R.drawable.ic_type_shopping);
                break;
            case 3:
                viewHolde.iv_type.setImageResource(R.drawable.ic_type_activity);
                break;
            default:
                viewHolde.iv_type.setImageResource(R.drawable.ic_type_delicacy);
        }
        return convertView;
    }

    public void setDrawableTop(TextView textView,boolean status){
        Drawable top = null;
        if(status){
            top = context.getResources().getDrawable(R.drawable.ic_item_collect1);
        }else{
            top = context.getResources().getDrawable(R.drawable.ic_item_collect0);
        }

        top.setBounds(0, 0, top.getMinimumWidth(), top.getMinimumHeight());
        textView.setCompoundDrawables(null, top, null, null);
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
