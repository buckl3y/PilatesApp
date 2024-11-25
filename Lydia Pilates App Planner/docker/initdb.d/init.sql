CREATE TABLE users (
    id INTEGER PRIMARY KEY,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (id, email, password) VALUES
(1, 'admin@admin.com', 'admin');