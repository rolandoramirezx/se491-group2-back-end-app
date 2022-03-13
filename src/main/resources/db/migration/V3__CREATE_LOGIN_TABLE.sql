CREATE TABLE LOGIN (
    login_id bigint auto_increment not null primary key,
    user_name varchar(50) not null,
    pass_hash text not null,
    FOREIGN KEY (user_name) REFERENCES USERS(user_name)
);
