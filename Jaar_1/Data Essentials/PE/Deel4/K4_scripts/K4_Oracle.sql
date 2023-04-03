REM ============================INHOUD================================================================
REM ====================CREEEREN VAN TABELLEN 1-12====================================================
REM ====================INSERT VALUES INTO ALLE TABELLEN==============================================
REM ====================INDIEN BELANGRIJK, TOEGEVOEGDE COMMENTAREN OVER EVT. KEUZES===================
REM===================================================================================================

REM================PART1============================================================================== 
REM====================================BELANGRIJKE KOMMENTAREN======================================== 
REM===================================================================================================   

REM   Series:  Series age min/max word als NUMBER behandelt, we gaan ervan uit dat alles clubs allen 
REM   cijfers ingeven.
REM
REM   Cities: We gaan ervan uit dat alle cities met eerste letter uppercase beginnen, 
REM   en dat alle postcodes in de database niet met een 0 beginnen.  
REM
REM   Clubs: Datatype voor club_id is char, omdat een club_id misschien met 0 zou kunnen beginnen.
REM
REM   Members: We gaan ervan uit dat niet elke member een ranking heeft, daarom geen NOT NULL constraint 
REM   voor de rankings_single en dubbel. Datatype Varchar voor sex laat meer dan 5 chars toe (‘Vrouw’) 
REM   voor mensen, die misschien iets non-binairs. Ook is er de optie niks in te vullen, als mensen dat 
REM   prettiger zouden vinden. Weerspiegelt 'modernere' invulformulieren.
REM
REM   Tournaments: Tournament_id is fictief, dus de hoeveelheid aan chars gaat tot max 30 in ons geval.
REM   Varchar 50 voor payment online, indien een club bepaalde text invoegd, bijv. ‘geen online betaling mogelijk’ 
REM   of dergelijke.
REM
REM   Bij date_starthour van de tabel reservations word de tijd alleen getoond bij de reservatie indie die sessie
REM   gealtered word met: "alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';"
REM
REM   Bij alle PK's, en samengestelde PK's, is NOT NULL weggelaten, omdat wij ervan uitgaan dat SQL plus automatisch
REM   geen NULL accepteerd. Bij MYSQL en SQL server is dat zo, hopelijk hier ook.


REM==============PART2================================================================================
REM====================================CREEEREN VAN TABELLEN==========================================
REM===================================================================================================

DROP TABLE series 			CASCADE CONSTRAINTS; 
DROP TABLE cities 			CASCADE CONSTRAINTS; 
DROP TABLE clubs  			CASCADE CONSTRAINTS; 
DROP TABLE members			CASCADE CONSTRAINTS; 
DROP TABLE tournaments			CASCADE CONSTRAINTS; 
DROP TABLE tournament_series		CASCADE CONSTRAINTS; 
DROP TABLE club_programoffers		CASCADE CONSTRAINTS; 
DROP TABLE club_qualitylabels		CASCADE CONSTRAINTS; 
DROP TABLE club_trainings		CASCADE CONSTRAINTS; 
DROP TABLE club_subscriptiontypes	CASCADE CONSTRAINTS; 
DROP TABLE reservations			CASCADE CONSTRAINTS;  
DROP TABLE club_rates			CASCADE CONSTRAINTS; 


REM ============== 
REM TABEL1: SERIES	 
REM ==============


CREATE TABLE series (  
  series		VARCHAR2(25)	CONSTRAINT series_series_pk PRIMARY KEY  
					CONSTRAINT series_series_ck CHECK (series = UPPER(series)) 
, age_min	 	NUMBER(2) 	CONSTRAINT series_age_min_nn NOT NULL  
					CONSTRAINT series_agemin_ck CHECK (age_min > 0) 
, age_max 		NUMBER(3)	CONSTRAINT series_agemax_nn NOT NULL
					CONSTRAINT series_agemax_ck CHECK (age_max > 0)
); 



REM ============== 
REM TABEL2: CITIES 
REM ==============


CREATE TABLE cities ( 
  zipcode		NUMBER(4) 	CONSTRAINT cities_zipcode_pk PRIMARY KEY 
					CONSTRAINT cities_zipcode_ck CHECK (zipcode >= 1000 AND zipcode <=9992)
, city			VARCHAR2(30) 	CONSTRAINT cities_city_nn NOT NULL 
);
 


REM =============  
REM TABEL3: CLUBS 
REM =============  


