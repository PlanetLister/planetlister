use planetlister_db;

SELECT * from planets;
SELECT * from users;
SELECT planets.planetname, planets.planetdesc, planets.id from users join planets on users.id = planets.user_id WHERE users.id = 3;
# COME BACK FROM LUNCH : show me the USER and USER'S EMAIL from PLANETS using the PLANET'S IDENTIFICATION to SHOW THE USER WHO CREATED IT ~
SELECT users.username, users.email from planets join users on planets.user_id = users.id WHERE planets.id = 4;


SELECT * from users;