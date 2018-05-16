CREATE TABLE users (
  id         BIGSERIAL PRIMARY KEY,
  username   VARCHAR(255) UNIQUE,
  password   VARCHAR(255),
  firstname  VARCHAR(255),
  secondname VARCHAR(255),
  role       VARCHAR(255)
);

CREATE TABLE event (
  id          BIGSERIAL PRIMARY KEY,
  name        varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  start_date  TIMESTAMP    NOT NULL,
  end_date    TIMESTAMP,
  address     varchar(255),
  image_url   varchar(255),
  status      varchar(255)
);

CREATE TABLE tag (
  id       BIGSERIAL PRIMARY KEY,
  tag_name varchar(255) NOT NULL
);

CREATE TABLE user_tag (
  user_id bigint REFERENCES users (id),
  tags_id bigint REFERENCES tag (id)
);

CREATE TABLE event_tag (
  user_id  bigint REFERENCES users (id),
  event_id bigint REFERENCES event (id)
);
