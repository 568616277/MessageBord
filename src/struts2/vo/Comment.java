package struts2.vo;


import java.util.Map;

/**
 * Created by zengman on 2017/7/16.
 */
public class Comment {
    private int id;
    private String comment;
    private String username;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
