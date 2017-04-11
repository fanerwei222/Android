package ulyne.com.reservedforfanwei.OkHttp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/5.
 */

public class OkHttpAct extends AppCompatActivity {
    String url = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * 全局配置
     */
    void confg()
    {
        /**
         * 单实例模式
         */
        OkHttpClient client =
                OkHttpUtils.getInstance().getOkHttpClient();
        client.setConnectTimeout(100000, TimeUnit.MILLISECONDS);
        //.....
    }

    /**
     * 设置超时
     */
    void setTimeOut()
    {
        try {
            OkHttpUtils
                    .get()//
                    .url(url)//
                    .tag(this)//
                    .build()//
                    .connTimeOut(20000)
                    .readTimeOut(20000)
                    .writeTimeOut(20000)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消单个请求
     */
    void cancel()
    {
        RequestCall call = OkHttpUtils.get().url(url).build();
        call.cancel();
    }

    /**
     * 根据tag取消请求
     */
    void cancelByTag()
    {
        OkHttpUtils
                .get()//
                .url(url)//
                .tag(this)//
                .build();//

    }
    //接上一个方法
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        //可以取消同一个tag的
        //OkHttpUtils.cancelTag(this);//取消以Activity.this作为tag的请求
    }

    /**
     * 一般用法
     */
    void normal()
    {
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response) throws IOException {
                        return null;
                    }

                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Object response) {

                    }
                });
    }

    /**
     * GET 请求
     */
    void get()
    {
        String url = "http://www.csdn.net/";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Request request, Exception e)
                    {

                    }

                    @Override
                    public void onResponse(String response)
                    {

                    }
                });
    }

    /**
     * POST 请求
     */
    void post()
    {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response) throws IOException {
                        return null;
                    }

                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Object response) {

                    }
                });
    }

    /**
     * POST STRING 请求
     */
    void postString()
    {
        OkHttpUtils
                .postString()
                .url(url)
                //.content(new Gson().toJson(new User("zhy", "123"))) // 需要Gson
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response) throws IOException {
                        return null;
                    }

                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Object response) {

                    }
                });
    }

    /**
     * POST FILE 请求
     */
    void postFile()
    {
        OkHttpUtils
                .postFile()
                .url(url)
                .file(new File(""))
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response) throws IOException {
                        return null;
                    }

                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Object response) {

                    }
                });
    }

    /**
     * Post upload file 请求
     */
    void postUploadFile()
    {
        OkHttpUtils.post()//
                .addFile("mFile", "messenger_01.png", new File(""))//
                .addFile("mFile", "test1.txt", new File(""))//
                .url(url)
                .params(new ArrayMap<String, String>())//
                .headers(new ArrayMap<String, String>())//
                .build()//
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response) throws IOException {
                        return null;
                    }

                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Object response) {

                    }
                });
    }

    /**
     *  download file 请求
     */
    void downloadFile()
    {
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "gson-2.2.1.jar")//
                {
                    @Override
                    public void inProgress(float progress)
                    {
                       // mProgressBar.setProgress((int) (100 * progress));
                    }

                    @Override
                    public void onError(Request request, Exception e)
                    {
                        Log.e("", "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File file)
                    {
                        Log.e("", "onResponse :" + file.getAbsolutePath());
                    }
                });
    }

    /**
     * show image 请求
     */
    void showImage()
    {
        OkHttpUtils
                .get()//
                .url(url)//
                .build()//
                .execute(new BitmapCallback()
                {
                    @Override
                    public void onError(Request request, Exception e)
                    {
                       // mTv.setText("onError:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap bitmap)
                    {
                       // mImageView.setImageBitmap(bitmap);
                    }
                });
    }
}
