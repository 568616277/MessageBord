package struts2.dao;
import java.util.List;

import struts2.vo.User;
/**
 * Created by zengman on 2017/7/14.
 */
import java.util.List;

public interface UserDAO {
    public int queryByUsername(User user) throws Exception;
    //定义一个查询用户名的方法
    public int registerUser(User user) throws Exception;
}
