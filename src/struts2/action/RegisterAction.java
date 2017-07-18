package struts2.action;

import com.opensymphony.xwork2.ActionContext;
import struts2.dao.UserDAO;
import struts2.dao.impl.UserDAOImpl;
import struts2.vo.User;

import java.util.Map;

/**
 * Created by zengman on 2017/7/18.
 */
public class RegisterAction {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String execute() throws  Exception{
        UserDAO dao = new UserDAOImpl();
        int flag = dao.registerUser(user);
        if(flag ==1){
            Map session=(Map) ActionContext.getContext().get(ActionContext.SESSION);
            session.put("user", user.getUsername());
            return "success";
        } else {
            System.out.println("Register fail");
            return "input";
        }
    }
}