CREATE TABLE clubs (  
  club_id		CHAR(4) 	CONSTRAINT club_club_id_pk PRIMARY KEY 
, clubname		VARCHAR2(30) 	CONSTRAINT clubs_club_name_nn NOT NULL
					CONSTRAINT clubs_club_name_ck CHECK (clubname = UPPER(clubname))   
, street		VARCHAR2(30)	CONSTRAINT club_street_nn NOT NULL 
, housenumber     	VARCHAR2(10)	CONSTRAINT club_housenumber_nn NOT NULL 
, zipcode		NUMBER(4)	CONSTRAINT club_zipcode_fk   
					REFERENCES cities(zipcode) 
, region		VARCHAR2(30)	CONSTRAINT club_region_nn NOT NULL	 
, telephone		VARCHAR2(20)	CONSTRAINT club_telephone_nn NOT NULL	 
					CONSTRAINT club_telephone_ck UNIQUE 
, email			VARCHAR2(30)	CONSTRAINT club_email_nn NOT NULL	 
					CONSTRAINT club_email_ck UNIQUE 
, website		VARCHAR2(100)	 
, facebook		VARCHAR2(100)	 
); 



REM =============== 
REM TABEL4: MEMBERS 
REM =============== 


CREATE TABLE members (  
  member_id		CHAR(7)  	CONSTRAINT members_member_id_pk PRIMARY KEY  
, firstname		VARCHAR2(25) 	CONSTRAINT members_firstname_nn NOT NULL
  					CONSTRAINT members_fname_ck CHECK (firstname = INITCAP(firstname))
, lastname		VARCHAR2(25) 	CONSTRAINT members_lastname_nn NOT NULL 
, club_id		CHAR(4) 	CONSTRAINT members_club_id_fk 
					REFERENCES clubs(club_id)
, password		VARCHAR2(30)	CONSTRAINT members_password_nn NOT NULL 
, ranking_single	VARCHAR2(30)	 
, ranking_double	VARCHAR2(30) 
, sex			VARCHAR2(20)	
, birthday		DATE		CONSTRAINT members_birthday_nn NOT NULL
, nationality		VARCHAR2(25)	CONSTRAINT members_nation_nn NOT NULL 
); 



REM =================== 
REM TABEL5: TOURNAMENTS 
REM =================== 


CREATE TABLE tournaments (   
  tournament_id		VARCHAR2(30) 	CONSTRAINT tournaments_tourn_id_pk PRIMARY KEY   
, tournament		VARCHAR2(25) 	CONSTRAINT tournaments_tourn_nn NOT NULL   
, startdate		DATE 		CONSTRAINT tournaments_startdate_nn NOT NULL  
, enddate		DATE 		CONSTRAINT tournaments_enddate_nn NOT NULL 
, club_id		CHAR(4) 	CONSTRAINT tourn_club_id_fk  
					REFERENCES clubs(club_id) 
, indoor_outdoor        VARCHAR2(25)	CONSTRAINT tourn_indout_nn NOT NULL 
, organiser_id		CHAR(7) 	CONSTRAINT tourn_org_id_fk 
					REFERENCES members(member_id) 
, payment_online	VARCHAR2(50)	CONSTRAINT tourn_payment_nn NOT NULL
); 



REM ========================= 
REM TABEL6: TOURNAMENT_SERIES	  
REM ========================= 


CREATE TABLE tournament_series (  
  tournament_id		VARCHAR2(30)	CONSTRAINT tourn_serie_tornid_fk  
					REFERENCES tournaments(tournament_id) 
, series		VARCHAR2(25) 	CONSTRAINT tourn_serie_serie_fk  
					REFERENCES series(series) 
, ranking_min		NUMBER(2) 	DEFAULT 3
					CONSTRAINT tournser_rankmin_ck CHECK (ranking_min >= 3)
					CONSTRAINT tournser_rankmin_nn NOT NULL 
, ranking_max		NUMBER(3) 	CONSTRAINT tournser_rankmax_ck CHECK (ranking_max >= 3)
					CONSTRAINT tournser_rankmax_nn NOT NULL 
, circuit		VARCHAR2(20) 
, CONSTRAINT tourn_serie_pk PRIMARY KEY(tournament_id, series) 
); 



REM =========================== 
REM TABEL7: CLUB_PROGRAMOFFERS	   
REM =========================== 


