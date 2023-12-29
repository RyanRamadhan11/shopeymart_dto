package com.enigma.challenge_shopemart_dto.service;

import com.enigma.challenge_shopemart_dto.dto.request.CustomerRequest;
import com.enigma.challenge_shopemart_dto.dto.response.CustomerResponse;


import java.util.List;

public interface CustomerService {

    List<CustomerResponse> getAll();

    CustomerResponse create(CustomerRequest customerRequest);

    CustomerResponse update(CustomerRequest customerRequest);

    void delete(String id);

    CustomerResponse getById(String id);

}
