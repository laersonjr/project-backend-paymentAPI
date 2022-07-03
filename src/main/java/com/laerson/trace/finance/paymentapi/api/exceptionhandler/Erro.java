package com.laerson.trace.finance.paymentapi.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Erro {

    private String mensagemUsuario;
    private String mensagemDesenvolvedor;
}
