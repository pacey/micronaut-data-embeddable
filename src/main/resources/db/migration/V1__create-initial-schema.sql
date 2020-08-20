CREATE TABLE persistence_details
(
    id IDENTITY PRIMARY KEY,
    first_bucket VARCHAR,
    first_path VARCHAR,
    second_bucket VARCHAR,
    second_path VARCHAR
);

CREATE TABLE parent
(
    id IDENTITY PRIMARY KEY,
    persistence_details_id BIGINT REFERENCES persistence_details (id)
);
