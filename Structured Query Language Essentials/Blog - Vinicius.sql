-- Vinicius Parzanini
-- Take home project - blog
-- 01/04/2021

-- blog
-- DROP DATABASE IF EXISTS blog;
CREATE DATABASE blog;
USE BLOG;
SHOW TABLES;
-- User table
CREATE TABLE user(
	user_id INT(10) NOT NULL AUTO_INCREMENT,
    user_email VARCHAR(60) UNIQUE NOT NULL,
    user_display_name VARCHAR(60) NOT NULL,
    user_timestamp_created DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT userid_pk PRIMARY KEY(user_id)
    );

-- BLOG table
CREATE TABLE blog(
	blog_id INT(10) NOT NULL,
    blog_url VARCHAR(100) UNIQUE NOT NULL,
	blog_title VARCHAR(100) NOT NULL,
    blog_description VARCHAR(100) NOT NULL,
    blog_template_name VARCHAR(100) UNIQUE NOT NULL,
    user_id int(10) NOT NULL AUTO_INCREMENT,
    CONSTRAINT blogid_pk PRIMARY KEY(blog_id),
    CONSTRAINT userid_pk FOREIGN KEY(user_id) REFERENCES user(user_id)
    );
    
-- TEMPLATE table
CREATE TABLE template(
	template_name VARCHAR(60) UNIQUE,
    template_desc VARCHAR(60),
	template_URL VARCHAR(100) UNIQUE NOT NULL
    );

-- COMMENT table
CREATE TABLE comment(
	comment_id INT(10),
    comment_text VARCHAR(2000) NOT NULL,
	comment_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    user_id INT(10) NOT NULL AUTO_INCREMENT,
    post_id INT(40) NOT NULL,
    CONSTRAINT postid_pk FOREIGN KEY(post_id) REFERENCES post(post_id),
    CONSTRAINT user_id_pk FOREIGN KEY(user_id) REFERENCES user(user_id)
    );
    
-- POST table
CREATE TABLE post(
	post_id INT(40) NOT NULL,
    post_title VARCHAR(60) NOT NULL,
    post_content VARCHAR(255) NOT NULL,
    post_comments_allowed CHAR(1),
    post_timestamp  DATETIME DEFAULT CURRENT_TIMESTAMP,
    blog_id INT(10) NOT NULL,
    CONSTRAINT postid_pk PRIMARY KEY(post_id),
    CONSTRAINT postCommentsAllowed CHECK(post_comments_allowed in('Y','y','n','N')),
	CONSTRAINT blogid_fk FOREIGN KEY(blog_id) REFERENCES blog(blog_id)
    );

-- blog keyword
CREATE TABLE blog_keyword(
	keyword VARCHAR(60),
    blog_id INT(10) NOT NULL,
	CONSTRAINT blogid_fk_kw FOREIGN KEY(blog_id) REFERENCES blog(blog_id)
    );
    
-- post keyword

CREATE TABLE post_keyword(
	keyword VARCHAR(60),
    post_id INT(40) NOT NULL,
	CONSTRAINT postid_pk_kw FOREIGN KEY(post_id) REFERENCES post(post_id)
    );
    
-- Exercise 2
INSERT INTO user VALUES
	('1','joe@gmail.com','Joey',NOW()),
    ('2','peter@gmail.com','Peter',NOW()),
    ('3','pablo@gmail.com','Pablo',NOW()),
    ('4','vicent@gmail.com','Vicent',NOW()),
    ('5','vilmar@gmail.com','Vilmar',NOW()),
    ('6','vanessa@gmail.com','Vanessa',NOW());
   
-- Exercise 3
INSERT INTO template VALUES
	('cool green','','https://templates/coolgreen'),
    ('awesome dog','a dog with nice style','https://templates/awesomedog'),
    ('space','nice template with space view','https://templates/space');
    
-- Exercise 4
INSERT INTO blog VALUES
	('1','https://www.moneyBlog.com','Copy Right law','','Cool Green','1'),
    ('2','https://www.tipstotravel.com','Trips','This is a blog about trips','Awesome Dog','1'),
    ('3','https://www.moonlights.com','Moon','This is a blog about the phases of the moon','Space','1');
    
-- Exercise 5
INSERT INTO blog_keyword VALUES
	('Copyright','1'),
    ('Law','1'),
    ('Intellectual property','1');
    
-- Exercise 6
ALTER TABLE post CHANGE post_content post_content VARCHAR(2000);
INSERT INTO post VALUES
	('1','What is copyright?','Copyright is a legal concept, enacted by most governments, 
    giving the creator of an original work exclusive rights to it, usually for a limited time. Generally, it is "the right to copy", 
    but also gives the copyright holder the right to be credited for the work, to determine who may adapt the work to other forms, who may perform the work, 
    who may financially benefit from it, and other, related rights. It is an intellectual property form (like the patent, the trademark, and thetrade secret) 
    applicable to any expressible form of an idea or information that is substantive and discrete.(Ref: Wikipedia)',
    'Y',NOW(),'1');
    
