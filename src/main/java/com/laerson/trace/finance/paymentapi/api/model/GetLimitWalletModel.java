package com.laerson.trace.finance.paymentapi.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class GetLimitWalletModel extends IdSuperClass {

    private BigDecimal value;

}
