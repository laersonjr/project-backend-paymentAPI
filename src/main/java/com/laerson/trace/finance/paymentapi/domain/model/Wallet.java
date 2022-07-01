package com.laerson.trace.finance.paymentapi.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private UUID id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String ownerName;

    @Column(name = "wallet_name", nullable = false)
    private String walletName;

    @Column(nullable = false)
    public BigDecimal value;

    @Column(name = "wallet_opening", nullable = false)
    public LocalDateTime walletOpening;

}
