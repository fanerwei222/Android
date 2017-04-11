package ulyne.com.reservedforfanwei.ListView;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/7.
 */

public class ListViewAct extends AppCompatActivity implements OnClickAdapter{
    private ListView listView;
    private UserDefinedAdpter userDefinedAdpter;
    private List<String> datas = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas.add("1");
        datas.add("2");
        datas.add("3");

        listView = (ListView) findViewById(R.id.listview);

        userDefinedAdpter = new UserDefinedAdpter(getApplicationContext(), datas, this);
        listView.setAdapter(userDefinedAdpter);
    }

    @Override
    public void onClickAdapter(Context context) {
        Toast.makeText(getApplicationContext(), "自定义好了", Toast.LENGTH_LONG).show();
    }
}
