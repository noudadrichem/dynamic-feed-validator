create table account (
 account_id SERIAL PRIMARY KEY not null,
 name varchar(255) not null,
 password varchar(255) not null,
 email_adress varchar(255) not null,
 role varchar(255) not null
);

create table feed (
 feed_id SERIAL not null,
 title varchar(255) not null,
 description varchar(255),
 feed_link varchar(255) not null,
 publication_date Date
);

create table product (
 product_id SERIAL not null,
 hashed varchar(255) not null
);

create table message (
 message_id SERIAL not null,
 title varchar(255) not null,
 description varchar(255),
 email_adress varchar(255) not null,
 product_link_id SERIAL varchar(255) not null,
 publication_date Date not null,
 type varchar(8) not null
);

create table email (
 email_id SERIAL not null,
 email_address varchar(255) not null,
 name varchar(255)
);

-- ALTER TABLE feed ADD COLUMN product_id INT;   
-- ALTER TABLE feed ADD CONSTRAINT feedForeignKey FOREIGN KEY (product_id) REFERENCES product (account_id);

ALTER TABLE feed ADD COLUMN account_id INT;   
ALTER TABLE feed ADD CONSTRAINT feedAccountKey FOREIGN KEY (account_id) REFERENCES account(account_id);

ALTER TABLE message ADD COLUMN feed_id INT;
ALTER TABLE message ADD CONSTRAINT feedIdMessage FOREIGN KEY (feed_id) REFERENCES feed(feed_id);

ALTER TABLE email ADD COLUMN feed_id INT;
ALTER TABLE email ADD CONSTRAINT feedIdEmail FOREIGN KEY (feed_id) REFERENCES feed(feed_id);


-- first account
insert into account(name, password, email_adress, role) values ('noud', 'test1234', 'noud@bannerwise.io', 'admin');