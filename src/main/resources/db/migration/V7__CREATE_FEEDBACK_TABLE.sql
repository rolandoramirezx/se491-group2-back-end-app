CREATE TABLE FEEDBACK (
      ID bigint auto_increment primary key not null ,
      rating  int,
      comments varchar(5000),
      user_name varchar(50) not null
   --   FOREIGN KEY (userName) REFERENCES USERS(userName)
);
