package com.laerson.trace.finance.paymentapi.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateWalletModel extends IdSuperClass {

    @NotBlank
    private String ownerName;

}
