use planetlister_db;

SELECT * from planets;
SELECT * from users;
SELECT planets.planetname, planets.planetdesc, planets.id from users join planets on users.id = planets.user_id WHERE users.id = 3;