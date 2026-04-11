



CREATE TABLE videos (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    created_at DATE DEFAULT CURRENT_DATE,
    published BOOLEAN DEFAULT FALSE
);



-- Do not modify below this line --
SELECT table_name, column_name, data_type
FROM information_schema.columns
WHERE table_name = 'videos';
