--테이블 만들기

create table member2(
id varchar2(15) primary key,
password varchar2(10),
name varchar2(10),
age number,
gender varchar2(5),
email varchar2(30)
);

-- 테이블에 데이터 넣기
insert into member1 values('hong2','1234','hongkil',20,'남','hong@hong.com');
commit;

select * from member1;

-------------------------------------

create table goodsinfo(
	code char(5) not null primary key,
	name varchar2(30) not null,
	price number(8) not null,
	maker varchar2(20)
);
	
	insert into goodsinfo values('10001','DIGITAL TV',35000,'LG');
	insert into goodsinfo values('10002','LCD TV',135000,'SAMSUNG');
	insert into goodsinfo values('10003','LED TV',235000,'LG');
	insert into goodsinfo values('10004','UHD TV',335000,'SAMSUNG');
	insert into goodsinfo values('10005','OLED TV',435000,'LG');
	
	commit;
