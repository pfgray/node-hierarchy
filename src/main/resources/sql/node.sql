create table nodes (
    id      bigint not null generated always as identity (start with 1, increment by 1),
    path    varchar(100) NOT NULL,
    primary key (id),
    unique(path)
);

insert into nodes  (path) values ('1');
insert into nodes  (path) values ('1/2');
insert into nodes  (path) values ('1/3');
insert into nodes  (path) values ('1/4');
insert into nodes  (path) values ('1/2/5');
insert into nodes  (path) values ('1/3/6');
insert into nodes  (path) values ('1/4/7');
insert into nodes  (path) values ('1/4/8');
insert into nodes  (path) values ('1/4/9');
insert into nodes  (path) values ('1/4/10');
