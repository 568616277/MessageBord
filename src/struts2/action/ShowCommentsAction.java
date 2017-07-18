package struts2.action;

import com.opensymphony.xwork2.ActionContext;
import struts2.dao.CommentsDAO;
import struts2.dao.impl.CommentsDAOImpl;
import struts2.vo.Comment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zengman on 2017/7/16.
 */
public class ShowCommentsAction {
    private Map<Integer,Comment> commentMap = new HashMap<Integer, Comment>();

    public Map<Integer, Comment> getCommentMap() {
        return commentMap;
    }

    public void setCommentMap(Map<Integer, Comment> commentMap) {
        this.commentMap = commentMap;
    }

    public String show() throws Exception{
        CommentsDAO dao = new CommentsDAOImpl();
        int flag = dao.getAllCommentsDB(commentMap);
        if(flag ==1){
            ActionContext context= ActionContext.getContext();
            Map request = (Map)context.get("request");
            request.put("commentMap", commentMap);

        }else{
            System.out.println("show comments fail");
        }
        return "show";

    }

}
