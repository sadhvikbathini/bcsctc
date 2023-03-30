-- database

create database oshp;
use oshp;

-- table

create table student(
	rollno varchar(12),
	no varchar(5),
	admdate varchar(10),
	course varchar(6),
	branch varchar(50),
	yos varchar(9),
	name varchar(50),
	fname varchar(50),
	mname varchar(50),
	dob varchar(10),
	pob varchar(30),
	aadharno varchar(16),
	caste varchar(4),
	subcaste varchar(30),
	income varchar(12),
	rnk varchar(7),
	casteno varchar(5),
	address varchar(300),
	phone1 varchar(13),
	phone2 varchar(13),
	email varchar(50),
	idmarks varchar(200),
	qexam varchar(50),
	regdno varchar(15),
	myop varchar(7),
	marks varchar(6),
	college varchar(50),
	itcdate varchar(20),
	remarks varchar(300),
	tcdate varchar(300) default 'null',
	bcdate varchar(300) default 'null',
	scdate varchar(300) default 'null',
	mcdate varchar(300) default 'null',
	feereim varchar(4),
	gen varchar(7),
	ssc varchar(4),
	inter varchar(4),
	itc varchar(4),
	photos varchar(4),
	PRIMARY KEY (rollno)
);

