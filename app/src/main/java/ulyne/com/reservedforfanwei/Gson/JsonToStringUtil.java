package ulyne.com.reservedforfanwei.Gson;

import android.content.Context;

import java.io.InputStream;

/**
 * Created by fanwei on 2017/4/5.
 */

public class JsonToStringUtil {

    public static String getStringByJson(Context context, int fileId){
        String resultString="";
        try {
            InputStream inputStream=context.getResources().openRawResource(fileId);
            byte[] buffer=new byte[inputStream.available()];
            inputStream.read(buffer);
            resultString=new String(buffer,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }
}
