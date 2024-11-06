INSERT INTO users (name, email, password)
VALUES ('User1', 'xuanloc.le@miu.edu', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2') --123
     , ('User2', 'test@miu.edu', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2')       --123
     , ('User3', 'test2@miu.edu', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO user_roles (roles_id, users_id)
VALUES (1, 1);
INSERT INTO user_roles (users_id, roles_id)
VALUES (2, 1);
INSERT INTO user_roles (users_id, roles_id)
VALUES (3, 2);

INSERT INTO posts (title, content, author, user_id)
VALUES ('Title1', 'Content1', 'Author1', 1);

INSERT INTO posts (title, content, author, user_id)
VALUES ('Title2', 'Content2', 'Author2', 1);

INSERT INTO posts (title, content, author, user_id)
VALUES ('Title3', 'Content3', 'Author3', 2);

INSERT INTO comments (name, post_id)
VALUES ('Test Comment1', 1),
       ('Test Comment2', 1),
       ('Test Comment3', 2)
