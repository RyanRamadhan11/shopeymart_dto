package com.enigma.challenge_shopemart_dto.service;

import com.enigma.challenge_shopemart_dto.dto.request.StoreRequest;
import com.enigma.challenge_shopemart_dto.dto.response.StoreResponse;

import java.util.List;

public interface StoreService {

    List<StoreResponse> getAll();

    StoreResponse update(StoreRequest storeRequest);

    void delete(String id);

    StoreResponse getById(String id);

    StoreResponse create(StoreRequest storeRequest);

}




