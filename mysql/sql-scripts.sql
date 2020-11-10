

docker run -d -p 3306:3306 -v /Users/fedeberon/Desarrollo/data-mysql:/var/lib/mysql 45992f027f9d

--Usuario 1:
-- username: fede
-- password: fede

--Usuario 2:
-- username: cecilia
-- password: 4b4jRBVw

INSERT INTO USERS(USU_ID, USU_ENABLED, USU_PASSWORD, USU_USERNAME) VALUES
(1, true, '$2a$10$BruORvlxSYVoUUsVe7aFeeVWAtrjAADPCS4UGZKZ4EYO1yB5d/tDC', 'fede'),
(2, true, '$2a$10$0ofZFZq2LO3xmQbPSN22nuf1vbt3RyZSdIhhe./9vIIBTvLCOyuY6', 'cecilia');

-- --Insert de Sucursales
-- INSERT INTO SUCURSALES (SUC_ID, SUC_DIRECCION, SUC_MAIL, SUC_NAME, SUC_TELEFONO) VALUES
-- (0,'Av Lavalle 425', 'actualsupermercados@gmail.com', 'Lavalle', 'Tel (02314) 420791'),
-- (1,'Av Rivadavia 513', 'actualsupermercados@gmail.com', 'Las Flores', 'Tel (02244) 451666'),
-- (2,'Av. Brown 554', 'actualsupermercados@gmail.com', 'Brown', 'Tel (02314) 15538246'),
-- (3,'Av. Roca 363', 'actualsupermercados@gmail.com', 'Daireaux', 'Tel (02314) 15543063');
--
-- --Insert de Puestos
-- INSERT INTO PUESTOS (PUESTO_ID, PUESTO_NAME) VALUES
-- (0,'REPOSITOR'),
-- (1,'CARNICERIA'),
-- (2,'PANADERIA'),
-- (3,'VERDULERIA'),
-- (4,'CAJEROS'),
-- (5,'SUP. DE CAJAS'),
-- (6,'ENCARGADO');

SELECT audiences_provider_id
 FROM ads_ooh_screen
  WHERE `audiences_provider_id` = 46170,55780,55784,59965,69031,69033,69207,87084