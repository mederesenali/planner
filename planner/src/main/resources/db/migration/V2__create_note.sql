use planner;
create table note(
    id int not null auto_increment,
    title varchar(45) not null  ,
    content varchar(255) not null ,
    local_date date,
    done bool,
    user_id int,
    foreign key (user_id) references user(id),
    primary key(id)
)