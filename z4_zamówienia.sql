CREATE TABLE wykaz_zamówień (
numer_zamówienia INT(6) NOT NULL,
nazwa_klienta VARCHAR(255) NOT NULL,
adres_klienta VARCHAR(255) NOT NULL,
data_zamówienia DATE,
szczegóły_zamówienia VARCHAR(255) NOT NULL
);

INSERT INTO wykaz_zamówień
VALUES
(200, 'Jan Kowalski', 'Sosnowiec, 40-210 ul. Rewolucji 1905r 11 m 33, woj. śląskie', '2019-05-01', 'Buty 250 PLN - 23% VAT; Koszulka 100 PLN - 23% VAT'),
(203, 'Jan Kowalski', 'Sosnowiec, 40-210 ul. Rewolucji 1905r 11 m 33, woj. śląskie', '2019-05-05', 'Ebook 20 PLN - 5% VAT'),
(204, 'Jan Kowalski', 'Sosnowiec, 40-210 ul. Rewolucji 1905r 11 m 33, woj. śląskie', '2019-05-08', 'Skarpetki 15 PLN - 23% VAT; Hulajnoga 100 PLN - 23% VAT'),
(202, 'Kamil Wąs', 'Warszawa, 02-290 ul. Hoża 1 m 56; woj. mazowieckie', '2019-05-02', 'Narty 1200 PLN - 23% VAT'),
(205, 'Michał Dobosz', 'Szczecin, 70-004 ul. Mariacka 75 m 40, woj. zachodniopomorskie', '2019-05-09', 'Skarpetki 5 PLN - 23% VAT; Koszulka 50 PLN - 23% VAT'),
(201, 'Piotr Nowak', 'Kraków, 22-178 ul. Prosta 12 m 1; woj. małopolskie', '2019-05-02', 'Narty 2400 PLN - 23% VAT');

SELECT * FROM wykaz_zamówień;
