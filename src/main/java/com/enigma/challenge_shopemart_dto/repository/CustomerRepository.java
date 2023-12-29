package com.enigma.challenge_shopemart_dto.repository;

import com.enigma.challenge_shopemart_dto.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
