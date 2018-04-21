/*All User's gets stored in APP_USER table*/
create table APP_USER (
   id BIGINT NOT NULL AUTO_INCREMENT,
   username VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   email VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (username)
);
   
/* ROLE_PROFILE table contains all possible roles */ 
create table ROLE_PROFILE(
   id BIGINT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
   
/* JOIN TABLE for MANY-TO-MANY relationship*/  
CREATE TABLE APP_USER_ROLE_PROFILE (
    user_id BIGINT NOT NULL,
    role_profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_profile_id),
    CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES APP_USER (id),
    CONSTRAINT FK_ROLE_PROFILE FOREIGN KEY (role_profile_id) REFERENCES ROLE_PROFILE (id)
);

/* TUTOR_APPLICATION tables contains elements for the tutor application form */
CREATE TABLE TUTOR_APPLICATION (
   id BIGINT NOT NULL AUTO_INCREMENT,
   username VARCHAR(30) NOT NULL,
   question1 VARCHAR(100) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (username, id)
);
  
/* Populate USER_PROFILE Table */
INSERT INTO ROLE_PROFILE(type)
VALUES ('ADMIN');

INSERT INTO ROLE_PROFILE(type)
VALUES ('TUTOR');

INSERT INTO ROLE_PROFILE(type)
VALUES ('STUDENT'); 
 
/* Create persistent_logins Table used to store remember.me related stuff*/
CREATE TABLE persistent_logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);

/*THIS IS WHERE CAT HAS DONE STUFF */

CREATE TABLE TUTOR (
	id BIGINT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(64) NOT NULL,
	last_name VARCHAR(64) NOT NULL,
	subject VARCHAR(64) NOT NULL,
	bio VARCHAR(64) NOT NULL,
	user_name VARCHAR(64) NOT NULL,
	email VARCHAR(64) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id, username)
	
	

);

CREATE TABLE APPOINTMENT(
	


);


