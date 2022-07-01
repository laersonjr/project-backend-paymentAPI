package com.laerson.trace.finance.paymentapi.domain.repository;

import com.laerson.trace.finance.paymentapi.domain.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}