CREATE TABLE club_programoffers (   
  club_id		CHAR(4)		CONSTRAINT clubprogoff_clubid_fk   
					REFERENCES clubs(club_id)  
, programoffers		VARCHAR2(30) 
, CONSTRAINT clubprogoff_pk PRIMARY KEY(club_id, programoffers)  
);


REM =========================== 
REM TABEL8: CLUB_QUALITYLABELS	   
REM =========================== 
 

CREATE TABLE club_qualitylabels (   
  club_id		CHAR(4)		CONSTRAINT clubquality_clubid_fk   
					REFERENCES clubs(club_id)  
, quality_label		VARCHAR2(30) 
, CONSTRAINT clubquality_label_pk PRIMARY KEY(club_id, quality_label)  
);


 
REM ====================== 
REM TABEL9: CLUB_TRAININGS	    
REM ====================== 
 

CREATE TABLE club_trainings (    
  club_id		CHAR(4)		CONSTRAINT clubtrain_clubid_fk    
					REFERENCES clubs(club_id)   
, training		VARCHAR2(20)  	
, startdate		DATE		CONSTRAINT clubtrain_startdat_nn NOT NULL
, status		VARCHAR2(25) 	CONSTRAINT clubtrain_status_nn NOT NULL
, CONSTRAINT club_trainings_pk PRIMARY KEY(club_id, training)   
); 



REM ===============================
REM TABEL10: CLUB_SUBSCRIPTIONTYPES	     
REM ===============================
    

CREATE TABLE club_subscriptiontypes (     
  club_id		CHAR(4)		CONSTRAINT clubsubtype_clubid_fk     
					REFERENCES clubs(club_id)    
, subscriptiontype	VARCHAR2(20)  	
, age_min	 	NUMBER(2) 	CONSTRAINT club_subtype_agemin_nn NOT NULL
					CONSTRAINT club_subtype_agemin_ck CHECK (age_min >= 3 AND age_min < 20)	 
, age_max 		NUMBER(3)      	CONSTRAINT club_subtype_agemax_nn NOT NULL
					CONSTRAINT club_subtype_agemax_ck CHECK (age_max >= 12 AND age_max < 100)	 	
, description 		VARCHAR2(100)	CONSTRAINT clubsubtype_desc_nn NOT NULL
, CONSTRAINT clubs_sub_type_pk PRIMARY KEY(club_id, subscriptiontype)    
);



REM ===================== 
REM TABEL11: RESERVATIONS	      
REM ===================== 
    

CREATE TABLE reservations (      
  member_id			CHAR(7)   	CONSTRAINT reservations_membid_fk  
						REFERENCES members(member_id)     
, reservation_date_starthour	DATE	  	
, terrain	 		NUMBER(3) 	CONSTRAINT reservations_terrain_nn NOT NULL   
, opponent_id			CHAR(7)  	CONSTRAINT reservations_oppid_fk 
						REFERENCES members(member_id)	 
, CONSTRAINT reservations_pk PRIMARY KEY(member_id, reservation_date_starthour)     
);  


 
REM =================== 
REM TABEL12: CLUB_RATES	       
REM ===================  
      

CREATE TABLE club_rates (        
  club_id			CHAR(4)		   
, sport				VARCHAR2(10)	CONSTRAINT clubrates_sport_ck CHECK (sport = INITCAP(sport)) 
, subscriptiontype		VARCHAR2(20) 	
, subscription_startdate	DATE		
, subscriptionrate_existing	NUMBER(3)	CONSTRAINT clubrates_subrate_exist_nn NOT NULL
						CONSTRAINT clubrates_subrate_exist_ck CHECK (subscriptionrate_existing >= 0) 
, subscriptionrate_new		NUMBER(3)	CONSTRAINT clubrate_subrate_new_nn NOT NULL  
						CONSTRAINT clubrates_subrate_new_ck CHECK (subscriptionrate_new >= 0) 
, subscription_enddate		DATE		CONSTRAINT club_rates_subend_nn NOT NULL 
, registration_startdate	DATE		CONSTRAINT club_rates_regstart_nn NOT NULL 
, registration_enddate		DATE		CONSTRAINT club_rates_regend_nn NOT NULL 
, CONSTRAINT club_rates_fk FOREIGN KEY(club_id, subscriptiontype)  
  REFERENCES   club_subscriptiontypes(club_id, subscriptiontype)
, CONSTRAINT club_rates_pk PRIMARY KEY(club_id, sport, subscriptiontype, subscription_startdate)  
);


 

