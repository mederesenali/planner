use planner;
create table user(
                        id int not null auto_increment,
                        email varchar(45),
                        password varchar(128),
                        name varchar(45),
                        enabled bit,
                        role varchar(45),
                        primary key (id)
);
insert into user(email, password, name, enabled, role)
VALUES ('admin@admin.ru','$2a$12$QbBhc9WPE65v9KhgGnjKruh81J1LP4J9kDverPbEEKoxu59HnjCMS','adminiovich',1,'ADMIN');