package com.laerson.trace.finance.paymentapi.event.listener;

import com.laerson.trace.finance.paymentapi.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.UUID;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvent event) {
        HttpServletResponse response = event.getResponse();
        UUID walletId = event.getWalletId();

        adicionarHeaderLocation(walletId, response);
    }

    private void adicionarHeaderLocation(UUID walletId, HttpServletResponse response) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{walletId}")
                .buildAndExpand(walletId).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
