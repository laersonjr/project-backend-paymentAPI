CREATE TABLE wallet
(
    id             BINARY(16)    NOT NULL,
    name           VARCHAR(255) NOT NULL,
    wallet_name    VARCHAR(255) NOT NULL,
    value          DECIMAL      NOT NULL,
    wallet_opening DATETIME     NOT NULL,
    CONSTRAINT pk_wallet PRIMARY KEY (id)
);