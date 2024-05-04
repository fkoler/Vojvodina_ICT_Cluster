/*1. Prikazati šifre i nazive filmova (IDF, NAZIVF) 
čiji naziv počinje na veliko slovo ‘T’ sortirano u rastućem redosledu IDF.*/

SELECT IDF, NAZIVF
FROM FILM
WHERE NAZIVF LIKE 'T%'
ORDER BY IDF ASC;

/*2. Prikazati naziv i trajanje (NAZIVF, TRAJANJE) svih filmova koji traju izmedju 130 i 150 minuta 
(uzeti u obzir i granične vrednosti) kao i nazive žanrova tih filmova. */

SELECT F.NAZIVF AS 'NAZIV FILMA', F.TRAJANJE, Z.NAZIVZ AS 'NAZIV ZANRA'
FROM FILM AS F
JOIN ZANR AS Z ON F.IDZ = Z.IDZ
WHERE F.TRAJANJE BETWEEN 130 AND 150
ORDER BY F.TRAJANJE;

/*3. Povećati iznos cene karte za bioskopsku projekciju za 20%, 
ali samo za projekcije gde je cena manja od 300 
(vrednosti moraju biti promenjene u tabeli).  */

UPDATE PROJEKCIJA AS P
JOIN FILM AS F ON P.IDF = F.IDF
SET P.CENAKARTE = P.CENAKARTE * 1.2
WHERE P.CENAKARTE < 300;

SELECT F.NAZIVF AS 'NAZIV FILMA', P.CENAKARTE AS 'NOVA CENA KARTE'
FROM FILM AS F
JOIN PROJEKCIJA AS P ON F.IDF = P.IDF
ORDER BY P.CENAKARTE;

/*4. Prikazati šifre i nazive bioskopa (IDB, NAZIVB) koji nemaju projekcije.*/

SELECT B.IDB, B.NAZIVB
FROM BIOSKOP AS B
LEFT JOIN PROJEKCIJA AS P ON B.IDB = P.IDB
WHERE P.IDB IS NULL;

/*5. Kreirati pogled pod nazivom Bioskopi_V koji će prikazivati  
šifre i nazive bioskopa (IDB, NAZIVB) u kojima se prikazuje više od 2 različita filma.*/

CREATE VIEW Bioskopi_V AS
SELECT P.IDB, B.NAZIVB
FROM (
    SELECT IDB
    FROM PROJEKCIJA
    GROUP BY IDB
    HAVING COUNT(DISTINCT IDF) > 2
) AS P
JOIN BIOSKOP AS B ON P.IDB = B.IDB;
SELECT * FROM Bioskopi_V; 

/*6. Za sve filmove prikazati šifru i naziv (IDF, NAZIVF) kao i naziv bioskopa u kojima se prikazuju. 
Iste podatke prikazati za filmove koji nemaju nijednu projekciju, 
ali u tom slučaju umesto  naziva bioskopa ispisati „Nema projekciju“.*/

SELECT F.IDF, F.NAZIVF AS 'NAZIV FILMA', IFNULL(B.NAZIVB, 'Nema projekciju') AS 'NAZIV BIOSKOPA'
FROM FILM AS F
LEFT JOIN PROJEKCIJA AS P ON F.IDF = P.IDF
LEFT JOIN BIOSKOP AS B ON P.IDB = B.IDB;
