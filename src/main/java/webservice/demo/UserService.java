package webservice.demo;

/**
 * Created by zhong on 2016/6/16.
 */
public class UserService {
    public User getUser(Integer userId) {
        return new User("zhong",userId);
    }

    public void createUser(String name, Integer age) {
        User user = new User(name, age);
        System.out.println(user);
    }
}
