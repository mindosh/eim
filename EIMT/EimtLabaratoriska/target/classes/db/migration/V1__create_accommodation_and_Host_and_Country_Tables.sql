CREATE TABLE country(
                        id bigserial PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        continent VARCHAR(255) NOT NULL
);

CREATE TABLE host(
                     id bigserial PRIMARY KEY,
                     created_at TIMESTAMP NOT NULL,
                     updated_at TIMESTAMP NOT NULL,
                     name VARCHAR(255) NOT NULL,
                     surname VARCHAR(255) NOT NULL,
                     country_id bigint  NOT NULL REFERENCES country(id) ON DELETE CASCADE
);

CREATE TABLE accommodation
(
    id         bigserial PRIMARY KEY,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NOT NULL,
    name       VARCHAR(255) NOT NULL,
    category   VARCHAR(255) NOT NULL,
    host_id    bigint NOT NULL references host (id) ON DELETE CASCADE,
    num_rooms int NOT NULL,
    rented BOOLEAN NOT NULL DEFAULT FALSE,
    condition VARCHAR(255) NOT NULL
);