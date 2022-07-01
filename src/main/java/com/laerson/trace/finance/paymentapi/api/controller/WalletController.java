package com.laerson.trace.finance.paymentapi.api.controller;

import com.laerson.trace.finance.paymentapi.domain.model.Wallet;
import com.laerson.trace.finance.paymentapi.domain.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletRepository walletRepository;

    @GetMapping
    public List<Wallet> listarWallet(){
        return walletRepository.findAll();
    }

}
