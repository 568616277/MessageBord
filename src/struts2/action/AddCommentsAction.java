package struts2.action;

import com.opensymphony.xwork2.ActionContext;
import struts2.dao.CommentsDAO;
import struts2.dao.impl.CommentsDAOImpl;
import struts2.vo.Comment;

import java.util.Map;


/**
 * Created by zengman on 2017/7/16.
 */
public class AddCommentsAction {
    private Comment com;
    private String error;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Comment getCom() {
        return com;
    }

    public void setCom(Comment com) {
        this.com = com;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String addCom() throws Exception{
        error = "";
        CommentsDAO dao = new CommentsDAOImpl();
        int flag = dao.addCommentsDB(com);
        if( flag == 0){//添加失败
            error = "添加失败！";
        }
        com.setUsername(username);
        ActionContext context= ActionContext.getContext();
        Map request = (Map)context.get("request");
        request.put("errorMessage",error);
        Map session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
        session.put("commentsUser", com.getUsername());
        return "addSuccess";

    }
}
