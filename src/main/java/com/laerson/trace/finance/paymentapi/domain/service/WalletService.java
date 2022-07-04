package com.laerson.trace.finance.paymentapi.domain.service;


import com.laerson.trace.finance.paymentapi.api.exceptionhandler.ValueMostBePositiveExcpetion;
import com.laerson.trace.finance.paymentapi.api.model.CreateWalletModel;
import com.laerson.trace.finance.paymentapi.api.model.GetLimitWalletModel;
import com.laerson.trace.finance.paymentapi.api.model.PaymentWalletModel;
import com.laerson.trace.finance.paymentapi.domain.model.Wallet;
import com.laerson.trace.finance.paymentapi.domain.model.WalletPayment;
import com.laerson.trace.finance.paymentapi.domain.repository.WalletPaymentRepository;
import com.laerson.trace.finance.paymentapi.domain.repository.WalletRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class WalletService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletPaymentRepository walletPaymentRepository;

    public Wallet createWalletService(CreateWalletModel createWalletModel){
        Wallet wallet = toEntity(createWalletModel);
        wallet.setWalletName(wallet.getOwnerName());
        wallet.setValue(BigDecimal.ZERO);
        wallet.setWalletOpening(LocalDateTime.now());
        return walletRepository.save(wallet);
    }

    public GetLimitWalletModel availableLimitService(UUID walletId) {
        Wallet wallet = findWallet(walletId);
        return toModel(wallet);
    }

    public void makePaymentService(PaymentWalletModel paymentWalletModel, UUID walletId) {
        if (valueMostBePositive(paymentWalletModel.getAmount())) {
            Wallet wallet = findWallet(walletId);
            WalletPayment walletPayment = toEntityPayment(paymentWalletModel);
            walletPayment.setWallet(wallet);
            walletPaymentRepository.save(walletPayment);
        }
    }

    private boolean valueMostBePositive(BigDecimal value){
        if(value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValueMostBePositiveExcpetion();
        }
        return true;
    }

    private Wallet toEntity(CreateWalletModel createWalletModel){
        return modelMapper.map(createWalletModel, Wallet.class);
    }

    private GetLimitWalletModel toModel(Wallet wallet){
        return modelMapper.map(wallet, GetLimitWalletModel.class);
    }

    private Wallet findWallet(UUID id){
        Wallet wallet = walletRepository.getReferenceById(id);
        return wallet;
    }

    private WalletPayment toEntityPayment(PaymentWalletModel paymentWalletModel){
        return modelMapper.map(paymentWalletModel, WalletPayment.class);
    }

}
