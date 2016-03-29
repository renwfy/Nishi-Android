package nishi.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lib.adapter.SimpleAdapter;
import com.lib.viewholder.ViewHolder;

import nishi.android.R;

/**
 * Created by LSD on 16/1/15.
 */
public class NearMenuAdapter extends SimpleAdapter<String> {
    public NearMenuAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, String data, View convertView) {
        if(convertView == null){
            convertView = View.inflate(context, R.layout.view_nearmenu,null);
        }
        TextView tvContent = ViewHolder.get(convertView,R.id.tv_content);
        tvContent.setText(data);
        return convertView;
    }
}
