package ulyne.com.reservedforfanwei.Bmob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobPushManager;
import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/11.
 */

public class BmobAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this, "");
        BmobInstallation.getCurrentInstallation().save();
        BmobPush.startWork(this);
        BmobPushManager bmobPushManager = new BmobPushManager();
    }
}
