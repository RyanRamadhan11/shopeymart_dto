package com.enigma.challenge_shopemart_dto.service.impl;

import com.enigma.challenge_shopemart_dto.dto.request.CustomerRequest;
import com.enigma.challenge_shopemart_dto.dto.response.CustomerResponse;
import com.enigma.challenge_shopemart_dto.entity.Customer;
import com.enigma.challenge_shopemart_dto.repository.CustomerRepository;
import com.enigma.challenge_shopemart_dto.service.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> getAll() {

        List<Customer> customers = customerRepository.findAll();

        List<CustomerResponse> customerResponses = customers.stream()
                .map(customer -> CustomerResponse.builder()
                        .customerName(customer.getName())
                        .address(customer.getAddress())
                        .phone(customer.getMobilePhone())
                        .build())
                .collect(Collectors.toList());
        return customerResponses;
    }

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .address(customerRequest.getAddress())
                .mobilePhone(customerRequest.getMobilePhone())
                .email(customerRequest.getEmail())
                .build();
        customerRepository.save(customer);
        return CustomerResponse.builder()
                .customerName(customer.getName())
                .address(customerRequest.getAddress())
                .phone(customerRequest.getMobilePhone())
                .build();
    }

    @Override
    public CustomerResponse update(CustomerRequest customerRequest) {
        Customer customer = new Customer(
                customerRequest.getId(),
                customerRequest.getName(),
                customerRequest.getAddress(),
                customerRequest.getMobilePhone(),
                customerRequest.getEmail()
        );
        CustomerResponse currentCustomerId = getById(customer.getId());
        if (currentCustomerId != null) {
            Customer updatedCustomer = customerRepository.save(customer);
            return CustomerResponse.builder()
                    .customerName(updatedCustomer.getName())
                    .address(updatedCustomer.getAddress())
                    .phone(updatedCustomer.getMobilePhone())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public void delete(String id) {
        // Mengambil data customer dari metode getById
        CustomerResponse customer = getById(id);

        if (customer != null) {
            // Jika customer ditemukan, lakukan penghapusan
            customerRepository.deleteById(id);
        }
    }

    @Override
    public CustomerResponse getById(String id) {
        // Mengambil data dari repository menggunakan ID
        Optional<Customer> customer = customerRepository.findById(id);

        // Menangani kasus customer tidak ditemukan
        Customer customers = customer.orElse(null);

        return CustomerResponse.builder()
                .customerName(customers.getName())
                .address(customers.getAddress())
                .phone(customers.getMobilePhone())
                .build();
    }
}
