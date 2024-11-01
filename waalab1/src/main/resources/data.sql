INSERT INTO users (name)
VALUES ('User1');

INSERT INTO users (name)
VALUES ('User2');

INSERT INTO users (name)
VALUES ('User3');


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
