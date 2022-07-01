package com.laerson.trace.finance.paymentapi.domain.service;

import com.laerson.trace.finance.paymentapi.api.model.CreateWalletModel;
import com.laerson.trace.finance.paymentapi.domain.model.Wallet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private ModelMapper modelMapper;

    private Wallet toEntity(CreateWalletModel createWalletModel){
        return modelMapper.map(createWalletModel, Wallet.class);
    }

}
