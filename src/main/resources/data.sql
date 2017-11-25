SET @@global.sql_mode= 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

INSERT IGNORE INTO user (id, username, email, password, instructor)  VALUES (1, 'student', 'example@example.com', '$2a$10$5fh0xrsnizwp5WKqSO1kYeMPIeulnjUV.mBsgOGg7hrGoT9ZphcMW', FALSE );
INSERT IGNORE INTO user (id, username, email, password, instructor)  VALUES (2, 'instructor', 'example@example.com', '$2a$10$5fh0xrsnizwp5WKqSO1kYeMPIeulnjUV.mBsgOGg7hrGoT9ZphcMW', FALSE );
INSERT IGNORE INTO course (id, name, section, instructor_id) VALUES(1, 'ENGG1003', 'FR01A', 2);
INSERT IGNORE INTO course (id, name, section, instructor_id) VALUES(2, 'ENGG1015', 'FR01A', 2);
INSERT IGNORE INTO course (id, name, section, instructor_id) VALUES(3, 'ENGG1001', 'FR01A', 2);
INSERT IGNORE INTO course (id, name, section, instructor_id) VALUES(4, 'MATH1503', 'FR01A', 2);
INSERT IGNORE INTO course_students (enrolled_courses_id, students_id) VALUES(1,1);
INSERT IGNORE INTO course_students (enrolled_courses_id, students_id) VALUES(2,1);
INSERT IGNORE INTO course_students (enrolled_courses_id, students_id) VALUES(3,1);
INSERT IGNORE INTO course_students (enrolled_courses_id, students_id) VALUES(4,1);