REM================PART3============================================================================== 
REM====================================INSERT VALUES INTO TABLES====================================== 
REM===================================================================================================   

DELETE FROM series;
DELETE FROM cities;
DELETE FROM clubs;
DELETE FROM members;
DELETE FROM tournaments;
DELETE FROM tournament_series;
DELETE FROM club_programoffers;
DELETE FROM club_qualitylabels;
DELETE FROM club_trainings;
DELETE FROM club_subscriptiontypes;
DELETE FROM reservations;
DELETE FROM club_rates; 

REM=====SERIES=====

INSERT INTO series(series, age_min, age_max)
VALUES ('ENKEL HEREN 1', 11, 99);
INSERT INTO series(series, age_min, age_max)
VALUES ('ENKEL HEREN 2', 11, 99);
INSERT INTO series(series, age_min, age_max)
VALUES ('ENKEL HEREN 3', 11, 99);
INSERT INTO series(series, age_min, age_max)
VALUES ('ENKEL HEREN 35 1', 35, 99);


REM=====CITIES============================================


INSERT INTO cities(zipcode, city)
VALUES (3500, 'Hasselt');
INSERT INTO cities(zipcode, city)
VALUES (3290, 'Diest');
INSERT INTO cities(zipcode, city)
VALUES (8210, 'Zedelgem');
INSERT INTO cities(zipcode, city)
VALUES (3570, 'Alken');


REM=====CLUBS=============================================


INSERT INTO clubs(club_id, clubname, street, 
		  housenumber, zipcode, region, telephone, email, website, facebook)
VALUES 		 (2876, 'TENNISCLUB SPORTIEF', 'Gouverneur Verwilghensingel', '102', 3500, 'Limburg', '0467529397',
		 'tennissportief@gmail.com', 'www.tennissportief.be', 'www.facebook.com/tennissportief');

INSERT INTO clubs(club_id, clubname, street, 
		  housenumber, zipcode, region, telephone, email, website, facebook)
VALUES 		 (5003, 'K.T.C. DIEST', 'Omer Vanaudenhovelaan', 'z/n', 3290, 'Limburg', '+32 13 33 37 03',
		 'ktcdiest@gmail.com', 'www.ktcdiest.be', 'www.facebook.com/ktcdiest');

INSERT INTO clubs(club_id, clubname, street, 
		  housenumber, zipcode, region, telephone, email, website, facebook)
VALUES 		 (2086, 'T.C. ZEDELGEM', 'Stadionlaan', '48', 8210, 'West-Vlaanderen', '+32 50 20 19 19',
		 'info@tczedelgem.be', 'https://www.tczedelgem.be', 'https://www.facebook.com/tczedelgem');

INSERT INTO clubs(club_id, clubname, street, 
		  housenumber, zipcode, region, telephone, email, website, facebook)
VALUES 		 (9816, 'TENNISCLUB OUDHAVEN', 'Oude Baan', '44-62', 3570, 'Limburg', '04663520983',
		 'tcoudhaven@gmail.com', 'www.tcoudhaven.be', 'www.facebook.com/tcoudhaven');


REM=====MEMBERS============================================

INSERT INTO members(member_id, firstname, lastname, club_id, password, ranking_single, 
		    ranking_double, sex, birthday, nationality)
VALUES (2565576, 'Josefine', 'Zolder', 2876, '*******', 'Tennis volwassenen enkel 43', 
	NULL, 'Vrouw', TO_DATE('16/04/1999', 'DD/MM/YYYY'), 'Belgie');

INSERT INTO members(member_id, firstname, lastname, club_id, password, ranking_single, 
		    ranking_double, sex, birthday, nationality)
VALUES (1274653, 'Jan', 'Smits', 2876, '*********', 'Tennis volwassenen enkel 24', 'Tennis volwassenen dubbel 76',
	'Man', TO_DATE('04/07/1993', 'DD/MM/YYYY'), 'Belgie');

INSERT INTO members(member_id, firstname, lastname, club_id, password, ranking_single, 
		    ranking_double, sex, birthday, nationality)
VALUES (9834322, 'Amanda', 'Heerlen', 5003, '*****', 'Tennis volwassenen enkel 20', 'Tennis volwassenen dubbel 33',
	'Vrouw', TO_DATE('09/01/1992', 'DD/MM/YYYY'), 'Belgie');

