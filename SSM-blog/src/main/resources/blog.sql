-- 创建一个数据库用来存储博客信息
create database if not exists blog_system;
-- 选中数据库
use blog_system;
-- 创建一个博客信息表
-- 在创建之前，先判断一下数据库中是否已经存在 entity.Blog 数据表
-- 如果存在，删除它
drop table if exists blog;
create table blog(
    -- 博客id，自增
    blogId int primary key auto_increment,
    -- 博客标题
    title varchar(1024),
    -- mediumtext 用来存储博客内容
    blog_content mediumtext,
    -- 作者ID
    userId int,
    -- 发布时间
    postTime datetime,
    -- 点赞数
    count_like int,
    -- 收藏数
    count_favorite int
);

insert into blog values (null,"我的第一篇博客","今天开始我要认真敲代码",1,now(),0,0);
insert into blog values (null,"我的第二篇博客","明天开始我要认真敲代码",2,now(),0,0);
insert into blog values (null,"我的第三篇博客","后天开始我要认真敲代码",3,now(),0,0);


-- 用户表
drop table  if exists user ;
create table user(
    -- 用户id，自增
    userId int primary key auto_increment,
    -- 用户名 不能重复
    username varchar(128) unique,
    -- 用户密码
    password varchar(128)
);
insert into user values (null,"zhangsan","123");
insert into user values (null,"lisi","456");
insert into user values (null,"张三","123");
drop table  if exists  user_blog_like;
drop table  if exists  user_blog_favorite;
create table user_blog_like(blogId int,userId int);
create table user_blog_favorite(blogId int ,userId int);
