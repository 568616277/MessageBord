 create database mystruts2db;
create table userinfo(
	username char(40),
	password char(20)
);

 insert into userinfo values ('zengman','123');
 create table CommentsInfo(id int, comments varchar(200),username char(40)) use mystruts2db;