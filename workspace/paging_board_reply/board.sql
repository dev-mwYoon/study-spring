create database paging;
use paging;

create table tbl_board(
	board_id int unsigned auto_increment primary key,
	board_title varchar(500),
	board_content varchar(500),
	board_grade_star tinyint default 0,
	board_status char(1) default 0, /*게시중, 블라인드*/
	member_id int unsigned,
	constraint fk_board_member foreign key(member_id)
	references tbl_member(member_id)
);

insert into tbl_board(board_title, board_content, board_grade_star, member_id) 
values('테스트 제목4', '테스트 내용4', 5, 2);

insert into tbl_board(board_title, board_content, board_grade_star, member_id)
(select board_title, board_content, board_grade_star, member_id from tbl_board);

select * from tbl_board
order by board_id desc;

select * from tbl_board
order by board_id desc;
