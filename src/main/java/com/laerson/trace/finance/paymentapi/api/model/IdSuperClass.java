package com.laerson.trace.finance.paymentapi.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;


import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class IdSuperClass {

    private UUID id;

}
