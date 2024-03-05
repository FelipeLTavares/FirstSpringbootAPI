CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    title VARCHAR(250),
    body TEXT,
    user_id INTEGER REFERENCES users(id)
);