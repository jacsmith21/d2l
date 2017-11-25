SET @@global.sql_mode= 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

INSERT IGNORE INTO user (id, username, email, password, instructor)  VALUES (1, 'student', 'example@example.com', '$2a$10$5fh0xrsnizwp5WKqSO1kYeMPIeulnjUV.mBsgOGg7hrGoT9ZphcMW', FALSE );
