package com.laerson.trace.finance.paymentapi.api.controller;

import com.laerson.trace.finance.paymentapi.api.model.CreateWalletModel;
import com.laerson.trace.finance.paymentapi.api.model.GetLimitWalletModel;
import com.laerson.trace.finance.paymentapi.api.model.PaymentWalletModel;
import com.laerson.trace.finance.paymentapi.domain.model.Wallet;
import com.laerson.trace.finance.paymentapi.domain.repository.WalletRepository;
import com.laerson.trace.finance.paymentapi.domain.service.WalletService;
import com.laerson.trace.finance.paymentapi.event.RecursoCriadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletService walletService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Wallet> listarWallet(){
        return walletRepository.findAll();
    }

    @GetMapping("/{walletId}/limits")
    public ResponseEntity<GetLimitWalletModel> availableLimit(@PathVariable UUID walletId){
        GetLimitWalletModel limitWallet = walletService.availableLimitService(walletId);
        return ResponseEntity.ok(limitWallet);
    }

    @PostMapping
    public ResponseEntity<Wallet> criarWallet(@Valid @RequestBody CreateWalletModel createWalletModel,
                                              HttpServletResponse response){
        Wallet walletSalva = walletService.createWalletService(createWalletModel);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, walletSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(walletSalva);
    }

    @PostMapping("/{walletId}/payments")
    @ResponseStatus(HttpStatus.OK)
    public void makePayment(@Valid @RequestBody PaymentWalletModel paymentWalletModel,
                            @PathVariable UUID walletId) {
        walletService.makePaymentService(paymentWalletModel, walletId);
    }

}
