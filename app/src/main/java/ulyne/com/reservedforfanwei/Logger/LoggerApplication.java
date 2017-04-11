package ulyne.com.reservedforfanwei.Logger;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;


/**
 * Created by fanwei on 2017/4/5.
 */

public class LoggerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init()                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                .methodOffset(2);            // default 0
    }
}
