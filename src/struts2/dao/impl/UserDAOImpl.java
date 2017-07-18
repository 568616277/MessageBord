package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import struts2.dao.UserDAO;
import struts2.db.DBConnect;
import struts2.vo.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public int queryByUsername(User user) throws Exception {
        // TODO Auto-generated method stub
        int flag = 0;
        String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;
        try{
            // connect database
            dbc = new DBConnect() ;
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1,user.getUsername()) ;
            System.out.println(user.getUsername());
            //query database
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                //
                if(rs.getString("password").equals(user.getPassword())){
                    flag = 1;
                }
            }
            rs.close() ;
            pstmt.close() ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{

            dbc.close() ;
        }
        return flag;
    }

}
