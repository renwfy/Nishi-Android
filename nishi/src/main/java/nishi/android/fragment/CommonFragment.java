package nishi.android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import nishi.android.activity.CommonActivity;
import nishi.android.base.BaseFragment;

/**
 * Created by LSD on 15/10/20.
 */
public abstract class CommonFragment extends BaseFragment {
    public CommonActivity mActivity;
    protected View rootView;//缓存Fragment view

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (CommonActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null){
            rootView= getContentView();
            ButterKnife.bind(this, rootView);
            onCreateViewCompleted();
        }
        //缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    protected abstract View getContentView();
    protected void onCreateViewCompleted(){}
}
