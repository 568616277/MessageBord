package struts2.dao.impl;

import struts2.dao.CommentsDAO;
import struts2.db.DBConnect;
import struts2.vo.Comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by zengman on 2017/7/16.
 */
public class CommentsDAOImpl implements CommentsDAO{
    @Override
    public int getAllCommentsDB(Map<Integer,Comment> commentMap) throws Exception {
        int flag = 0;
        String sql = "select * from CommentsInfo";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;
        try {
            dbc = new DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            commentMap.clear();//保证数据不会的叠加重复
            while(rs.next()){
                Comment comment = new Comment();
                comment.setId(rs.getInt(1));
                comment.setComment(rs.getString(2));
                comment.setUsername(rs.getString(3));
                commentMap.put(comment.getId(),comment);
            }
            flag = 1;
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }finally {
            dbc.close() ;
        }
        return flag;
    }

    @Override
    public int addCommentsDB(Comment comment) throws Exception {
        int flag =0;
        String sql = "insert into CommentsInfo (`comments`,`username`) values(?,?)";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;
        try {
            dbc =new  DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1,comment.getComment());
            pstmt.setString(2,comment.getUsername());
            pstmt.executeUpdate();
            flag = 1;
            pstmt.close() ;
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }finally {
            dbc.close() ;
        }
        return flag;
    }

    @Override
    public int deleteCommentDB(int id) throws Exception {
        int flag=0;
        String sql = "delete from CommentsInfo where id = ?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;
        try {
            dbc = new DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            pstmt.close() ;
            flag = 1;
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }finally {
            dbc.close() ;
        }

        return flag;
    }
}
