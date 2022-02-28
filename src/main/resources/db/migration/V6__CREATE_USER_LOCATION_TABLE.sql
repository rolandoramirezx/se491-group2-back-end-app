CREATE TABLE USER_LOCATION (
    ID bigint auto_increment primary key not null ,
    userName varchar(50) not null,
    FOREIGN KEY (userName) REFERENCES USERS(userName),
    zipCode varchar(100) not null,
    FOREIGN KEY (zipCode) REFERENCES LOCATIONS(zipCode)
)
;