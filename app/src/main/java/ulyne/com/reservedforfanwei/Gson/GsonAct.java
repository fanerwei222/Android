package ulyne.com.reservedforfanwei.Gson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/5.
 */

public class GsonAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * One 仅包含基本数据类型的数据结构
     */
    void gson2Json()
    {
        Gson gson = new Gson();
        Student student = new Student();
        student.id = 1;
        student.nickName = "fan";
        student.age = 22;
        String str = gson.toJson(student);
        Log.e("Gson2Json:", gson.toJson(student));
    }

    /**
     * Two 除了基本数据类型还包含了List集合
     */
    void gson2JsonIncludeList()
    {
        Gson gson = new Gson();
        Student student = new Student();
        student.id = 1;
        student.nickName = "fan";
        student.age = 22;
        ArrayList<String> books = new ArrayList<String>();
        books.add("数学");
        books.add("语文");
        books.add("英语");
        books.add("物理");
        books.add("化学");
        books.add("生物");
        student.books = books;
        String str = gson.toJson(student);
        Log.e("gson2JsonIncludeList:", gson.toJson(student));
    }

    /**
     * Three 除了基本数据类型还包含了List和Map集合
     */
    void gson2JsonIncludeListAndMap()
    {
        Gson gson = new Gson();
        Student student = new Student();
        student.id = 1;
        student.nickName = "fan";
        student.age = 22;
        ArrayList<String> books = new ArrayList<String>();
        books.add("数学");
        books.add("语文");
        books.add("英语");
        books.add("物理");
        books.add("化学");
        books.add("生物");
        student.books = books;
        HashMap<String, String> booksMap = new HashMap<String, String>();
        booksMap.put("1", "数学");
        booksMap.put("2", "语文");
        booksMap.put("3", "英语");
        booksMap.put("4", "物理");
        booksMap.put("5", "化学");
        booksMap.put("6", "生物");
        student.booksMap = booksMap;
        String str = gson.toJson(student);
        Log.e("MainActivity", gson.toJson(student));
    }

    /**
     * 把Three输出的字符串使用Gson转换成Student对象
     */
    void json2GsonThree()
    {
        Gson gson = new Gson();
        Student student = new Student();
        student.id = 1;
        student.nickName = "fan";
        student.age = 22;
        ArrayList<String> books = new ArrayList<String>();
        books.add("数学");
        books.add("语文");
        books.add("英语");
        books.add("物理");
        books.add("化学");
        books.add("生物");
        student.books = books;
        HashMap<String, String> booksMap = new HashMap<String, String>();
        booksMap.put("1", "数学");
        booksMap.put("2", "语文");
        booksMap.put("3", "英语");
        booksMap.put("4", "物理");
        booksMap.put("5", "化学");
        booksMap.put("6", "生物");
        student.booksMap = booksMap;
        String result = gson.toJson(student);

        /**
         * 主要是这段代码
         */
        Student studentG = gson.fromJson(result, Student.class);

        Log.e("MainActivity", "id:" + studentG.id);
        Log.e("MainActivity", "nickName:" + studentG.nickName);
        Log.e("MainActivity", "age:" + studentG.age);
        Log.e("MainActivity", "books size:" + studentG.books.size());
        Log.e("MainActivity", "booksMap size:" + studentG.booksMap.size());
    }

    /**
     * 泛型的使用
     */
    void fanXing()
    {
        /**
         * 在Student类中修改如下
         */
        /*public HashMap<String,Book> booksMap;*/

        /**
         * 添加
         */
        /*public class Book{
            public int id;
            public String name;
        }*/

        /**
         * json2Gson 泛型
         */
        /*HashMap<String, Book> booksMap = gson.fromJson(result, new TypeToken<HashMap<String, Book>>() { }.getType());*/

    }
}
