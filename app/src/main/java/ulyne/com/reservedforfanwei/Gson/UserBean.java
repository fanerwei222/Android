package ulyne.com.reservedforfanwei.Gson;

/**
 * Created by fanwei on 2017/4/5.
 */

public class UserBean {
    //变量名跟JSON数据的字段名需要一致
    private String name ;
    private String age;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
