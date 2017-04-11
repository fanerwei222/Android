package ulyne.com.reservedforfanwei.EventBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/5.
 */

public class EventBusAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * EventBus订阅和解除订阅
     * 接受类所用方法
     */
    void registerAndUnregister()
    {
        EventBus.getDefault().register(this);//订阅
        EventBus.getDefault().unregister(this);//解除订阅
    }

    /**
     * 发布消息
     * 发出类所用的方法
     */
    void send()
    {
        EventBus.getDefault().post(new DataSynEvent());
    }

    /**
     * 订阅事件处理
     * 接受类所用方法
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(DataSynEvent event) {
        //NAIN UI主线程
        //BACKGROUND 后台线程
        //POSTING 和发布者处在同一个线程
        //ASYNC 异步线程
        Log.e("", "event---->" + event.getCount());
    }

    /**
     * 优先级
     * 接受类所用方法
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 100) //在ui线程执行 优先级100
    public void onDataSynEvent2(DataSynEvent event) {
        Log.e("", "event---->" + event.getCount());
    }

    /**
     * 终止事件往下传递
     * 接受类所用方法
     */
    void stop()
    {
        EventBus.getDefault().cancelEventDelivery(new DataSynEvent()) ;//优先级高的订阅者可以终止事件往下传递
    }
}
