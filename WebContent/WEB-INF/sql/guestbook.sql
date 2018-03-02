Create table guestbook_message(
  id int primary key,
  guestName varchar(50) not null,
  password varchar(10) not NULL,
  message VARCHAR(3000) not null

);

select * from guestbook_message;