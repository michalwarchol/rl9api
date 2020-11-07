CREATE TABLE t_match(
    id UUID NOT NULL PRIMARY KEY,
    "date" DATE NOT NULL,
    goals INT NOT NULL,
    assists INT NOT NULL,
    yellow_cards INT NOT NULL,
    red_cards INT NOT NULL,
    team VARCHAR(50) NOT NULL,
    opponent VARCHAR(50) NOT NULL,
    competition VARCHAR(40) NOT NULL,
    season VARCHAR(9) NOT NULL
);