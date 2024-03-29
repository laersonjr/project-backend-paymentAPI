package com.laerson.trace.finance.paymentapi.domain.repository;

import com.laerson.trace.finance.paymentapi.domain.model.WalletPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletPaymentRepository extends JpaRepository<WalletPayment, UUID> {

    @Query(nativeQuery = true, value = "SELECT COALESCE(SUM(amount), 0) FROM wallet_payment WHERE date = :date AND id_wallet = :id_wallet")
    public BigDecimal sumAmount(@Param("date") String date, @Param("id_wallet") UUID id);

}