CREATE TABLE FEEDBACK (
      id bigint auto_increment primary key not null ,
      user_id varchar(100) not null,
      rating  int,
      comments varchar(5000)
);
