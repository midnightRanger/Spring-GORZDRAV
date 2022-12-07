package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.Address;
import com.project.GORZDRAV.Models.Course;
import com.project.GORZDRAV.Repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AddressService {

    public final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void delete(Address address) {
        addressRepository.delete(address);
    }

    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Iterable<Address> findAll () {
        return addressRepository.findAll();
    }
}
