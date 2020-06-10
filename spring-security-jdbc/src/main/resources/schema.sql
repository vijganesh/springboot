create table users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(50) not null,
	enabled boolean not null
	);

create table authorities(
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_user foreign key(username) reference users(username)
	);
	
create unique index ix_auth_username on authorities (username,authority);