INSERT INTO members(member_id, firstname, lastname, club_id, password, ranking_single, 
		    ranking_double, sex, birthday, nationality)
VALUES (8362111, 'Mathias', 'Zeeman', 5003, '******', 'Tennis volwassenen enkel 18', 'Tennis volwassenen dubbel 37',
	'Man', TO_DATE('19/06/1973', 'DD/MM/YYYY'), 'Nederland');

INSERT INTO members(member_id, firstname, lastname, club_id, password, ranking_single, 
		    ranking_double, sex, birthday, nationality)
VALUES (8923873, 'Andrea', 'Smeekes', 2086, '*******', 'Tennis volwassenen enkel 2', NULL,
	NULL, TO_DATE('09/03/1991', 'DD/MM/YYYY'), 'Belgie');

INSERT INTO members(member_id, firstname, lastname, club_id, password, ranking_single, 
		    ranking_double, sex, birthday, nationality)
VALUES (3743567, 'Julia', 'Kloeckner', 2086, '**********', 'Tennis volwassenen enkel 5', 'Tennis volwassenen dubbel 100',
	'Vrouw', TO_DATE('25/05/1962', 'DD/MM/YYYY'), 'Duitsland');

INSERT INTO members(member_id, firstname, lastname, club_id, password, ranking_single, 
		    ranking_double, sex, birthday, nationality)
VALUES (9394894, 'Maxime', 'Smijts', 2086, '*********', NULL, 'Tennis volwassen dubbel 15', 
	'Vrouw', TO_DATE('17/03/1996', 'DD/MM/YYYY'), 'Belgie');

INSERT INTO members(member_id, firstname, lastname, club_id, password, ranking_single, 
		    ranking_double, sex, birthday, nationality)
VALUES (9263784, 'Arthur', 'Arjan', 5003, '***********', 'Tennis volwassenen enkel 31', 
	'Tennis volwassen dubbel 11', 'Man', TO_DATE('20/01/1994', 'DD/MM/YYYY'), 'Belgie');


REM=====TOURNAMENTS===============================================

INSERT INTO tournaments(tournament_id, tournament, startdate, enddate, club_id, indoor_outdoor, 
		    organiser_id, payment_online)
VALUES (98346239, 'Summer Breeze', TO_DATE('11/05/2021', 'DD/MM/YYYY'), TO_DATE('19/05/2021', 'DD/MM/YYYY'), 2086, 'Outdoor', 
	3743567, 'Geen online betaalmogelijkheden');

INSERT INTO tournaments(tournament_id, tournament, startdate, enddate, club_id, indoor_outdoor, 
		    organiser_id, payment_online)
VALUES (98263654, 'Winter Solstice', TO_DATE('12/12/2021', 'DD/MM/YYYY'), TO_DATE('14/12/2021', 'DD/MM/YYYY'), 5003, 'Indoor', 
	8923873, 'Ja');

INSERT INTO tournaments(tournament_id, tournament, startdate, enddate, club_id, indoor_outdoor, 
		    organiser_id, payment_online)
VALUES (9823946, 'Fun Fair Tennis Jam', TO_DATE('02/09/2020', 'DD/MM/YYYY'), TO_DATE('17/10/2020', 'DD/MM/YYYY'), 2876, 'Indoor/Outdoor', 
	8362111, 'Alleen maar contactloos ter plekke');


REM=====TOURNAMENT_SERIES=========================================

INSERT INTO tournament_series(tournament_id, series, ranking_max, circuit)
VALUES (98346239, 'ENKEL HEREN 1', 115, 'Semi-finals');

INSERT INTO tournament_series(tournament_id, series, ranking_max, circuit)
VALUES (98263654, 'ENKEL HEREN 2', 45, 'Quarter-finals');

INSERT INTO tournament_series(tournament_id, series, ranking_max, circuit)
VALUES (9823946, 'ENKEL HEREN 3', 10, 'Finals');

INSERT INTO tournament_series(tournament_id, series, ranking_max, circuit)
VALUES (98346239, 'ENKEL HEREN 35 1', 95, 'Semi-finals');


REM=====CLUB_PROGRAMOFFERS========================================


INSERT INTO club_programoffers(club_id, programoffers)
VALUES (5003, 'Jeugdtop');
INSERT INTO club_programoffers(club_id, programoffers)
VALUES (2876, 'Top100');
INSERT INTO club_programoffers(club_id, programoffers)
VALUES (2086, 'SnellJelle');
INSERT INTO club_programoffers(club_id, programoffers)
VALUES (5003, 'Womens-Night');



