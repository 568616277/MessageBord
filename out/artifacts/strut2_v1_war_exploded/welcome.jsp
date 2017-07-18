<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Map" %>
<%@ page import="struts2.vo.Comment" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%

    String username = (String)session.getAttribute("user");
     Map<Integer,Comment> commentMap = (Map)request.getAttribute("commentMap");
//    String errormessage = (String)request.getAttribute("errorMessage");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Struts2 Person Login Result</title>
</head>
<body>
<style type = "text/css">

    .welcome{
        background-color: #00c96a;
        font-size: 2.5rem;
        line-height: 1.15;
        margin-bottom: 1.25rem;
        text-decoration: #e5e5e5;
        height:60px;
        text-align: center;
    }
    .welcome h1{
        padding-top: 10px;
    }
    li{
        list-style: none;
    }

</style>
<link rel="stylesheet" href="bootstrap.css">
<div class="welcome"><h1>Hi <%=username%>, Welcome</h1></div>
<%--Hi:<br>--%>
<%--<%=username%><br>--%>
<%--Welcome... <br>--%>

<div id = "commitDisplay" class="panel panel-success">
    <div class="panel-heading"><P>评论区</P></div>
    <div class="panel-body">
    <% for(Comment c :commentMap.values()){ %>
        <div class="panel panel-primary">
            <div class="panel-heading"><%= c.getId()%></div>
            <div class="panel-body"><%= c.getComment()%></div>
            <div class="panel-footer">user:<%= c.getUsername()%></div>
            <form action="delComAction"><button name="id" value="<%=c.getId()%>" class="btn btn-success">delete</button></form>
        </div>
    <% } %>
    </div>
</div>

<form action="AddComAction">
    <p>评论：</p>
    <%--<p><%=errormessage%></p>--%>
    <div class="input-group" style="text-align: center">
        <textarea class="form-control" name="com.comment" ></textarea>
        <input type="hidden" name="com.username" value="<%=username%>"></input>
        <button class="btn btn-success" type="submit" action="AddComAction">submit</button>
    </div>
</form>
</body>
</html>
