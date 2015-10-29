package nishi.android.view.ns_listview;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lib.adapter.SimpleAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import nishi.android.R;
import nishi.android.activity.CommonActivity;

/**
 * Created by LSD on 15/10/20.
 */
public abstract class NSListView<T> {
    private String Tag = NSListView.class.getSimpleName();
    NSListView nsListView;
    CommonActivity context;
    View root;

    boolean enableRefrash;

    @Bind(R.id.list_framelayout)
    PtrClassicFrameLayout list_framelayout;

    @Bind(R.id.listview)
    ListView listView;

    public NSListView(CommonActivity context, boolean enableRefrash) {
        this.context = context;
        this.enableRefrash = enableRefrash;

        nsListView = this;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        root = layoutInflater.inflate(R.layout.view_nslistview, null);
        ButterKnife.bind(this, root);

        init();
    }

    private void init() {
        list_framelayout.setEnabled(enableRefrash);
        list_framelayout.setLastUpdateTimeRelateObject(this);
        list_framelayout.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                loadData();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                T t = (T) parent.getAdapter().getItem(position);
                nsListView.onItemClick(t);
            }
        });
    }

    public void setAdapter(SimpleAdapter adapter){
        listView.setAdapter(adapter);
    }

    public void firstLoad(){
        list_framelayout.autoRefresh();
    }

    public void loadFinish(){
        list_framelayout.refreshComplete();
    }

    public View getView() {
        return root;
    }

    public abstract void loadData();

    public abstract void onItemClick(T t);
}
