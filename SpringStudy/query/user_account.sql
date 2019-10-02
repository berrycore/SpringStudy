CREATE TABLE USER_ACCOUNT(
	user_id 	varchar2(50),
	user_name 	varchar2(50),
	password 	varchar2(50),
	email 		varchar2(50),
	job 		varchar2(50),
	gender 		varchar2(50)
);

INSERT INTO USER_ACCOUNT (user_id, user_name, password, email, job, gender) values(
	'manager','manager', 'manager12#','manager@localhost', 'manager', 'M'
);

commit;