REM=====CLUB_QUALITYLABELS========================================

INSERT INTO club_qualitylabels(club_id, quality_label)
VALUES (5003, 'Klant100');
INSERT INTO club_qualitylabels(club_id, quality_label)
VALUES (2876, 'BesteHoreca');
INSERT INTO club_qualitylabels(club_id, quality_label)
VALUES (9816, 'Jeugdvriendlelijk');
INSERT INTO club_qualitylabels(club_id, quality_label)
VALUES (5003, 'Jeugdtop');


REM=====CLUB_TRAININGS========================================


INSERT INTO club_trainings(club_id, training, startdate, status)
VALUES (5003, 'Lentelessen', TO_DATE('19/04/2021', 'DD/MM/YYYY'), 'Inschrijvingen afgesloten');

INSERT INTO club_trainings(club_id, training, startdate, status)
VALUES (2876, 'Zomerstage 1', TO_DATE('05/05/2021', 'DD/MM/YYYY'), 'Inschrijvingen volzet');

INSERT INTO club_trainings(club_id, training, startdate, status)
VALUES (2086, 'Zomerstage 2', TO_DATE('02/08/2021', 'DD/MM/YYYY'), 'Inschrijven mogelijk');

INSERT INTO club_trainings(club_id, training, startdate, status)
VALUES (5003, 'Zomerstage 3', TO_DATE('23/08/2021', 'DD/MM/YYYY'), 'Inschrijven mogelijk');


REM=====CLUB_SUBSCRIPTIONTYPES========================================

INSERT INTO club_subscriptiontypes(club_id, subscriptiontype, age_min, age_max, description)
VALUES (5003, 'MINI', 3, 12, 'kinderen');

INSERT INTO club_subscriptiontypes(club_id, subscriptiontype, age_min, age_max, description)
VALUES (5003, 'VOLWASSENEN', 19, 99, 'volwassenen');

INSERT INTO club_subscriptiontypes(club_id, subscriptiontype, age_min, age_max, description)
VALUES (2086, 'MINI', 3, 12, 'kinderen');

INSERT INTO club_subscriptiontypes(club_id, subscriptiontype, age_min, age_max, description)
VALUES (2086, 'JUNIOR', 13, 19, 'jeugd');


REM=====CLUB_RESERVATIONS========================================


INSERT INTO reservations(member_id, reservation_date_starthour, terrain, opponent_id)
VALUES (3743567, TO_DATE('17/12/2020 17:30','DD/MM/YYYY HH24:MI'), 3, 9263784);

INSERT INTO reservations(member_id, reservation_date_starthour, terrain, opponent_id)
VALUES (2565576, TO_DATE('11/08/2020 18:30','DD/MM/YYYY HH24:MI'), 8, 9394894);

INSERT INTO reservations(member_id, reservation_date_starthour, terrain, opponent_id)
VALUES (8923873, TO_DATE('10/08/2020 14:30','DD/MM/YYYY HH24:MI'), 1, 9834322);

INSERT INTO reservations(member_id, reservation_date_starthour, terrain, opponent_id)
VALUES (1274653, TO_DATE('09/08/2020 15:00','DD/MM/YYYY HH24:MI'), 8, 8362111);

INSERT INTO reservations(member_id, reservation_date_starthour, terrain, opponent_id)
VALUES (8362111, TO_DATE('18/08/2020 11:30','DD/MM/YYYY HH24:MI'), 0, 1274653);

INSERT INTO reservations(member_id, reservation_date_starthour, terrain, opponent_id)
VALUES (9834322, TO_DATE('19/08/2020 17:00','DD/MM/YYYY HH24:MI'), 8, 8923873);

INSERT INTO reservations(member_id, reservation_date_starthour, terrain, opponent_id)
VALUES (9394894, TO_DATE('20/08/2020 09:30','DD/MM/YYYY HH24:MI'), 2, 2565576);

INSERT INTO reservations(member_id, reservation_date_starthour, terrain, opponent_id)
VALUES (9263784, TO_DATE('01/12/2020 10:30','DD/MM/YYYY HH24:MI'), 1, 3743567);


REM=====CLUB_RATES========================================


INSERT INTO club_rates(club_id, sport, subscriptiontype, subscription_startdate, subscriptionrate_existing,
			     subscriptionrate_new, subscription_enddate, registration_startdate, registration_enddate)
