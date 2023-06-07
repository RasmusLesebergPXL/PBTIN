REM   Script:   creatie tabellen voor Tennis Vlaanderen

SET FEEDBACK 1
SET NUMWIDTH 10
SET LINESIZE 80
SET TRIMSPOOL ON
SET TAB OFF
SET PAGESIZE 100
SET ECHO OFF 
CLEAR SCREEN

REM *******************************************************************
Prompt --> dropping tables TENNIS
REM *******************************************************************
DROP TABLE Club_rates;
DROP TABLE Club_subscriptiontypes;
DROP TABLE Club_Qualitylabels;
DROP TABLE Club_trainings;
DROP TABLE Club_programoffers;
DROP TABLE Tournament_series;
DROP TABLE Series;
DROP TABLE Tournaments;
DROP TABLE Reservations;
DROP TABLE Members;
DROP TABLE Clubs;
DROP TABLE Cities;


Prompt *************************************************
Prompt --> creatie en insert in table Cities
Prompt *************************************************
CREATE TABLE Cities (
  zipcode 		VARCHAR2(4)
			CONSTRAINT CIT_PK   PRIMARY KEY ,
  city			VARCHAR2(30)
			CONSTRAINT CIT_CIT_NN NOT NULL
);

INSERT INTO cities VALUES (3290, 'Diest');
INSERT INTO cities VALUES (3293, 'Kaggevinne');
INSERT INTO cities VALUES (3294, 'Molenstede');
INSERT INTO cities VALUES (8210, 'Zedelgem');
INSERT INTO cities VALUES (8000, 'Brugge');
INSERT INTO cities VALUES (3500, 'Hasselt');
INSERT INTO cities VALUES (3511, 'Kuringen');
INSERT INTO cities VALUES (3510, 'Kermt');



Prompt *************************************************
Prompt --> creatie en insert in table Clubs 
Prompt *************************************************
CREATE TABLE Clubs (
  club_id 			NUMBER(5)
				CONSTRAINT CLUB_PK   PRIMARY KEY ,
  clubname			VARCHAR2(30)
				CONSTRAINT CLUB_NM_NN NOT NULL,
  street			VARCHAR2(30)
				CONSTRAINT CLUB_STR_NN NOT NULL,
  housenumber 			NUMBER(3),
  zipcode			VARCHAR2(4)
				CONSTRAINT CLUB_ZIP_FK REFERENCES cities
				CONSTRAINT CLUB_ZIP_NN NOT NULL,
  region			VARCHAR2(20)
				CONSTRAINT CLUB_REG_NN NOT NULL,
  telephone 			VARCHAR2(20)
				CONSTRAINT CLUB_TEL_NN NOT NULL,
  email 			VARCHAR2(30)
				CONSTRAINT CLUB_EM_NN NOT NULL
				CONSTRAINT CLUB_EM_CHK CHECK(email like '_%@_%._%'),
  website 			VARCHAR2(30),
  facebook 			VARCHAR2(50)
				CONSTRAINT CLUB_FB_CHK CHECK(facebook like '%facebook.com%')
);

INSERT INTO Clubs VALUES(5003, 'KTC Diest', 'Omer Vanaudenhovelaan', null, '3290', 'Limburg', '32 13 33 37 03', 'info@ktcdiest.be', 'http://www.ktcdiest.be', 'https://www.facebook.com/ktcdiest');
INSERT INTO Clubs VALUES(2086, 'TC Zedelgem', 'Stationlaan', 48, '8210', 'West-Vlaanderen', '32 50 20 19 19', 'info@tczedelgem.be', 'http://www.tczedelgem.be', 'https://www.facebook.com/tczedelgem');
INSERT INTO Clubs VALUES(5039, 'Runkster Tennisclub', 'Kapellekensbampdstraat', 17, '3500', 'Limburg', '32 11 27 46 56', 'info@runkster.be', 'https://www.runkster.be', 'https://www.facebook.com/RunksterTc/');
INSERT INTO Clubs VALUES(5004, 'Koninklijke Excelsior T.C.', 'Oude Kuringerbaan', 125, '3500', 'Limburg', '32 11 25 35 81', 'info@excelsior.be', 'https://www.excelsiortc.be', 'https://www.facebook.com/excelsior');


Prompt *************************************************
Prompt --> creatie en insert in table Members 
Prompt *************************************************
CREATE TABLE Members (
  member_id 			NUMBER(7)
				CONSTRAINT MEM_PK   PRIMARY KEY,
  firstname 			VARCHAR2(30)
				CONSTRAINT MEM_FN_NN NOT NULL,
  lastname 			VARCHAR2(30)
				CONSTRAINT MEM_LN_NN NOT NULL,
  club_id 			NUMBER(5)
				CONSTRAINT MEM_club_FK REFERENCES Clubs
				CONSTRAINT MEM_CL_NN NOT NULL,
  password 			VARCHAR2(30),
  ranking_single 		NUMBER(3)
				CONSTRAINT MEM_RS_CHK CHECK(ranking_single BETWEEN 3 AND 115)
				CONSTRAINT MEM_RS_NN NOT NULL,
  ranking_double 		NUMBER(3)
				CONSTRAINT MEM_RD_CHK CHECK(ranking_double BETWEEN 3 AND 115)
				CONSTRAINT MEM_RD_NN NOT NULL,
  sex 				VARCHAR2(5)
				CONSTRAINT MEM_SEX_CHK CHECK(sex IN ('V', 'M'))
				CONSTRAINT MEM_SEX_NN NOT NULL,
  birthday 			DATE
				CONSTRAINT MEM_BD_NN NOT NULL,
  nationality 			VARCHAR2(30)
				CONSTRAINT MEM_NAT_NN NOT NULL,
  hulp				NUMBER(3)
);

INSERT INTO Members VALUES (565615, 'Isabelle', 'Godfrind', 5003, 'IsGo30', 50,50, 'V', TO_DATE('30/08/1973','dd-mm-yyyy'), 'Belgie',1);
INSERT INTO Members VALUES (565616, 'Ellen', 'Godfrind', 5003, 'ElGo15', 50,50, 'V', TO_DATE('15/08/1970','dd-mm-yyyy'), 'Belgie',2);

