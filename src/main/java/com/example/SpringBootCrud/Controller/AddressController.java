package com.example.SpringBootCrud.Controller;

import com.example.SpringBootCrud.Model.Address;
import com.example.SpringBootCrud.Repository.AddressRepository;
import com.example.SpringBootCrud.Service.AddressService;
import com.example.SpringBootCrud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address/")
public class AddressController {

    @Autowired
    private AddressService _addressService;


    @GetMapping("GetAddress")
    public List<Address> GetAddress(){
        return _addressService.GetAddress();
    }

    @GetMapping("GetAllAddresses")
    public List<Address> GetAllAddresses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "addressId") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        return _addressService.GetAllAddresses(page,size,sortBy,ascending);
    }
}