VALUES (5003, 'Tennis', 'MINI', TO_DATE('11/05/2021', 'DD/MM/YYYY'), 25, 65, TO_DATE('31/12/2020', 'DD/MM/YYYY'),
	 TO_DATE('31/12/2021', 'DD/MM/YYYY'), TO_DATE('11/04/2021', 'DD/MM/YYYY'));

INSERT INTO club_rates(club_id, sport, subscriptiontype, subscription_startdate, subscriptionrate_existing,
			     subscriptionrate_new, subscription_enddate, registration_startdate, registration_enddate)
VALUES (5003, 'Padel', 'VOLWASSENEN', TO_DATE('12/06/2021', 'DD/MM/YYYY'), 15, 75, TO_DATE('31/12/2020', 'DD/MM/YYYY'),
	 TO_DATE('31/12/2021', 'DD/MM/YYYY'), TO_DATE('11/04/2021', 'DD/MM/YYYY'));

INSERT INTO club_rates(club_id, sport, subscriptiontype, subscription_startdate, subscriptionrate_existing,
			     subscriptionrate_new, subscription_enddate, registration_startdate, registration_enddate)
VALUES (5003, 'Tennis', 'VOLWASSENEN', TO_DATE('13/05/2021', 'DD/MM/YYYY'), 35, 65, TO_DATE('31/12/2020', 'DD/MM/YYYY'),
	 TO_DATE('31/12/2021', 'DD/MM/YYYY'), TO_DATE('11/04/2021', 'DD/MM/YYYY'));

INSERT INTO club_rates(club_id, sport, subscriptiontype, subscription_startdate, subscriptionrate_existing,
			     subscriptionrate_new, subscription_enddate, registration_startdate, registration_enddate)
VALUES (5003, 'Padel', 'MINI', TO_DATE('14/06/2021', 'DD/MM/YYYY'), 20, 85, TO_DATE('31/12/2020', 'DD/MM/YYYY'),
	 TO_DATE('31/12/2021', 'DD/MM/YYYY'), TO_DATE('11/05/2021', 'DD/MM/YYYY'));

INSERT INTO club_rates(club_id, sport, subscriptiontype, subscription_startdate, subscriptionrate_existing,
			     subscriptionrate_new, subscription_enddate, registration_startdate, registration_enddate)
VALUES (2086, 'Tennis', 'MINI', TO_DATE('15/05/2020', 'DD/MM/YYYY'), 25, 65, TO_DATE('31/12/2020', 'DD/MM/YYYY'),
	 TO_DATE('31/12/2021', 'DD/MM/YYYY'), TO_DATE('11/04/2021', 'DD/MM/YYYY'));

INSERT INTO club_rates(club_id, sport, subscriptiontype, subscription_startdate, subscriptionrate_existing,
			     subscriptionrate_new, subscription_enddate, registration_startdate, registration_enddate)
VALUES (2086, 'Padel', 'JUNIOR', TO_DATE('16/06/2020', 'DD/MM/YYYY'), 15, 75, TO_DATE('31/12/2020', 'DD/MM/YYYY'),
	 TO_DATE('31/12/2021', 'DD/MM/YYYY'), TO_DATE('12/05/2021', 'DD/MM/YYYY'));

INSERT INTO club_rates(club_id, sport, subscriptiontype, subscription_startdate, subscriptionrate_existing,
			     subscriptionrate_new, subscription_enddate, registration_startdate, registration_enddate)
VALUES (2086, 'Tennis', 'MINI', TO_DATE('17/05/2020', 'DD/MM/YYYY'), 35, 65, TO_DATE('31/12/2020', 'DD/MM/YYYY'),
	 TO_DATE('31/12/2021', 'DD/MM/YYYY'), TO_DATE('13/04/2021', 'DD/MM/YYYY'));

INSERT INTO club_rates(club_id, sport, subscriptiontype, subscription_startdate, subscriptionrate_existing,
			     subscriptionrate_new, subscription_enddate, registration_startdate, registration_enddate)
VALUES (2086, 'Padel', 'JUNIOR', TO_DATE('18/08/2020', 'DD/MM/YYYY'), 20, 85, TO_DATE('31/12/2020', 'DD/MM/YYYY'),
	 TO_DATE('31/12/2021', 'DD/MM/YYYY'), TO_DATE('10/05/2021', 'DD/MM/YYYY'))
/