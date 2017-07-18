package struts2.dao;

import struts2.vo.Comment;

import java.util.Map;

/**
 * Created by zengman on 2017/7/16.
 */
public interface CommentsDAO {
    public int getAllCommentsDB(Map<Integer,Comment> commentMap) throws Exception;
    public int addCommentsDB(Comment comment) throws  Exception;
    public int deleteCommentDB(int id) throws Exception;
}
