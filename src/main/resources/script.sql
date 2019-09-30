drop table if exists users;

create table users (
  id int auto_increment primary key,
  name varchar(250) not null,
  email varchar(250) not null,
  password varchar(250) not null
);

insert into users (name, email, password) values
('Joseph Microsoft', 'joseph@ms.com', '123'),
('John Oracle', 'john@oracle.com', '123'),
('Peter Google', 'peter@gmail.com', '123');