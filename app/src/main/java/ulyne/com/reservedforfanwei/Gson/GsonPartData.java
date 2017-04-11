package ulyne.com.reservedforfanwei.Gson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/5.
 */

public class GsonPartData extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * 介绍
     */
    void info()
    {
        /*
        "muser": [
        {
            "name": "zhangsan",
                "age": "10",
                "phone": "11111",
                "email": "11111@11.com"
        },
    ...
]
*/
        /*这里的 "muser" ，也就是数组的名称，称它为数据头，防止跟里面的 字段 有歧义；
        如果没有数据头，那就叫它纯数据，或者纯数组数据；
        代码中用到的 JsonArray/JsonObject 等熟悉的类全部来自 GSON 。*/
    }

    /**
     * 解析没有数据头的纯数组
     */
    private void parseNoHeaderJArray() {
        //拿到本地JSON 并转成String
        String strByJson = JsonToStringUtil.getStringByJson(this, R.raw.juser_1);

        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(strByJson).getAsJsonArray();

        Gson gson = new Gson();
        ArrayList<UserBean> userBeanList = new ArrayList<>();

        //加强for循环遍历JsonArray
        for (JsonElement user : jsonArray) {
            //使用GSON，直接转成Bean对象
            UserBean userBean = gson.fromJson(user, UserBean.class);
            userBeanList.add(userBean);
        }
        //mainLView.setAdapter(new UserAdapter(this, userBeanList));
    }

    /**
     * 解析有数据头的纯数组
     */
    private void parseHaveHeaderJArray() {
        //拿到本地JSON 并转成String
        String strByJson = JsonToStringUtil.getStringByJson(this, R.raw.juser_2);

        //先转JsonObject
        JsonObject jsonObject = new JsonParser().parse(strByJson).getAsJsonObject();
        //再转JsonArray 加上数据头
        JsonArray jsonArray = jsonObject.getAsJsonArray("muser");

        Gson gson = new Gson();
        ArrayList<UserBean> userBeanList = new ArrayList<>();

        //循环遍历
        for (JsonElement user : jsonArray) {
            //通过反射 得到UserBean.class
            UserBean userBean = gson.fromJson(user, new TypeToken<UserBean>() {}.getType());
            userBeanList.add(userBean);
        }
        //mainLView.setAdapter(new UserAdapter(this, userBeanList));
    }

    /**
     * 有消息头 复杂数据 常规方式
     */
    private void parseComplexJArrayByCommon() {
        //拿到Json字符串
        String strByJson = JsonToStringUtil.getStringByJson(this, R.raw.juser_3);
        //GSON直接解析成对象
        ResultBean resultBean = new Gson().fromJson(strByJson,ResultBean.class);
        //对象中拿到集合
        List<ResultBean.UserBean> userBeanList = resultBean.getMuser();
        //展示到UI中
        //mainLView.setAdapter(new ResultAdapter(this, userBeanList));
    }

    /**
     * 有数据头 复杂数据 截取方式
     */
    private void parseComplexJArrayByDirect() {
        //拿到JSON字符串
        String strByJson = JsonToStringUtil.getStringByJson(this, R.raw.juser_3);
        List<UserBean> userBeanList = new ArrayList<>();

        //拿到数组
        JsonObject jsonObject = new JsonParser().parse(strByJson).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("muser");

        //循环遍历数组
        for (JsonElement user : jsonArray) {
            UserBean userBean = new Gson().fromJson(user, new TypeToken<UserBean>() {
            }.getType());
            //根据条件过滤
            if (Integer.parseInt(userBean.getAge()) > 30) {
                userBeanList.add(userBean);
            }
        }
        //mainLView.setAdapter(new UserAdapter(this, userBeanList));
    }

    /**
     * 通过JsonReader的方式去解析
     */
    private void parseComplexJArrayByReader() throws IOException {
        String strByJson = JsonToStringUtil.getStringByJson(this, R.raw.juser_4);
        JsonReader reader = new JsonReader(new StringReader(strByJson));
        try {
            reader.beginObject();
            String tagName = reader.nextName();
            if (tagName.equals("group")) {
                //读group这个节点
                readGroup(reader);
            }
            reader.endObject();
        } finally {
            reader.close();
        }
    }

    /**
     * 读group这个节点
     *
     * @param reader JsonReader
     */
    private void readGroup(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String tagName = reader.nextName();
            if (tagName.equals("user")) {
                readUser(reader);
            } else if (tagName.equals("info")) {
                readInfo(reader);
            }
        }
        reader.endObject();
    }

    /**
     * 读用户基本消息 user节点
     *
     * @param reader JsonReader
     */
    private void readUser(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String tag = reader.nextName();
            if (tag.equals("name")) {
                String name = reader.nextString();
                //nameText.setText(name);
            } else if (tag.equals("age")) {
                String age = reader.nextString();
               // ageText.setText(age);
            }
        //...
        else {
                reader.skipValue();//忽略
            }
        }
        reader.endObject();
    }

    /**
     * 读用户其他消息 info节点
     *
     * @param reader JsonReader
     */
    private void readInfo(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String tag = reader.nextName();
            if (tag.equals("address")) {
                String address = reader.nextString();
                //addressText.setText(address);
            } else if (tag.equals("work")) {
                String work = reader.nextString();
               // workText.setText(work);
            }
        //...
        else {
                reader.skipValue();//忽略
            }
        }
        reader.endObject();
    }
}
