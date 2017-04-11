package ulyne.com.reservedforfanwei.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.List;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/7.
 * 自定义adapter
 */

public class UserDefinedAdpter extends BaseAdapter implements View.OnClickListener {
    //视图容器工厂
    private LayoutInflater inflater ;
    private Context context;
    private List<String> datas;
    //传入一个点击接口
    private OnClickAdapter onClickAdapter;

    public  UserDefinedAdpter(Context context, List<String> datas, OnClickAdapter onClickAdapter)
    {
        //创建视图容器工厂并设置上下文
        inflater = LayoutInflater.from(context);
        //创建视图容器另一写法
       /* (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
        this.context = context;
        this.datas = datas;
        this.onClickAdapter = onClickAdapter;
    }

    /**
     * 获取数目
     * @return
     */
    @Override
    public int getCount() {
        return datas.size();
    }

    /**
     * 获取指定下标的项目
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    /**
     * 获取指定item的position
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 设置内容
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            //创建layout_item.xml布局文件的视图
            convertView = inflater.inflate(R.layout.layout_item, parent, false);
            //获取控件对象
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_item_1);
            viewHolder.button = (Button) convertView.findViewById(R.id.btn_item_1);
            //设置控件集到View
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //设置文字
        viewHolder.textView.setText(datas.get(position));
        //Logger.d(viewHolder.textView);
        viewHolder.button.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_item_1:
                onClickAdapter.onClickAdapter(context);
                break;
        }
    }

    /**
     * 自定义viewholder
     */
    private final class ViewHolder
    {
        TextView textView;
        Button button;
    }
}
