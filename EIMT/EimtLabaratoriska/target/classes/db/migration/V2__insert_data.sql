INSERT INTO country (name, continent) VALUES
                                          ('North Macedonia', 'Europe'),
                                          ('Germany', 'Europe'),
                                          ('USA', 'North America');
INSERT INTO host (name, surname, country_id, created_at, updated_at) VALUES
                                                                         ('Petar', 'Petrovski', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                         ('Hans', 'Müller', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                         ('John', 'Doe', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO accommodation (name, category, host_id, num_rooms, rented, condition, created_at, updated_at) VALUES
                                                                                                              ('Skopje Central Apartment', 'APARTMENT', 1, 3, false, 'GOOD', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                              ('Berlin Cozy Studio', 'FLAT', 2, 1, false, 'BAD', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                              ('Lakeview Villa', 'HOUSE', 1, 5, true, 'GOOD', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                              ('NYC Loft', 'FLAT', 3, 2, false, 'BAD', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);