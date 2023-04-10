create database paging;
use paging;

create table tbl_member(
	member_id int unsigned auto_increment primary key,
	member_identification varchar(500) unique not null,
	member_password varchar(500) not null,
	member_nickname varchar(500)
);

insert into tbl_member(member_identification, member_password, member_nickname)
values('hcs1234', '1234', '철수');

select * from tbl_member
where member_nickname like concat('%', '철수', '%');