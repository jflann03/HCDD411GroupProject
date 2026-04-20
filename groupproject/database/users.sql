 USE jupiter_company;
 

--    Username = first name, Password = test123
 
INSERT INTO users (username, password, enabled) VALUES
    ('james', '{bcrypt}$2a$12$key0.wEmg2Y9RnlEhebdru5mwbJPFMqXaAgqTu9uJ9j3txaiDFCFe', TRUE),
    ('maria', '{bcrypt}$2a$12$key0.wEmg2Y9RnlEhebdru5mwbJPFMqXaAgqTu9uJ9j3txaiDFCFe', TRUE),
    ('david', '{bcrypt}$2a$12$key0.wEmg2Y9RnlEhebdru5mwbJPFMqXaAgqTu9uJ9j3txaiDFCFe', TRUE),
    ('sarah', '{bcrypt}$2a$12$key0.wEmg2Y9RnlEhebdru5mwbJPFMqXaAgqTu9uJ9j3txaiDFCFe.', TRUE);
 
INSERT INTO authorities (username, authority) VALUES
    ('james', 'ROLE_SUPERVISOR'),
    ('maria', 'ROLE_MANAGER'),
    ('david', 'ROLE_MANAGER'),
    ('sarah', 'ROLE_ADMIN');
 
INSERT INTO employees (
    first_name,
    last_name,
    start_date,
    start_salary,
    employee_contract_signed,
    social_security_number,
    birthdate,
    phone_number,
    emergency_contact_name,
    emergency_contact_phone_number
) VALUES
    ('Robert',  'Harris',   '2020-02-10', 52000.00, TRUE,  '55566677788', '1990-04-14', '814-555-1001', 'Susan Harris',   '814-555-1002'),
    ('Emily',   'Nguyen',   '2021-08-23', 58000.00, TRUE,  '66677788899', '1994-07-30', '814-555-1003', 'Kevin Nguyen',   '814-555-1004'),
    ('Carlos',  'Rivera',   '2019-11-05', 61000.00, FALSE, '77788899900', '1987-01-22', '814-555-1005', 'Ana Rivera',     '814-555-1006'),
    ('Jessica', 'Thompson', '2022-03-14', 54500.00, TRUE,  '88899900011', '1996-09-03', '814-555-1007', 'Mark Thompson',  '814-555-1008'),
    ('Michael', 'Brown',    '2018-06-01', 67000.00, TRUE,  '99900011122', '1983-11-17', '814-555-1009', 'Patricia Brown', '814-555-1010');
