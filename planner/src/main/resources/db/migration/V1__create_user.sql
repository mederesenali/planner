use planner;

create table user(
    id int not null auto_increment,
    name varchar(45) not null ,
    email varchar(45) not null ,
    password varchar(128) not null ,
    enabled bit,
    role varchar(45),
    primary key (id)


);
insert into  user(name, email, password, enabled, role)
VALUES('adminovich','admin@admin.ru','$2a$12$dGRxs1d6ETSONBs/VFCFIeY9GoUbaJeZysO/3Qhu3uKEazzUeiMHi',1,'ADMIN')