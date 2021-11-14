-- Ch01. Oracle & DataBase
-- Relation Database : 테이블과 테이블 사이의 관계를 통해서 데이터 저장, 검색하는 것
-- DBMS: Oracle, MySQL, MS-SQL

-- 테이블 지우기
drop table employee;
drop table department;
drop table salgrade;
-- parent table 먼저 그 다음 child table 만들어야함
-- 테이블 지울 때 child먼저


commit;
rollback;
-- 실행취소

-- 테이블 만들기
create table employee(
    eno number(4) primary key,
    ename varchar2(10),
    job varchar2(9),
    manager number(4),
    hiredate date,
    salary number(7,2),
    commission number(7,2),
    dno number(2) REFERENCES department (dno)
);

create table department(
    dno number(2) PRIMARY KEY,
    dname varchar2(14),
    loc varchar2(13)
);

create table salgrade(
grade number,
losal number,
hisal number
);

insert into department values(20,'RESEARCH','DALLAS');
insert into department values(10,'ACCOUNTING','NEW YORK');
insert into department values(30,'SALES','CHICAGO');
insert into department values(40,'OPERATIONS','BOSTON');

insert into employee values(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,null,50);
insert into employee values(7499,'ALLEN','SALESMAN',7698,to_date('20-02-1981','dd-mm-yyyy'),1600,300,30);
insert into employee values(7521,'WARD','SALESMAN',7698,to_date('22-02-1981','dd-mm-yyyy'),1250,500,30);
insert into employee values(7566,'JONES','MANAGER',7839,to_date('02-04-1981','dd-mm-yyyy'),2975,null,20);
insert into employee values(7654,'MARTIN','SALESMAN',7698,to_date('28-09-1981','dd-mm-yyyy'),1250,1400,30);
insert into employee values(7698,'BLAKE','MANAGER',7839,to_date('01-05-1981','dd-mm-yyyy'),2850,null,30);
insert into employee values(7782,'CLARK','MANAGER',7839,to_date('09-06-1981','dd-mm-yyyy'),2450,null,10);
insert into employee values(7788,'SCOTT','ANALYST',7566,to_date('19-04-1987','dd-mm-yyyy'),3000,null,20);
insert into employee values(7839,'KING','PRESIDENT',null,to_date('07-11-1981','dd-mm-yyyy'),5000,null,10);
insert into employee values(7844,'TURNER','SALESMAN',7698,to_date('08-09-1981','dd-mm-yyyy'),1500,0,30);
insert into employee values(7876,'ADAMS','CLERK',7788,to_date('23-05-1987','dd-mm-yyyy'),1100,null,20);
insert into employee values(7900,'JAMES','CLERK',7698,to_date('03-12-1981','dd-mm-yyyy'),950,null,30);
insert into employee values(7902,'FORD','ANALYST',7566,to_date('03-12-1981','dd-mm-yyyy'),3000,null,20);
insert into employee values(7934,'MILLER','CLERK',7782,to_date('23-01-1981','dd-mm-yyyy'),1300,null,10);
--추가
insert into employee values(1000,'MILLER','CLERK',7782,to_date('23-01-1981','dd-mm-yyyy'),1300,null,10);
insert into employee values(2000,'MILLER','CLERK',7782,to_date('23-01-1981','dd-mm-yyyy'),1300,null,null);

insert into salgrade values(1,700,1200);
insert into salgrade values(2,1201,1400);
insert into salgrade values(3,1401,2000);
insert into salgrade values(4,2001,3000);
insert into salgrade values(5,3001,9999);


select * from employee;
select * from department;
select * from salgrade;

-- describe
desc department;

select *from employee;
select eno, ename from employee;
-- 연봉구하기
select ename,salary,salary*12 from employee;
select ename,salary,salary*12 ,salary*12+commission from employee;

-- null+10 =>null, 0+10=>10
select ename,salary,job, dno,nvl(commission,0) Bonus,salary*12, salary*12+nvl(commission,0)"AnnualIncome"
from employee;

select ename || ' is a ' || job from employee;
select ename , ' is a ' , job from employee;

-- Distinct : 중복제거
select dno from employee;
select distinct dno from employee;

-- 직급이 중복되지 않고 한번씩 출력하기
select distinct job from employee;
