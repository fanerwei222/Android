package ulyne.com.reservedforfanwei.Sugar;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by fanwei on 2017/4/5.
 */

public class Book extends SugarRecord {
    String title;
    String edition;

    public Book(){
    }

    public Book(String title, String edition){
        this.title = title;
        this.edition = edition;
    }
}

/**
 * 或者这样的写法和上面是一样的
 *
 */
/*@Table
public class Book {
    private Long id;

    public Book(){
    }

    public Book(String title, String edition){
        this.title = title;
        this.edition = edition;
    }

    public Long getId() {
        return id;
    }
}*/
