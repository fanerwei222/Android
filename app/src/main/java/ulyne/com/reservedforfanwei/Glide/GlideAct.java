package ulyne.com.reservedforfanwei.Glide;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import java.io.File;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/5.
 */

public class GlideAct extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 通用加载图片方法
     */
    void loadImage()
    {
        Glide.with(getApplicationContext())
                .load("url")
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(imageView);
    }

    /**
     * 利用glide-transformations设置圆形图片
     */
    void loadImageCircle()
    {
        Glide.with(GlideAct.this)
                .load("url")
                .error(R.mipmap.ic_launcher)
                .bitmapTransform(new CropCircleTransformation((BitmapPool) GlideAct.this))
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }
    /**
     * 简单的从网络加载图片
     */
    void loadImageFromInternet()
    {
        Glide.with(getApplicationContext()).load("url").into(imageView);
    }

    /**
     * 从文件加载
     */
    void loadImageFromFile()
    {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"Test.jpg");
        Glide.with(getApplicationContext()).load(file).into(imageView);
    }

    /**
     * 从资源id
     */
    void loadImageFromResourceId()
    {
        int resourceId = R.mipmap.ic_launcher;
        Glide.with(getApplicationContext()).load(resourceId).into(imageView);
    }

    /**
     * 从uri
     */
    void loadImageFromUri()
    {
        Glide.with(getApplicationContext()).load("uri").into(imageView);
    }

    /**
     * 加载gif
     */
    void loadImageFromGif()
    {
        String gifUrl = "xxxxx";
        Glide.with(getApplicationContext()).load( gifUrl ).into(imageView);
    }
}
