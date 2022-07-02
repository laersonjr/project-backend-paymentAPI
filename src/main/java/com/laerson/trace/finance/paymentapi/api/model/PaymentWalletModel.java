package com.laerson.trace.finance.paymentapi.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class PaymentWalletModel {

    @NotNull
    private BigDecimal amount;

    @NotNull
    private String date;

}
