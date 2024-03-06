CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    title VARCHAR(250),
    body TEXT,
    userId INTEGER REFERENCES users(id)
);