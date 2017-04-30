-- 1. Könyv, film, cd felvétele:
INSERT INTO KONYV (ID, CIM, OLDALSZAM, KIADIDO, KIADASSZAMA, SZERZO, TARSSZERZO, KIADO, VASARLASSZAM, MERET, KOTES, AR, MUFAJ, ALMUFAJ, EBOOK, ISBN13)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

INSERT INTO FILM(ID, CIM, MUFAJ, BLURAYE, RENDEZO, AR) -- itt a filmnél elfelejtettük felvenni az adatbázisban az AR attribútumot
VALUES(?, ?, ?, ?, ?);

INSERT INTO ALBUM(ID, ELOADO, CIM, MUFAJ, AR)
VALUES (? , ?, ?, ?, ?);



-- 2. Műfajok és alműfajok szerinti lekérdezés:
SELECT * FROM
FROM KONYV
ORDER BY MUFAJ;

SELECT * FROM
FROM KONYV
ORDER BY ALMUFAJ;



-- 3. Vásárlás: (termékekhez nem vettünk fel darabszámot):

UPDATE KONYV 
SET DARABSZAM = DARABSZAM-1
WHERE ID ='?'; --megvásárloni kívánt könyv ID-ja

UPDATE FILM
SET DARABSZAM = DARABSZAM-1
WHERE ID ='?';

UPDATE ALBUM
SET DARABSZAM = DARABSZAM-1
WHERE ID ='?';

SELECT DARABSZAM --darabszámok lekérdezése, azért, hogy ha nincs több elérhető, ne lehessen vásárolni belőle
FROM KONYV;

SELECT DARABSZAM
FROM ALBUM;

SELECT DARABSZAM
FROM FILM;

------

INSERT INTO RENDELES(ID, TERMEKID, TERMEKTIPUS, VASARLOID, RENDELESID)
VALUES(?, ?, ?, ?, ?);

UPDATE VASARLO
SET OSSZESKOLTSEG = OSSZESKOLTSEG + KONYV.AR,
	TETELSZAM = TETELSZAM + 1
WHERE ID='?';


-- 4. Műfajok szerint hány könyv elérhető: 

SELECT SUM(DARABSZAM)
FROM KONYV
GROUP BY MUFAJ;

-- vagy:

SELECT SUM(DARABSZAM)
FROM KONYV
WHERE MUFAJ='?';


-- 5. Keresés címre, szerzőre, találatok számának kigyűjtése:

DECLARE 
	v_cim KONYV.cim%ROWTYPE;
BEGIN
	SELECT *
	INTO v_cim
	FROM KONYV
	WHERE KONYV.CIM='?';
	SQL%ROWCOUNT;
END;

--

DECLARE 
	v_szerzo KONYV.szerzo%ROWTYPE;
BEGIN
	SELECT *
	INTO v_szerzo
	FROM KONYV
	WHERE KONYV.SZERZO=' ';
	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT);
END;

--

DECLARE 
	v_tarsszerzo KONYV.tarsszerzo%ROWTYPE;
BEGIN
	SELECT *
	INTO v_tarsszerzo
	FROM KONYV
	WHERE KONYV.TARSSZERZO=' ';
	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT);
END;


-- 6. Legújabb könyvek:

SELECT CIM
FROM KONYV
ORDER BY kiadido
LIMIT 20; -- 20 legújabb könyv

-- 7. Mely könyvek kaphatók egy áruházban? Egy adott könyv mely áruházban kapható? (a termékekhez fel kell vennünk egy ARUHAZ.ID-t, és NEV-et, és a kulcsnak ID+ARUHAZ.ID-nek kell lennie)

SELECT * 
FROM KONYV
WHERE KONYV.ID=ARUHAZ.ID
GROUP BY ARUHAZ.ID;

SELECT KONYV.CIM, ARUHAZ.NEV
FROM KONYV, ARUHAZ
WHERE KONYV.ID=ARUHAZ.ID AND KONYV.CIM=' ';


-- 8. Regisztráció:

INSERT INTO VASARLO(ID, NEV, SZAMLACIM, SZALLITCIM, SZALLITCIM2, TORZSE, OSSZESKOLTSEG, TETELSZAM)
VALUES (?, ?, ?, ?, ?, ?, ?, ?);

-- 9. Készlet nyilvántartása boltonként, figyelmeztetés:

CREATE TRIGGER konyv_kifogy
AFTER UPDATE OF DARABSZAM ON KONYV
FOR EACH ROW
WHEN(NEW.DARABSZAM<2)
BEGIN
	DBMS_OUTPUT.PUT_LINE ('A készlet ki fog fogyni!');
END;

--

CREATE TRIGGER FILM_kifogy
AFTER UPDATE OF DARABSZAM ON FILM
FOR EACH ROW
WHEN(NEW.DARABSZAM<2)
BEGIN
	DBMS_OUTPUT.PUT_LINE ('A készlet ki fog fogyni!');
END;

--

CREATE TRIGGER album_kifogy
AFTER UPDATE OF DARABSZAM ON ALBUM
FOR EACH ROW
WHEN(NEW.DARABSZAM<2)
BEGIN
	DBMS_OUTPUT.PUT_LINE ('A készlet ki fog fogyni!');
END;

-- 10. „Olcsó könyvek” kilistázása árkategóriánként:

