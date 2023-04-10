create database paging;
use paging;

create table tbl_reply(
	reply_id int unsigned auto_increment primary key,
	reply_content varchar(500) not null,
	board_id int unsigned,
	member_id int unsigned,
	constraint fk_reply_board foreign key(board_id)
	references tbl_board(board_id),
	constraint fk_reply_member foreign key(member_id)
	references tbl_member(member_id)
);

insert into tbl_reply (reply_content, board_id, member_id)
values('렀다갑니다들뽀삐.', 16371, 1);
insert into tbl_reply (reply_content, board_id, member_id)
(select reply_content, board_id, member_id from tbl_reply);