-- Exercise 7
INSERT INTO post_keyword VALUES
	('Copyright','1'),
    ('Law','1'),
    ('Finance','1');

-- Exercise 8
INSERT INTO post VALUES
	('2','What about going to brazil?','Rio de janeiro! With arms outstretched 28 meters, as if to encompass all of humanity, the colossal Art Deco statue of Christ, 
    called Cristo Redentor (Christ the Redeemer), gazes out over Rio de Janeiro and the bay from the summit of Corcovado.
    The 709-meter height on which it stands is part of the Tijuca National Park, and a rack railway climbs 3.5 kilometers to its top, 
    where a broad plaza surrounds the statue. Completed in 1931, the 30-meter statue was the work of Polish-French sculptor Paul Landowski
    and Brazilian engineer Heitor da Silva Costa, and is constructed of reinforced concrete and soapstone.(Ref: planetware.com)','Y',NOW(),'1');
    
-- Exercise 9
INSERT INTO user VALUES
	('7','Katie@gmail.com','Katie',NOW()),
    ('8','Vinnie@gmail.com','Vinnie',NOW());

-- Creating two more tampletes
INSERT INTO template VALUES
	('Hair','Templates showing hairs','https://templates/hair'),
    ('Passport','Templates showing pictures of different passports','https://templates/Passport');
    
INSERT INTO blog VALUES
	('4','https://www.hairdresser.com','Hair Styles','A blog about different style of hair','Hair','7'),
    ('5','https://www.visa.com','Visa to travel','A blog to help different nationals to get visa to travel','Passport','8');
    
INSERT INTO post VALUES
	('3','Why do not you go for blonde?','Sometimes one colour hair can look flat and boring. Upping your shade a notch or two lighter can really
	enhance high lights and low lights in your hair. And you go a step a further and really have fun with the new blonde tones that are taking
    the fashion and celebrity world by storm. “Consumers are seeing celebrities and models with the new blondes and want to make the change on their own hair,
    ” says Beeson. “The new pearl blonde tones for the fall/winter season (you can get the look from Sassoon’s Constructivist collection) work with many skin tones.
    ” Think lilac, silver and gray-blonde for your next update. (Ref: ellecanada.com)','N',NOW(),'4'),
    ('4','Why is italian passport','An Italian passport is one of the worlds most useful to have, according to an index that ranks
    how many countries each passport allows its holders to visit without applying for a visa in advance.
	Granting visa-free or visa-on-arrival entry to 188 destinations worldwide, Italys passport comes fourth on the 2020 Henley Passport Index,
    putting it on a par with Finland and ahead of any other EU country except Germany.
	Japan comes in top with easy access to 191 other countries, followed by Singapore with 190, then South Korea and Germany with 189.
	Italian nationals gained easy entry to one extra destination in the past year, after Saudi Arabia simplified its visa requirements for several
    countries including Italy. (Ref: thelocal.it)','Y',NOW(),'5');

INSERT INTO blog_keyword VALUES
	('Hair','4'),
    ('Styles','4'),
    ('Visa','5'),
    ('Passport','5');
    
INSERT INTO post_keyword VALUES
	('Blonde','3'),
    ('hair','3'),
    ('Italian','4'),
    ('Passport','4');
    
-- Exercise 10
INSERT INTO comment VALUES
	('1','Really? gonna claim my copyrights right now!!!!!!!',NOW(),'7','1'),
    ('2','Brazil!!! Rio de Janeiro!!! here I go!',NOW(),'6','2'),
    ('2','That country refresh my soul! cannot wait to visit again!',NOW(),'3','2'),
    ('4','WOW, so luck to be Italian!',NOW(),'4','4'),
    ('4','Ciao ragazzi! Iscriviti per ulteriori informazioni, Grazie! a presto.',NOW(),'8','4');
    
-- Exercise 11
ALTER TABLE user ADD first_name VARCHAR(40) NOT NULL, ADD sur_name VARCHAR(40) NOT NULL;

-- Exercise 12
ALTER TABLE post DROP post_timestamp;

-- Exercise 13
ALTER TABLE blog_keyword CHANGE keyword blg_keyword VARCHAR(40);

-- Exercise 14
ALTER TABLE user RENAME TO BlogUser;

-- Exercise 15
ALTER TABLE BlogUser ADD gender CHAR(1);
ALTER TABLE BlogUser ADD CONSTRAINT gend_User CHECK(gender IN('M','m','F','f'));

-- Exercise 16
ALTER TABLE post CHANGE post_content post_content VARCHAR(300);

-- Exercise 17
DELETE FROM blog WHERE blog_id=1;
-- That's not gonna work because to delete parent key with a lot of child we should've created a table with the CASCADE command.