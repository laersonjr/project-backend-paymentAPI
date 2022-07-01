CREATE TABLE wallet_payment
(
    id        BINARY(16)     NOT NULL,
    amount    DECIMAL      NOT NULL,
    date      VARCHAR(255) NOT NULL,
    id_wallet BINARY(16)     NOT NULL,
    CONSTRAINT pk_wallet_payment PRIMARY KEY (id)
);

ALTER TABLE wallet_payment
    ADD CONSTRAINT FK_WALLET_PAYMENT_ON_ID_WALLET FOREIGN KEY (id_wallet) REFERENCES wallet (id);