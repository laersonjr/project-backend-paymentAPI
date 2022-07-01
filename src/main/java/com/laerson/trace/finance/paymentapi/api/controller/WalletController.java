package com.laerson.trace.finance.paymentapi.api.controller;

import com.laerson.trace.finance.paymentapi.domain.model.Wallet;
import com.laerson.trace.finance.paymentapi.domain.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<Wallet> criarWallet(@Valid @RequestBody Wallet wallet){
        Wallet walletSalva = walletRepository.save(wallet);
        return ResponseEntity.status(HttpStatus.CREATED).body(walletSalva);
    }

}
