CREATE TABLE LOCATIONS (
    location_id bigint auto_increment primary key not null,
    zip_code varchar(100),
    city_name varchar(100) not null,
    latitude double,
    longitude double,
    date_created datetime not null default(current_timestamp),
    user_name varchar(50) not null,
    FOREIGN KEY (user_name) REFERENCES USERS(user_name)
);
