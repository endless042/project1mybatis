
CREATE TABLE aproduct (
state varchar(10) not null,
re	int default 1,
num	int primary KEY ,
origin varchar(30) not null,
title	varchar(100) not null,
name varchar(50) not null,
category varchar(50) not null,
height  varchar(10) not null,
sdate	varchar(50) not null,
edate	varchar(50) not null,
sprice	VARCHAR(10) not null,
eprice	VARCHAR(10), 
rdate	date default sysdate ,
deliv	varchar(10) not null,
count int default 0,
imgs varchar(3000),
imgsize int,
content	varchar(3000) not null,
readcount int DEFAULT 0

);



create SEQUENCE aSer 
   START WITH 1
  INCREMENT BY 1
  NOMAXVALUE ;
  
  create SEQUENCE pSer
   START WITH 1
  INCREMENT BY 1
  NOMAXVALUE ;

drop table aproduct;



create table gproduct(
state varchar(10) not null,
process varchar(10) not null,
re	int default 1,
num	int primary KEY ,
origin varchar(30) not null,
title	varchar(100) not null,
name varchar(50) not null,
category varchar(50) not null,
height  varchar(10) not null,
sdate	varchar(50) not null,
edate	varchar(50) not null,
price	VARCHAR(10) not null,
goal	int not null,
count	int default 0,
rdate	date default sysdate,
deliv	varchar(10) not null,
imgs varchar(3000),
imgsize int,
content	varchar(3000) not null,
readcount int DEFAULT 0
);
commit;
select * from aproduct ;
select * from gproduct;
drop table aproduct;
delete from cart ;

drop table cart;

create table cart(
userid varchar(20),
pronum varchar(10),
rdate date default sysdate

);

select * from cart;
commit;
select * from (select rownum rum ,
b.* from (select a.* from cart a 
where pronum like concat ('a', '%') and userid='admin' ORDER BY rdate desc) b)  
where rum between 1 and 5;


ALTER TABLE orderlist add (count int default 0);

select * from board order by num desc;

select * from userlist;

desc guestbook_message ;

drop table reply;
create table reply(
num int primary key,
userid varchar(20) not null,
rdate date default sysdate,
pronum varchar(10),
content varchar(500),
password varchar(20) not null


);
desc reply;
select * from reply;
create SEQUENCE rSer 
   START WITH 1
  INCREMENT BY 1
  NOMAXVALUE ;
  
create table sample (
ddd timestamp);
delete from gproduct;
select * from gproduct;

select * from ahistory;

delete from ahistory where price='4500';

drop table ahistory;
create table ahistory(
num int not null,
userid varchar(20) not null,
price varchar(20) not null,
adate date default sysdate
);
desc ahistory;

select * from ahistory;
delete from ahistory;

select count(*) from aproduct  where num=23 ;

select * from orderlist;
desc orderlist;
Create table orderlist(
num int primary key,
userid varchar(20),
pronum varchar(10),
rdate date default sysdate,
aprice varchar(10),
payState varchar(10),
count int default 0
);

select * from cart;
delete from cart;

create SEQUENCE oSer 
   START WITH 1
  INCREMENT BY 1
  NOMAXVALUE ;

commit;
delete from cart;
select * from orderlist;
delete from orderlist;
delete from aproduct;
delete from cart where pronum='a1';

delete from orderlist where userid is null;
select * from orderlist;
select * from aproduct;
select * from gproduct;