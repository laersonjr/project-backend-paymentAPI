package com.laerson.trace.finance.paymentapi.api.controller;

import com.laerson.trace.finance.paymentapi.api.model.CreateWalletModel;
import com.laerson.trace.finance.paymentapi.domain.model.Wallet;
import com.laerson.trace.finance.paymentapi.domain.repository.WalletRepository;
import com.laerson.trace.finance.paymentapi.domain.service.WalletService;
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

    @Autowired
    private WalletService walletService;

    @GetMapping
    public List<Wallet> listarWallet(){
        return walletRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Wallet> criarWallet(@Valid @RequestBody CreateWalletModel createWalletModel){
        Wallet walletSalva = walletService.createWalletService(createWalletModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(walletSalva);
    }

}
