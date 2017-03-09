package com.michal.springboot.service;

import com.michal.springboot.domain.Address;
import com.michal.springboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017-03-09.
 */
@Service
public class CrudAddressService {

    private AddressRepository addressRepository;


    @Autowired
    CrudAddressService(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }

    public List<Address> getAllAddress(long id){
        return (List<Address>) addressRepository.findByUserId(id);
    }

    public void addAddress(Address address){
        addressRepository.save(address);
    }

    public void updateAddress(Address address){
        addressRepository.save(address);
    }

    public Address getAddress(long id){
        return addressRepository.findOne(id);
    }


    public void deleteAddress(long id) {
        addressRepository.delete(id);
    }
}
