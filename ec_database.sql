\c postgres
-- DROPは同じファイル名があったときの上書き削除
DROP DATABASE IF EXISTS ec_sample;
DROP ROLE IF EXISTS student;
-- ROLEは権限　
CREATE ROLE student WITH PASSWORD 'himitu' LOGIN;
-- データべ巣の作成
CREATE DATABASE ec_sample OWNER student ENCODING 'UTF8';
