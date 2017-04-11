package ulyne.com.reservedforfanwei.Sugar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/5.
 */

public class SugarAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * 保存
     */
    void save()
    {
        Book book = new Book("Title here", "2nd edition");
        book.save();
    }

    /**
     * 加载
     */
    void load()
    {
        Book book = Book.findById(Book.class, 1);
    }

    /**
     * 更新
     */
    void update()
    {
        Book book = Book.findById(Book.class, 1);
        book.title = "updated title here"; // modify the values
        book.edition = "3rd edition";
        book.save(); // updates the previous entry with new values.
    }

    /**
     * 删除
     */
    void delete()
    {
        Book book = Book.findById(Book.class, 1);
        book.delete();
    }

    /**
     * 批量操作
     */
    void muchDo()
    {
        List<Book> books = Book.listAll(Book.class);

        Book.deleteAll(Book.class);
    }
}
