CREATE TABLE LOGIN (
    ID bigint auto_increment primary key not null ,
    userName varchar(50) not null,
    password varchar(100),
    FOREIGN KEY (userName) REFERENCES USERS(userName)
)
;