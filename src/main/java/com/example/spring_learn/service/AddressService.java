package com.example.spring_learn.service;

import com.example.spring_learn.models.Address;
import com.example.spring_learn.repository.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    public Address saveAddress(Address ad){

        return addressDao.save(ad);
    }
}
