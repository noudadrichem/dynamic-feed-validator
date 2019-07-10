-- delete script
drop table blueprint;
drop table message;
drop table email;
drop table product;
drop table feed;
drop table account;

create table account (
 account_id SERIAL PRIMARY KEY not null,
 name varchar(255) not null,
 password varchar(255) not null,
 email_adress varchar(255) not null,
 role varchar(255) not null
);

create table feed (
 feed_id varchar(255) PRIMARY KEY not null,
 title varchar(255) not null,
 description varchar(255),
 feed_link varchar(255) not null,
 publication_date varchar(255)
);

create table product (
 product_id SERIAL PRIMARY KEY not null,
 product_id_from_feed varchar(255) not null,
 hashed varchar(255) not null
);

create table message (
 message_id SERIAL PRIMARY KEY not null,
 title varchar(255) not null,
 description varchar(255),
 type varchar(8) not null,
 hashed varchar(255) not null,
 product_id varchar(255) not null
);

create table email (
 email_id SERIAL PRIMARY KEY not null,
 email_address varchar(255) not null,
 name varchar(255)
);

create table blueprint (
  blueprint_id SERIAL PRIMARY KEY not null,
  key varchar(255)
);

alter table product ADD COLUMN feed_id varchar(255);
alter table product ADD CONSTRAINT feedForeignKey FOREIGN KEY (feed_id) REFERENCES feed(feed_id);

alter table feed ADD COLUMN account_id int;   
alter table feed ADD CONSTRAINT feedAccountKey FOREIGN KEY (account_id) REFERENCES account(account_id);

-- this bugs inside the code base because of line by line validation.
-- alter table message ADD COLUMN product_id integer;
-- alter table message ADD CONSTRAINT productIdMessage FOREIGN KEY (product_id) REFERENCES product(product_id);

alter table message ADD COLUMN feed_id varchar(255);
alter table message ADD CONSTRAINT feedIdMessage FOREIGN KEY (feed_id) REFERENCES feed(feed_id);

alter table email ADD COLUMN feed_id varchar(255);
alter table email ADD CONSTRAINT feedIdEmail FOREIGN KEY (feed_id) REFERENCES feed(feed_id);

alter table blueprint ADD COLUMN feed_id varchar(255);
alter table blueprint ADD CONSTRAINT feedIdBlueprint FOREIGN KEY (feed_id) REFERENCES feed(feed_id);


-- first account
insert into account(name, password, email_adress, role) values ('noud', '16d7a4fca7442dda3ad93c9a726597e4', 'noud@bannerwise.io', 'admin');


