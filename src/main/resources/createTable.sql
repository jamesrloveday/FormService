/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  James Loveday
 * Created: 26-Jun-2016
 */

drop table IMAGE; 

create table IMAGE
(
	ID INTEGER not null primary key,
	FILE_LOCATION VARCHAR(200),
	FORM VARCHAR(50),
	SECTION_NAME VARCHAR(50),
	TITLE VARCHAR(100)
)

INSERT INTO IMAGE (ID, FILE_LOCATION, FORM, SECTION_NAME, TITLE) 
	VALUES (1, 'C:\Users\james\Documents\java projects\Wing-Chun-Web-App-JSP\src\main\webapp\resources\images\siuNimTao\basic stance.jpg', 'siu nim tao', 'section 1', 'basic stance');
INSERT INTO IMAGE (ID, FILE_LOCATION, FORM, SECTION_NAME, TITLE) 
	VALUES (2, 'C:\Users\james\Documents\java projects\Wing-Chun-Web-App-JSP\src\main\webapp\resources\images\siuNimTao\jic kuen.png', 'siu nim tao', 'section 1', 'jic kuen');
INSERT INTO IMAGE (ID, FILE_LOCATION, FORM, SECTION_NAME, TITLE) 
	VALUES (3, 'C:\Users\james\Documents\java projects\Wing-Chun-Web-App-JSP\src\main\webapp\resources\images\siuNimTao\jic kuen 1.png', 'siu nim tao', 'section 1', 'jic kuen');


