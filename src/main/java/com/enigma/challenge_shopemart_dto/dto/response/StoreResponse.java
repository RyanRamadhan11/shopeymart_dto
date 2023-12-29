package com.enigma.challenge_shopemart_dto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class StoreResponse {

//    dihilangkan agar direspon tidak aman menampilkan null;
//    private String id;

    private String noSiup;

    private String storeName;

//    private String address;

    private String phone;
}
