package ulyne.com.reservedforfanwei.Logger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/5.
 */

public class LoggerAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.d("this is a logger d");
    }
}
