package struts2.action;

import struts2.dao.CommentsDAO;
import struts2.dao.impl.CommentsDAOImpl;
import struts2.vo.Comment;

/**
 * Created by zengman on 2017/7/17.
 */
public class DelCommentsAction {
   private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String delCom() throws Exception{
        CommentsDAO dao = new CommentsDAOImpl();
        System.out.println("id ==="+id);
        int flag = dao.deleteCommentDB(id);
        if(flag ==0){
            System.out.println("delete fail");
        }
        return "delSuccess";

    }
}
