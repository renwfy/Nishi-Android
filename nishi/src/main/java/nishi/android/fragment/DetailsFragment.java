package nishi.android.fragment;

import android.view.LayoutInflater;
import android.view.View;

import nishi.android.R;

/**
 * Created by LSD on 15/11/3.
 */
public class DetailsFragment extends CommonFragment{
    @Override
    protected View getContentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_detail,null);
    }
}