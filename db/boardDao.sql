SELECT * FROM webdb.board;

select no, title, contents, hit, g_no, o_no, depth, reg_date, user_no from board;

insert into board values (null, ?, ?, 1,1, 1, 1, now(), ? );

update board set title=?, contents=? where user_no=?;

insert into board values (null, 'TEST', 'TEST글', 1, 1, 1, 1, now(), ? );
select max(g_no)+1 from board;
select max(ifnull(g_no, 0))+1 as g_no from board;
select ifnull(g_no, 0) from board;
select ifnull(max(g_no)+1, 1) as g_no from board;
insert into board values (null, 'TEST', 'TEST글', 1, ifnull((select max(g_no)+1 from board as b) ,1), 1, 1, now(), 7 );
select ifnull(max(g_no)+1, 1) as g_no from board;

insert into board values (null, ?, ?, 1, 1, 1, 1, now(), ? );

