package com.laerson.trace.finance.paymentapi.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Getter
public class RecursoCriadoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private HttpServletResponse response;
    private UUID walletId;

    public RecursoCriadoEvent(Object source, HttpServletResponse response,UUID walletId) {
        super(source);
        this.response = response;
        this.walletId = walletId;
    }

}
