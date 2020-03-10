INSERT INTO tbl_group (symbol, name) VALUES ('Ia', 'Grupa Ia');

INSERT INTO tbl_student (first_name, last_name, email, group_id) VALUES ('Jan', 'Kowalski', 'jan@kowalski.pl', (select id from tbl_group where symbol = 'Ia'));
INSERT INTO tbl_student (first_name, last_name, email, group_id) VALUES ('Piotr', 'Nowak', 'piotr@nowak.pl', (select id from tbl_group where symbol = 'Ia'));
INSERT INTO tbl_student (first_name, last_name, email, group_id) VALUES ('Anna', 'Wiśniewska', 'anna@wisniewska.pl', (select id from tbl_group where symbol = 'Ia'));