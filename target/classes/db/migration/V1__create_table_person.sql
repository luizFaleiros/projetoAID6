create table person (
    id bigint not null auto_increment,
    address varchar(80) not null,
    first_name varchar(80) not null,
    gender varchar(10) not null,
    last_name varchar(80) not null,
    primary key (id));