package com.pjb.springbootweixinseller.service.impl;

import com.pjb.springbootweixinseller.dataobject.SellerInfo;
import com.pjb.springbootweixinseller.repository.SellerInfoRepository;
import com.pjb.springbootweixinseller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerInfoRepository repository;

    @Autowired
    public SellerServiceImpl(SellerInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
