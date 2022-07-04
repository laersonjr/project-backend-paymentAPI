package com.laerson.trace.finance.paymentapi.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Getter
@Setter
public class PaymentWalletModel {

    @NotNull
    private BigDecimal amount;

    @NotNull
    @Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
    private String date;

}
