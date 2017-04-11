package ulyne.com.reservedforfanwei.RecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/7.
 */

public class RecyclerViewAct extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemDecoration itemDecoration;
    private RecyclerView.ItemAnimator itemAnimator;
    //private RecyclerView.Adapter adapter;
    private StaggeredHomeAdapter adapter;
    private List<String> datas = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recyclerview);

        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //layoutManager = new LinearLayoutManager(this);
        //layoutManager = new GridLayoutManager(this, 3);
        layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        //adapter = new RecyclerviewAdapter(this, datas);
        adapter = new StaggeredHomeAdapter(getApplicationContext(), datas);
        itemAnimator = new DefaultItemAnimator();
        //itemDecoration = new RecyclerItemDecoration(this, RecyclerItemDecoration.VERTICAL_LIST);
        itemDecoration = new DividerGridItemDecoration(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(itemDecoration);

        adapter.setOnItemClickLitener(new StaggeredHomeAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), position + " long click",
                        Toast.LENGTH_SHORT).show();
                adapter.removeData(position);
            }
        });
    }

    protected void initData()
    {
        datas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            datas.add("" + (char) i);
        }
    }
}
