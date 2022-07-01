package com.laerson.trace.finance.paymentapi.domain.repository;

import com.laerson.trace.finance.paymentapi.domain.model.WalletPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletPaymentRepository extends JpaRepository<WalletPayment, UUID> {
}