package com.example.SpringBootCrud.Service;

import com.example.SpringBootCrud.Model.Address;
import com.example.SpringBootCrud.Repository.AddressRepository;
import com.example.SpringBootCrud.Repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository _addressRepository;

    public AddressService(AddressRepository addressRepository){
        this._addressRepository = addressRepository;
    }

    public List<Address> GetAddress() {
        return _addressRepository.findAll();
    }

    public List<Address> GetAllAddresses(int page,int size,String sortBy,boolean ascending) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Address> addressPage = _addressRepository.findAll(pageable);
        return addressPage.getContent();
    }
}
