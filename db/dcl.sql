-- db 생성
create database webdb;

-- user 생성
create user 'webdb'@'localhost' identified by 'webdb';

-- 인증은 받겠지만 권한이 없음. webdb에 접근할 권한이 없음
-- 보안 = 인증(authorization: user id, pw) + 권한(Authentification: 접근)

-- 권한 부여
grant all privileges on webdb.* to 'webdb'@'localhost';