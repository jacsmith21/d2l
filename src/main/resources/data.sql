INSERT IGNORE INTO user (id, username, email, password, instructor)  VALUES (1, 'student', 'example@example.com', '$2a$10$5fh0xrsnizwp5WKqSO1kYeMPIeulnjUV.mBsgOGg7hrGoT9ZphcMW', FALSE );
INSERT IGNORE INTO user (id, username, email, password, instructor)  VALUES (2, 'instructor', 'example@example.com', '$2a$10$5fh0xrsnizwp5WKqSO1kYeMPIeulnjUV.mBsgOGg7hrGoT9ZphcMW', TRUE );

INSERT IGNORE INTO course (id, name, section, instructor_id) VALUES(1, 'ENGG1003', 'FR01A', 2);
INSERT IGNORE INTO course (id, name, section, instructor_id) VALUES(2, 'ENGG1015', 'FR01A', 2);
INSERT IGNORE INTO course (id, name, section, instructor_id) VALUES(3, 'ENGG1001', 'FR01A', 2);
INSERT IGNORE INTO course (id, name, section, instructor_id) VALUES(4, 'MATH1503', 'FR01A', 2);

INSERT IGNORE INTO course_students (enrolled_courses_id, students_id) VALUES(1,1);
INSERT IGNORE INTO course_students (enrolled_courses_id, students_id) VALUES(2,1);
INSERT IGNORE INTO course_students (enrolled_courses_id, students_id) VALUES(3,1);
INSERT IGNORE INTO course_students (enrolled_courses_id, students_id) VALUES(4,1);

INSERT IGNORE INTO deliverable VALUES(1, 'Assignment 1', 1);
INSERT IGNORE INTO deliverable VALUES(2, 'Assignment 2', 1);
INSERT IGNORE INTO deliverable VALUES(3, 'Assignment 1', 2);
INSERT IGNORE INTO deliverable VALUES(4, 'Assignment 1', 3);
INSERT IGNORE INTO deliverable VALUES(5, 'Assignment 1', 4);
