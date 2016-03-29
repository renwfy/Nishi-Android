package nishi.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;
import nishi.android.R;

/**
 * 活动发布
 * Created by LSD on 16/2/22.
 */
public class ViewActivityPublish extends LinearLayout {

    @Bind(R.id.et_title)
    EditText etTitle;
    @Bind(R.id.et_organizer)
    EditText etOrganizer;
    @Bind(R.id.et_address)
    EditText etAddress;
    @Bind(R.id.et_openstart)
    EditText etOpenstart;
    @Bind(R.id.et_openend)
    EditText etOpenend;
    @Bind(R.id.et_expend)
    EditText etExpend;
    @Bind(R.id.sp_ischeck)
    Spinner spIscheck;
    @Bind(R.id.et_pnum)
    EditText etPnum;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_tag)
    EditText etTag;

    public ViewActivityPublish(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init(context);
    }

    public ViewActivityPublish(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init(context);
    }

    void init(Context context) {
        View.inflate(context, R.layout.view_activity_publish, this);
        ButterKnife.bind(this);
    }

}
