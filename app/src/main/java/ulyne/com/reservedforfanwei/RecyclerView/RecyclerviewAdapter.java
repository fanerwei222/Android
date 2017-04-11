package ulyne.com.reservedforfanwei.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/7.
 * 控制点击、长按事件
 */

public class RecyclerviewAdapter  extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewholder>{
    private List<String> datas = new ArrayList<String>();
    private Context context;
    private LayoutInflater inflater;

    public RecyclerviewAdapter(Context context, List<String> datas)
    {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 返回一个自定义的ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_recyclerview_item, parent, false);
        MyViewholder myViewholder = new MyViewholder(view);

        return myViewholder;
    }

    /**
     * 返回的holder中的控件
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {

        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder
    {
        TextView textView;
        public MyViewholder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recyclerview_item_tv);
        }
    }
}
