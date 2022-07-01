package com.laerson.trace.finance.paymentapi.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "wallet_payment")
public class WalletPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private String date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_wallet")
    private Wallet wallet;

}
