CREATE TABLE Zanr(
	 IDZ varchar(5) NOT NULL,
	 NAZIVZ varchar(30) NOT NULL,	      	 
	 CONSTRAINT Zanr_PK PRIMARY KEY (IDZ)		      	 
);

CREATE TABLE Bioskop(
	 IDB varchar(5) NOT NULL,
	 NAZIVB varchar(30) NOT NULL,
	 MESTOB varchar(30) NOT NULL, 
	 CONSTRAINT Bioskop_PK PRIMARY KEY (IDB)	 
);

CREATE TABLE Film(
	 IDF varchar(5) NOT NULL,
	 NAZIVF varchar(35) NOT NULL,	
     TRAJANJE decimal(10,2) NOT NULL,
	 IDZ varchar(5) NOT NULL,
	 CONSTRAINT Film_PK PRIMARY KEY (IDF),
	 CONSTRAINT Film_Zanr_FK FOREIGN KEY (IDZ) REFERENCES Zanr(IDZ) 	      	 
);

CREATE TABLE Projekcija(
	 IDB varchar(5) NOT NULL,	 
	 IDF varchar(5) NOT NULL,
   	 DATUM date NOT NULL,
   	 CENAKARTE decimal(10,2),
   	 CONSTRAINT Projekcija_PK PRIMARY KEY (IDB, IDF, DATUM),
	 CONSTRAINT Projekcija_Bioskop_FK FOREIGN KEY (IDB) REFERENCES Bioskop(IDB),
	 CONSTRAINT Projekcija_Film_FK FOREIGN KEY (IDF) REFERENCES Film(IDF)         
);
