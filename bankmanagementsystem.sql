create database bankmanagementsystem;

show databases;
use bankmanagementsystem;

create table signup(formNumber varchar(20), name varchar(20), fatherName varchar(20), dob varchar(20), gender varchar(20), email varchar(30), address varchar(40), city varchar(25), state varchar(25), postalCode varchar(20)); 

show tables;
select * from signup;

create table signuptwo(formNumber varchar(20), nationality varchar(20), occupation varchar(20), idType varchar(20), idNumber varchar(30), issuingAuthority varchar(20), dateofIssue varchar(20), expiryDate varchar(20), accountType varchar(30), purposeofAccount varchar(30), income varchar(20), seniorCitizen varchar(20));
create table signupthree(formNumber varchar(20), cardNumber varchar(25), pinNumber varchar(10), facility varchar(100));
create table login(formNumber varchar(20), cardNumber varchar(25), pinNumber varchar(10));
select * from signupthree;
select * from login;
select * from bank;

create table bank(pinNumber varchar(10), date varchar(50), type varchar(20), amount varchar(20));
drop table bank;
