package com.enigma.challenge_shopemart_dto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "m_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "address", nullable = false, length = 30)
    private String address;

    @Column(name = "mobile_phone", unique = true, nullable = false, length = 30)
    private String mobilePhone;


    @Column(name = "email", unique = true, nullable = false, length = 30)
    private String email;

}
