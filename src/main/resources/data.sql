-- Dodavanje uloge ADMIN i USER
INSERT INTO roles(name)
VALUES ('ROLE_ADMIN');
INSERT INTO roles(name)
VALUES ('ROLE_USER');
-- Dodavanje korisnika (lozinka treba biti enkriptovana!, lozinka je admin10)
INSERT INTO users(email, first_name, last_name, password)
VALUES (
        'admin@gmail.com',
        'admin1',
        'admin1',
        '$2a$10$hashedpassword'
    );
INSERT INTO user_roles(user_id, role_id)
VALUES (1, 1);
-- Admin ima ROLE_ADMIN
INSERT INTO user_roles(user_id, role_id)
VALUES (2, 2);
-- Korisnik ima ROLE_USER