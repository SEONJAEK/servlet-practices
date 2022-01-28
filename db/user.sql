desc user;
-- insert
insert into user values(null, '관리자', 'admin@mysite.com', '1234', 'male', now());

-- select1(login)
select no, name from user where email = 'admin@mysite.com' and password='1234';

-- select2(update profile)회원정보수정
select no, name from user where email = 'admin@mysite.com' and password='1234';

select * from user;

delete from user where gender='female';

-- update
update user set name='', gender='' where no=10;
update user set name='', gender='' , password='' where no=10;

desc board;
select b.no, b.title, b.hit, b.contents, a.name 
  from user a, board b 
 where a.no = b.user_no
order by b.g_no desc, b.o_no asc;