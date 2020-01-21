use planetlister_db;

INSERT INTO users (username, email, password)
VALUES ('SpaceVulf', 'BigKahunaJW@gmail.com', 'hunter123'),
       ('EddieV', 'EduardoLovesSpace@gmail.com', 'mars4lyfe'),
       ('KennyKen', 'ken2cool@yahoo.com', 'muskymusk');

INSERT INTO planets (planetname, planetdesc, user_id)
VALUES ('Earth', 'Shields up. I recommend we transfer power to phasers and arm the photon torpedoes. Something strange on the detector circuit. The weapons must have disrupted our communicators. You saw something as tasty as meat, but inorganically materialized out of patterns used by our transporters. Captain, the most elementary and valuable statement in science, the beginning of wisdom - All transporters off.
', 1),
       ('Mars', 'Planet Earth contains a large number of life forms. Some of them are intelligent. Water is prevalent across the planet, with many weather features and differing terrains. You can find the sentient species of Human widespread across multiple continents, and they are currently surviving and evolving into a post-information age. It remains to be seen the effects of climate change on the planet, and there is still a possibility of catastrophic warfare or other disasters.

At this time though, Planet Earth hums along as the only example of a habitable world found with significant life and an example of sentient.', 1),
       ('Mercury', 'Shields up. I recommend we transfer power to phasers and arm the photon torpedoes. Something strange on the detector circuit. The weapons must have disrupted our communicators. You saw something as tasty as meat, but inorganically materialized out of patterns used by our transporters. Captain, the most elementary and valuable statement in science, the beginning of wisdom - All transporters off.
', 1),
       ('Venus', 'Shields up. I recommend we transfer power to phasers and arm the photon torpedoes. Something strange on the detector circuit. The weapons must have disrupted our communicators. You saw something as tasty as meat, but inorganically materialized out of patterns used by our transporters. Captain, the most elementary and valuable statement in science, the beginning of wisdom - All transporters off.
', 2),
       ('Jupiter', 'I have reset the sensors to scan for frequencies outside the usual range. By emitting harmonic vibrations to shatter the lattices. We will monitor and adjust the frequency of the resonators. He has this ability of instantly interpreting and extrapolating any verbal communication he hears. It may be due to the envelope over the structure, causing hydrogen-carbon helix patterns throughout. I\'m comparing the molecular integrity of that bubble against our phasers.', 2),
       ('Neptune', 'I have reset the sensors to scan for frequencies outside the usual range. By emitting harmonic vibrations to shatter the lattices. We will monitor and adjust the frequency of the resonators. He has this ability of instantly interpreting and extrapolating any verbal communication he hears. It may be due to the envelope over the structure, causing hydrogen-carbon helix patterns throughout. I\'m comparing the molecular integrity of that bubble against our phasers.', 2),
       ('Uranus', 'I have reset the sensors to scan for frequencies outside the usual range. By emitting harmonic vibrations to shatter the lattices. We will monitor and adjust the frequency of the resonators. He has this ability of instantly interpreting and extrapolating any verbal communication he hears. It may be due to the envelope over the structure, causing hydrogen-carbon helix patterns throughout. I\'m comparing the molecular integrity of that bubble against our phasers.', 3),
       ('Saturn', 'I have reset the sensors to scan for frequencies outside the usual range. By emitting harmonic vibrations to shatter the lattices. We will monitor and adjust the frequency of the resonators. He has this ability of instantly interpreting and extrapolating any verbal communication he hears. It may be due to the envelope over the structure, causing hydrogen-carbon helix patterns throughout. I\'m comparing the molecular integrity of that bubble against our phasers.', 3),
       ('Pluto', 'I have reset the sensors to scan for frequencies outside the usual range. By emitting harmonic vibrations to shatter the lattices. We will monitor and adjust the frequency of the resonators. He has this ability of instantly interpreting and extrapolating any verbal communication he hears. It may be due to the envelope over the structure, causing hydrogen-carbon helix patterns throughout. I\'m comparing the molecular integrity of that bubble against our phasers.', 3);

INSERT INTO categories (name)
VALUES ('rings'),
       ('moons'),
       ('terrestrial'),
       ('gas giant'),
       ('ice giant'),
       ('dwarf'),
       ('asteroid'),
       ('habitable'),
       ('water giant');

INSERT INTO ad_category(planet_id, category_id)
VALUES (1,3),
       (1,8),
       (2, 2),
       (5,2),
       (5,4),
       (6,2),
       (6,4),
       (7,4),
       (8,1),
       (8,4),
       (9,6);





#     SELECT * FROM users;
#     SELECT * FROM planets;
#     SELECT * FROM categories;
#     SELECT * FROM ad_category;
#     SELECT * FROM planets WHERE id = 2;
#
#     SELECT planetname, c.name FROM planets JOIN ad_category ac on planets.id = ac.planet_id
# JOIN categories c on ac.category_id = c.id;