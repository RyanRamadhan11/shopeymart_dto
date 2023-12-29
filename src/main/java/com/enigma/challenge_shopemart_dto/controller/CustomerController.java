package com.enigma.challenge_shopemart_dto.controller;

import com.enigma.challenge_shopemart_dto.constant.AppPath;
import com.enigma.challenge_shopemart_dto.dto.request.CustomerRequest;
import com.enigma.challenge_shopemart_dto.dto.response.CustomerResponse;
import com.enigma.challenge_shopemart_dto.service.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppPath.CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @GetMapping
    public List<CustomerResponse> getAllCustomer() {
        return customerService.getAll();
    }

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.create(customerRequest);
    }


    @PutMapping
    public CustomerResponse updateCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.update(customerRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.delete(id);
    }


    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable String id) {
        return customerService.getById(id);
    }




}
