SELECT * FROM webdb.guestbook;
ALTER TABLE guestbook AUTO_INCREMENT = 2;
SET @CNT = 0;
UPDATE GUESTBOOK SET GUESTBOOK.NO = @CNT:=@CNT+1;