package com.example.SpringBootCrud.Controller;

import com.example.SpringBootCrud.Model.Address;
import com.example.SpringBootCrud.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses/")
public class AddressController {

    @Autowired
    private AddressService _addressService;

    @GetMapping
    public List<Address> GetAddress(){
        return _addressService.GetAddress();
    }

    @GetMapping("address")
    public List<Address> GetAllAddresses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "addressId") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        return _addressService.GetAllAddresses(page,size,sortBy,ascending);
    }
}