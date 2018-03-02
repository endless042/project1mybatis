create table board(
  num int not null primary key,
  boardid VARCHAR(1) DEFAULT '1',
  writer VARCHAR(10) not null,
  email VARCHAR(30),
  subject VARCHAR(50) not NULL ,
  passwd VARCHAR(12) NOT NULL ,
  reg_date DATE not null,
  readcount int DEFAULT 0,
  ref int NOT NULL ,
  re_step int not NULL ,
  re_level int NOT NULL ,
  content VARCHAR(3000) NOT NULL ,
  ip VARCHAR(20) not NULL ,
  filename VARCHAR(30),
  filesize int


);

create SEQUENCE BoardSer
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE ;


delete from board where num BETWEEN 61 and 77;
select * from board ORDER BY num;

select * from emp;

select rownum, rowid, ENAME from EMP ORDER BY ENAME;

select ROWNUM, a.* from emp a where ROWNUM<3;


select * from (
select rownum rum , b.* from (
select a.* from board a where boardid=1 ORDER BY ref DESC , re_step asc) b)
where rum between 3 and 5;

SELECT *
FROM board
ORDER BY num DESC;

drop table userlist;





create table userlist (

num int not NULL  ,

  ulevel VARCHAR(1) DEFAULT '1',

name VARCHAR(30) not NULL,

id VARCHAR(20) not NULL PRIMARY KEY,

pwd varchar(20) not NULL,

bdate DATE not NULL,

  addr VARCHAR(100),

    tel VARCHAR(25),

    email VARCHAR(50) not NULL

);





ALTER TABLE userlist ADD (ulevel number DEFAULT 1);
alter table userlist modify (bdate varchar(20));
alter table userlist add(cdate DATE default sysdate);

Alter Table userlist Add (point varchar(10) DEFAULT '1000');

drop SEQUENCE userSeq;
create SEQUENCE userSeq
   START WITH 1
  INCREMENT BY 1
  NOMAXVALUE ;

SELECT *FROM userlist ORDER BY num;


insert into userlist VALUES(1,'0','admin','admin','admin','2018-02-08','admin Address','admin Tel','admin Email',sysdate);



delete from userlist where ulevel=0;
commit;

select userSeq.currval from dual;

update userlist set email='admin@email.com' where num=1;

update userlist set pwd='admin' where ulevel=0;

commit;

delete from userlist;


select count(*) from userlist where ulevel like '1';

select * from (select rownum rum , b.* from (
					select a.* from userlist a where id='test1' ORDER BY cdate DESC, ulevel asc ) b)
					where rum between 1 and 24 ORDER BY ulevel asc, cdate DESC;


select * from(select rownum rum, b.* from (select a.* from GUESTBOOK_MESSAGE a) b) where rum between ? and ?;

update userlist set name='aasdg', bdate='2018-02-08', addr='주소수정완료', tel='tel', email='235@sdg', ulevel='2' where id='zs3aefsd' and pwd='sgsdgsd';


Alter table userlist drop COLUMN point;

drop table member;

create table member(

  id varchar(10) primary key,
  name varchar(50) not null,
  password varchar(10) not null,
  regdate date not null
);

select * from member;

select * from GUESTBOOK_MESSAGE;

delete from GUESTBOOK_MESSAGE;

commit;

select * from (" +
					"select rownum rum , b.* from (" +
					"select a.* from userlist a  ORDER BY cdate DESC, ulevel asc where ? = ?) b)" +
					"where rum between ? and ? ORDER BY   num desc";


Create table comments(
  conum Number PRIMARY KEY ,
  id varchar(20) not null,
  cocontent VARCHAR(500) not NULL ,
  codate DATE default SYSDATE not NULL,
  articlenum NUMBER NOT NULL,
  CONSTRAINT comment_con FOREIGN KEY(articlenum)
    REFERENCES board(num) ON DELETE CASCADE
);
Alter Table comments Add (pwd varchar(20) not null);



CREATE SEQUENCE coser
  START WITH 1
  INCREMENT BY 1;
