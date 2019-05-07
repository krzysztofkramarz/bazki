CREATE TABLE ZAJECIA(
    NAZWA VARCHAR (255) NOT NULL,
    RODZAJ VARCHAR (255) NOT NULL,
    NRSTUDENTA INT NOT NULL,
    STUDENT VARCHAR (255) NOT NULL,
    WYKLADOWCA VARCHAR (255)
);
INSERT INTO ZAJECIA (NAZWA, RODZAJ, NRSTUDENTA, STUDENT, WYKLADOWCA) VALUES
('Podstawy Baz Danych', 'ćwiczenia, laboratorium', 14, 'Piotr Piotrowski', 'Jan Nowak');
INSERT INTO ZAJECIA (NAZWA, RODZAJ, NRSTUDENTA, STUDENT, WYKLADOWCA) VALUES
('Podstawy języka Java', 'laboratorium, ćwiczenia', 14, 'Piotr Piotrowski',
'Jan Kowalski');
INSERT INTO ZAJECIA (NAZWA, RODZAJ, NRSTUDENTA, STUDENT, WYKLADOWCA) VALUES
('Analiza Matematyczna', 'wykład', 3, 'Garbriel Gabrowski', 'Barbara Borowska');

