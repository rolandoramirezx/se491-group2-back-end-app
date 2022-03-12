CREATE TABLE LOGIN (
    login_id bigint auto_increment not null primary key,
    user_name varchar(50) not null,
    password varchar(100),
    FOREIGN KEY (user_name) REFERENCES USERS(user_name)
);
