INSERT INTO client
(name)
VALUES
('Anna'),
('Brennan'),
('Candice'),
('Derek'),
('Evan'),
('Fred'),
('Grant'),
('Hanna'),
('Iris'),
('Julian');

INSERT INTO planet
(id, name)
VALUES
('PLANET1', 'MERCURY'),
('PLANET2', 'VENUS'),
('PLANET3', 'EARTH'),
('PLANET4', 'MARS'),
('PLANET5', 'URANUS');

INSERT INTO ticket
(client_id, from_planet_id, to_planet_id)
VALUES
(1, 'PLANET1', 'PLANET2'),
(2, 'PLANET2', 'PLANET3'),
(3, 'PLANET3', 'PLANET4'),
(4, 'PLANET4', 'PLANET5'),
(5, 'PLANET5', 'PLANET1'),
(6, 'PLANET2', 'PLANET1'),
(7, 'PLANET3', 'PLANET2'),
(8, 'PLANET4', 'PLANET3'),
(9, 'PLANET5', 'PLANET4'),
(10, 'PLANET1', 'PLANET5');



