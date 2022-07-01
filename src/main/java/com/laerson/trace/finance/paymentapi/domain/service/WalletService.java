package com.laerson.trace.finance.paymentapi.domain.service;

import com.laerson.trace.finance.paymentapi.api.model.CreateWalletModel;
import com.laerson.trace.finance.paymentapi.domain.model.Wallet;
import com.laerson.trace.finance.paymentapi.domain.repository.WalletRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class WalletService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWalletService(CreateWalletModel createWalletModel){
        Wallet wallet = toEntity(createWalletModel);
        wallet.setWalletName(wallet.getOwnerName());
        wallet.setValue(BigDecimal.ZERO);
        wallet.setWalletOpening(LocalDateTime.now());
        return walletRepository.save(wallet);
    }

    private Wallet toEntity(CreateWalletModel createWalletModel){
        return modelMapper.map(createWalletModel, Wallet.class);
    }

}
