CREATE TABLE FEEDBACK (
      ID bigint auto_increment primary key not null ,
      userID varchar(100) not null,
      rating  int,
      comments varchar(5000),
      userName varchar(50) not null,
      FOREIGN KEY (userName) REFERENCES USERS(userName)
);