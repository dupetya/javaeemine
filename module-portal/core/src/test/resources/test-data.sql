INSERT INTO users (id, username, pass, email, dob)
	VALUES (1, 'TestAcc1', 'TestPass1', 'test@email.com', TO_DATE('1991-01-01', 'YYYY-MM-DD'));
	
INSERT INTO roles (role_id, role_name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (role_id, role_name) VALUES (2, 'ROLE_MOD');
INSERT INTO roles (role_id, role_name) VALUES (3, 'ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES (1,1);