INSERT INTO members  VALUES(	1415260	,	'Ann'	,	'Claes'	,	5003	,	null	,	45	,	50	,	'V'	,	TO_DATE('	2000	-	03	-	14	','yyyy-mm-dd')	,	'Belgie'	,	3	);
INSERT INTO members  VALUES(	1012458	,	'Marie'	,	'Vandenborre'	,	5003	,	null	,	65	,	70	,	'V'	,	TO_DATE('	1955	-	11	-	10	','yyyy-mm-dd')	,	'Belgie'	,	4	);
INSERT INTO members  VALUES(	1717997	,	'Lina'	,	'Tilkens'	,	5003	,	null	,	50	,	50	,	'V'	,	TO_DATE('	1956	-	05	-	17	','yyyy-mm-dd')	,	'Belgie'	,	5	);
INSERT INTO members  VALUES(	1924840	,	'Kyril'	,	'Kuppens'	,	5003	,	null	,	90	,	90	,	'M'	,	TO_DATE('	2004	-	01	-	19	','yyyy-mm-dd')	,	'Belgie'	,	6	);
INSERT INTO members  VALUES(	1956832	,	'Anna'	,	'Borders'	,	5003	,	null	,	80	,	90	,	'V'	,	TO_DATE('	1955	-	12	-	19	','yyyy-mm-dd')	,	'Belgie'	,	7	);
INSERT INTO members  VALUES(	1918592	,	'Patrick'	,	'Clerinx'	,	5003	,	null	,	70	,	85	,	'M'	,	TO_DATE('	1957	-	10	-	19	','yyyy-mm-dd')	,	'Belgie'	,	8	);
INSERT INTO members  VALUES(	2720734	,	'Marcel'	,	'Vandenborre'	,	5003	,	null	,	65	,	70	,	'M'	,	TO_DATE('	2005	-	04	-	27	','yyyy-mm-dd')	,	'Belgie'	,	9	);
INSERT INTO members  VALUES(	1057910	,	'Rita'	,	'Terriers'	,	5003	,	null	,	75	,	75	,	'V'	,	TO_DATE('	1957	-	06	-	10	','yyyy-mm-dd')	,	'Belgie'	,	10	);
INSERT INTO members  VALUES(	1260066	,	'Christian'	,	'Boes'	,	5003	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1961	-	02	-	12	','yyyy-mm-dd')	,	'Belgie'	,	11	);
INSERT INTO members  VALUES(	1512523	,	'Lotte'	,	'Verstreken'	,	5003	,	null	,	95	,	100	,	'V'	,	TO_DATE('	1958	-	01	-	15	','yyyy-mm-dd')	,	'Belgie'	,	12	);
INSERT INTO members  VALUES(	2553598	,	'Roger'	,	'Klimop'	,	5003	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1958	-	08	-	25	','yyyy-mm-dd')	,	'Belgie'	,	13	);
INSERT INTO members  VALUES(	2423709	,	'Patricia'	,	'Appelmans'	,	5003	,	null	,	15	,	15	,	'V'	,	TO_DATE('	1958	-	05	-	24	','yyyy-mm-dd')	,	'Belgie'	,	14	);
INSERT INTO members  VALUES(	1345234	,	'An'	,	'Borders'	,	5003	,	null	,	45	,	50	,	'V'	,	TO_DATE('	1972	-	04	-	13	','yyyy-mm-dd')	,	'Belgie'	,	15	);
INSERT INTO members  VALUES(	2718473	,	'Michel'	,	'Boes'	,	5003	,	null	,	65	,	70	,	'M'	,	TO_DATE('	1955	-	09	-	27	','yyyy-mm-dd')	,	'Belgie'	,	16	);
INSERT INTO members  VALUES(	1683756	,	'Annemie'	,	'Jacobs'	,	5003	,	null	,	50	,	55	,	'V'	,	TO_DATE('	1958	-	09	-	16	','yyyy-mm-dd')	,	'Belgie'	,	17	);
INSERT INTO members  VALUES(	1388288	,	'Hélène'	,	'Jacquelot'	,	5003	,	null	,	90	,	95	,	'V'	,	TO_DATE('	1962	-	12	-	13	','yyyy-mm-dd')	,	'Belgie'	,	18	);
INSERT INTO members  VALUES(	2886022	,	'Marc'	,	'Jacquelot'	,	5003	,	null	,	80	,	85	,	'M'	,	TO_DATE('	1960	-	10	-	28	','yyyy-mm-dd')	,	'Belgie'	,	19	);
INSERT INTO members  VALUES(	1490554	,	'Valerie'	,	'Jacquelot'	,	5003	,	null	,	70	,	75	,	'V'	,	TO_DATE('	1955	-	06	-	14	','yyyy-mm-dd')	,	'Belgie'	,	20	);
INSERT INTO members  VALUES(	2195086	,	'Hilde'	,	'Jacobs'	,	5003	,	null	,	65	,	65	,	'V'	,	TO_DATE('	1959	-	02	-	21	','yyyy-mm-dd')	,	'Belgie'	,	21	);
INSERT INTO members  VALUES(	1811556	,	'Evelien'	,	'Van Roy'	,	5003	,	null	,	75	,	75	,	'V'	,	TO_DATE('	1965	-	05	-	18	','yyyy-mm-dd')	,	'Belgie'	,	22	);
INSERT INTO members  VALUES(	1710478	,	'Katrien'	,	'Van Roy'	,	5003	,	null	,	85	,	85	,	'V'	,	TO_DATE('	1963	-	04	-	17	','yyyy-mm-dd')	,	'Belgie'	,	23	);
INSERT INTO members  VALUES(	2092820	,	'Ivo'	,	'Van Roy'	,	5003	,	null	,	95	,	100	,	'M'	,	TO_DATE('	1957	-	11	-	20	','yyyy-mm-dd')	,	'Belgie'	,	24	);
INSERT INTO members  VALUES(	1158988	,	'Eric'	,	'Teerain'	,	5003	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1959	-	11	-	11	','yyyy-mm-dd')	,	'Belgie'	,	25	);
INSERT INTO members  VALUES(	1118024	,	'Adam'	,	'Teerain'	,	5003	,	null	,	15	,	20	,	'M'	,	TO_DATE('	1977	-	12	-	11	','yyyy-mm-dd')	,	'Belgie'	,	26	);
INSERT INTO members  VALUES(	1027106	,	'Jonas'	,	'Beervoets'	,	5003	,	null	,	45	,	50	,	'M'	,	TO_DATE('	2005	-	08	-	10	','yyyy-mm-dd')	,	'Belgie'	,	27	);
INSERT INTO members  VALUES(	1523828	,	'Ann'	,	'Witte'	,	5003	,	null	,	65	,	65	,	'V'	,	TO_DATE('	1960	-	03	-	15	','yyyy-mm-dd')	,	'Belgie'	,	28	);
INSERT INTO members  VALUES(	2634194	,	'Marie'	,	'Yilmaz'	,	5003	,	null	,	50	,	50	,	'V'	,	TO_DATE('	1970	-	02	-	26	','yyyy-mm-dd')	,	'Belgie'	,	29	);
INSERT INTO members  VALUES(	1129372	,	'Niels'	,	'Yilmaz'	,	5003	,	null	,	90	,	95	,	'M'	,	TO_DATE('	2000	-	09	-	11	','yyyy-mm-dd')	,	'Belgie'	,	30	);
INSERT INTO members  VALUES(	1612642	,	'Miet'	,	'Vandenborre'	,	5003	,	null	,	80	,	90	,	'V'	,	TO_DATE('	1960	-	08	-	16	','yyyy-mm-dd')	,	'Belgie'	,	31	);
INSERT INTO members  VALUES(	2518235	,	'Jean'	,	'Terriers'	,	5003	,	null	,	70	,	85	,	'M'	,	TO_DATE('	1960	-	01	-	25	','yyyy-mm-dd')	,	'Belgie'	,	32	);
INSERT INTO members  VALUES(	2335561	,	'Gert'	,	'Witte'	,	5003	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1961	-	04	-	23	','yyyy-mm-dd')	,	'Belgie'	,	33	);
INSERT INTO members  VALUES(	1118830	,	'André'	,	'De Cuyper'	,	5003	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1961	-	06	-	11	','yyyy-mm-dd')	,	'Belgie'	,	34	);
INSERT INTO members  VALUES(	1818116	,	'Marie'	,	'Borders'	,	5003	,	null	,	85	,	85	,	'V'	,	TO_DATE('	1958	-	03	-	18	','yyyy-mm-dd')	,	'Belgie'	,	35	);
INSERT INTO members  VALUES(	2297352	,	'Filip'	,	'Van Roy'	,	5003	,	null	,	100	,	100	,	'M'	,	TO_DATE('	1961	-	07	-	22	','yyyy-mm-dd')	,	'Belgie'	,	36	);
INSERT INTO members  VALUES(	2714790	,	'Puck'	,	'Van Roy'	,	5003	,	null	,	25	,	30	,	'V'	,	TO_DATE('	1971	-	08	-	27	','yyyy-mm-dd')	,	'Belgie'	,	37	);
INSERT INTO members  VALUES(	2613712	,	'Emmeline'	,	'Van Roy'	,	5003	,	null	,	15	,	20	,	'V'	,	TO_DATE('	1969	-	01	-	26	','yyyy-mm-dd')	,	'Belgie'	,	38	);
INSERT INTO members  VALUES(	2812761	,	'Lies'	,	'Alberty'	,	5003	,	null	,	45	,	50	,	'V'	,	TO_DATE('	1962	-	09	-	28	','yyyy-mm-dd')	,	'Belgie'	,	39	);
INSERT INTO members  VALUES(	1214427	,	'Bram'	,	'Geldof'	,	5003	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1981	-	12	-	12	','yyyy-mm-dd')	,	'Belgie'	,	40	);
INSERT INTO members  VALUES(	2381626	,	'Tom'	,	'Alberty'	,	5003	,	null	,	50	,	55	,	'M'	,	TO_DATE('	1964	-	10	-	23	','yyyy-mm-dd')	,	'Belgie'	,	41	);
INSERT INTO members  VALUES(	2755754	,	'Nicole'	,	'Tilkens'	,	5003	,	null	,	90	,	90	,	'V'	,	TO_DATE('	1962	-	10	-	27	','yyyy-mm-dd')	,	'Belgie'	,	42	);
INSERT INTO members  VALUES(	2513713	,	'Piet'	,	'Terriers'	,	5003	,	null	,	80	,	85	,	'M'	,	TO_DATE('	1969	-	05	-	25	','yyyy-mm-dd')	,	'Belgie'	,	43	);
INSERT INTO members  VALUES(	2443262	,	'Rien'	,	'Aerts'	,	5003	,	null	,	70	,	75	,	'M'	,	TO_DATE('	1963	-	05	-	24	','yyyy-mm-dd')	,	'Belgie'	,	44	);
INSERT INTO members  VALUES(	1684860	,	'Jeannine'	,	'Aerts'	,	5003	,	null	,	65	,	85	,	'V'	,	TO_DATE('	1970	-	11	-	16	','yyyy-mm-dd')	,	'Belgie'	,	45	);
INSERT INTO members  VALUES(	1227860	,	'Kris'	,	'Appelmans'	,	5003	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1959	-	07	-	12	','yyyy-mm-dd')	,	'Belgie'	,	46	);
INSERT INTO members  VALUES(	2361144	,	'Marcel'	,	'Clerinx'	,	5003	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1963	-	07	-	23	','yyyy-mm-dd')	,	'Belgie'	,	47	);
INSERT INTO members  VALUES(	2654676	,	'Willy'	,	'Daenen'	,	5003	,	null	,	95	,	100	,	'M'	,	TO_DATE('	1960	-	09	-	26	','yyyy-mm-dd')	,	'Belgie'	,	48	);
INSERT INTO members  VALUES(	2215617	,	'Ben'	,	'Yilmaz'	,	5003	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1964	-	09	-	22	','yyyy-mm-dd')	,	'Belgie'	,	49	);
INSERT INTO members  VALUES(	1112047	,	'Leen'	,	'Yilmaz'	,	5003	,	null	,	15	,	20	,	'V'	,	TO_DATE('	1987	-	07	-	11	','yyyy-mm-dd')	,	'Belgie'	,	50	);
INSERT INTO members  VALUES(	2319068	,	'Monique'	,	'Geyskens'	,	5003	,	null	,	40	,	50	,	'V'	,	TO_DATE('	1965	-	02	-	23	','yyyy-mm-dd')	,	'Belgie'	,	51	);
INSERT INTO members  VALUES(	1550963	,	'Matthias'	,	'Klawitter'	,	5003	,	null	,	65	,	75	,	'M'	,	TO_DATE('	1965	-	03	-	15	','yyyy-mm-dd')	,	'Belgie'	,	52	);
INSERT INTO members  VALUES(	2819544	,	'Paul'	,	'Keuninckx'	,	5003	,	null	,	50	,	50	,	'M'	,	TO_DATE('	1973	-	03	-	28	','yyyy-mm-dd')	,	'Belgie'	,	53	);
INSERT INTO members  VALUES(	2815022	,	'Omer'	,	'Keuninckx'	,	5003	,	null	,	90	,	95	,	'M'	,	TO_DATE('	2004	-	04	-	28	','yyyy-mm-dd')	,	'Belgie'	,	54	);
INSERT INTO members  VALUES(	1713475	,	'Dennis'	,	'Franssen'	,	5003	,	null	,	80	,	85	,	'M'	,	TO_DATE('	1965	-	07	-	17	','yyyy-mm-dd')	,	'Belgie'	,	55	);
INSERT INTO members  VALUES(	1730960	,	'Alice'	,	'Claes'	,	5003	,	null	,	70	,	85	,	'V'	,	TO_DATE('	1964	-	12	-	17	','yyyy-mm-dd')	,	'Belgie'	,	56	);
INSERT INTO members  VALUES(	1832038	,	'Juliette'	,	'Kuppens'	,	5003	,	null	,	65	,	75	,	'V'	,	TO_DATE('	1966	-	06	-	18	','yyyy-mm-dd')	,	'Belgie'	,	57	);
INSERT INTO members  VALUES(	2321329	,	'Alain'	,	'Klawitter'	,	5003	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1966	-	09	-	23	','yyyy-mm-dd')	,	'Belgie'	,	58	);
INSERT INTO members  VALUES(	1538436	,	'Jules'	,	'Verstreken'	,	5003	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1966	-	11	-	15	','yyyy-mm-dd')	,	'Belgie'	,	59	);
INSERT INTO members  VALUES(	1179470	,	'Nicolas'	,	'Verstreken'	,	5003	,	null	,	105	,	105	,	'M'	,	TO_DATE('	1999	-	08	-	11	','yyyy-mm-dd')	,	'Belgie'	,	60	);
INSERT INTO members  VALUES(	1138506	,	'Jean'	,	'Verstreken'	,	5003	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1978	-	03	-	11	','yyyy-mm-dd')	,	'Belgie'	,	61	);
INSERT INTO members  VALUES(	1488094	,	'Patricia'	,	'Franssen'	,	5003	,	null	,	15	,	20	,	'V'	,	TO_DATE('	1976	-	04	-	14	','yyyy-mm-dd')	,	'Belgie'	,	62	);
INSERT INTO members  VALUES(	1658664	,	'Mark'	,	'Kenes'	,	5003	,	null	,	55	,	55	,	'M'	,	TO_DATE('	1967	-	01	-	16	','yyyy-mm-dd')	,	'Belgie'	,	63	);
INSERT INTO members  VALUES(	1114308	,	'Indra'	,	'De Cuyper'	,	5003	,	null	,	65	,	70	,	'V'	,	TO_DATE('	1979	-	10	-	11	','yyyy-mm-dd')	,	'Belgie'	,	64	);
INSERT INTO members  VALUES(	2512634	,	'Madeleine'	,	'Dox'	,	5003	,	null	,	50	,	55	,	'V'	,	TO_DATE('	1967	-	03	-	25	','yyyy-mm-dd')	,	'Belgie'	,	65	);
INSERT INTO members  VALUES(	1813594	,	'Jan'	,	'Borders'	,	5003	,	null	,	90	,	90	,	'M'	,	TO_DATE('	1967	-	04	-	18	','yyyy-mm-dd')	,	'Belgie'	,	66	);
INSERT INTO members  VALUES(	2017640	,	'Elena'	,	'Janssens'	,	5003	,	null	,	80	,	85	,	'V'	,	TO_DATE('	1987	-	02	-	20	','yyyy-mm-dd')	,	'Belgie'	,	67	);
INSERT INTO members  VALUES(	1563300	,	'Peter'	,	'De Cuyper'	,	5003	,	null	,	70	,	75	,	'M'	,	TO_DATE('	1967	-	05	-	15	','yyyy-mm-dd')	,	'Belgie'	,	68	);
INSERT INTO members  VALUES(	1447130	,	'Philippe'	,	'Franssen'	,	5003	,	null	,	65	,	70	,	'M'	,	TO_DATE('	1994	-	02	-	14	','yyyy-mm-dd')	,	'Belgie'	,	69	);
INSERT INTO members  VALUES(	2217878	,	'Sofia'	,	'Daenen'	,	5003	,	null	,	75	,	75	,	'V'	,	TO_DATE('	1991	-	04	-	22	','yyyy-mm-dd')	,	'Belgie'	,	70	);
INSERT INTO members  VALUES(	2695640	,	'Matthias'	,	'Daenen'	,	5003	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1990	-	12	-	26	','yyyy-mm-dd')	,	'Belgie'	,	71	);
INSERT INTO members  VALUES(	2419187	,	'Philippe'	,	'Haest'	,	5003	,	null	,	95	,	105	,	'M'	,	TO_DATE('	1967	-	07	-	24	','yyyy-mm-dd')	,	'Belgie'	,	72	);
INSERT INTO members  VALUES(	2414665	,	'Hans'	,	'Haest'	,	5003	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1985	-	11	-	24	','yyyy-mm-dd')	,	'Belgie'	,	73	);
INSERT INTO members  VALUES(	2436170	,	'Piet'	,	'Goedeman'	,	5003	,	null	,	15	,	20	,	'M'	,	TO_DATE('	1964	-	06	-	24	','yyyy-mm-dd')	,	'Belgie'	,	74	);
INSERT INTO members  VALUES(	1583782	,	'Christophe'	,	'Witte'	,	5003	,	null	,	45	,	50	,	'M'	,	TO_DATE('	1968	-	06	-	15	','yyyy-mm-dd')	,	'Belgie'	,	75	);
INSERT INTO members  VALUES(	1542818	,	'Luc'	,	'Witte'	,	5003	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1986	-	10	-	15	','yyyy-mm-dd')	,	'Belgie'	,	76	);
INSERT INTO members  VALUES(	2421448	,	'Robert'	,	'Kenes'	,	5003	,	null	,	55	,	60	,	'M'	,	TO_DATE('	1968	-	10	-	24	','yyyy-mm-dd')	,	'Belgie'	,	77	);
INSERT INTO members  VALUES(	1387016	,	'Sarah'	,	'Kenes'	,	5003	,	null	,	90	,	100	,	'V'	,	TO_DATE('	1974	-	07	-	13	','yyyy-mm-dd')	,	'Belgie'	,	78	);
INSERT INTO members  VALUES(	2213356	,	'Niels'	,	'Kenes'	,	5003	,	null	,	80	,	90	,	'M'	,	TO_DATE('	1963	-	02	-	22	','yyyy-mm-dd')	,	'Belgie'	,	79	);
INSERT INTO members  VALUES(	2533116	,	'Elena'	,	'Beervoets'	,	5003	,	null	,	70	,	85	,	'V'	,	TO_DATE('	1968	-	11	-	25	','yyyy-mm-dd')	,	'Belgie'	,	80	);
INSERT INTO members  VALUES(	2482704	,	'Guy'	,	'Appelmans'	,	5003	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1966	-	12	-	24	','yyyy-mm-dd')	,	'Belgie'	,	81	);
INSERT INTO members  VALUES(	2574080	,	'Thomas'	,	'Beervoets'	,	5003	,	null	,	75	,	75	,	'M'	,	TO_DATE('	2002	-	07	-	25	','yyyy-mm-dd')	,	'Belgie'	,	82	);
INSERT INTO members  VALUES(	1815855	,	'Noah'	,	'Vanneste'	,	5003	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1968	-	12	-	18	','yyyy-mm-dd')	,	'Belgie'	,	83	);
INSERT INTO members  VALUES(	1923114	,	'Guy'	,	'Vanneste'	,	5003	,	null	,	100	,	100	,	'M'	,	TO_DATE('	1996	-	06	-	19	','yyyy-mm-dd')	,	'Belgie'	,	84	);
INSERT INTO members  VALUES(	1319663	,	'Nathalie'	,	'Tilkens'	,	5003	,	null	,	25	,	30	,	'V'	,	TO_DATE('	1975	-	01	-	13	','yyyy-mm-dd')	,	'Belgie'	,	85	);
INSERT INTO members  VALUES(	1820377	,	'Rita'	,	'Vanneste'	,	5003	,	null	,	15	,	20	,	'V'	,	TO_DATE('	2002	-	11	-	18	','yyyy-mm-dd')	,	'Belgie'	,	86	);
INSERT INTO members  VALUES(	1664378	,	'Jacques'	,	'Geldof'	,	5003	,	null	,	45	,	50	,	'M'	,	TO_DATE('	1969	-	03	-	16	','yyyy-mm-dd')	,	'Belgie'	,	87	);
INSERT INTO members  VALUES(	1519306	,	'Martine'	,	'Hendrix'	,	5003	,	null	,	65	,	70	,	'V'	,	TO_DATE('	1969	-	04	-	15	','yyyy-mm-dd')	,	'Belgie'	,	88	);
INSERT INTO members  VALUES(	1374066	,	'Tom'	,	'Hons'	,	5003	,	null	,	50	,	55	,	'M'	,	TO_DATE('	1971	-	09	-	13	','yyyy-mm-dd')	,	'Belgie'	,	89	);
INSERT INTO members  VALUES(	1514784	,	'Conrad'	,	'Hendrix'	,	5003	,	null	,	90	,	100	,	'M'	,	TO_DATE('	2002	-	02	-	15	','yyyy-mm-dd')	,	'Belgie'	,	90	);
INSERT INTO members  VALUES(	2866365	,	'Eline'	,	'Franssen'	,	5003	,	null	,	80	,	85	,	'V'	,	TO_DATE('	1969	-	08	-	28	','yyyy-mm-dd')	,	'Belgie'	,	91	);
INSERT INTO members  VALUES(	2842968	,	'Abdul'	,	'Heersel'	,	5003	,	null	,	70	,	70	,	'M'	,	TO_DATE('	1970	-	07	-	28	','yyyy-mm-dd')	,	'Belgie'	,	92	);
INSERT INTO members  VALUES(	1521567	,	'Daniel'	,	'Franssen'	,	5003	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1970	-	12	-	15	','yyyy-mm-dd')	,	'Belgie'	,	93	);
INSERT INTO members  VALUES(	1967894	,	'Jorben'	,	'Hendrix'	,	5003	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1992	-	02	-	19	','yyyy-mm-dd')	,	'Belgie'	,	94	);
INSERT INTO members  VALUES(	1426648	,	'Emma'	,	'Hendrix'	,	5003	,	null	,	85	,	85	,	'V'	,	TO_DATE('	2005	-	01	-	14	','yyyy-mm-dd')	,	'Belgie'	,	95	);
INSERT INTO members  VALUES(	2865456	,	'Dirk'	,	'Geyskens'	,	5003	,	null	,	95	,	100	,	'M'	,	TO_DATE('	1971	-	01	-	28	','yyyy-mm-dd')	,	'Belgie'	,	96	);
INSERT INTO members  VALUES(	1640702	,	'Ali'	,	'Janssens'	,	5003	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1968	-	02	-	16	','yyyy-mm-dd')	,	'Belgie'	,	97	);
INSERT INTO members  VALUES(	1852520	,	'Pierre'	,	'Janssens'	,	5003	,	null	,	15	,	20	,	'M'	,	TO_DATE('	1956	-	01	-	18	','yyyy-mm-dd')	,	'Belgie'	,	98	);
INSERT INTO members  VALUES(	2613832	,	'Jules'	,	'Teerain'	,	5003	,	null	,	100	,	110	,	'M'	,	TO_DATE('	1971	-	03	-	26	','yyyy-mm-dd')	,	'Belgie'	,	99	);
INSERT INTO members  VALUES(	2618354	,	'Marc'	,	'Teerain'	,	5003	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1962	-	08	-	26	','yyyy-mm-dd')	,	'Belgie'	,	100	);
INSERT INTO members  VALUES(	1619425	,	'Anne'	,	'Huyghe'	,	5003	,	null	,	15	,	15	,	'V'	,	TO_DATE('	1971	-	05	-	16	','yyyy-mm-dd')	,	'Belgie'	,	101	);
INSERT INTO members  VALUES(	2885938	,	'Olivier'	,	'Klawitter'	,	5003	,	null	,	45	,	50	,	'M'	,	TO_DATE('	1972	-	02	-	28	','yyyy-mm-dd')	,	'Belgie'	,	102	);
INSERT INTO members  VALUES(	2844974	,	'Jan'	,	'Klawitter'	,	5003	,	null	,	65	,	80	,	'M'	,	TO_DATE('	1990	-	06	-	28	','yyyy-mm-dd')	,	'Belgie'	,	103	);
INSERT INTO members  VALUES(	2616093	,	'Louis'	,	'Verstreken'	,	5003	,	null	,	50	,	55	,	'M'	,	TO_DATE('	1972	-	11	-	26	','yyyy-mm-dd')	,	'Belgie'	,	104	);
INSERT INTO members  VALUES(	2735272	,	'Sofia'	,	'Spaelt'	,	5003	,	null	,	80	,	85	,	'V'	,	TO_DATE('	1972	-	07	-	27	','yyyy-mm-dd')	,	'Belgie'	,	105	);
INSERT INTO members  VALUES(	2713951	,	'Ali'	,	'Boes'	,	5003	,	null	,	90	,	90	,	'M'	,	TO_DATE('	1973	-	01	-	27	','yyyy-mm-dd')	,	'Belgie'	,	106	);
INSERT INTO members  VALUES(	2149286	,	'Anne'	,	'Huisjes'	,	5003	,	null	,	70	,	75	,	'V'	,	TO_DATE('	1987	-	04	-	21	','yyyy-mm-dd')	,	'Belgie'	,	107	);
INSERT INTO members  VALUES(	1366534	,	'Alain'	,	'Haest'	,	5003	,	null	,	65	,	70	,	'M'	,	TO_DATE('	1973	-	08	-	13	','yyyy-mm-dd')	,	'Belgie'	,	108	);
INSERT INTO members  VALUES(	1915868	,	'Arthur'	,	'Borders'	,	5003	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1973	-	09	-	19	','yyyy-mm-dd')	,	'Belgie'	,	109	);
INSERT INTO members  VALUES(	1481767	,	'Leen'	,	'Huisjes'	,	5003	,	null	,	90	,	90	,	'V'	,	TO_DATE('	1973	-	10	-	14	','yyyy-mm-dd')	,	'Belgie'	,	110	);
INSERT INTO members  VALUES(	2716212	,	'Liam'	,	'Vandenborre'	,	5003	,	null	,	95	,	100	,	'M'	,	TO_DATE('	1974	-	02	-	27	','yyyy-mm-dd')	,	'Belgie'	,	111	);
INSERT INTO members  VALUES(	2270846	,	'Christine'	,	'Tilkens'	,	5003	,	null	,	25	,	30	,	'V'	,	TO_DATE('	1981	-	06	-	22	','yyyy-mm-dd')	,	'Belgie'	,	112	);
INSERT INTO members  VALUES(	1936350	,	'Lina'	,	'Vanneste'	,	5003	,	null	,	15	,	20	,	'V'	,	TO_DATE('	1974	-	04	-	19	','yyyy-mm-dd')	,	'Belgie'	,	113	);
INSERT INTO members  VALUES(	1447500	,	'Indra'	,	'Terriers'	,	5003	,	null	,	40	,	45	,	'V'	,	TO_DATE('	1974	-	05	-	14	','yyyy-mm-dd')	,	'Belgie'	,	114	);
INSERT INTO members  VALUES(	2019901	,	'Roger'	,	'Kuppens'	,	5003	,	null	,	65	,	75	,	'M'	,	TO_DATE('	1979	-	09	-	20	','yyyy-mm-dd')	,	'Belgie'	,	115	);
INSERT INTO members  VALUES(	2821805	,	'Christine'	,	'Huisjes'	,	5003	,	null	,	50	,	50	,	'V'	,	TO_DATE('	1974	-	11	-	28	','yyyy-mm-dd')	,	'Belgie'	,	116	);
INSERT INTO members  VALUES(	1621686	,	'David'	,	'Hons'	,	5003	,	null	,	90	,	95	,	'M'	,	TO_DATE('	1972	-	06	-	16	','yyyy-mm-dd')	,	'Belgie'	,	117	);
INSERT INTO members  VALUES(	2027726	,	'Olivia'	,	'Huyghe'	,	5003	,	null	,	80	,	85	,	'V'	,	TO_DATE('	2000	-	08	-	20	','yyyy-mm-dd')	,	'Belgie'	,	118	);
INSERT INTO members  VALUES(	1914070	,	'Abdul'	,	'Clerinx'	,	5003	,	null	,	70	,	85	,	'M'	,	TO_DATE('	1975	-	08	-	19	','yyyy-mm-dd')	,	'Belgie'	,	119	);
INSERT INTO members  VALUES(	1467612	,	'Robert'	,	'Hendrix'	,	5003	,	null	,	65	,	70	,	'M'	,	TO_DATE('	1975	-	09	-	14	','yyyy-mm-dd')	,	'Belgie'	,	120	);
INSERT INTO members  VALUES(	2089172	,	'Ann'	,	'Hons'	,	5003	,	null	,	75	,	75	,	'V'	,	TO_DATE('	1978	-	05	-	20	','yyyy-mm-dd')	,	'Belgie'	,	121	);
INSERT INTO members  VALUES(	1016946	,	'Noah'	,	'Terriers'	,	5003	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1975	-	10	-	10	','yyyy-mm-dd')	,	'Belgie'	,	122	);
INSERT INTO members  VALUES(	1713510	,	'Lotte'	,	'Klimop'	,	5003	,	null	,	105	,	110	,	'V'	,	TO_DATE('	1981	-	02	-	17	','yyyy-mm-dd')	,	'Belgie'	,	123	);
INSERT INTO members  VALUES(	2089468	,	'Veerle'	,	'Willems'	,	5003	,	null	,	25	,	30	,	'V'	,	TO_DATE('	1975	-	12	-	20	','yyyy-mm-dd')	,	'Belgie'	,	124	);
INSERT INTO members  VALUES(	2340662	,	'Michel'	,	'Alberty'	,	5003	,	null	,	15	,	20	,	'M'	,	TO_DATE('	1982	-	08	-	23	','yyyy-mm-dd')	,	'Belgie'	,	125	);
INSERT INTO members  VALUES(	1120159	,	'Philippe'	,	'Alberty'	,	5003	,	null	,	55	,	55	,	'M'	,	TO_DATE('	1957	-	02	-	11	','yyyy-mm-dd')	,	'Belgie'	,	126	);
INSERT INTO members  VALUES(	1321924	,	'Jacqueline'	,	'Willems'	,	5003	,	null	,	65	,	70	,	'V'	,	TO_DATE('	1976	-	02	-	13	','yyyy-mm-dd')	,	'Belgie'	,	127	);
INSERT INTO members  VALUES(	2049766	,	'Bram'	,	'Teerain'	,	5003	,	null	,	30	,	30	,	'M'	,	TO_DATE('	1976	-	03	-	20	','yyyy-mm-dd')	,	'Belgie'	,	128	);
INSERT INTO members  VALUES(	1037428	,	'Marie'	,	'Goedeman'	,	5003	,	null	,	90	,	90	,	'V'	,	TO_DATE('	1976	-	05	-	10	','yyyy-mm-dd')	,	'Belgie'	,	129	);
INSERT INTO members  VALUES(	1916331	,	'Lucas'	,	'Alberty'	,	5003	,	null	,	80	,	85	,	'M'	,	TO_DATE('	1976	-	07	-	19	','yyyy-mm-dd')	,	'Belgie'	,	130	);
INSERT INTO members  VALUES(	2323590	,	'Sarah'	,	'Alberty'	,	5003	,	null	,	70	,	75	,	'V'	,	TO_DATE('	1956	-	04	-	23	','yyyy-mm-dd')	,	'Belgie'	,	131	);
INSERT INTO members  VALUES(	1920853	,	'Johan'	,	'Alberty'	,	5003	,	null	,	65	,	70	,	'M'	,	TO_DATE('	2000	-	05	-	19	','yyyy-mm-dd')	,	'Belgie'	,	132	);
INSERT INTO members  VALUES(	2197169	,	'Marijke'	,	'Waterman'	,	5003	,	null	,	75	,	75	,	'V'	,	TO_DATE('	1977	-	06	-	21	','yyyy-mm-dd')	,	'Belgie'	,	133	);
INSERT INTO members  VALUES(	1419782	,	'Pierre'	,	'Claes'	,	5003	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1977	-	08	-	14	','yyyy-mm-dd')	,	'Belgie'	,	134	);
INSERT INTO members  VALUES(	1771924	,	'Jacqueline'	,	'Claes'	,	5003	,	null	,	95	,	105	,	'V'	,	TO_DATE('	1983	-	11	-	17	','yyyy-mm-dd')	,	'Belgie'	,	135	);
INSERT INTO members  VALUES(	2722574	,	'Lowie'	,	'Claes'	,	5003	,	null	,	25	,	30	,	'M'	,	TO_DATE('	2007	-	03	-	27	','yyyy-mm-dd')	,	'Belgie'	,	136	);
INSERT INTO members  VALUES(	1014189	,	'An'	,	'Daniels'	,	5003	,	null	,	15	,	20	,	'V'	,	TO_DATE('	1977	-	09	-	10	','yyyy-mm-dd')	,	'Belgie'	,	137	);
INSERT INTO members  VALUES(	2663362	,	'Atakan'	,	'Geyskens'	,	5003	,	null	,	45	,	50	,	'M'	,	TO_DATE('	1988	-	06	-	26	','yyyy-mm-dd')	,	'Belgie'	,	138	);
INSERT INTO members  VALUES(	1218949	,	'Jan'	,	'Geldof'	,	5003	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1963	-	11	-	12	','yyyy-mm-dd')	,	'Belgie'	,	139	);
INSERT INTO members  VALUES(	2068690	,	'Daniel'	,	'Huyghe'	,	5003	,	null	,	55	,	65	,	'M'	,	TO_DATE('	1977	-	10	-	20	','yyyy-mm-dd')	,	'Belgie'	,	140	);
INSERT INTO members  VALUES(	1715736	,	'Arthur'	,	'Spaelt'	,	5003	,	null	,	90	,	95	,	'M'	,	TO_DATE('	1966	-	10	-	17	','yyyy-mm-dd')	,	'Belgie'	,	141	);
INSERT INTO members  VALUES(	1614903	,	'Magomed'	,	'Huyghe'	,	5003	,	null	,	80	,	90	,	'M'	,	TO_DATE('	2007	-	07	-	16	','yyyy-mm-dd')	,	'Belgie'	,	142	);
INSERT INTO members  VALUES(	2152032	,	'Kevin'	,	'Boes'	,	5003	,	null	,	70	,	85	,	'M'	,	TO_DATE('	1978	-	01	-	21	','yyyy-mm-dd')	,	'Belgie'	,	143	);
INSERT INTO members  VALUES(	1422043	,	'Joseph'	,	'Franssen'	,	5003	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1978	-	07	-	14	','yyyy-mm-dd')	,	'Belgie'	,	144	);
INSERT INTO members  VALUES(	2561096	,	'Omer'	,	'Geldof'	,	5003	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1986	-	12	-	25	','yyyy-mm-dd')	,	'Belgie'	,	145	);
INSERT INTO members  VALUES(	1623414	,	'Victor'	,	'Geldof'	,	5003	,	null	,	85	,	85	,	'M'	,	TO_DATE('	2002	-	04	-	16	','yyyy-mm-dd')	,	'Belgie'	,	146	);
INSERT INTO members  VALUES(	1219102	,	'Louis'	,	'Boes'	,	5003	,	null	,	100	,	100	,	'M'	,	TO_DATE('	1979	-	06	-	12	','yyyy-mm-dd')	,	'Belgie'	,	147	);
INSERT INTO members  VALUES(	1016450	,	'Jules'	,	'Appelmans'	,	5003	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1978	-	04	-	10	','yyyy-mm-dd')	,	'Belgie'	,	148	);
INSERT INTO members  VALUES(	1312880	,	'Louise'	,	'Appelmans'	,	5003	,	null	,	15	,	20	,	'V'	,	TO_DATE('	1955	-	10	-	13	','yyyy-mm-dd')	,	'Belgie'	,	149	);
INSERT INTO members  VALUES(	2211244	,	'Leen'	,	'Janssens'	,	5003	,	null	,	45	,	50	,	'V'	,	TO_DATE('	1979	-	11	-	22	','yyyy-mm-dd')	,	'Belgie'	,	150	);
INSERT INTO members  VALUES(	2169768	,	'David'	,	'Keuninckx'	,	5003	,	null	,	65	,	70	,	'M'	,	TO_DATE('	1979	-	12	-	21	','yyyy-mm-dd')	,	'Belgie'	,	151	);
INSERT INTO members  VALUES(	2128804	,	'Louise'	,	'Keuninckx'	,	5003	,	null	,	50	,	55	,	'V'	,	TO_DATE('	1999	-	09	-	21	','yyyy-mm-dd')	,	'Belgie'	,	152	);
INSERT INTO members  VALUES(	2190250	,	'Marie'	,	'Huisjes'	,	5003	,	null	,	90	,	95	,	'V'	,	TO_DATE('	1980	-	03	-	21	','yyyy-mm-dd')	,	'Belgie'	,	153	);
INSERT INTO members  VALUES(	2817283	,	'Mila'	,	'Huisjes'	,	5004	,	null	,	80	,	85	,	'V'	,	TO_DATE('	1992	-	12	-	28	','yyyy-mm-dd')	,	'Belgie'	,	1	);
INSERT INTO members  VALUES(	2022162	,	'Thomas'	,	'Janssens'	,	5004	,	null	,	70	,	80	,	'M'	,	TO_DATE('	1980	-	04	-	20	','yyyy-mm-dd')	,	'Belgie'	,	2	);
INSERT INTO members  VALUES(	2515974	,	'Adam'	,	'Goedeman'	,	5004	,	null	,	65	,	80	,	'M'	,	TO_DATE('	1970	-	06	-	25	','yyyy-mm-dd')	,	'Belgie'	,	3	);
INSERT INTO members  VALUES(	2520496	,	'Eric'	,	'Goedeman'	,	5004	,	null	,	75	,	75	,	'M'	,	TO_DATE('	2007	-	02	-	25	','yyyy-mm-dd')	,	'Belgie'	,	4	);
INSERT INTO members  VALUES(	1116569	,	'Victor'	,	'Witte'	,	5004	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1980	-	05	-	11	','yyyy-mm-dd')	,	'Belgie'	,	5	);
INSERT INTO members  VALUES(	1121091	,	'Jacques'	,	'Witte'	,	5004	,	null	,	95	,	100	,	'M'	,	TO_DATE('	1998	-	01	-	11	','yyyy-mm-dd')	,	'Belgie'	,	6	);
INSERT INTO members  VALUES(	1412999	,	'Lowie'	,	'Witte'	,	5004	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1957	-	12	-	14	','yyyy-mm-dd')	,	'Belgie'	,	7	);
INSERT INTO members  VALUES(	2254298	,	'Hans'	,	'Clerinx'	,	5004	,	null	,	15	,	20	,	'M'	,	TO_DATE('	1980	-	08	-	22	','yyyy-mm-dd')	,	'Belgie'	,	8	);
INSERT INTO members  VALUES(	2320180	,	'Liam'	,	'Clerinx'	,	5004	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1981	-	11	-	23	','yyyy-mm-dd')	,	'Belgie'	,	9	);
INSERT INTO members  VALUES(	2120020	,	'Willy'	,	'Beervoets'	,	5004	,	null	,	15	,	20	,	'M'	,	TO_DATE('	1981	-	10	-	21	','yyyy-mm-dd')	,	'Belgie'	,	10	);
INSERT INTO members  VALUES(	1221210	,	'Dirk'	,	'Aerts'	,	5004	,	null	,	45	,	50	,	'M'	,	TO_DATE('	1964	-	08	-	12	','yyyy-mm-dd')	,	'Belgie'	,	11	);
INSERT INTO members  VALUES(	1623947	,	'Tom'	,	'Aerts'	,	5004	,	null	,	45	,	60	,	'M'	,	TO_DATE('	1962	-	01	-	16	','yyyy-mm-dd')	,	'Belgie'	,	12	);
INSERT INTO members  VALUES(	2291328	,	'Philippe'	,	'Willems'	,	5004	,	null	,	115	,	115	,	'M'	,	TO_DATE('	1982	-	01	-	22	','yyyy-mm-dd')	,	'Belgie'	,	13	);
INSERT INTO members  VALUES(	2229882	,	'Mila'	,	'Tilkens'	,	5004	,	null	,	90	,	90	,	'V'	,	TO_DATE('	1998	-	10	-	22	','yyyy-mm-dd')	,	'Belgie'	,	14	);
INSERT INTO members  VALUES(	2620308	,	'Louise'	,	'Tilkens'	,	5004	,	null	,	80	,	90	,	'V'	,	TO_DATE('	2002	-	05	-	26	','yyyy-mm-dd')	,	'Belgie'	,	15	);
INSERT INTO members  VALUES(	2122281	,	'Jozef'	,	'Klimop'	,	5004	,	null	,	70	,	85	,	'M'	,	TO_DATE('	1982	-	05	-	21	','yyyy-mm-dd')	,	'Belgie'	,	16	);
INSERT INTO members  VALUES(	1756564	,	'Conrad'	,	'Daniels'	,	5004	,	null	,	50	,	60	,	'M'	,	TO_DATE('	1982	-	09	-	17	','yyyy-mm-dd')	,	'Belgie'	,	17	);
INSERT INTO members  VALUES(	2314546	,	'Kevin'	,	'Geyskens'	,	5004	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1983	-	06	-	23	','yyyy-mm-dd')	,	'Belgie'	,	18	);
INSERT INTO members  VALUES(	2412404	,	'Leen'	,	'Goedeman'	,	5004	,	null	,	85	,	85	,	'V'	,	TO_DATE('	1956	-	03	-	24	','yyyy-mm-dd')	,	'Belgie'	,	19	);
INSERT INTO members  VALUES(	1078392	,	'François'	,	'Goedeman'	,	5004	,	null	,	100	,	100	,	'M'	,	TO_DATE('	2000	-	01	-	10	','yyyy-mm-dd')	,	'Belgie'	,	20	);
INSERT INTO members  VALUES(	1815776	,	'Miet'	,	'Daenen'	,	5004	,	null	,	25	,	30	,	'V'	,	TO_DATE('	1983	-	07	-	18	','yyyy-mm-dd')	,	'Belgie'	,	21	);
INSERT INTO members  VALUES(	2220139	,	'Nicole'	,	'Yilmaz'	,	5004	,	null	,	15	,	20	,	'V'	,	TO_DATE('	1983	-	12	-	22	','yyyy-mm-dd')	,	'Belgie'	,	22	);
INSERT INTO members  VALUES(	2316807	,	'Mohamed'	,	'Klawitter'	,	5004	,	null	,	45	,	50	,	'M'	,	TO_DATE('	1984	-	01	-	23	','yyyy-mm-dd')	,	'Belgie'	,	23	);
INSERT INTO members  VALUES(	2113237	,	'Jonas'	,	'Klawitter'	,	5004	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1961	-	11	-	21	','yyyy-mm-dd')	,	'Belgie'	,	24	);
INSERT INTO members  VALUES(	1792406	,	'Kris'	,	'Waterman'	,	5004	,	null	,	35	,	35	,	'V'	,	TO_DATE('	1984	-	08	-	17	','yyyy-mm-dd')	,	'Belgie'	,	25	);
INSERT INTO members  VALUES(	1417521	,	'Juliette'	,	'Waterman'	,	5039	,	null	,	90	,	100	,	'V'	,	TO_DATE('	1996	-	11	-	14	','yyyy-mm-dd')	,	'Belgie'	,	1	);
INSERT INTO members  VALUES(	1751442	,	'Nathalie'	,	'Waterman'	,	5039	,	null	,	80	,	85	,	'V'	,	TO_DATE('	1991	-	03	-	17	','yyyy-mm-dd')	,	'Belgie'	,	2	);
INSERT INTO members  VALUES(	2441740	,	'Patrick'	,	'Appelmans'	,	5039	,	null	,	70	,	70	,	'M'	,	TO_DATE('	1984	-	09	-	24	','yyyy-mm-dd')	,	'Belgie'	,	3	);
INSERT INTO members  VALUES(	1858830	,	'Magomed'	,	'De Cuyper'	,	5039	,	null	,	65	,	70	,	'M'	,	TO_DATE('	1984	-	10	-	18	','yyyy-mm-dd')	,	'Belgie'	,	4	);
INSERT INTO members  VALUES(	1873002	,	'Joseph'	,	'Kuppens'	,	5039	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1985	-	02	-	18	','yyyy-mm-dd')	,	'Belgie'	,	5	);
INSERT INTO members  VALUES(	2015379	,	'Jorben'	,	'Kuppens'	,	5039	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1999	-	01	-	20	','yyyy-mm-dd')	,	'Belgie'	,	6	);
INSERT INTO members  VALUES(	2416926	,	'Emma'	,	'Kenes'	,	5039	,	null	,	95	,	100	,	'V'	,	TO_DATE('	1986	-	08	-	24	','yyyy-mm-dd')	,	'Belgie'	,	7	);
INSERT INTO members  VALUES(	1720258	,	'Anna'	,	'Spaelt'	,	5039	,	null	,	25	,	30	,	'V'	,	TO_DATE('	1985	-	06	-	17	','yyyy-mm-dd')	,	'Belgie'	,	8	);
INSERT INTO members  VALUES(	1822638	,	'François'	,	'Kuppens'	,	5039	,	null	,	15	,	20	,	'M'	,	TO_DATE('	1988	-	08	-	18	','yyyy-mm-dd')	,	'Belgie'	,	9	);
INSERT INTO members  VALUES(	1522336	,	'Jules'	,	'De Cuyper'	,	5039	,	null	,	70	,	85	,	'M'	,	TO_DATE('	1985	-	07	-	15	','yyyy-mm-dd')	,	'Belgie'	,	10	);
INSERT INTO members  VALUES(	2222400	,	'Isabelle'	,	'Daenen'	,	5039	,	null	,	65	,	65	,	'V'	,	TO_DATE('	1984	-	03	-	22	','yyyy-mm-dd')	,	'Belgie'	,	11	);
INSERT INTO members  VALUES(	1722519	,	'Bart'	,	'Tilkens'	,	5039	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1986	-	01	-	17	','yyyy-mm-dd')	,	'Belgie'	,	12	);
INSERT INTO members  VALUES(	1274692	,	'Josse'	,	'Jacobs'	,	5039	,	null	,	85	,	85	,	'M'	,	TO_DATE('	1987	-	05	-	12	','yyyy-mm-dd')	,	'Belgie'	,	13	);
INSERT INTO members  VALUES(	2479224	,	'Tineke'	,	'Jacobs'	,	5039	,	null	,	100	,	100	,	'V'	,	TO_DATE('	1991	-	01	-	24	','yyyy-mm-dd')	,	'Belgie'	,	14	);
INSERT INTO members  VALUES(	2376958	,	'Gratia'	,	'De nayer'	,	5039	,	null	,	25	,	30	,	'V'	,	TO_DATE('	1989	-	03	-	23	','yyyy-mm-dd')	,	'Belgie'	,	15	);
INSERT INTO members  VALUES(	1581490	,	'Eva'	,	'Jacobs'	,	5039	,	null	,	15	,	20	,	'V'	,	TO_DATE('	1956	-	08	-	15	','yyyy-mm-dd')	,	'Belgie'	,	16	);
INSERT INTO members  VALUES(	1023233	,	'Christophe'	,	'Goedeman'	,	5039	,	null	,	40	,	40	,	'M'	,	TO_DATE('	1987	-	11	-	10	','yyyy-mm-dd')	,	'Belgie'	,	17	);
INSERT INTO members  VALUES(	2824492	,	'Gabriel'	,	'Geyskens'	,	5039	,	null	,	45	,	55	,	'M'	,	TO_DATE('	2007	-	05	-	28	','yyyy-mm-dd')	,	'Belgie'	,	18	);
INSERT INTO members  VALUES(	1643896	,	'André'	,	'Aerts'	,	5039	,	null	,	50	,	55	,	'M'	,	TO_DATE('	1988	-	12	-	16	','yyyy-mm-dd')	,	'Belgie'	,	19	);
INSERT INTO members  VALUES(	2522757	,	'Nicolas'	,	'Beervoets'	,	5039	,	null	,	90	,	95	,	'M'	,	TO_DATE('	1990	-	09	-	25	','yyyy-mm-dd')	,	'Belgie'	,	20	);
INSERT INTO members  VALUES(	1216688	,	'Gabriel'	,	'Aerts'	,	5039	,	null	,	80	,	85	,	'M'	,	TO_DATE('	1982	-	03	-	12	','yyyy-mm-dd')	,	'Belgie'	,	21	);
INSERT INTO members  VALUES(	2013118	,	'Kyril'	,	'Aerts'	,	5039	,	null	,	60	,	65	,	'M'	,	TO_DATE('	1959	-	06	-	20	','yyyy-mm-dd')	,	'Belgie'	,	22	);
INSERT INTO members  VALUES(	1123352	,	'Jeannine'	,	'Verstreken'	,	5039	,	null	,	65	,	65	,	'V'	,	TO_DATE('	1989	-	02	-	11	','yyyy-mm-dd')	,	'Belgie'	,	23	);
INSERT INTO members  VALUES(	2620615	,	'Christiane'	,	'Verstreken'	,	2086	,	null	,	75	,	75	,	'V'	,	TO_DATE('	2004	-	07	-	26	','yyyy-mm-dd')	,	'Belgie'	,	1	);
INSERT INTO members  VALUES(	1212166	,	'Veerle'	,	'Spaelt'	,	2086	,	null	,	90	,	90	,	'V'	,	TO_DATE('	1989	-	04	-	12	','yyyy-mm-dd')	,	'Belgie'	,	2	);
INSERT INTO members  VALUES(	2776236	,	'Isabelle'	,	'Spaelt'	,	2086	,	null	,	95	,	100	,	'V'	,	TO_DATE('	2004	-	05	-	27	','yyyy-mm-dd')	,	'Belgie'	,	3	);
INSERT INTO members  VALUES(	2250364	,	'Paul'	,	'Willems'	,	2086	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1989	-	05	-	22	','yyyy-mm-dd')	,	'Belgie'	,	4	);
INSERT INTO members  VALUES(	2675158	,	'Jozef'	,	'Yilmaz'	,	2086	,	null	,	15	,	20	,	'M'	,	TO_DATE('	2007	-	04	-	26	','yyyy-mm-dd')	,	'Belgie'	,	5	);
INSERT INTO members  VALUES(	2117759	,	'Marie'	,	'Klimop'	,	2086	,	null	,	25	,	30	,	'V'	,	TO_DATE('	1989	-	07	-	21	','yyyy-mm-dd')	,	'Belgie'	,	6	);
INSERT INTO members  VALUES(	2594562	,	'Rien'	,	'Klimop'	,	2086	,	null	,	15	,	20	,	'M'	,	TO_DATE('	1988	-	10	-	25	','yyyy-mm-dd')	,	'Belgie'	,	7	);
INSERT INTO members  VALUES(	2765628	,	'Ann'	,	'Haest'	,	2086	,	null	,	45	,	50	,	'V'	,	TO_DATE('	1990	-	11	-	27	','yyyy-mm-dd')	,	'Belgie'	,	8	);
INSERT INTO members  VALUES(	1617164	,	'Louise'	,	'Hons'	,	2086	,	null	,	60	,	60	,	'V'	,	TO_DATE('	1990	-	10	-	16	','yyyy-mm-dd')	,	'Belgie'	,	9	);
INSERT INTO members  VALUES(	1325570	,	'Mohamed'	,	'Haest'	,	2086	,	null	,	105	,	110	,	'M'	,	TO_DATE('	2004	-	03	-	13	','yyyy-mm-dd')	,	'Belgie'	,	10	);
INSERT INTO members  VALUES(	2312285	,	'Marijke'	,	'Vanneste'	,	2086	,	null	,	90	,	95	,	'V'	,	TO_DATE('	1991	-	05	-	23	','yyyy-mm-dd')	,	'Belgie'	,	11	);
INSERT INTO members  VALUES(	1239584	,	'Marc'	,	'Vandenborre'	,	2086	,	null	,	80	,	90	,	'M'	,	TO_DATE('	1980	-	01	-	12	','yyyy-mm-dd')	,	'Belgie'	,	12	);
INSERT INTO members  VALUES(	1977314	,	'Bart'	,	'Vanneste'	,	2086	,	null	,	70	,	85	,	'M'	,	TO_DATE('	2005	-	03	-	19	','yyyy-mm-dd')	,	'Belgie'	,	13	);
INSERT INTO members  VALUES(	1223471	,	'Olivier'	,	'Klawitter'	,	2086	,	null	,	60	,	60	,	'M'	,	TO_DATE('	1991	-	07	-	12	','yyyy-mm-dd')	,	'Belgie'	,	14	);
INSERT INTO members  VALUES(	1517045	,	'Olivia'	,	'Franssen'	,	2086	,	null	,	70	,	75	,	'V'	,	TO_DATE('	1988	-	09	-	15	','yyyy-mm-dd')	,	'Belgie'	,	15	);
INSERT INTO members  VALUES(	2796718	,	'Mark'	,	'Tilkens'	,	2086	,	null	,	80	,	85	,	'M'	,	TO_DATE('	1992	-	06	-	27	','yyyy-mm-dd')	,	'Belgie'	,	16	);
INSERT INTO members  VALUES(	1997796	,	'Eline'	,	'Kuppens'	,	2086	,	null	,	100	,	105	,	'V'	,	TO_DATE('	1994	-	11	-	19	','yyyy-mm-dd')	,	'Belgie'	,	17	);
INSERT INTO members  VALUES(	1315141	,	'Atakan'	,	'Tilkens'	,	2086	,	null	,	25	,	30	,	'M'	,	TO_DATE('	2005	-	05	-	13	','yyyy-mm-dd')	,	'Belgie'	,	18	);
INSERT INTO members  VALUES(	2622876	,	'Christian'	,	'Kenes'	,	2086	,	null	,	15	,	20	,	'M'	,	TO_DATE('	1992	-	10	-	26	','yyyy-mm-dd')	,	'Belgie'	,	19	);
INSERT INTO members  VALUES(	1346052	,	'Monique'	,	'Kenes'	,	2086	,	null	,	45	,	50	,	'V'	,	TO_DATE('	1992	-	11	-	13	','yyyy-mm-dd')	,	'Belgie'	,	20	);
INSERT INTO members  VALUES(	1893484	,	'Gert'	,	'Janssens'	,	2086	,	null	,	65	,	70	,	'M'	,	TO_DATE('	1986	-	09	-	18	','yyyy-mm-dd')	,	'Belgie'	,	21	);
INSERT INTO members  VALUES(	1317402	,	'Alice'	,	'Willems'	,	2086	,	null	,	35	,	40	,	'V'	,	TO_DATE('	1994	-	06	-	13	','yyyy-mm-dd')	,	'Belgie'	,	22	);
INSERT INTO members  VALUES(	2722995	,	'Tom'	,	'Spaelt'	,	2086	,	null	,	90	,	90	,	'M'	,	TO_DATE('	1994	-	12	-	27	','yyyy-mm-dd')	,	'Belgie'	,	23	);
INSERT INTO members  VALUES(	1098874	,	'Tom'	,	'Beervoets'	,	2086	,	null	,	80	,	85	,	'M'	,	TO_DATE('	1996	-	02	-	10	','yyyy-mm-dd')	,	'Belgie'	,	24	);
INSERT INTO members  VALUES(	2115498	,	'Jordy'	,	'Beervoets'	,	2086	,	null	,	70	,	75	,	'M'	,	TO_DATE('	1998	-	08	-	21	','yyyy-mm-dd')	,	'Belgie'	,	25	);
INSERT INTO members  VALUES(	1018711	,	'Luc'	,	'Daniels'	,	2086	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1959	-	12	-	10	','yyyy-mm-dd')	,	'Belgie'	,	26	);
INSERT INTO members  VALUES(	1172426	,	'Ben'	,	'Keuninckx'	,	2086	,	null	,	75	,	75	,	'M'	,	TO_DATE('	1996	-	04	-	11	','yyyy-mm-dd')	,	'Belgie'	,	27	);
INSERT INTO members  VALUES(	2048208	,	'Martine'	,	'Hons'	,	2086	,	null	,	85	,	85	,	'V'	,	TO_DATE('	1996	-	07	-	20	','yyyy-mm-dd')	,	'Belgie'	,	28	);
INSERT INTO members  VALUES(	1070160	,	'Jordy'	,	'Huyghe'	,	2086	,	null	,	95	,	100	,	'M'	,	TO_DATE('	1994	-	07	-	10	','yyyy-mm-dd')	,	'Belgie'	,	29	);
INSERT INTO members  VALUES(	1280548	,	'Christian'	,	'Vandenborre'	,	2086	,	null	,	25	,	30	,	'M'	,	TO_DATE('	1998	-	09	-	12	','yyyy-mm-dd')	,	'Belgie'	,	30	);
INSERT INTO members  VALUES(	2518042	,	'Lies'	,	'Tilkens'	,	2086	,	null	,	15	,	20	,	'V'	,	TO_DATE('	1985	-	04	-	25	','yyyy-mm-dd')	,	'Belgie'	,	31	);
INSERT INTO members  VALUES(	2333904	,	'Jan'	,	'Vanneste'	,	2086	,	null	,	45	,	50	,	'M'	,	TO_DATE('	1998	-	12	-	23	','yyyy-mm-dd')	,	'Belgie'	,	32	);
INSERT INTO members  VALUES(	1020972	,	'Peter'	,	'Appelmans'	,	2086	,	null	,	65	,	65	,	'M'	,	TO_DATE('	1999	-	03	-	10	','yyyy-mm-dd')	,	'Belgie'	,	33	);
INSERT INTO members  VALUES(	2421258	,	'Lucas'	,	'Daniels'	,	2086	,	null	,	35	,	40	,	'M'	,	TO_DATE('	1983	-	02	-	24	','yyyy-mm-dd')	,	'Belgie'	,	34	);
INSERT INTO members  VALUES(	2462222	,	'Johan'	,	'Daniels'	,	2086	,	null	,	90	,	90	,	'M'	,	TO_DATE('	1965	-	04	-	24	','yyyy-mm-dd')	,	'Belgie'	,	35	);
INSERT INTO members  VALUES(	1231638	,	'Dennis'	,	'Spaelt'	,	2086	,	null	,	80	,	85	,	'M'	,	TO_DATE('	1999	-	10	-	12	','yyyy-mm-dd')	,	'Belgie'	,	36	);
INSERT INTO members  VALUES(	1231639	,	'Iris'	,	'Spaelt'	,	2086	,	null	,	70	,	80	,	'V'	,	TO_DATE('	1969	-	05	-	14	','yyyy-mm-dd')	,	'Belgie'	,	37	);



UPDATE members 
SET password = SUBSTR(firstname, 1,2) || SUBSTR(lastname, 1,2) || TO_CHAR(birthday, 'yy');
    
ALTER TABLE members MODIFY (password CONSTRAINT MEM_PW_NN NOT NULL); 

Prompt *************************************************
Prompt --> creatie en insert in table Reservations 
Prompt *************************************************
CREATE TABLE Reservations (
  member_id 			NUMBER(7)
				CONSTRAINT RES_mem_FK REFERENCES Members,
  reservation_date_starthour 	DATE
				CONSTRAINT RES_DAT_NN NOT NULL,
  terrain 			NUMBER(2)
				CONSTRAINT RES_TER_NN NOT NULL,
  opponent_id 			NUMBER(7)
				CONSTRAINT RES_OPP_FK REFERENCES Members
				CONSTRAINT RES_OPP_NN NOT NULL,
  CONSTRAINT RES_PK PRIMARY KEY (member_id, reservation_date_starthour)
);

INSERT INTO Reservations VALUES (565615, TO_DATE('15/08/2010 14:00','dd-mm-yyyy hh24:mi'),5, 565616);

DECLARE
   v_date       DATE := TO_DATE('2021-03-15 13','yyyy-mm-dd hh24');
   v_hulp       NUMBER(3) := 1;
   v_memberid   NUMBER(7);
   v_oppid      NUMBER(7);
   v_maxhulp    NUMBER(3);
BEGIN
-- reservaties voor club 5003, 'KTC Diest' --> 6 terreinen
   SELECT max(hulp) INTO v_maxhulp FROM members where club_id = 5003;
   WHILE v_date <= TO_DATE('2021-11-15','yyyy-mm-dd') LOOP
      FOR terrain in 1 .. 6 LOOP
           SELECT member_id INTO v_memberid FROM members where club_id = 5003 AND hulp = v_hulp;
           IF v_hulp < 133 THEN
               SELECT member_id INTO v_oppid FROM members where club_id = 5003 AND hulp = v_hulp + TO_CHAR(v_date,'hh24');
           ELSE
               SELECT member_id INTO v_oppid FROM members where club_id = 5003 AND hulp = v_hulp - TO_CHAR(v_date,'hh24');
           END IF;
           INSERT INTO Reservations VALUES (v_memberid, v_date, terrain, v_oppid);
           v_hulp := v_hulp + 1;
           IF v_hulp > v_maxhulp
               THEN v_hulp := 1;
           END IF;
      END LOOP;
      v_date := v_date + 1/24;
      IF TO_CHAR(v_date, 'hh24') > 20
           THEN  v_date := v_date + to_char(v_date,'d') + 14/24;
      END IF;
   END LOOP;

-- reservaties voor de andere clubs --> 4 terreinen
   FOR rec in (SELECT * FROM clubs where club_id != 5003) LOOP
      v_hulp  := 1;
      v_date  := TO_DATE('2021-03-15 13','yyyy-mm-dd hh24');
      SELECT max(hulp) INTO v_maxhulp FROM members where club_id = rec.club_id;
      WHILE v_date <= TO_DATE('2021-11-15','yyyy-mm-dd') LOOP
         FOR terrain in 1 .. 4 LOOP
           SELECT member_id INTO v_memberid FROM members where club_id = rec.club_id AND hulp = v_hulp;
           IF v_hulp < v_maxhulp/2 THEN
               SELECT member_id INTO v_oppid FROM members where club_id = rec.club_id AND hulp = v_hulp + floor(TO_CHAR(v_date,'hh24')/2);
           ELSE
               SELECT member_id INTO v_oppid FROM members where club_id = rec.club_id AND hulp = v_hulp - floor(TO_CHAR(v_date,'hh24')/2);
           END IF;
           INSERT INTO Reservations VALUES (v_memberid, v_date, terrain, v_oppid);
           v_hulp := v_hulp + 1;
           IF v_hulp > v_maxhulp
               THEN v_hulp := 1;
           END IF;
         END LOOP;
         v_date := v_date + 1/24;
         IF TO_CHAR(v_date, 'hh24') > 20
           THEN  v_date := v_date + to_char(v_date,'d') + 14/24;
         END IF;
      END LOOP;
   END LOOP;
END;
/

ALTER TABLE members DROP COLUMN hulp;

Prompt *************************************************
Prompt --> creatie en insert in table Tournaments 
Prompt *************************************************
CREATE TABLE Tournaments (
  tournament_id 		NUMBER(7)
				CONSTRAINT TOUR_PK   PRIMARY KEY,
  tournament 			VARCHAR2(30)
				CONSTRAINT TOUR_TOUR_NN NOT NULL,
  startdate 			DATE
				CONSTRAINT TOUR_START_NN NOT NULL,
  enddate 			DATE,
  club_id 			NUMBER(5)
				CONSTRAINT TOUR_club_FK REFERENCES Clubs
				CONSTRAINT TOUR_CLUB_NN NOT NULL,
  indoor_outdoor 		VARCHAR2(10)
				CONSTRAINT TOUR_IO_CHK CHECK (indoor_outdoor IN ('indoor', 'outdoor'))
				CONSTRAINT TOUR_INOUT_NN NOT NULL,
  organiser_id 			NUMBER(7)
				CONSTRAINT TOUR_ORG_FK REFERENCES Members
				CONSTRAINT TOUR_ORG_NN NOT NULL,
  payment_online 		VARCHAR2(3)
				CONSTRAINT TOUR_PAY_CHK CHECK (payment_online IN ('ja', 'nee'))
				CONSTRAINT TOUR_PAY_NN NOT NULL,
  CONSTRAINT TOUR_DATES_CHK CHECK(startdate < enddate)
);


INSERT INTO Tournaments VALUES (1, 'clubkampioenschap Corona', TO_DATE('02/09/2021','dd/mm/yyyy'), TO_DATE('17/10/2021','dd/mm/yyyy'), 5003, 'outdoor', 565616, 'nee');
INSERT INTO Tournaments VALUES (2, 'lentetoernooi', TO_DATE('01/04/2021','dd/mm/yyyy'), TO_DATE('17/05/2021','dd/mm/yyyy'), 5003, 'outdoor', 565616, 'nee');
INSERT INTO Tournaments VALUES (3, 'halloweentoernooi KIDS', TO_DATE('01/11/2021','dd/mm/yyyy'), TO_DATE('10/11/2021','dd/mm/yyyy'), 5003, 'indoor', 565615, 'nee');
INSERT INTO Tournaments VALUES (4, 'clubkampioenschap Excelsior', TO_DATE('25/05/2021','dd/mm/yyyy'), TO_DATE('17/06/2021','dd/mm/yyyy'), 5004, 'outdoor', 1116569, 'ja');
INSERT INTO Tournaments VALUES (5, 'clubkampioenschap Runkst', TO_DATE('01/05/2021','dd/mm/yyyy'), TO_DATE('01/06/2021','dd/mm/yyyy'), 5039, 'outdoor', 1522336, 'nee');
INSERT INTO Tournaments VALUES (6, 'lentetoernooi', TO_DATE('05/04/2021','dd/mm/yyyy'), TO_DATE('29/05/2021','dd/mm/yyyy'), 2086, 'outdoor', 1231639, 'ja');
INSERT INTO Tournaments VALUES (7, 'nazomercup', TO_DATE('02/09/2021','dd/mm/yyyy'), TO_DATE('20/10/2021','dd/mm/yyyy'), 2086, 'outdoor', 1231638, 'nee');


Prompt *************************************************
Prompt --> creatie en insert in table Series 
Prompt *************************************************
CREATE TABLE Series (
  series 			VARCHAR2(30)
				CONSTRAINT SER_PK   PRIMARY KEY
				CONSTRAINT SER_SER_CHK CHECK(series = UPPER(series)),
  age_min 			NUMBER(2)
				CONSTRAINT SER_MIN_NN NOT NULL,
  age_max 			NUMBER(2)
				CONSTRAINT SER_MAX_NN NOT NULL
, CONSTRAINT SER_MINMAX_CHK     CHECK(age_min < age_max)
);

INSERT INTO Series VALUES ('ENKEL HEREN 1', 11, 99);
INSERT INTO Series VALUES ('ENKEL HEREN 2', 11, 99);
INSERT INTO Series VALUES ('ENKEL HEREN 3', 11, 99);
INSERT INTO Series VALUES ('ENKEL HEREN 35 1', 35, 99);
INSERT INTO Series VALUES ('ENKEL HEREN 35 2', 35, 99);
INSERT INTO Series VALUES ('ENKEL HEREN 45 1', 45, 99);
INSERT INTO Series VALUES ('ENKEL HEREN 45 2', 45, 99);

INSERT INTO Series VALUES ('ENKEL VROUWEN 1', 11, 99);
INSERT INTO Series VALUES ('ENKEL VROUWEN 2', 11, 99);
INSERT INTO Series VALUES ('ENKEL VROUWEN 3', 11, 99);
INSERT INTO Series VALUES ('ENKEL VROUWEN 35 1', 35, 99);
INSERT INTO Series VALUES ('ENKEL VROUWEN 35 2', 35, 99);
INSERT INTO Series VALUES ('ENKEL VROUWEN 45 1', 45, 99);
INSERT INTO Series VALUES ('ENKEL VROUWEN 45 2', 45, 99);

INSERT INTO Series VALUES ('ENKEL JUNIOR 1', 0, 11);
INSERT INTO Series VALUES ('ENKEL JUNIOR 2', 0, 11);


Prompt *************************************************
Prompt --> creatie en insert in table Tournament_Series 
Prompt *************************************************
CREATE TABLE Tournament_Series (
  tournament_id 		NUMBER(7)
				CONSTRAINT TOURSER_tour_FK REFERENCES Tournaments,
  series 			VARCHAR2(30)
				CONSTRAINT TOURSER_ser_FK REFERENCES Series,
  ranking_min 			NUMBER(3)
				CONSTRAINT TOURSER_MIN_NN NOT NULL
				CONSTRAINT TOURSER_MIN_CHK CHECK(ranking_min BETWEEN 3 AND 115),
  ranking_max 			NUMBER(3)
				CONSTRAINT TOURSER_MAX_NN NOT NULL
				CONSTRAINT TOURSER_MAX_CHK CHECK(ranking_max BETWEEN 3 AND 115),
  circuit 			VARCHAR2(30),
  CONSTRAINT TOURSER_PK PRIMARY KEY (tournament_id, series)
, CONSTRAINT TOURSER_MINMAX_CHK     CHECK(ranking_min  < ranking_max )
);


DECLARE
v_hulp   NUMBER(1) :=0;
BEGIN
   FOR tourrec in (SELECT * from tournaments WHERE club_id IN (2086, 5003)) LOOP
      FOR serrec in (SELECT * from series) LOOP
          INSERT INTO tournament_series VALUES (tourrec.tournament_id, serrec.series, 3, 115, null);
      END LOOP;
   END LOOP;
   DELETE FROM tournament_series where tournament_id = 3 and series not like '%JUNIOR%';
   FOR serrec in (SELECT * from series) LOOP
      IF v_hulp = 0 THEN
              INSERT INTO tournament_series VALUES (4, serrec.series, 3, 115, null);
              v_hulp := 1;
      ELSE
              INSERT INTO tournament_series VALUES (5, serrec.series, 3, 115, null);
              v_hulp := 0;
      END IF;
   END LOOP;
END;
/

UPDATE tournament_series SET ranking_max = 45 WHERE series LIKE '%2';
UPDATE tournament_series SET ranking_max = 10 WHERE series LIKE '%3';
UPDATE tournament_series SET ranking_max = 95 WHERE series LIKE '%5 1';
UPDATE tournament_series SET ranking_max = 10 WHERE series LIKE '%5 2';
UPDATE tournament_series SET ranking_max = 60 WHERE series LIKE '%45 1';

Prompt *************************************************
Prompt --> creatie en insert in table Club_Programoffers 
Prompt *************************************************
CREATE TABLE Club_Programoffers (
  club_id 			NUMBER(5)
				CONSTRAINT CLUBOFF_club_FK REFERENCES Clubs,
  program_offer 		VARCHAR2(30),
  CONSTRAINT CLUBOFF_PK  PRIMARY KEY (club_id, program_offer)
);

INSERT INTO Club_Programoffers VALUES (5003, 'Start to tennis kidsclub');
INSERT INTO Club_Programoffers VALUES (5003, 'Start to tennis');
INSERT INTO Club_Programoffers VALUES (5003, 'Rolstoeltennis');
INSERT INTO Club_Programoffers VALUES (2086, 'Start to tennis kidsclub');
INSERT INTO Club_Programoffers VALUES (2086, 'Start to tennis');
INSERT INTO Club_Programoffers VALUES (2086, 'Start to tennis senior');
INSERT INTO Club_Programoffers VALUES (5004, 'Start to tennis kidsclub');
INSERT INTO Club_Programoffers VALUES (5004, 'Start to tennis');
INSERT INTO Club_Programoffers VALUES (5039, 'Rolstoeltennis');

Prompt *************************************************
Prompt --> creatie en insert in table Club_Trainings 
Prompt *************************************************
CREATE TABLE Club_Trainings (
  club_id 			NUMBER(5)
				CONSTRAINT CLUBTRAI_club_FK REFERENCES Clubs,
  training 			VARCHAR2(30),
  startdate 			DATE
				CONSTRAINT CLUBTRAI_START_NN NOT NULL,
  status 			VARCHAR2(30)
				CONSTRAINT CLUBTRAI_STAT_NN NOT NULL,
  CONSTRAINT CLUBTRAI_PK  PRIMARY KEY (club_id, training)
);

INSERT INTO Club_Trainings VALUES (2086, 'Lentelessen 2021', TO_DATE('19/04/2021', 'dd/mm/yyyy'), 'inschrijvingen afgesloten');
INSERT INTO Club_Trainings VALUES (2086, 'Zomerstage 1', TO_DATE('05/07/2021', 'dd/mm/yyyy'), 'inschrijvingen volzet');
INSERT INTO Club_Trainings VALUES (2086, 'Zomerstage 2', TO_DATE('02/08/2021', 'dd/mm/yyyy'), 'inschrijvingen afgesloten');
INSERT INTO Club_Trainings VALUES (2086, 'Zomerstage 3', TO_DATE('23/08/2021', 'dd/mm/yyyy'), 'inschrijvingen afgesloten');
INSERT INTO Club_Trainings VALUES (5003, 'Get back in shape 2021', TO_DATE('01/03/2021', 'dd/mm/yyyy'), 'inschrijvingen afgesloten');
INSERT INTO Club_Trainings VALUES (5003, 'Lentestage 2021', TO_DATE('06/04/2021', 'dd/mm/yyyy'), 'inschrijvingen afgesloten');
INSERT INTO Club_Trainings VALUES (5003, 'Zomerstage 1', TO_DATE('02/07/2021', 'dd/mm/yyyy'), 'inschrijvingen volzet');
INSERT INTO Club_Trainings VALUES (5003, 'Zomerstage 2', TO_DATE('16/08/2021', 'dd/mm/yyyy'), 'inschrijvingen afgesloten');
INSERT INTO Club_Trainings VALUES (5004, 'Lentestage 2021', TO_DATE('06/04/2021', 'dd/mm/yyyy'), 'inschrijvingen afgesloten');
INSERT INTO Club_Trainings VALUES (5004, 'Zomerlessen', TO_DATE('20/07/2021', 'dd/mm/yyyy'), 'inschrijvingen volzet');
INSERT INTO Club_Trainings VALUES (5039, 'Lentestage 2021', TO_DATE('05/04/2021', 'dd/mm/yyyy'), 'inschrijvingen afgesloten');
INSERT INTO Club_Trainings VALUES (5039, 'Zomerlessen', TO_DATE('01/08/2021', 'dd/mm/yyyy'), 'inschrijvingen volzet');
INSERT INTO Club_Trainings VALUES (5039, 'initiatie rolstoeltennis 2021', TO_DATE('05/07/2021', 'dd/mm/yyyy'), 'inschrijvingen afgesloten');

Prompt *************************************************
Prompt --> creatie en insert in table Club_Qualitylabels 
Prompt *************************************************
CREATE TABLE Club_Qualitylabels (
  club_id 			NUMBER(5)
				CONSTRAINT CLUBQUA_club_FK REFERENCES Clubs,
  quality_label 		VARCHAR2(30),
  CONSTRAINT CLUBQUA_PK  PRIMARY KEY (club_id, quality_label)
);

INSERT INTO Club_Qualitylabels VALUES (5003, 'Jeugdvriendelijke Tennisclub');
INSERT INTO Club_Qualitylabels VALUES (5003, 'Erkende Tennisschool');
INSERT INTO Club_Qualitylabels VALUES (5003, 'Opleidingsclub Goud');
INSERT INTO Club_Qualitylabels VALUES (2086, 'Jeugdvriendelijke Tennisclub');
INSERT INTO Club_Qualitylabels VALUES (2086, 'Opleidingsclub zilver');
INSERT INTO Club_Qualitylabels VALUES (5004, 'Jeugdvriendelijke Tennisclub');
INSERT INTO Club_Qualitylabels VALUES (5004, 'rolstoelvriendelijk');


Prompt *************************************************
Prompt --> creatie en insert in table Club_Subscriptiontypes 
Prompt *************************************************
CREATE TABLE Club_Subscriptiontypes (
  club_id 			NUMBER(5)
				CONSTRAINT CLUBSUBTYP_club_FK REFERENCES Clubs,
  subscriptiontype 		VARCHAR2(15),
  age_min		 	NUMBER(2)
				CONSTRAINT CLUBSUBTYP_MIN_NN NOT NULL,
  age_max		 	NUMBER(2)
				CONSTRAINT CLUBSUBTYP_MAX_NN NOT NULL,
  description 			VARCHAR2(50),
  CONSTRAINT CLUBSUBTYP_PK  PRIMARY KEY (club_id, subscriptiontype)
, CONSTRAINT CLUBSUBTYP_MINMAX_CHK     CHECK(age_min  < age_max )
);

INSERT INTO Club_Subscriptiontypes VALUES (	5003	,	'MINI'	,	3	,	12	,	'kinderen'	);
INSERT INTO Club_Subscriptiontypes VALUES (	5003	,	'VOLWASSENEN'	,	19	,	99	,	'volwassenen'	);
INSERT INTO Club_Subscriptiontypes VALUES (	5003	,	'MAXI'	,	13	,	18	,	'jeugd'	);
										
INSERT INTO Club_Subscriptiontypes VALUES (	2086	,	'MINI'	,	3	,	10	,	'kinderen'	);
INSERT INTO Club_Subscriptiontypes VALUES (	2086	,	'VOLWASSENEN'	,	19	,	99	,	'volwassenen'	);
INSERT INTO Club_Subscriptiontypes VALUES (	2086	,	'MAXI'	,	11	,	18	,	'tieners'	);
										
INSERT INTO Club_Subscriptiontypes VALUES (	5004	,	'MINI'	,	4	,	11	,	'kids'	);
INSERT INTO Club_Subscriptiontypes VALUES (	5004	,	'VOLWASSENEN'	,	20	,	99	,	'adults'	);
INSERT INTO Club_Subscriptiontypes VALUES (	5004	,	'JUNIOR'	,	12	,	19	,	'teenagers'	);
										
INSERT INTO Club_Subscriptiontypes VALUES (	5039	,	'MINI'	,	3	,	11	,	'kinderen'	);
INSERT INTO Club_Subscriptiontypes VALUES (	5039	,	'VOLWASSENEN'	,	19	,	99	,	'volwassenen'	);
INSERT INTO Club_Subscriptiontypes VALUES (	5039	,	'JUNIOR'	,	12	,	18	,	'jeugd'	);


Prompt *************************************************
Prompt --> creatie en insert in table Club_Rates 
Prompt *************************************************
CREATE TABLE Club_Rates (
  club_id 				NUMBER(5),
  sport 				VARCHAR2(30)
					CONSTRAINT CLUBRAT_SPORT_CHK CHECK(sport in ('tennis','padel','tennis/padel')),
  subscriptiontype 			VARCHAR2(30),
  subscription_startdate 		DATE,
  subscription_enddate 			DATE
					CONSTRAINT CLUBRAT_END_NN NOT NULL,
  registration_startdate 		DATE
					CONSTRAINT CLUBRAT_STARTREG_NN NOT NULL,
  registration_enddate 			DATE
					CONSTRAINT CLUBRAT_ENDREG_NN NOT NULL,
  subscription_rate_existing	 	NUMBER(5,2)
					CONSTRAINT CLUBRAT_EX_NN NOT NULL,
  subscription_rate_new 		NUMBER(5,2)
					CONSTRAINT CLUBRAT_NEW_NN NOT NULL,
  CONSTRAINT CLUBRAT_PK    PRIMARY KEY (club_id, sport, subscriptiontype, subscription_startdate),
  CONSTRAINT CLUBRAT_subtype_FK    FOREIGN KEY (club_id, subscriptiontype) REFERENCES Club_Subscriptiontypes,
  CONSTRAINT CLUBRAT_regdate_CHK     CHECK(registration_startdate < registration_enddate),
  CONSTRAINT CLUBRAT_subdate_CHK     CHECK(subscription_startdate < subscription_enddate)
);

INSERT INTO Club_Rates VALUES (	5003	,	'tennis'	,	'MINI'	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	15	,	15	);
INSERT INTO Club_Rates VALUES (	5003	,	'tennis'	,	'VOLWASSENEN'	,	TO_DATE('	2021	-	7	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	7	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	11	-	30	','yyyy-mm-dd')	,	70	,	70	);
INSERT INTO Club_Rates VALUES (	5003	,	'tennis'	,	'MAXI'	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	25	,	25	);
																																										
INSERT INTO Club_Rates VALUES (	2086	,	'tennis'	,	'MINI'	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	15	,	15	);
INSERT INTO Club_Rates VALUES (	2086	,	'tennis'	,	'VOLWASSENEN'	,	TO_DATE('	2021	-	7	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	7	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	10	-	31	','yyyy-mm-dd')	,	70	,	70	);
INSERT INTO Club_Rates VALUES (	2086	,	'tennis'	,	'MAXI'	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	25	,	25	);
																																										
INSERT INTO Club_Rates VALUES (	5004	,	'tennis'	,	'MINI'	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	15	,	15	);
INSERT INTO Club_Rates VALUES (	5004	,	'tennis'	,	'VOLWASSENEN'	,	TO_DATE('	2021	-	7	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	7	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	11	-	15	','yyyy-mm-dd')	,	70	,	70	);
INSERT INTO Club_Rates VALUES (	5004	,	'tennis'	,	'JUNIOR'	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	25	,	25	);
																																										
INSERT INTO Club_Rates VALUES (	5039	,	'tennis'	,	'MINI'	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	1	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	15	,	15	);
INSERT INTO Club_Rates VALUES (	5039	,	'tennis'	,	'VOLWASSENEN'	,	TO_DATE('	2021	-	6	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	5	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	11	-	10	','yyyy-mm-dd')	,	70	,	70	);
INSERT INTO Club_Rates VALUES (	5039	,	'tennis'	,	'JUNIOR'	,	TO_DATE('	2021	-	4	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	31	','yyyy-mm-dd')	,	TO_DATE('	2021	-	3	-	1	','yyyy-mm-dd')	,	TO_DATE('	2021	-	12	-	1	','yyyy-mm-dd')	,	25	,	25	);

INSERT INTO Club_Rates
  SELECT club_id,   'padel', subscriptiontype,  subscription_startdate,  subscription_enddate,
         registration_startdate,  registration_enddate , subscription_rate_existing, subscription_rate_new
  FROM Club_rates where club_id IN( 5003, 2086, 5039);

INSERT INTO Club_Rates
  SELECT club_id,   'tennis/padel', subscriptiontype,  subscription_startdate,  subscription_enddate,
         registration_startdate,  registration_enddate , subscription_rate_existing, subscription_rate_new
  FROM Club_rates where club_id IN( 5003, 2086, 5039) AND sport = 'tennis';

UPDATE Club_rates
   SET subscription_startdate = TO_DATE('2021-09-01','yyyy-mm-dd'),  
       subscription_enddate   = TO_DATE('2022-08-31','yyyy-mm-dd'),
       registration_startdate = TO_DATE('2021-08-01','yyyy-mm-dd'),  
       registration_enddate   = TO_DATE('2022-04-01','yyyy-mm-dd'),
       subscription_rate_existing = FLOOR(subscription_rate_existing * 8 / 10),
       subscription_rate_new = FLOOR(subscription_rate_new * 8 / 10)
   WHERE club_id = 5003 AND sport = 'padel';

