--javalink/javalink

create table book(
	id varchar2(20) primary key,
	name varchar2(20),
	price number(10)
);

insert into book values ('aaaa','hong',1000);
insert into book values ('bbbb','alphago',2000);
insert into book values ('cccc','beta',3000);

select * from book;