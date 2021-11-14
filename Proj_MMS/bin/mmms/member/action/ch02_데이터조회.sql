-- 데이터 조회
select * from tab; --table


-- 문자열 데이터 조회
-- 문자열, 날짜 : 작은따옴표 사용, 대소문자 구분
select eno,ename,salary from employee where ename='ford'; --x
select eno,ename,salary from employee where ename='FORD';
select eno,ename,salary from employee where ename="FORD"; --x
select * from employee where hiredate <= '1982/01/01';

-- 논리연산자(AND, OR, NOT)
-- 2000~3000 급여 받는 자 정보 출력
select *
from employee
where salary >= 2000 and salary <= 3000;

select *
from employee
where salary BETWEEN 2000 and 3000;

-- in: 특정값이 하나라도 일치하면 참
select * from employee where commission in(300,500,1400);

-- commission이 300,500,1400 아닌 자 검색
select * from employee where commission not in(300,500,1400);
select * from employee where commission <> 300 and commission <> 500 and commission <> 1400;
-- Like(%,_)
--%: 여러문자들 포함, _ : 하나의 문자만을 포함
select * from employee where ename = 'F';
select * from employee where ename LIKE'F%';
select * from employee where ename LIKE'%A%';
select * from employee where ename not LIKE'%A%';
select * from employee where ename LIKE'_A%';

-- null : 0도 아니고 공백도 아닌 알 수 없는 어떤 값 unknown
-- 연산, 할당, 비교 불가
select * from employee where commission = null; --x
select * from employee where commission is null; --x
select * from employee where commission is not null; --x
select * from employee where commission <> null; --x


-- order by
-- ascending (오름차순, null은 가장 나중), descending (내림차순)
select * from employee order by commission asc;
select * from employee order by commission desc;
select * from employee order by commission desc, eno asc;

-- 상사 없는 자 검색


-- 2000이하 or 3000이상 급여 받는 자
select *
from employee
where salary <= 2000 or salary >= 3000;

